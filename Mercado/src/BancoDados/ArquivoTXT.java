package BancoDados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Mercadorias.Produtos;
import Util.ListaDeProdutos;

public class ArquivoTXT {
	
	//chamar o nome do arquivo
	private static String arquivo = "Cadastro de Produtos.txt";
	
	public static void SalvarArquivoTXT () throws IOException {
		//cria no novo arquivo
		try (BufferedWriter buffer = new BufferedWriter (new FileWriter(arquivo));
				PrintWriter printwriter = new PrintWriter(buffer)) {
			
			//salva todas as informações dentro da lista
			for (Produtos p : ListaDeProdutos.getInstance())
				printwriter.println(p);
		}
	}

	public static void LerArquivoTxt () throws FileNotFoundException, IOException {
		
		try(FileWriter arq = new FileWriter(arquivo, true)) {};	
		
		String line = "";

		try (BufferedReader reader = new BufferedReader(new FileReader (arquivo))) {

			while ((line = reader.readLine())!= null && !"".equals(line)) //pra ter certeza que não ta vázio 
			{
				Produtos produtos = new Produtos(line); // construtor da lista com o line como parâmetro
				ListaDeProdutos.getInstance().add(produtos);
			}
		}
	}
}
