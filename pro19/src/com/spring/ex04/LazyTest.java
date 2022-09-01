package com.spring.ex04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class LazyTest {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("lazy.xml");
		// 호출함과 동시에 모두 생성을 하기때문에 메모리가 꽉 찰수도있다.
		
		
		System.out.println("SecondBean 얻기");
		// 레이지가 걸려있는것은 호출됐을때 생성된다
		// 자주쓰지 않는것은 레이지로 관리한다
		context.getBean("secondBean");
	}
}


