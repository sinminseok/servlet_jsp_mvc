package servletproject.servletproject.web.frontcontroller.v5.adapter;

import servletproject.servletproject.web.frontcontroller.ModelView;
import servletproject.servletproject.web.frontcontroller.v3.ControllerV3;
import servletproject.servletproject.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {

    //ControllerV3를 처리할 수 있는 어댑터를 뜻한다.
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV3);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {

        //V3에 맞게 형변환
        ControllerV3 controller = (ControllerV3) handler;
        Map<String,String> paramMap = createParamMap(request);
        //controllerV3는 modelview를 반환
        ModelView mv = controller.process(paramMap);
        return mv;
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName,
                        request.getParameter(paramName)));
        return paramMap;
    }
}
