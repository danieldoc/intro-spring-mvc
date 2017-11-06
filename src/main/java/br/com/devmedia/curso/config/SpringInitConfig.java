package br.com.devmedia.curso.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {RootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringMvcConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
