package com.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.dto.Cat;

public class MainClass {

	public static void main(String[] args) {
		
		//Java에서  xml 실행시 
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("bean.xml");
		
		// xml에서 생성된 Object를 읽어드리기
		
		Cat myCat = ctx.getBean("myCat", Cat.class);
		
		myCat.info();
		myCat.setAge(4);
		myCat.getColor();
	}

}
