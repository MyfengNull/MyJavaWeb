import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yangshirong on 2017/2/20.
 */
//@WebServlet("/feng")
public class Main extends HttpServlet {
    private String message;
    @Override
    public void init() throws ServletException {
        message = "test";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("<h1>"+message+"</h1>");

    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
