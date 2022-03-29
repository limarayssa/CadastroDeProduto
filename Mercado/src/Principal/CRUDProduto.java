package Principal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import BancoDados.ArquivoTXT;
import BancoDados.ArquivoXML;
import Mercadorias.Marca;
import Mercadorias.Produtos;
import Util.ListaDeProdutos;
import ViewMercado.ViewCRUDProduto;
public class CRUDProduto {
	
	//m�todo do menu, chamado no main
	//essa classe aqui faz a execu��o, a parte visual que � mostrada pro usu�rio est� na classe ViewCRUDProduto
	
	public static Produtos CadastrarProdutos (BufferedReader reader) throws IOException, ParserConfigurationException, TransformerException {
		//esse m�todo cadastra os objetos, salvando eles na lista e nos arquivos
		
		//inst�ncia de produtos e marca pra poder setar os dados recebidos pelo reader
		Produtos produtos = new Produtos();
		Marca marca = new Marca();
		
		String [] dadosProduto = ViewCRUDProduto.ViewMenuSalvarProduto(reader);
		//essa string tr�s os dados que o usu�rio colocou
		
			produtos.setCategoria(dadosProduto[0]);
			produtos.setNome(dadosProduto[1]);
			marca.setNomeMarca(dadosProduto[2]);
			marca.setPreco(dadosProduto[3]);
			produtos.setMarca(marca);

			ListaDeProdutos.getInstance().add(produtos); //adiciona ele na lista
			ArquivoXML.SalvarArquivoXML(); //salva na lista de arquivos XML
			ArquivoTXT.SalvarArquivoTXT(); //salva na lista de arquivos TXT
			
		return produtos;


	}

	public static void MostrarProdutos (int ops) throws FileNotFoundException, IOException, ParserConfigurationException, SAXException {
		//esse m�todo lista todos os produtos pro usu�rio

		ListaDeProdutos.getInstance().clear(); //inst�ncia da lista, o clear limpa ela
		
		ArquivoXML.LerArquivoXML(); //l� o arquivo 
		
		if(ops==0)
			
		ViewCRUDProduto.ViewListaDeProdutosEditada(); //apresenta a lista 
		
	}
	

	public static void DeletarProduto (BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException {
		
		//m�todo pra apresentar as informa��es e ler o �ndice para remover o produto
		int indice = ViewCRUDProduto.ViewMenuEditarOuDeletarProduto("deletar", reader); 

		ListaDeProdutos.getInstance().remove(indice); // remove o objeto alocado no espa�o selecionado
		
		ArquivoXML.SalvarArquivoXML();
		ArquivoTXT.SalvarArquivoTXT();
	}
	
	
	public static void 	EditarProduto (BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException {
		
		//tr�s as duas informa��es, a do �ndice e a do atributo, por isso � um array de String
		String[] dadosEditados = {"", ""};
		
		int indice = ViewCRUDProduto.ViewMenuEditarOuDeletarProduto("editar", reader);
		
		Produtos produto = ListaDeProdutos.getInstance().get(indice);
		Marca produtoMarca = produto.getMarca();
		
		dadosEditados = ViewCRUDProduto.ViewOpcaoEdicao(reader);
		
		switch(Integer.parseInt(dadosEditados[0])) {
		//cada um dos casos altera as informa��es em um dos atributos, fazendo a altera��o
		
		case 1:
			produto.setCategoria(dadosEditados[1]);
			break;
			
		case 2:
			produto.setNome(dadosEditados[1]);
			break;
			
		case 3:
			produtoMarca.setNomeMarca(dadosEditados[1]);
			break;
			
		case 4:
			produtoMarca.setPreco(dadosEditados[1]);
			break;
		}

		ArquivoXML.SalvarArquivoXML();
		ArquivoTXT.SalvarArquivoTXT();
		
	}
}