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
public class CadClienteControllerTest {

	private CadClienteController cad = new CadClienteController();

	/**
	 * Test method for
	 * {@link views.controllers.cliente.CadClienteController#verificaEmail(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testVerificaEmail() {
		Assert.assertEquals(true, cad.verificaEmail("Vitor@gmail.com", "Mensagem de erro"));
	}

	/**
	 * Test method for
	 * {@link views.controllers.cliente.CadClienteController#verificaDocumento(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testVerificaDocumento() {
		Assert.assertEquals(true, cad.verificaDocumento("095.743.039-69", "Mensagem de erro"));
	}

	/**
	 * Test method for
	 * {@link views.controllers.cliente.CadClienteController#verificaNumero(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testVerificaNumero() {
		Assert.assertEquals(true, cad.verificaNumero("9 8494-1246", "Mensagem de erro"));
	}

	/**
	 * Test method for
	 * {@link views.controllers.cliente.CadClienteController#passou(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testPassou() {
		Assert.assertEquals(true, cad.passou("qualquer coisa", "Mensagem de erro"));
	}

	/**
	 * Test method for
	 * {@link views.controllers.cliente.CadClienteController#verificaDocumento(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testVerificaDocumentoEr() {
		Assert.assertEquals(true, cad.verificaDocumento("095.743.039-69", "Mensagem de erro"));
	}

}
