package com.util;

import java.util.Hashtable;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {
	
		private static Hashtable<String, ApplicationContext> contextRegistry=new Hashtable<String, ApplicationContext>();
	
	   public static Object getBean(String beanName,String pathName) throws Exception{
			System.out.println("pathNamepathName"+pathName); 
			ApplicationContext appCtx;
			if(contextRegistry.get(pathName)!=null){
				appCtx=(ApplicationContext)contextRegistry.get(pathName);
				System.out.println(" Got Spring App Ctx from teh Registry");
			}else{
				System.out.println(" Could not get the Spring App Ctx from teh Registry. Hence Setting in the registry");
				appCtx= new ClassPathXmlApplicationContext(pathName);
				contextRegistry.put(pathName,appCtx);
			}
			 System.out.println("contextcontext"+appCtx);
			 return appCtx.getBean(beanName);
			
		}
}
