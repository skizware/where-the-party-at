package wherethepartyat;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Controller to get party info.
 */
public class PartyInfoServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Where the party at?</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>The secret party is at Entelect HQ</h2>");
        out.println("</body>");
        out.println("</html>");
    }

}
