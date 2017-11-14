package br.com.devmedia.curso.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class FrontController {

    @GetMapping(value = "/")
    public String welcome() {
        return "redirect:/usuario/todos";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

//    @GetMapping(value = "/logout")
//    public ModelAndView logout() {
//        ModelAndView view = new ModelAndView("login");
//        view.addObject("msg", "Saiu com sucesso!");
//        return view;
//    }

    @GetMapping(value="/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
}
