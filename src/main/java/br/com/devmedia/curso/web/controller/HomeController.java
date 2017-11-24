package br.com.devmedia.curso.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String index() {
        return "redirect:/usuario/todos";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }
}
