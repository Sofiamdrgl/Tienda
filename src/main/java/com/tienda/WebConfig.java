
package com.tienda;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class WebConfig implements WebMvConfigurer {
    @Bean
    public SessionLocaleResolver localeResolver(){
        var slr =new SessionLocalResolver();
        slr.setDefaultLocale(new Locale("es"));
        return slr;
    }
    @Bean
    public localeChangeInterceptor localeChangeInterceptor(){
        var lci = new localeChangeInterceptor();
        lci.setparamName("lang");
        return lci;
    }
    public void addInterceptors(InterceptorRegistry registro){
        registro.addInterseptor(localeChangeInterseptor());
    }
    public void addViewControllers(ViewControlerRegitry regitro){
        regitro.addViewController("/").setViewName("personas");
        regitro.addViewController("/login");
        regitro.addViewController("errores/403")/setViewName("/errores/403");
    }
}