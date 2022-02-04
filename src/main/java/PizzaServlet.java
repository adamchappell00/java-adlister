import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PizzaServlet", urlPatterns = "/pizza-order")
public class PizzaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("pizza-order.jsp").forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request.getParameter("size"));
        System.out.println(request.getParameter("sauce"));
        System.out.println(request.getParameter("crust"));
        System.out.println(request.getParameter("sausage"));
        System.out.println(request.getParameter("ham"));
        System.out.println(request.getParameter("bacon"));
        System.out.println(request.getParameter("mushrooms"));
        System.out.println(request.getParameter("spinach"));
        System.out.println(request.getParameter("olives"));
        System.out.println(request.getParameter("address"));
    }

}