package Controller;

import Model.Regra;
import Dao.PessoaDao;
import Dao.RegraDao;
import Model.Pessoa;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MesadaController {
    
    @RequestMapping(value="/visualizarmesada")
    String visualizarMesada(@RequestParam String mensagem,
            HttpSession s){
        s.setAttribute("mensagem", mensagem);
        return "visualizarMesada";
    }

    @RequestMapping(value = "/visualizarmesada", method = RequestMethod.GET)
    String visualizarMesada(@RequestParam int filhoid,
            HttpSession session) {
        Pessoa filho;
        session.setAttribute("resultMesada", calcularMesada(filhoid));
        session.setAttribute("filho", filho = PessoaDao.obterFilho(filhoid));
        session.setAttribute("regras", RegraDao.obterRegrasFilho(filho.getId()));
        return "visualizarMesada";
    }

    @RequestMapping(value = "/excluirmesada", method = RequestMethod.GET)
    String excluirFilho(@RequestParam int filhoid,
            HttpSession s) {
        s.setAttribute("mensagem", "Filho excluido com sucesso!");
        PessoaDao.excluirFilho(filhoid);
        return "redirect:/home";
    }

    Integer calcularMesada(int filhoid) {
        Integer resultMesada = 0;
        Pessoa filho = PessoaDao.obterFilho(filhoid);
        if (null != RegraDao.obterRegrasFilho(filho.getId())){
            for (Regra regra : RegraDao.obterRegrasFilho(filho.getId())) {
                    resultMesada += regra.getValor() * regra.getOcorrencia();
            }
            return filho.getValorMesada() + resultMesada;
        }
        return 0;
    }
}
