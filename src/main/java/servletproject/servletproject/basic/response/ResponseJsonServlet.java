package servletproject.servletproject.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import servletproject.servletproject.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "responseJsonServlet" , urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("content-type","application/json");
        resp.setCharacterEncoding("utf-8");

        HelloData data = new HelloData();
        data.setUsername("kim");
        data.setAge(20);

        String result = objectMapper.writeValueAsString(data);

        resp.getWriter().write(result);

    }
}
