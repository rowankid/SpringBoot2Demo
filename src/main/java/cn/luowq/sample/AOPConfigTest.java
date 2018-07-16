package cn.luowq.sample;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

public class AOPConfigTest {

	// 匹配com.luowq.sample.controller包及其子包中所有类中的所有方法，返回类型任意，方法参数任意
	@Pointcut("execution(* cn.luowq.sample.controller.*(..))")
	public void before() {
	}

	// 匹配HelloSpringBoot2Controller类中的所有方法
	@Pointcut("within(HelloSpringBoot2Controller)")
	public void aspectMethod() {
	}

	// 匹配com.cjm包及其子包中所有类中的所有方法
	@Pointcut("within(cn.luowq..*)")
	public void aspectClass() {
	}

	// this：用于向通知方法中传入代理对象的引用。
	@Before("before() && this(proxy)")
	public void beforeAdvideThis(JoinPoint point, Object proxy) {
		// 处理逻辑
	}

	// target：用于向通知方法中传入目标对象的引用。
	@Before("before() && target(target)")
	public void beforeAdvideTarget(JoinPoint point, Object proxy) {
		// 处理逻辑
	}

	//args：用于将参数传入到通知方法中。
    @Before("before() && args(age,username)")
    public void beforeAdvide(JoinPoint point, int age, String username){
          //处理逻辑
    }
    
    //within ：用于匹配在类一级使用了参数确定的注解的类，其所有方法都将被匹配。 
    @Pointcut("@within(com.cjm.annotation.AdviceAnnotation)")
    //所有被@AdviceAnnotation标注的类都将匹配
    public void aspectAnnotation(){}
    
    //target ：和@within的功能类似，但必须要指定注解接口的保留策略为RUNTIME。
    @Pointcut("@target(com.cjm.annotation.AdviceAnnotation)")
    public void aspectRuntimeAnnotation(){}
	
    //@args ：传入连接点的对象对应的Java类必须被@args指定的Annotation注解标注。
    @Before("@args(com.cjm.annotation.AdviceAnnotation)")
    public void beforeAdvide(JoinPoint point){
          //处理逻辑
    }
    
    //@annotation ：匹配连接点被它参数指定的Annotation注解的方法。也就是说，所有被指定注解标注的方法都将匹配。
    @Pointcut("@annotation(com.cjm.annotation.AdviceAnnotation)")
    public void aspectAnnoOnMethod(){}
    
    //bean：通过受管Bean的名字来限定连接点所在的Bean。该关键词是Spring2.5新增的。
    @Pointcut("bean(person)")
    public void aspectBean(){}
    
	@Before("executeService() &&" + "args(name)")
	public void before(String name) {
		System.out.println("before say hello");
		System.out.println("name = " + name);
	}

	@AfterReturning("executeService()")
	public void after() {
		System.out.println("after return");
	}
}
