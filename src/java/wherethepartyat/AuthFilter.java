package wherethepartyat;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Auth filter to make sure resources are protected.
 */
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("AUTH FILTER!");
        if(isLoggedOut((HttpServletRequest) servletRequest)){
            System.out.println("NOT LOGGED IN!");
            ((HttpServletResponse)servletResponse).sendRedirect("/where-the-party-at/login");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean isLoggedOut(HttpServletRequest servletRequest) {
        return (servletRequest).getSession().getAttribute("isLoggedIn") == null || !(Boolean)(servletRequest).getSession().getAttribute("isLoggedIn");
    }

    @Override
    public void destroy() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
