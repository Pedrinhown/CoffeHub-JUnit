package testes;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import control.produto.ControlCategoria;
import control.produto.ControlProduto;
import entitys.Categoria;
import entitys.Produto;

public class CadProdutoTeste {
	
	// Testar todos os campos - Editar
	
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
			String nomeCat = cat.getNome();
			String nomeProd = retorno.getDescricao();
			
			ctCategoria.Inserir(cat);
			 
			 cat = ctCategoria.Listar(cat.getNome()).stream().filter(x -> x.getNome().equals(nomeCat))
					  .findAny()
					  .orElse(null);
			 
			 retorno.setCategoria(cat);
			 
			 ctProduto.Inserir(retorno);
			 
			 retorno = ctProduto.Listar(retorno.getDescricao()).stream().filter(x -> x.getDescricao().equals(nomeProd)).findAny().orElse(null);
			
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
			Assert.assertEquals("Informe uma ID v�lida para o produto", e.getMessage());
		}
	}
	
	@Ignore
	@Test
	public void TestaDescricaoProdutoValidoEditar() {
		try {
			Produto prod = this.GravarProdutoValidoComCategoria();
			
			if(ret == 2)
				
				
			
		} catch (Exception e) {
			// TODO: handle exception
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
			Assert.assertEquals("Informe uma descri��o para o produto.", e.getMessage());
		}	
	}	
	
	
	@Ignore
	@Test
	public void TestaQtdProdutoValidoEditar() {
		
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
			Assert.assertEquals("A quantidade n�o pode ser menor ou igual a zero.", e.getMessage());
		}	
	}
	
	
	@Ignore
	@Test
	public void TestaValorProdutoValidoEditar() {
		
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
			Assert.assertEquals("O valor unit�rio n�o pode ser menor ou igual a zero.", e.getMessage());
		}
	}
	
	@Ignore
	@Test
	public void TestaUnProdutoValidoEditar() {
		
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
	public void TestaDescricaoProdutoValidoGravar() {
		
	}
	
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
			Assert.assertEquals("Informe uma descri��o para o produto.", e.getMessage());
		}
	}	
	
	@Ignore
	@Test
	public void TestaQtdProdutoValidoGravar() {
		
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
			Assert.assertEquals("A quantidade n�o pode ser menor ou igual a zero.", e.getMessage());
		}
	}
	
	@Ignore
	@Test
	public void TestaValorProdutoValidoGravar() {
		
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
			Assert.assertEquals("O valor unit�rio n�o pode ser menor ou igual a zero.", e.getMessage());
		}
	}
	
	
	@Ignore
	@Test
	public void TestaUnProdutoValidoGravar() {
		
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
	
	@Ignore
	@Test
	public void TestaCategoriaProdutoEditar() {
		// Gravar nova categoria -> carrega ela -> gravar a mesma no produto -> deletar categoria para for�ar exception de constraint fk
	}

	
	
	// testar o gravar no geral
	@Ignore
	@Test
	public void TestaGravarProdutoInvalido() {
		
	}
	
	@Ignore
	@Test
	public void TestaGravarProdutoValido() {
		
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
			Assert.assertEquals("Informe um produto para a grava��o.", e.getMessage());
		}	
		
	}
	
	@Ignore
	@Test
	public void TestaEditarProdutoValido() {
		
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
			Assert.assertEquals("Informe uma ID v�lida para a exclus�o do produto.", e.getMessage());
		}		
	}	
	
	@Ignore
	@Test
	public void TestaExcluirProdutoValido() {
		
	}	
}
