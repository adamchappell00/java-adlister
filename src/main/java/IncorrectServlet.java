import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "IncorrectServlet", urlPatterns = "/incorrect")
public class IncorrectServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "You Lose!";
        request.setAttribute("message", message);
        request.getRequestDispatcher("outcome.jsp").forward(request,response);
    }
}