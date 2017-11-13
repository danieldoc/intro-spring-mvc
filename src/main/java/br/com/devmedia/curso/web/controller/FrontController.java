package br.com.devmedia.curso.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FrontController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome() {
        //return "login";
        return "redirect:/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
        //return "redirect:/usuario/todos";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam(value = "username") String usuario, @RequestParam(value = "password") String senha) {
        ModelAndView view = new ModelAndView();

//        if ((usuario.equals("admin")) && (senha.equals("ppgm")))
            view.setViewName("redirect:/usuario/todos");
//        else
//            view.addObject("msg", "Usuário e senha não encontrado.");**/
//
        return view;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout() {
        ModelAndView view = new ModelAndView("login");
        view.addObject("msg", "Saiu com sucesso!");
        return view;
    }
}
