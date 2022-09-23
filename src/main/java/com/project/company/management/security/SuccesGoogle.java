package com.project.company.management.security;

import com.project.company.management.services.EmployeeImplService;
import com.project.company.management.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SuccesGoogle implements AuthenticationSuccessHandler {

    @Autowired
    IEmployeeService employeeImplService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        DefaultOidcUser user = (DefaultOidcUser) authentication.getPrincipal();

        String email = user.getEmail();
        try {
            employeeImplService.getEmployee(email);
            response.sendRedirect("/welcome");
        }catch(Exception e){
            //Logout en google
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
    }
}
