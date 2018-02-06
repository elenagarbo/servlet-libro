package com.basico;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ambito")
public class Ambito extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ambito() {
		super();

	}

	// protected void doGet(HttpServletRequest request, HttpServletResponse
	// response) throws ServletException, IOException {
	//
	//
	// getServletContext().setAttribute("ciudadaplicacion", "Barcelona");
	// System.out.println("Datos de aplicacion: "+
	// getServletContext().getAttribute("ciudadaplicacion"));
	//
	// //en sesion si no has abierto primero el servlet no inicia el servidor y no
	// sale Zamora
	// request.getSession().setAttribute("ciudadsesion","Zamora");
	// System.out.println("Datos de sesion:
	// "+request.getSession().getAttribute("ciudadsesion"));
	//
	//
	//
	// }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);

		String producto = request.getParameter("producto");
		request.getSession().setAttribute("producto", producto);
		
		

		if (producto.equals("camisa")) {

			request.getSession().setAttribute("precio", 25);

		} else {

			request.getSession().setAttribute("precio", 13);

		}

		response.sendRedirect("carrito.jsp");// lleve al jsp los datos

	}

}
