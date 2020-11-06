/**
 * 
 */
package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.ClienteDAO;
import entitys.Cliente;

public class ClienteDAOTest {

	/**
	 * Test method for {@link dao.ClienteDAO#inserir(entitys.Cliente)}.
	 */
	@Test
	final void testInserir() {
		try {
			LocalDate data = LocalDate.now();
			Cliente c = new Cliente(data, "54445545445", "912345678", "Cliente teste", "endereço teste",
					"email@teste.com");
			ClienteDAO dao = new ClienteDAO();
			dao.inserir(c);
			List<Cliente> lista = dao.listar();
			Cliente clienteInserido = lista.get(lista.size() - 1);

			assertAll(() -> Assert.assertTrue(clienteInserido.getCod() > 0),
					() -> Assert.assertEquals(data, clienteInserido.getData_nascimento()),
					() -> Assert.assertEquals("54445545445", clienteInserido.getDocumento()),
					() -> Assert.assertEquals("912345678", clienteInserido.getTelefone()),
					() -> Assert.assertEquals("Cliente teste", clienteInserido.getNome()),
					() -> Assert.assertEquals("endereço teste", clienteInserido.getEndereco()),
					() -> Assert.assertEquals("email@teste.com", clienteInserido.getEmail()));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link dao.ClienteDAO#buscarId(java.lang.Integer)}.
	 */
	@Test
	final void testBuscarId() {
		try {
			Cliente cliente = new ClienteDAO().buscarId(3);
			assertAll(() -> Assert.assertNotNull(cliente.getCod()),
					() -> Assert.assertNotNull(cliente.getData_nascimento()),
					() -> Assert.assertNotNull(cliente.getEmail()), () -> Assert.assertNotNull(cliente.getEndereco()),
					() -> Assert.assertNotNull(cliente.getNome()), () -> Assert.assertNotNull(cliente.getTelefone()),
					() -> Assert.assertNotNull(cliente.getDocumento()));
		} catch (Exception e) {
			Assert.fail();
		}
	}

	/**
	 * Test method for {@link dao.ClienteDAO#deletar(java.lang.Integer)}.
	 */
	@Test
	final void testDeletar() {
		try {
			ClienteDAO dao = new ClienteDAO();
			List<Cliente> listaAntes = dao.listar();
			Collections.sort(listaAntes);
			Cliente c1 = listaAntes.get(0);

			dao.deletar(c1.getCod());

			List<Cliente> listaDepois = dao.listar();
			Collections.sort(listaDepois);
			Cliente c2 = listaDepois.get(0);

			Assert.assertNotEquals(listaAntes.size(), listaDepois.size());
			Assert.assertNotEquals(c1.getCod(), c2.getCod());

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	final void testEditar() {
		try {

			ClienteDAO dao = new ClienteDAO();

			Cliente cliente = dao.buscarId(3);

			Cliente clienteEditado = dao.buscarId(3);
			clienteEditado.setNome("Cliente Teste Editado");
			dao.editar(clienteEditado);
			clienteEditado = dao.buscarId(3);

			Assert.assertNotEquals(cliente.getNome(), clienteEditado.getNome());

			clienteEditado.setNome("Cliente teste");
			dao.editar(clienteEditado);
			clienteEditado = dao.buscarId(3);

			Assert.assertEquals(cliente.getNome(), clienteEditado.getNome());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link dao.ClienteDAO#verificaRG(java.lang.String)}.
	 */
	@Test
	final void testVerificaRG() {
		try {
			ClienteDAO dao = new ClienteDAO();
			String rg1 = "32165498712";
			String rg2 = "65465465454";

			boolean b1 = dao.verificaRG(rg1);
			boolean b2 = dao.verificaRG(rg2);

			Assert.assertTrue(b1);
			Assert.assertFalse(b2);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link dao.ClienteDAO#listar()}.
	 */
	@Test
	final void testListar() {
		try {
			ClienteDAO dao = new ClienteDAO();
			List<Cliente> lista = dao.listar();
			Assert.assertNotNull(lista);
			if(lista.size() > 0) {
				Assert.assertTrue(lista.size() > 0);
			}
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

}















