
package com.tienda;


public class AppAuthenticationSuccessHandler {

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class AppAuthenticationSuccessHandler extends SimpleUrlAuthenticationFailureHandler {
    protected void handle (HttpServletRequest request, HttpServletResponse response, 
    Authentication authentication) throws IOException, ServletException{

    }
}
}
