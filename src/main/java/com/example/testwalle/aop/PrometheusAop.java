package com.example.testwalle.aop;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Administrator on 2019/6/15.
 *
 * 集成prometheus监控接口流量 实现金丝雀部署
 */
@Component
@Aspect
public class PrometheusAop {

	@Pointcut("execution(public * com.example.testwalle.controller.*.*(..))")
	public void pointCut(){}

	//统计请求的处理时间
	ThreadLocal<Long> startTime = new ThreadLocal<>();

	@Autowired
	MeterRegistry registry;

	private Counter counter;

	@PostConstruct
	private void init(){
		counter = registry.counter("requests_total","status","success");
	}

	@Before("pointCut()")
	public void doBefore(JoinPoint joinPoint) throws Throwable{
		startTime.set(System.currentTimeMillis());

		counter.increment(); //记录系统总请求数
	}

	@AfterReturning(returning = "returnVal" , pointcut = "pointCut()")
	public void doAfterReturning(Object returnVal){
		//处理完请求后
		System.out.println("方法执行时间:"+ (System.currentTimeMillis() - startTime.get()));
	}

}

