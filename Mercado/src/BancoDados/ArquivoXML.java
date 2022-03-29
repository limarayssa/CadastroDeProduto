package BancoDados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import Handler.XMLHandlerProdutos;
import Mercadorias.Produtos;
import Util.ListaDeProdutos;

public class ArquivoXML {
	
	private static String nomeDoArquivo = "CadastrodeProduto.xml";
	
	public static void SalvarArquivoXML () throws ParserConfigurationException, UnsupportedEncodingException, FileNotFoundException, IOException, TransformerException {
		
		//usado para criar um documento XML
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		//cria um novo documento XML
		Document doc = db.newDocument();
		
		//cria os elementos 
		Element produtosTag = doc.createElement("Produtos");
		doc.appendChild(produtosTag);
		
		for (Produtos p: ListaDeProdutos.getInstance()) {
			
			//doc.createElement cria os elementos do documento XML na tag de produto
			Element produtoTag = doc.createElement("produto");
			produtoTag.setAttribute("id", "1");
			produtosTag.appendChild(produtoTag);
			
			Element categoriaTag = doc.createElement("Categoria");
			categoriaTag.setTextContent(p.getCategoria());
			produtoTag.appendChild(categoriaTag);
			
			Element nomeTag = doc.createElement("Nome"); //feijão, arroz, etc
			nomeTag.setTextContent(p.getNome());
			produtoTag.appendChild(nomeTag);
			
			Element marcaTag = doc.createElement("Marca");
			produtoTag.appendChild(marcaTag);			
				
				Element nomeMarcaTag = doc.createElement("NomeMarca");
				nomeMarcaTag.setTextContent(p.getMarca().getNomeMarca());
				marcaTag.appendChild(nomeMarcaTag);
				
				Element precoTag = doc.createElement("Preco");
				precoTag.setTextContent(p.getMarca().getPreco());
				marcaTag.appendChild(precoTag);			
		}
		
		//transforma esses elementos em objeto
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer trans = tf.newTransformer();
		
		trans.setOutputProperty(OutputKeys.INDENT , "yes"); //identa a lista
		trans.setOutputProperty("{http://xml.apache.org/xlst}indent-amount", "2");
		
		DOMSource source = new DOMSource(doc);
		
		//cria o novo arquivo
		try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(nomeDoArquivo), "UTF-8")) {
			
			StreamResult result = new StreamResult(osw);
			trans.transform(source, result);
		}
		
	}
	
	public static void LerArquivoXML () throws ParserConfigurationException, SAXException, UnsupportedEncodingException, FileNotFoundException, IOException {
		// o saxparser lê os arquivos xml e analisa eles
		SAXParserFactory spf = SAXParserFactory.newInstance(); // instância do objeto
		 
		SAXParser parser = spf.newSAXParser(); 
		File arquivoxml = new File(nomeDoArquivo);
		
		if (arquivoxml.exists()) {
		
		//qual arquivo e o tipode caractere que contem nele 
			try (InputStreamReader isr = new InputStreamReader(new FileInputStream(nomeDoArquivo), "UTF-8")) {	
				
				InputSource source = new InputSource(isr);
				XMLHandlerProdutos handler = new XMLHandlerProdutos();
				
				parser.parse(source, handler);
				
			}
		} else {
			try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(nomeDoArquivo), "UTF-8")) {
			}
		}
		
	}

}
