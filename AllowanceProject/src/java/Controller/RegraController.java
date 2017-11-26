package Controller;

import Dao.PessoaDao;
import Dao.RegraDao;
import Model.Pessoa;
import Model.Regra;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegraController {
    
    @RequestMapping(value="/cadastrarRegra", method = RequestMethod.GET)
    String cadastrarRegra(@RequestParam int idfilho,
            HttpSession session){        
        session.setAttribute("filho", PessoaDao.obterFilho(idfilho));
        return "cadastrarRegra";
    }
    
    @RequestMapping(value="/cadastrarRegra", method = RequestMethod.POST)
    String cadastrarRegra(@RequestParam String regra,
            @RequestParam int valor,
            @RequestParam int filhoid,
            @RequestParam int ocorrencia,
            HttpSession s){
        Regra r = new Regra();
        r.setNomeregra(regra);
        r.setIdfilho(filhoid);
        r.setOcorrencia(ocorrencia);
        r.setValor(valor);
        RegraDao.cadastrarRegra(r);
        s.setAttribute("regras", RegraDao.obterRegrasFilho(filhoid));
        s.setAttribute("resultMesada", calcularMesada(filhoid));
        s.setAttribute("mensagem", "Regra cadastrada com sucesso");
        return "visualizarMesada";
    }
    
    Integer calcularMesada(int filhoid){
        Integer resultMesada = 0;
        Pessoa filho=PessoaDao.obterFilho(filhoid);
        for(Regra regra: RegraDao.obterRegrasFilho(filho.getId())){
            resultMesada += regra.getValor()*regra.getOcorrencia();
        }
        return filho.getValorMesada()+resultMesada;
    }
    @RequestMapping(value="/deletarRegra", method = RequestMethod.POST)
    String deletarRegra(@RequestParam int idregra,
            @RequestParam int idfilho,
            HttpSession s){
        RegraDao.deletarRegra(idregra);
        s.setAttribute("regras", RegraDao.obterRegrasFilho(idfilho));
        s.setAttribute("resultMesada", calcularMesada(idfilho));
        s.setAttribute("mensagem", "Regra deletada com sucesso");
        return "visualizarMesada";
    }
    
    @RequestMapping(value="/obterRegra", method = RequestMethod.POST)
    String obterRegra(@RequestParam int idregra,
            HttpSession s){
        s.setAttribute("regra", RegraDao.obterRegra(idregra));
        return "editarRegra";
    }
    
    @RequestMapping(value="/editarRegra", method = RequestMethod.POST)
    String editarRegra(@RequestParam String nomeRegra,
            @RequestParam int idregra,
            @RequestParam int valor,
            @RequestParam int ocorrencia,
            @RequestParam int idfilho,
            HttpSession s){
        RegraDao.editarRegra(idregra, nomeRegra, valor, ocorrencia);
        s.setAttribute("regras", RegraDao.obterRegrasFilho(idfilho));
        s.setAttribute("resultMesada", calcularMesada(idfilho));
        s.setAttribute("mensagem", "Regra modificada com sucesso");
        return "visualizarMesada";
    }
}
