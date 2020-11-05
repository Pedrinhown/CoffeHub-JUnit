package views.controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import dao.ClienteDAO;
import entitys.Cliente;

public class initial {

	public enum Teste{teste1,teste2,teste3}
	
	public static void main(String[] args) {

		ClienteDAO dao = new ClienteDAO();
		
		List<Cliente> lista = dao.listar();
		System.out.println(lista);
		
		Collections.sort(lista);
		System.out.println(lista);
		
		Cliente c = lista.get(lista.size() - 1);
		System.out.println(c);
	}

}


















