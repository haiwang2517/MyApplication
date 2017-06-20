package org.gradle.security;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	
	
	@Override    
    public void onAuthenticationSuccess(HttpServletRequest request,    
            HttpServletResponse response, Authentication authentication) throws IOException,    
            ServletException {    
		
		UserDetails user= (UserDetails) authentication.getPrincipal();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
        System.out.println("username:"+username+",password:"+password+",url:"+request.getServletPath()+",登录的用户名:["+user.getUsername()+"]");
        Enumeration<String> enumeration = request.getParameterNames();  
	    while (enumeration.hasMoreElements()){  
	        String parameter = enumeration.nextElement(); 
	        System.out.println("参数:"+parameter);
	    } 
        System.out.println("defaultTargetUrl:["+super.getDefaultTargetUrl()+
        		"],redirectStrategy:["+super.getRedirectStrategy()+
        		"],isAlwaysUseDefaultTargetUrl:["+this.isAlwaysUseDefaultTargetUrl()+
        		"],targetUrlParameter:["+super.getTargetUrlParameter()+"]");
        
	    System.out.println("username:"+username+",password:"+password+",url:"+request.getServletPath());
	    
	    response.sendRedirect("findAll");
    }    
      
	
}
