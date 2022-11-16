package servletproject.servletproject.web.frontcontroller.v3;

import lombok.extern.slf4j.Slf4j;
import servletproject.servletproject.web.frontcontroller.ModelView;
import servletproject.servletproject.web.frontcontroller.MyView;
import servletproject.servletproject.web.frontcontroller.v3.controller.MemberFormControllerV3;
import servletproject.servletproject.web.frontcontroller.v3.controller.MemberListControllerV3;
import servletproject.servletproject.web.frontcontroller.v3.controller.MemberSaveControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Slf4j
@WebServlet(name = "frontControllerServletV3",urlPatterns = "/front-controller/v3/*")
public class FrontControllerV3 extends HttpServlet {

    private Map<String,ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerV3() {
        controllerMap.put("/front-controller/v3/members/new-form", new
                MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new
                MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new
                MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        ControllerV3 controller = controllerMap.get(requestURI);
        if(controller == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String ,String > paramMAp = createParamMap(request);
        ModelView mv = controller.process(paramMAp);

        String viewName = mv.getViewName();
        MyView view = viewResolver(viewName);
        view.render(mv.getModel(), request, response);
    }

    private Map<String,String> createParamMap(HttpServletRequest request){
        Map<String,String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName,
                        request.getParameter(paramName)));

        return paramMap;
    }

    private MyView viewResolver(String viewName){
        return new MyView("/WEB-INF/views/" + viewName +".jsp");
    }
}
