package servletproject.servletproject.web.frontcontroller.v5;

import servletproject.servletproject.web.frontcontroller.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {

    //handler는 컨트롤러를 말한다. 어댑터가 해당 컨트롤러를 처리할수 있는지를 판단하는 메서드이다.
    boolean supports(Object handler);

    //어댑터는 실제 컨트롤러를 호출하고 그 결과로 ModelView를 반환한다.
    //실제 컨트롤러가 ModelView를 반환하지 못하면 어댑터가 직접 생성해서라도 반환해야한다.
    //이전에는 프론터 컨트롤러가 실제 컨트롤러를호출했지만 이제는 어댑터를 통해 실제 컨트롤러가 실행된다.
    ModelView handle(HttpServletRequest request, HttpServletResponse response,Object handler) throws ServletException, IOException;
}
