package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import modelo.entidad.Usuario;
import modelo.negocio.GestorUsuario;


@WebServlet("/usuarios/login")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		Usuario usuario = new Usuario(nombre,password);
		GestorUsuario gu = new GestorUsuario();
		
		if(!gu.hayUsuarios()) {
			gu.insertarUsuarios();
		}
		
		int validar = gu.validarUsuario(usuario);
		boolean validado = (validar == 0);

		JSONObject json = new JSONObject();
		json.put("validado", validado);
		
		response.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");	// permitir la petición de código del origen web angular
		response.setContentType("application/json");
		response.getWriter().write(json.toString());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		Usuario usuario = new Usuario(nombre,password);
		GestorUsuario gu = new GestorUsuario();
		
		boolean validar = gu.insertarUsuario(usuario);
		
		JSONObject json = new JSONObject();
		json.put("insertado", validar);
		
		response.setContentType("application/json");
		response.getWriter().write(json.toString());
		
	}

}
