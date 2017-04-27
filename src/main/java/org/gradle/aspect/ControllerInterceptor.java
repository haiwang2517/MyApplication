package org.gradle.aspect;

import java.util.Enumeration;
import java.util.Map;

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
	
	// ����aop�������
	@Pointcut("execution(* org.gradle.a..*.*(..))")  
	public void executeService(){  

	}
	
	@Before("executeService()")
	public void doBeforeAdvice(JoinPoint joinPoint ){
		
		System.out.println("www");
		
		//��ȡĿ�귽���Ĳ�����Ϣ  
	    Object[] obj = joinPoint.getArgs();  
	    //AOP���������Ϣ  
	    joinPoint.getThis();  
	    //�����Ŀ�����  
	    joinPoint.getTarget();  
	    //�õ���� ֪ͨ��ǩ��  
	    Signature signature = joinPoint.getSignature();  
	    //���������һ������  
	    System.out.println(signature.getName());  
	    //AOP�����������  
	    System.out.println(signature.getDeclaringTypeName());  
	    //AOP��������ࣨclass����Ϣ  
	    signature.getDeclaringType();  
	    //��ȡRequestAttributes  
	    RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();  
	    //�ӻ�ȡRequestAttributes�л�ȡHttpServletRequest����Ϣ  
	    HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);  
	    //���Ҫ��ȡSession��Ϣ�Ļ�����������д��  
	    //HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);  
	    Enumeration<String> enumeration = request.getParameterNames();  
	    while (enumeration.hasMoreElements()){  
	        String parameter = enumeration.nextElement(); 
	        System.out.println("����:"+parameter);
	    }  
	}
	
	
	
	
}
