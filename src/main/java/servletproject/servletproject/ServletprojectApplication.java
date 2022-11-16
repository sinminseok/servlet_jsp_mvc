package servletproject.servletproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


//해당 어노테이션은 서블릿을 직접 등록해서 사용
@ServletComponentScan
@SpringBootApplication
public class ServletprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletprojectApplication.class, args);
	}

}
