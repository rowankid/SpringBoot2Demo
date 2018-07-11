package com.luowq.sample;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

/**
 * Controller 的所有方法在执行前后都会进入functionAccessCheck方法 测试URL:
 * http://localhost:8080/sayhello.html?name=a
 */
// 切面类注解
@Aspect
// 声明这是一个Spring管理的bean
@Configuration
public class AOPConfig {
	/**
	 * 声明一个表达式，表明包含此注解的类在被调用前后都会执行被@Around注解的方法。
	 * 还有@target() 所有被注解的方法。
	 * execution(方法描述)
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	@Around("@within(org.springframework.stereotype.Controller) ")
	public Object functionAccessCheck(final ProceedingJoinPoint pjp) throws Throwable {
		try {
			Object[] args = pjp.getArgs();
			System.out.println("args:" + Arrays.asList(args));
			// 调用原有的方法
			Object o = pjp.proceed();

			System.out.println("return :" + o);
			return o;

		} catch (Throwable e) {
			throw e;
		}
	}
}