package servletproject.servletproject.basic.request;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name = "requestHeaderServlet",urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printStartLine(request);
    }

    //start line 정보
    private void printStartLine(HttpServletRequest request){
        log.info("---Request Line start ---");
        log.info("request.getMethod() = " + request.getMethod());
        log.info("request.getScheme() =" + request.getProtocol());
        log.info("request.getRequestURL() =" + request.getRequestURL());
        log.info("request.getQueryString() =" + request.isSecure());

        log.info("---Request line end---");


    }

    //Header 모든 정보
    private void printHeaders(HttpServletRequest request){
        log.info("---Headers - start---");

    }
}
