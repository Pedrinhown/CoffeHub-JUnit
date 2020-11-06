/**
 * 
 */
package testes;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import exceptions.ItemInvalidoException;
import utils.Formatacao;

public class FormatacaoTest {

	@Test
	final void testFormatarDocumentoCpf() {
		String cpf = "09574303969";
		String cpfFormatado = Formatacao.formatarDocumento(cpf);
		Assert.assertEquals("095.743.039-69", cpfFormatado);
	}

	/**
	 * Test method for {@link utils.Formatacao#formatarDocumento(java.lang.String)}.
	 */
	@Test
	final void testFormatarDocumentoCnpj() {
		String cnpj = "07322883000103";
		String cnpjFormatado = Formatacao.formatarDocumento(cnpj);
		Assert.assertEquals("07.322.883/0001-03", cnpjFormatado);
	}

	/**
	 * Test method for {@link utils.Formatacao#formatarDocumento(java.lang.String)}.
	 */
	@Test
	final void testFormatarDocumentoRg() {
		String cnpj = "143679705";
		String cnpjFormatado = Formatacao.formatarDocumento(cnpj);
		Assert.assertEquals("14.367.970-5", cnpjFormatado);
	}

	
	/**
	 * Test method for {@link utils.Formatacao#formatarTelefone(java.lang.String)}.
	 */
	@Test
	final void testFormatarTelefone() {
		String cnpj = "33742015";
		String cnpjFormatado = Formatacao.formatarTelefone(cnpj);
		Assert.assertEquals("3374-2015", cnpjFormatado);
	}

	/**
	 * Test method for {@link utils.Formatacao#formatarTelefone(java.lang.String)}.
	 */
	@Test
	final void testFormatarTelefoneDDD() {
		String cnpj = "4133742015";
		String cnpjFormatado = Formatacao.formatarTelefone(cnpj);
		Assert.assertEquals("(41) 3374-2015", cnpjFormatado);
	}

	/**
	 * Test method for {@link utils.Formatacao#formatarTelefone(java.lang.String)}.
	 */
	@Test
	final void testFormatarCelular() {
		String cnpj = "984941246";
		String cnpjFormatado = Formatacao.formatarTelefone(cnpj);
		Assert.assertEquals("9 8494-1246", cnpjFormatado);
	}
	
	/**
	 * Test method for {@link utils.Formatacao#formatarTelefone(java.lang.String)}.
	 */
	@Test
	final void testFormatarCelularDDD() {
		String cnpj = "41984941246";
		String cnpjFormatado = Formatacao.formatarTelefone(cnpj);
		Assert.assertEquals("(41) 9 8494-1246", cnpjFormatado);
	}
	
	/**
	 * Test method for {@link utils.Formatacao#formatarTelefone(java.lang.String)}.
	 */
	@Test
	final void testFormatarDocumentoErro() {
		String documento = "123";
		assertThrows(ItemInvalidoException.class, () -> {
			Formatacao.formatarDocumento(documento);
	    });
	}
	
	/**
	 * Test method for {@link utils.Formatacao#formatarTelefone(java.lang.String)}.
	 */
	@Test
	final void testFormatarTelefoneErro() {
		String documento = "123";
		assertThrows(ItemInvalidoException.class, () -> {
			Formatacao.formatarDocumento(documento);
	    });
	}
}































