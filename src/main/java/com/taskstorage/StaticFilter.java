package com.taskstorage;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/*
    Фикс для статик контента
    https://stackoverflow.com/questions/14539076/serving-static-resources-at-static-context-while-keeping-my-servlet-handling

    Unfortunately after looking into DefaultServlet source I found that DefaultServlet takes only pathInfo part of
    requested URL, so if your request is /static/styles.css, container translates it into /styles.css. Servlet part is
    omitted by the DefaultServlet. If you want to access such css file you should use /static/static/styles.css request url.

    The simple solution of our problem is to write DefaultFilter class and place it at the beginning of web.xml file.
    This filter will forward all static content calls to DefaultServlet.
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
    public void init(FilterConfig filterConfig) {
        this.requestDispatcher =
                filterConfig.getServletContext().getNamedDispatcher("default");
    }
}
