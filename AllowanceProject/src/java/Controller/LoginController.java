package Controller;
import Dao.PessoaDao;
import Model.Pessoa;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    
    @RequestMapping(value="/login", method=RequestMethod.GET)
    String mostrarFormularioLogin(){
        return "login";
    }
    
    @RequestMapping(value = "/login", method=RequestMethod.POST)
    String receberDadosLogin(@RequestParam String email, 
            @RequestParam String senha, 
            HttpSession session){
        
        Pessoa pai = PessoaDao.obterPessoa(email);
        
        if (pai != null && pai.getSenha().equals(senha)){
            
            session.setAttribute("pai", pai);
            return "redirect:/home";
        }

        session.setAttribute("status", "Email ou senha inválida!");
        return "login";

    }
    
}

