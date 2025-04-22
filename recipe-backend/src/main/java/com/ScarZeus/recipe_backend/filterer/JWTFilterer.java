package com.ScarZeus.recipe_backend.filterer;

import jakarta.servlet.ServletException;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JWTFilterer extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(jakarta.servlet.http.HttpServletRequest request,
                                    jakarta.servlet.http.HttpServletResponse response,
                                    jakarta.servlet.FilterChain filterChain) throws ServletException, IOException {

    }
}
