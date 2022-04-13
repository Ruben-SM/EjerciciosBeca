package modelo.negocio;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.json.JSONObject;


public class GestorUsuario {
	
	/**
	 * Metodo de validación de usuario introducido por argumentos
	 * @param nombre de usuario
	 * @param password del usuario
	 * @return true si el usuario ha sido validado, false en caso contrario
	 */
	public boolean validarUsuario(String nombre, String password) {
		try {
			HttpRequest request = HttpRequest.newBuilder()
					  .uri(new URI("http://localhost:8080/Ejercicio21/usuarios/login?nombre="
							  +nombre+"&password="+password))
					  .GET()
					  .build();
			
			HttpClient client = HttpClient.newHttpClient();
			
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			JSONObject json = new JSONObject(response.body());
			return json.getBoolean("validado");

		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
						
		return false;
	}
	
	/**
	 * Metodo de inserccion de usuario introducido por argumentos en la BBDD
	 * @param nombre de usuario
	 * @param password del usuario
	 * @return true si el usuario ha sido insertado, false en caso contrario
	 */
	public boolean insertarUsuario(String nombre, String password) {
		try {
			HttpRequest request = HttpRequest.newBuilder()
					  .uri(new URI("http://localhost:8080/Ejercicio21/usuarios/login?nombre="+nombre+"&password="+password))
					  .POST(HttpRequest.BodyPublishers.noBody())
					  .build();
			HttpClient client = HttpClient.newHttpClient();

			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			JSONObject json = new JSONObject(response.body());
			return json.getBoolean("insertado");
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			return false;

	}
}
