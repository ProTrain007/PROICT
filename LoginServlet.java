import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AuthManager authManager = AuthManager.getInstance();

        if (authManager.authenticate(username, password)) {
            request.getSession().setAttribute("username", username);
            response.sendRedirect("main");
        } else {
            response.sendRedirect("login.html"); // Redirect to login page
        }
    }
}
