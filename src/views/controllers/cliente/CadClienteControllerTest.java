/**
 * 
 */
package views.controllers.cliente;

import static org.junit.Assert.assertThrows;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import exceptions.CampoVazioException;
import exceptions.ItemInvalidoException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utils.Formatacao;

/**
 * @author Vitor Hainosz
 *
 */
class CadClienteControllerTest {

	private CadClienteController cad = new CadClienteController();
	
	/**
	 * Test method for {@link views.controllers.cliente.CadClienteController#getCadCliente()}.
	 */
	@Test
	final void testGetCadCliente() {
		try {
			Stage primaryStage = new Stage();
			AnchorPane root = FXMLLoader.load(getClass().getResource("/views/cliente/CadCliente.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			Assert.assertEquals(primaryStage, cad.getCadCliente());
		} catch (Exception e) {
			Assert.fail();
		}
	}

	/**
	 * Test method for {@link views.controllers.cliente.CadClienteController#verificaEmail(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testVerificaEmail() {
		Assert.assertEquals(true, cad.verificaEmail("Vitor@gmail.com", "Mensagem de erro"));
	}
	
	/**
	 * Test method for {@link views.controllers.cliente.CadClienteController#verificaDocumento(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testVerificaDocumento() {
		Assert.assertEquals(true, cad.verificaDocumento("095.743.039-69", "Mensagem de erro"));
	}

	/**
	 * Test method for {@link views.controllers.cliente.CadClienteController#verificaNumero(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testVerificaNumero() {
		Assert.assertEquals(true, cad.verificaNumero("9 8494-1246", "Mensagem de erro"));
	}

	/**
	 * Test method for {@link views.controllers.cliente.CadClienteController#passou(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testPassou() {
		Assert.assertEquals(true, cad.passou("qualquer coisa", "Mensagem de erro"));
	}

	/**
	 * Test method for {@link views.controllers.cliente.CadClienteController#initialize(java.net.URL, java.util.ResourceBundle)}.
	 */
	@Test
	final void testInitializeURLResourceBundle() {
		Stage stage = cad.getCadCliente();
	}
	
	/**
	 * Test method for {@link views.controllers.cliente.CadClienteController#verificaEmail(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testVerificaEmailErroEmBranco() {
		String email = "";
		Exception exception = assertThrows("Estourou um erro mas não o esperado", CampoVazioException.class, () -> {
			Formatacao.formatarDocumento(email);
	    });

		Assert.assertEquals("Insira um Email", exception.getMessage());
	}
	
	@Test
	final void testVerificaEmailErroNull() {
		String email = null;
		Exception exception = assertThrows("Estourou um erro mas não o esperado", CampoVazioException.class, () -> {
			Formatacao.formatarDocumento(email);
		});

		Assert.assertEquals("Insira um Email", exception.getMessage());
	}
	
	@Test
	final void testVerificaEmailErroInvalido() {
		String email = "email Sem as exigências";
		Exception exception = assertThrows("Estourou um erro mas não o esperado", ItemInvalidoException.class, () -> {
			Formatacao.formatarDocumento(email);
		});

		Assert.assertEquals("Insira um email correto", exception.getMessage());
	}
	
	/**
	 * Test method for {@link views.controllers.cliente.CadClienteController#verificaDocumento(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testVerificaDocumentoEr() {
		Assert.assertEquals(true, cad.verificaDocumento("095.743.039-69", "Mensagem de erro"));
	}


}




























