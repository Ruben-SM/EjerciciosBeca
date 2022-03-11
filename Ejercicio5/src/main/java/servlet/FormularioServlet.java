package servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidad.Usuario;


@WebServlet("/FormularioServlet")
public class FormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LinkedList<Usuario> listaUsuarios = new LinkedList<>();
		
		Usuario u1 = new Usuario("pedro","1234");
		listaUsuarios.add(u1);
		
		Usuario u2 = new Usuario("luis","5678");
		listaUsuarios.add(u2);
		
		Usuario u3 = new Usuario("ana","2468");
		listaUsuarios.add(u3);
		
		
		String nombreInput = request.getParameter("nombre");
		String passInput = request.getParameter("pass");
		
		RequestDispatcher rd;
		boolean ok = false;
		
		for(Usuario u : listaUsuarios) {
			if (nombreInput.equals(u.getNombre()) && passInput.equals(u.getPass())) {
				ok = true;
				break;
			}
		}
		
		if (ok) {
			rd = request.getRequestDispatcher("bienvenida.jsp");
			request.setAttribute("n", nombreInput);
		}else{
			rd = request.getRequestDispatcher("error.jsp");
			
		}
		
		
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
