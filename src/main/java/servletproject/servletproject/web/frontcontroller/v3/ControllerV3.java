package servletproject.servletproject.web.frontcontroller.v3;

import servletproject.servletproject.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    ModelView process(Map<String,String> paramMap);
}
