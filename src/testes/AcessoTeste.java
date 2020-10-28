package testes;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import control.acesso.ControlAcesso;

public class AcessoTeste {

	//Testar todos os caminhos possiveis
	
	@Test
	@Ignore
	public void testeAcessoExistente() {
		
		try
		{
			// Definir que o meu teste foi bem sucedido = assertTrue
			Assert.assertEquals(1, new ControlAcesso().CarregarLogin(1, "10"));					
			System.out.println("Logou");
		} 
		catch (Exception e) {				
			Assert.assertFalse(!e.getMessage().equals("") ? false:true);	
			
			System.out.println(e.getMessage());
		}
	}

	@Test
	@Ignore
	public void testeAcessoInexistente() {
		
		try
		{
				// Definir que o meu teste foi bem sucedido = assertTrue
				Assert.assertEquals(1, new ControlAcesso().CarregarLogin(11, "880"));					
				System.out.println("User invalido");
		} 
		catch (Exception e) {				
			Assert.assertFalse(!e.getMessage().equals("") ? false:true);	
			
			System.out.println("User invalido - " + e.getMessage());
		}
	}
	
	
	@Test
	public void testeAcessoSemSenha() {
		try 
		{			
			Assert.assertEquals(1, new ControlAcesso().CarregarLogin(1, null));					
			System.out.println("Senha invalida");
		} 
		catch (Exception e) 
		{
			/* Assert.assertFalse(!e.getMessage().equals("") ? false:true); */		
			Assert.assertEquals(null, e.getMessage());
			System.out.println("Senha - " + e.getMessage());
		}
	}
}
