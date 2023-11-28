package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Userdto;
import service.UserService;
@WebServlet("/signup")
public class Signup extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String name=req.getParameter("name");
//		String email=req.getParameter("email");
//		String password=req.getParameter("password");
//		long mobile=Long.parseLong(req.getParameter("mobile"));
//		LocalDate dob=LocalDate.parse(req.getParameter("date"));
//		String gender=req.getParameter("gender");
//		int age=LocalDate.now().getYear()-dob.getYear();
//		
//		resp.getWriter().print("<h1>");
//		resp.getWriter().print("Name: "+name+"<br>");
//		resp.getWriter().print("Email: "+email+"<br>");
//		resp.getWriter().print("Password: "+password+"<br>");
//		resp.getWriter().print("Mobile: "+mobile+"<br>");
//		resp.getWriter().print("Dob: "+dob+"<br>");
//		resp.getWriter().print("Gender: "+gender+"<br>");
//		resp.getWriter().print("Age: "+age+"<br>");
//		resp.getWriter().print("</h1>");
		
		
		
		LocalDate dob=LocalDate.parse(req.getParameter("date"));
		int age=LocalDate.now().getYear()-dob.getYear();
		Userdto dto=new Userdto();
		dto.setPassword(req.getParameter("password"));
		dto.setName(req.getParameter("name"));
		dto.setEmail(req.getParameter("email"));
		dto.setMobile(Long.parseLong(req.getParameter("mobile")));
		dto.setGender(req.getParameter("gender"));
		dto.setDate(dob);
		dto.setAge(age);
		
		UserService service=new UserService();
		if(service.saveUser(dto))
		{
			resp.getWriter().print("<h1 align='center'style='color:green'>Account created Successfully</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		}
		else
		{
			resp.getWriter().print("<h1 align='center'style='color:red'>Sorry! Account can't be created</h1>");
			req.getRequestDispatcher("signup.html").include(req, resp);
		}
		
		
		
	}

}
