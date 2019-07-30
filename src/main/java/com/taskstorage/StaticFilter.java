package com.taskstorage;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/*
Фикс для статик контента
*/
@WebFilter("/static/*")
public class StaticFilter implements Filter {

    private RequestDispatcher requestDispatcher;

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        requestDispatcher.forward(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.requestDispatcher =
                filterConfig.getServletContext().getNamedDispatcher("default");
    }
}
