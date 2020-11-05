package testes;

import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import control.produto.ControlCategoria;
import control.produto.ControlProduto;
import entitys.Categoria;
import entitys.Produto;

public class TestSuitProdutoEditar {
	// Testar todos os campos - Editar

	@Test
	public void TesteProdutoCodInvalidoEdicao() {
		Produto produto = new Produto();
		produto.setCod(-1);
		try 
		{
			new ControlProduto().Editar(produto);
			fail();
		}
		catch (Exception e)
		{
			Assert.assertEquals("Informe uma ID válida para o produto", e.getMessage());
		}
	}

	@Test
	public void TestaDescricaoProdutoInvalidoEditar() {
		Produto produto = new Produto();
		produto.setCod(1);
		produto.setDescricao("");
		try 
		{
			new ControlProduto().Editar(produto);
			fail();
		}
		catch (Exception e)
		{
			Assert.assertEquals("Informe uma descrição para o produto.", e.getMessage());
		}	
	}	
	
	

	@Test
	public void TestaQtdProdutoInvalidoEditar() {
		Produto produto = new Produto();
		produto.setCod(1);
		produto.setDescricao("Teste JUnit");
		produto.setQtd_atual(-1);
		try 
		{
			new ControlProduto().Editar(produto);
			fail();
		}
		catch (Exception e)
		{
			Assert.assertEquals("A quantidade não pode ser menor ou igual a zero.", e.getMessage());
		}	
	}
	
	

	@Test
	public void TestaValorProdutoInvalidoEditar() {
		Produto produto = new Produto();
		produto.setCod(1);
		produto.setDescricao("Teste JUnit");
		produto.setQtd_atual(1);
		produto.setValor_un(-1);
		try 
		{
			new ControlProduto().Editar(produto);
			fail();
		}
		catch (Exception e)
		{
			Assert.assertEquals("O valor unitário não pode ser menor ou igual a zero.", e.getMessage());
		}
	}


	@Test
	public void TestaUnProdutoInvalidoEditar() {
		Produto produto = new Produto();
		produto.setCod(1);
		produto.setDescricao("Teste JUnit");
		produto.setQtd_atual(1);
		produto.setValor_un(100);
		produto.setUnidadeMedida("CCCCCC");
		try 
		{
			new ControlProduto().Editar(produto);
			fail();
		}
		catch (Exception e)
		{
			Assert.assertEquals("A unidade de medida deve ser de 2 caracteres", e.getMessage());
		}
	}
	
	//testar o editar produto
	
	@Test
	public void TestaEditarProdutoInvalido() {
		Produto produto = null;
		try 
		{
			new ControlProduto().Editar(produto);
			
			fail();
		}
		catch (Exception e)
		{
			Assert.assertEquals("Informe um produto para a gravação.", e.getMessage());
		}	
		
	}
	
	@Test
	public void TestaEditarProdutoValido() throws ClassNotFoundException, SQLException, Exception {
		
		try 
		{			
			Produto produto = new Produto();
			produto.setCod(4);
			produto.setDescricao("Teste JUnit");
			produto.setQtd_atual(1);
			produto.setValor_un(100);
			produto.setUnidadeMedida("CX");		
			Categoria cat = new ControlCategoria().Carregar(1);
			produto.setCategoria(cat);
			
			Assert.assertEquals(1, new ControlProduto().Editar(produto));
		}
		catch (Exception e)
		{
			fail();
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
