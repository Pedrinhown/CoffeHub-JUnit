package testes;

import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import control.produto.ControlCategoria;
import control.produto.ControlProduto;
import entitys.Categoria;
import entitys.Produto;

public class CadProdutoTeste {
	
	// Testar Gravar geral Válido
	
	private Produto ProdutoValidoGravar() {
		Produto produto = new Produto();
		produto.setDescricao("Produto JUnit");
		produto.setQtd_atual(3);
		produto.setUnidadeMedida("CX");
		produto.setValor_un(1.55);
		return produto;
	}
	
	private Categoria CategoriaValidaGravar() {
		Categoria categoria = new Categoria();
		categoria.setNome("Categoria JUnit");
		return categoria;
	}
	
	private Produto GravarProdutoValidoComCategoria() {
		Produto retorno = null;
		
		try {
			
			ControlCategoria ctCategoria = new ControlCategoria();
			ControlProduto ctProduto = new ControlProduto();
			Categoria cat = this.CategoriaValidaGravar();
			retorno = this.ProdutoValidoGravar();
			
			 cat = ctCategoria.Carregar(ctCategoria.Inserir(cat));
			 retorno.setCategoria(cat);

			 retorno = ctProduto.Carregar(ctProduto.Inserir(retorno));

			 
		}
		catch(Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			retorno = null;
		}
		
		return retorno;
	}
	
	@Ignore
	@Test
	public void TestarGravarProdutoComCat() throws Exception
	{
		Assert.assertEquals(new ControlProduto().BuscarUltimo(), this.GravarProdutoValidoComCategoria().getCod());
	}
	
	// Testar todos os campos - Editar
	
	@Ignore
	@Test
	public void TesteProdutoCodInvalidoEdicao() {
		Produto produto = new Produto();
		produto.setCod(-1);
		try 
		{
			Assert.assertEquals(1, new ControlProduto().Editar(produto));
			fail();
		}
		catch (Exception e)
		{
			Assert.assertEquals("Informe uma ID válida para o produto", e.getMessage());
		}
	}
	
	@Ignore
	@Test
	public void TestaDescricaoProdutoInvalidoEditar() {
		Produto produto = new Produto();
		produto.setCod(1);
		produto.setDescricao("");
		try 
		{
			Assert.assertEquals(1, new ControlProduto().Editar(produto));
			fail();
		}
		catch (Exception e)
		{
			Assert.assertEquals("Informe uma descrição para o produto.", e.getMessage());
		}	
	}	
	
	
	@Ignore
	@Test
	public void TestaQtdProdutoInvalidoEditar() {
		Produto produto = new Produto();
		produto.setCod(1);
		produto.setDescricao("Teste JUnit");
		produto.setQtd_atual(-1);
		try 
		{
			Assert.assertEquals(1, new ControlProduto().Editar(produto));
			fail();
		}
		catch (Exception e)
		{
			Assert.assertEquals("A quantidade não pode ser menor ou igual a zero.", e.getMessage());
		}	
	}
	
	
	@Ignore
	@Test
	public void TestaValorProdutoInvalidoEditar() {
		Produto produto = new Produto();
		produto.setCod(1);
		produto.setDescricao("Teste JUnit");
		produto.setQtd_atual(1);
		produto.setValor_un(-1);
		try 
		{
			Assert.assertEquals(1, new ControlProduto().Editar(produto));
			fail();
		}
		catch (Exception e)
		{
			Assert.assertEquals("O valor unitário não pode ser menor ou igual a zero.", e.getMessage());
		}
	}

	@Ignore
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
			Assert.assertEquals(1, new ControlProduto().Editar(produto));
			fail();
		}
		catch (Exception e)
		{
			Assert.assertEquals("A unidade de medida deve ser de 2 caracteres", e.getMessage());
		}
	}


	// Testar todos os campos - Gravar
	
	@Ignore
	@Test
	public void TestaDescricaoProdutoInvalidoGravar() {
		Produto produto = new Produto();
		produto.setDescricao("");
		try 
		{
			Assert.assertEquals(1, new ControlProduto().Inserir(produto));
			fail();
		}
		catch (Exception e)
		{
			Assert.assertEquals("Informe uma descrição para o produto.", e.getMessage());
		}
	}	
	
	@Ignore
	@Test
	public void TestaQtdProdutoInvalidoGravar() {
		Produto produto = new Produto();
		produto.setDescricao("Teste JUnit");
		produto.setQtd_atual(-1);
		try 
		{
			Assert.assertEquals(1, new ControlProduto().Inserir(produto));
			fail();
		}
		catch (Exception e)
		{
			Assert.assertEquals("A quantidade não pode ser menor ou igual a zero.", e.getMessage());
		}
	}
	
	@Ignore
	@Test
	public void TestaValorProdutoInvalidoGravar() {
		Produto produto = new Produto();
		produto.setDescricao("Teste JUnit");
		produto.setQtd_atual(1);
		produto.setValor_un(-1);
		try 
		{
			Assert.assertEquals(1, new ControlProduto().Inserir(produto));
			fail();
		}
		catch (Exception e)
		{
			Assert.assertEquals("O valor unitário não pode ser menor ou igual a zero.", e.getMessage());
		}
	}
	
	
	@Ignore
	@Test
	public void TestaUnProdutoInvalidoGravar() {
		Produto produto = new Produto();
		produto.setDescricao("Teste JUnit");
		produto.setQtd_atual(1);
		produto.setValor_un(100);
		produto.setUnidadeMedida("CCCCCC");
		try 
		{
			Assert.assertEquals(1, new ControlProduto().Inserir(produto));
			fail();
		}
		catch (Exception e)
		{
			Assert.assertEquals("A unidade de medida deve ser de 2 caracteres", e.getMessage());
		}
	}	

	
	// testar o gravar no geral
	@Ignore
	@Test
	public void TestaGravarProdutoInvalido() {
		Produto produto = null;
		try 
		{
			Assert.assertEquals(1, new ControlProduto().Inserir(produto));
			fail();
		}
		catch (Exception e)
		{
			Assert.assertEquals("Informe um produto para a gravação.", e.getMessage());
		}
	}
	
	//testar o editar produto
	
	@Ignore
	@Test
	public void TestaEditarProdutoInvalido() {
		Produto produto = null;
		try 
		{
			Assert.assertEquals(1, new ControlProduto().Editar(produto));
			fail();
		}
		catch (Exception e)
		{
			Assert.assertEquals("Informe um produto para a gravação.", e.getMessage());
		}	
		
	}
	
	@Ignore
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
	
	//testar excluir produto
	
	@Ignore
	@Test
	public void TestaExcluirProdutoInvalido() {
		Produto produto = new Produto();
		produto.setCod(-1);
		try 
		{
			Assert.assertEquals(1, new ControlProduto().Deletar(produto.getCod()));
			fail();
		}
		catch (Exception e)
		{
			Assert.assertEquals("Informe uma ID válida para a exclusão do produto.", e.getMessage());
		}		
	}	
	
	@Ignore
	@Test
	public void TestaExcluirProdutoValido()
	{
		Produto porduto = this.GravarProdutoValidoComCategoria();		
		try
		{
			Assert.assertEquals(1, new ControlProduto().Deletar(porduto.getCod()));
		} 
		catch (Exception e) {
			e.printStackTrace();
			fail();
		} 		
	}	
}
