package Controller;

import Dao.PessoaDao;
import Model.Pessoa;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaiController {

    @RequestMapping("/cadpai")
    String cadPai() {
        return "cadastrarPai";
    }

    @RequestMapping(value = "/cadpai", method = RequestMethod.POST)
    String cadatrarPai(
            @RequestParam String nome,
            @RequestParam String email,
            @RequestParam String senha,
            @RequestParam String senhaConfirmar,
            HttpSession session) {
        if (PessoaDao.obterPessoa(email) == null) {
            if (senha.equals(senhaConfirmar)) {
                Pessoa pai = new Pessoa();
                pai.setNome(nome);
                pai.setEmail(email);
                pai.setSenha(senha);
                PessoaDao.cadastrarPessoa(pai);
                session.setAttribute("pai", pai);
                session.setAttribute("mensagem", pai.getNome() + " cadastrado com sucesso!");
                return "redirect:/home";
            } else {
                session.setAttribute("mensagem", "As senhas não conferem!");
                return "cadastrarPai";
            }
        } else {
            session.setAttribute("mensagem", "O Email " + email + " já está cadastrado em nosso sistema");
            return "cadastrarPai";
        }
    }
}
