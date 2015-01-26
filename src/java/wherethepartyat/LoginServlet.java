package wherethepartyat;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: david.anderson
 * Date: 2015/01/26
 * Time: 11:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        boolean errorLogin = "true".equals(req.getParameter("error"));
        ServletOutputStream out = resp.getOutputStream();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Where the party at?</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Please login:</h2>");
        out.println("<form method='POST'>");
        out.println("<label>Username:</label>");
        out.println("<input name='username'>");
        out.println("<label>Password:</label>");
        out.println("<input name='password'>");
        out.println("<button type='submit' value='Login'>Login</button>");
        if(errorLogin){
            out.println("<div>Error! Please try again.</div>");
        }
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String redirectPath = "/where-the-party-at/login?error=true";

        if("dave".equals(username) && "password".equals(password)){
            req.getSession().setAttribute("isLoggedIn", true);
            redirectPath = "/where-the-party-at/getInfo";
        }

        resp.sendRedirect(redirectPath);
    }

}
