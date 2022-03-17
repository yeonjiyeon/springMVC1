package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    //서블릿이 호출되면 서비스 메서드가 호출된다
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username");//쿼리 파라미터를 읽어올 수 있다
        System.out.println("username = " + username);

        //응답메시지 보내기
        //header
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        //body
        response.getWriter().write("hello " + username);
    }
}
