package org.gradle.aspect;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@Aspect
@Component
public class ControllerInterceptor {
	
	// 设置aop的切入点
	@Pointcut("execution(* org.gradle.controller..*.*(..))")  
	public void executeService(){  

	}
	
	@Before("executeService()")
	public void doBeforeAdvice(JoinPoint joinPoint ){
		
		System.out.println("www");

		//获取目标方法的参数信息  
//	    Object[] obj = joinPoint.getArgs();  
	    //AOP代理类的信息  
	    joinPoint.getThis();  
	    //代理的目标对象  
	    joinPoint.getTarget();  
	    //用的最多 通知的签名  
	    Signature signature = joinPoint.getSignature();  
	    //代理的是哪一个方法  
	    System.out.println(signature.getName());  
	    //AOP代理类的名字  
	    System.out.println(signature.getDeclaringTypeName());  
	    //AOP代理类的类（class）信息  
	    signature.getDeclaringType();  
	    //获取RequestAttributes  
	    RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();  
	    //从获取RequestAttributes中获取HttpServletRequest的信息  
	    HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);  
	    //如果要获取Session信息的话，可以这样写：  
	    //HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);  
	    Enumeration<String> enumeration = request.getParameterNames();  
	    while (enumeration.hasMoreElements()){  
	        String parameter = enumeration.nextElement(); 
	        System.out.println("参数:"+parameter);
	    }  
	}
	
	
	
	
}
