package Handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import Mercadorias.Produtos;
import Util.ListaDeProdutos;
import Mercadorias.Marca;

public class XMLHandlerProdutos extends DefaultHandler {
	
	private StringBuilder texto;
	Produtos produto;
	Marca marca;
	
	//os overrides vão sobescrever 

	@Override
	//inicia o documento
	public void startDocument() throws SAXException {
		System.out.println("Início do Documento");
	}

	@Override
	//termina o documento
	public void endDocument() throws SAXException {
		System.out.println("Fim do Documento");
	}

	@Override
	//inicia o elemento 
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		if (qName.equals("produto")) {
			
			produto = new Produtos();
			marca = new Marca ();
		} else {
			texto = new StringBuilder();
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
	
		if(qName.equals("Categoria")) {
			produto.setCategoria(texto.toString());
		} else if(qName.equals("Nome")) {
			produto.setNome(texto.toString());
		}else if(qName.equals("Marca")) {
			marca.setNomeMarca(texto.toString());
		}else if(qName.equals("Preco")) {
			marca.setPreco(texto.toString());
			produto.setMarca(marca);
			ListaDeProdutos.getInstance().add(produto);			
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
				texto.append(ch, start, length);
	}

	@Override
	public void error(SAXParseException e) throws SAXException {

	}

}
