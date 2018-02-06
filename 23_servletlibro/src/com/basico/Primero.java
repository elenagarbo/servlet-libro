package com.basico;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Vector;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		description = "listado de parametros de servlet config", 
		urlPatterns = { 
				"/Primero", 
				"/VerConfig"
		}, 
		initParams = { 
				@WebInitParam(name = "ciudad", value = "madrid"), 
				@WebInitParam(name = "unidades", value = "50"), 
				@WebInitParam(name = "precio", value = "12.6")
		})

public class Primero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Primero() {  // constructor
        super();
        
    }

	
    Vector<Object> vector=new Vector<Object>();
    ServletContext application;    //variable de contexto del servlet
 
   
    
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Metodo init");
		
		application=config.getServletContext();
		
		application.setAttribute("curso", "java");
		application.setAttribute("iva",0.21f);
		
		
		Enumeration<?> listaParams= config.getInitParameterNames();
		while(listaParams.hasMoreElements()) {
			String nombreParam=(String)listaParams.nextElement();
			vector.add("{nombre="+ nombreParam+", valor=" +config.getInitParameter(nombreParam)+"}");
		}
	}


	public ServletConfig getServletConfig() {
		System.out.println("Metodo servletconfig");
		return null;
	}


	public String getServletInfo() {
		System.out.println("Metodo servletinfo");
		return null; 
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Metodo doGet");
		

		System.out.println(application.getAttribute("curso")); //tiene que salir java en consola
		
		response.setContentType("text/plain");
		PrintWriter out= response.getWriter();
		out.write(vector.toString());
		out.flush();
		out.close();
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Metodo doPost");
		//doGet(request, response) llama al metodo get y no da tiempo a pintar el parametro;
		
		String p=request.getParameter("producto");
		System.out.println(p);
	}

}
