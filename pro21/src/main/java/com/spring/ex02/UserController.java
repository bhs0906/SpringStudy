package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController {
//	설정 파일의 userMethodNameResolver 프로퍼티를 사용하려면 반드시 MultiActionController를 상속 받아야한다.

	
//	  public ModelAndView login(HttpServletRequest request, HttpServletResponse
//	  response) throws Exception { String userID = ""; String passwd = "";
//	  ModelAndView mav = new ModelAndView(); request.setCharacterEncoding("utf-8");
//	  userID = request.getParameter("userID"); passwd =
//	  request.getParameter("passwd");
//	  
//	  mav.addObject("userID", userID); mav.addObject("passwd", passwd);
//	  mav.setViewName("result"); return mav; }
	 


	  public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception { 
		  String userID = ""; 
		  String passwd = "";

		  String viewName=getViewName(request);
		  // getViewName() 메서드를 호출해 요청명에서 확장명.do를 제외한 뷰이름을 가져온다.
	  
	  
		  ModelAndView mav = new ModelAndView(); 
		  request.setCharacterEncoding("utf-8");
		  userID = request.getParameter("userID"); 
		  passwd = request.getParameter("passwd"); 

	  
		  mav.addObject("userID", userID); // ModelAndView에 로그인 정보를 바인딩합니다.
		  mav.addObject("passwd", passwd); 
		  //mav.setViewName("result"); // ModelAndView
		  //객체에 포워딩할 JSP 이름을 설정한다.
	  
		  mav.setViewName(viewName); 
		  // 뷰이름을 지정한다. 
	  
		  System.out.println("ViewName:"+viewName); 
		  return mav; 
	  
	  }
	  
	  
  
	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
		  String viewName=getViewName(request);
			
		  request.setCharacterEncoding("utf-8");
		  ModelAndView mav=new ModelAndView();
		  String id=request.getParameter("id");
		  String pwd=request.getParameter("pwd");
		  String name=request.getParameter("name");
		  String email=request.getParameter("email");
		    
		    
		  // 회원 가입창에서 전송된 회원정보를 addObject()
		  // 메서드를 이용해 ModeAndView 객체에 바인딩한다.
		  mav.addObject("id",id);
		  mav.addObject("pwd",pwd);
		  mav.addObject("name",name);
		  mav.addObject("email",email);
		  mav.setViewName("memberInfo");
		  // memberInfo.jsp로 포워딩한다. 
		     
		  mav.setViewName(viewName); 
		  // 뷰이름을 지정한다. 
			  
		  System.out.println("ViewName:"+viewName);
			  
		  return mav;
		}
		
		public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String viewName = getViewName(request);
			return new ModelAndView(viewName);
		}
		
		public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String viewName = getViewName(request);
			return new ModelAndView(viewName);
		}
		
		private  String getViewName(HttpServletRequest request) throws Exception {
			// request 객체에서 URL요청명을 가져와 .do를 제외한 요청을 구한다.
			
		  String contextPath = request.getContextPath();
		  System.out.println("contexPath : " + contextPath);
		  // contexPath 프로젝트 경로를 가져온다.
			
		  
		  String uri = (String)request.getAttribute("javax.servlet.include.request_uri");
		  System.out.println("uri : " + uri);		
		  
		  
		  if(uri == null || uri.trim().equals("")) {
		      uri = request.getRequestURI();
		   }

		  System.out.println("uri : " + uri);	
		  
		  int begin = 0;
		  if(!((contextPath==null)||("".equals(contextPath)))){
		       begin = contextPath.length();
			   System.out.println("begin : " + begin);	
		   // begin은 contexPath 길이를 구한다 /pro21 이므로, 6이 나온다
		   }

		  int end;
		  if(uri.indexOf(";")!=-1){
		      end=uri.indexOf(";");
		   }else if(uri.indexOf("?")!=-1){
		      end=uri.indexOf("?");
		   }else{
		      end=uri.length();
		   }
		  
		   System.out.println("end : " + end);	
		   // indexOf = 몇번쨰 있는지 위치를 찾는것

		   String fileName=uri.substring(begin,end);
		   if(fileName.indexOf(".")!=-1){
		      fileName=fileName.substring(0,fileName.lastIndexOf("."));
		   }
		   if(fileName.lastIndexOf("/")!=-1){
		      fileName=fileName.substring(fileName.lastIndexOf("/"),fileName.length());
		   }
		   
		     System.out.println("fileName : " + fileName);	
		     return fileName;
		   }
}
