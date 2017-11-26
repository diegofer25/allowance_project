package Controller;
import Model.Pessoa;
import Dao.PessoaDao;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FilhoController {

    @RequestMapping(value="/cadfilho", method = RequestMethod.GET)
    String cadastrarFilho(@RequestParam String paiemail,
            HttpSession session){
        session.setAttribute("pai", PessoaDao.obterPessoa(paiemail));
        return "cadastrarFilho";
    }
    @RequestMapping(value="/cadfilho", method = RequestMethod.POST)
    String cadastrarFilho(@RequestParam String emailp,
            @RequestParam String nome,
            @RequestParam int mesada,
            HttpSession session){        
        Pessoa filho = new Pessoa();
        filho.setNome(nome);
        filho.setValorMesada(mesada);
        filho.setFilhode(PessoaDao.obterPessoa(emailp).getId());
        PessoaDao.cadastrarPessoa(filho);
        session.setAttribute("mensagem", filho.getNome()+" cadastrado com sucesso! :)");
        return "redirect:/home";
    }
    @RequestMapping(value="/gerfilho", method = RequestMethod.GET)
    String gerenciarFilhos(@RequestParam String emailp,
            HttpSession session){
        session.setAttribute("filhos", PessoaDao.obterFilhos(emailp));
        session.setAttribute("pai", PessoaDao.obterPessoa(emailp));
        return "gerenciarFilhos";
    } 
    @RequestMapping(value="/gerfilho")
    String gerenciarFilhos(){
        return "gerenciarFilhos";
    }
}
