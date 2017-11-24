package br.com.devmedia.curso.web.controller;

import br.com.devmedia.curso.security.UsuarioOnline;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class UsuarioOnlineController {

    @ModelAttribute("usuarioOnline")
    public UsuarioOnline getUsuarioOnline(Authentication authentication) {
        return (authentication == null ? null : (UsuarioOnline) authentication.getPrincipal());
    }
}
