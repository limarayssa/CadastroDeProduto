package Principal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import ViewMercado.ViewCRUDProduto;

public class Executar {
public static void main(String[] args) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException, SAXException {
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	//o 1 serve pra não reescrever a lista sem ter cadastrado nada, pra não ficar vazia, caso peçam pra mostrar antes
	CRUDProduto.MostrarProdutos(1);
	
	int menu = 0;
	while (menu != 5) {
			
			menu = ViewCRUDProduto.ViewMenu(reader);
			
			
			switch (menu) {
			
			case 1: 
				CRUDProduto.CadastrarProdutos(reader);
				ViewCRUDProduto.msgFinal(0);
				break;
			
			case 2:
				CRUDProduto.MostrarProdutos(0); 
				break;
				
			case 3:
				CRUDProduto.DeletarProduto(reader);
				ViewCRUDProduto.msgFinal(1);
				break;
				
			case 4:
				CRUDProduto.EditarProduto(reader);
				ViewCRUDProduto.msgFinal(2);
				break;
				
			case 5:
				ViewCRUDProduto.msgFinal(3);
				break;
			}

	}
}
}
