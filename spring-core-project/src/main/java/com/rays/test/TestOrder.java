package com.rays.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

	public class TestOrder {
		
		public static void main(String[] args) {
			
			BeanFactory factory = new XmlBeanFactory(new ClassPathResource("order.xml"));
			
			Order dto = (Order) factory.getBean("order");

		    System.out.println(dto.getProduct());
		    System.out.println(dto.getPrice());
		    System.out.println(dto.getQuantity());
		    
		    System.out.println("------------------");
		    
		    dto = (Order) factory.getBean("order1");
		    
		    
		    System.out.println(dto.getProduct());
		    System.out.println(dto.getPrice());
		    System.out.println(dto.getQuantity());
		    
		    System.out.println("-------------------");
		    
            dto = (Order) factory.getBean("order2");
		    
		    System.out.println(dto.getProduct());
		    System.out.println(dto.getPrice());
		    System.out.println(dto.getQuantity());
		     
		    }
}
