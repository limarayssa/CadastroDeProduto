package ViewMercado;

import java.io.BufferedReader;
import java.io.IOException;
//import Principal.Executar;

import Mercadorias.Produtos;
import Util.ListaDeProdutos;

public class ViewCRUDProduto {
//pacote dedicado a tudo que vai mostrar informa��es pro usu�rio
	public static int ViewMenu (BufferedReader reader) throws NumberFormatException, IOException {
		System.out.println("\nBem vindo ao sistema do supermercado!");
		System.out.println("\nEscolha o que deseja fazer:"
				+ "\n1 - Cadastrar produto"
				+ "\n2 - Consultar produtos"
				+ "\n3 - Deletar Produtos"
				+ "\n4 - Editar Produtos"
				+ "\n5 - Sair");
		

	return  Integer.parseInt(reader.readLine());
	}
	 
	
	public static String[] ViewMenuSalvarProduto (BufferedReader reader) throws IOException {
		//String que mostra os atributos pro usu�rio
		String [] menuProduto = {"Categoria (ex Alimento, Bebida): ", " Nome (ex Feij�o, Arroz): ",
				" Marca: ", " Pre�o: "};
		//espa�o alocado para as informa��es 
		String [] dadosProduto = {"", "", "", ""};
		
		for(int i = 0; i< dadosProduto.length; i++) {
			System.out.println(menuProduto[i]);
			dadosProduto[i] = reader.readLine();
		}
		return dadosProduto;
	}
	
	
	public static int ViewMenuEditarOuDeletarProduto (String editar_deletar, BufferedReader reader) throws NumberFormatException, IOException {
		//l� todos as informa��es da lista 
		for (int i = 0; i <ListaDeProdutos.getInstance().size(); i++)
			//mostra a lista pro usu�rio
			System.out.println(i + " - " + ListaDeProdutos.getInstance().get(i));
		
		System.out.println();
		System.out.println("Dentre a lista acima, escolha o �ndice do produto que deseja " + editar_deletar);
		
		return Integer.parseInt(reader.readLine()); //retorna um valor inteiro 
	}
	
	public static String[] ViewOpcaoEdicao (BufferedReader reader) throws IOException {
		//para poder retornar os dois valores (switch e atributos) usamos um array de string 
		String[] dadosEditados = {"", ""};
		
		System.out.println("Escolha o atributo que deseja alterar: ");
		System.out.println("\n1 - Categoria"
						+ "\n2 - Nome"
						+ "\n3 - Marca"
						+ "\n4 - Pre�o");
		
		dadosEditados [0] = reader.readLine(); // espa�o 0 � onde fica o indice do inteiro que vai no switch
		System.out.printf("Reescreva o valor do atributo: ");
		dadosEditados [1] = reader.readLine(); //1 � atributo
		
		return dadosEditados;
	}
	
	public static void ViewListaDeProdutosEditada () {
		//mostra as informa��es depois de alterar
		for (Produtos p: ListaDeProdutos.getInstance()) {
			System.out.println("\n-------- Dados do Produto --------");
			System.out.println("Categoria: " + p.getCategoria());
			System.out.println("Nome: " + p.getNome());
			System.out.println("Marca: " + p.getMarca().getNomeMarca());
			System.out.println("Pre�o: " + p.getMarca().getPreco());
			System.out.println("------------------------------------\n");
		}
	}
	
	public static void msgFinal (int op) {
		String[] msgFinal = {"Cadastro realizado com sucesso!", "Produto editado com sucesso!", "Produto deletado com sucesso", "Obrigada por usar nosso sistema!"};
		System.out.println(msgFinal[op]);
	}
}

