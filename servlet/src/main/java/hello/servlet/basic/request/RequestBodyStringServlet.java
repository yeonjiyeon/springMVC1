package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();//메시지 바디의 내용을 바이트 코드로 바로 얻을 수 있다
        //StreamUtils-스프링이 제공하는 유틸리티
        String messagebody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        // 바이트를 문자로 전환할 때는 항상 인코딩이 무엇인지 알려줘야 한다. 반대도 마찬가지!
        System.out.println("messagebody = " + messagebody);
        response.getWriter().write("ok");

    }
}
