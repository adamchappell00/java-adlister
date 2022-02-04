import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CorrectServlet", urlPatterns = "/correct")
public class CorrectServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "You Won!";
        request.setAttribute("message", message);
        request.getRequestDispatcher("outcome.jsp").forward(request,response);
    }

}