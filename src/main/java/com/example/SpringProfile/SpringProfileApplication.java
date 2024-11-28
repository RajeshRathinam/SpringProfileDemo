package com.example.SpringProfile;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;

import com.example.SpringProfile.bean.Fruit;

//@SpringBootApplication(excludeName = {"com.example.SpringProfile.bean.Fruit"})
@SpringBootApplication
@ComponentScan(excludeFilters={@Filter(type=FilterType.ASSIGNABLE_TYPE,
										value={
												Fruit.class
												}
										) })
public class SpringProfileApplication implements CommandLineRunner{
	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		  applicationContext=SpringApplication.run(SpringProfileApplication.class, args);
		displayAllBeans();
	}
	public static void displayAllBeans() {
        String[] allBeanNames = applicationContext.getBeanDefinitionNames();
        System.out.println("Bean Count="+allBeanNames.length);
        for(String beanName : allBeanNames) {
            System.out.println(beanName);
        }
    }
	
	@Autowired
	private MesssageInterface messsageInterface; 
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("In CLI run method...........");
		messsageInterface.showMsg();
	}


}
