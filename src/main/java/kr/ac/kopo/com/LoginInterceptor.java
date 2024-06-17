package kr.ac.kopo.com;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;


//핸들러 인터셉터
//다수의 컨트롤러(핸들러) 실행 전후에 공통적으로 해야하는 일들을 수행하기 위한
//HandlerInterceptor 인터페이스를 구현하도록 정의

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
					
		HttpSession session = request.getSession();
		LoginVO mvo = (LoginVO)session.getAttribute("loginUser");
		if(mvo == null) {
			response.sendRedirect(request.getContextPath() + "/login.do");
			
			return false;
		}			
		
		return true;
	}
}
