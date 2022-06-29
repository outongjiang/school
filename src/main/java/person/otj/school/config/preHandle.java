package person.otj.school.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class preHandle implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("..");
        Object username = request.getSession().getAttribute("username");
        if(username!=null){
            return true;
        }else
        {
            response.sendRedirect("/login");
            return false;
        }
    }
}
