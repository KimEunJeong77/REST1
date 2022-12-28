package com.example.demo.system.interceptor;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor{

public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception{
log.info("========================== AuthInterceptor ==================================");
log.info(request.getRequestURI());
HttpSession session = request.getSession();
String userId = (String)session.getAttribute("id");
log.info("userId:"+(userId == null));
if(userId == null) {
response.sendRedirect("/login/form");
return false;
}else
return true;

}
}