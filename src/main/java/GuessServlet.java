import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GuessServlet", urlPatterns = "/guess")
public class GuessServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("guess.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String guess = request.getParameter("number");
        int input = Integer.parseInt(guess);
        double random = Math.random() * 4;
        int randomInt = (int) random;
        if(input == randomInt){
            response.sendRedirect("/correct");
        } else {
            response.sendRedirect("/incorrect");
        }
    }
}