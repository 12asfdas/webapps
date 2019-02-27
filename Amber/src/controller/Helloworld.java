package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bean.User;

@Controller
public class Helloworld {
	/**
	      * 1. ʹ��RequestMappingע����ӳ�������URL
	      * 2. ����ֵ��ͨ����ͼ����������Ϊʵ�ʵ�������ͼ, ����InternalResourceViewResolver��ͼ���������������½���
	      * ͨ��prefix+returnVal+suffix �����ķ�ʽ�õ�ʵ�ʵ�������ͼ��Ȼ���ת������
	      * "/WEB-INF/views/success.jsp"
	      * @return
	      */
	     @RequestMapping(value="logincheck")
	     public String hello(){
	         System.out.println("hello world");
	         return "success";
	     }
	
}
