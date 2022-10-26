package com.example.demo.security;

import com.example.demo.model.Role;
import com.example.demo.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
public class SuccessUserHandler implements AuthenticationSuccessHandler {

    private UserService userService;

    public SuccessUserHandler(UserService userService) {
        this.userService=userService;
    }
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Set<Role> roles = userService.getUserByUsername(authentication.getName()).getRoles();
        for (Role role : roles) {
            if (role.getName().equals("ROLE_ADMIN")) {
                response.sendRedirect("/admin/users");
            } else {
                response.sendRedirect("/user");
            }
        }
    }
}
