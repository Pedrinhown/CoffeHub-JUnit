package testes.views.controllers.funcionario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entitys.Funcionario;
import entitys.Pessoa;
import javafx.stage.Stage;
import junit.framework.TestCase;
import views.controllers.HomeController;

class PesquisaFuncionarioControllerTest extends TestCase {
	
	
	String entidadeController = ">Funcionario.PesquisaFuncionarioController";
	String teste;
	String error;

	@Test
	void PesquisaFuncionarioTest() {
	}
	
	
	@Test
	void testGetPesquisaFuncionario() {
		teste = "getPesquisaFuncionario.status";
		error = "ERROR: erro ao tentar executar a tela PesquisaFuncionario";
		try {
			
						
			//assertEquals(HomeController.FuncionarioEstatico , HomeController.FuncionarioEstatico);
			
			System.out.println(entidadeController + "." + teste + ":\n" + "OK");
		} catch (Exception e) {
			System.out.println(entidadeController + "." + teste + ":\n" + error);
			fail(error);
		}
	}

}
