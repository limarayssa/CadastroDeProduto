package Mercadorias;

public class Produtos {

	private String categoria;
	private String nome;
	private Marca marca;

	//construtor vazio
	public Produtos() {
	}

	//construtor que trata os dados
	public Produtos (String dados) {

		//o split quebra a informação em duas
		String [] atributos = dados.split(",");
		String [] categoria = atributos[1].split("=");
		String [] nome = atributos[2].split("=");
		Marca marcaP = new Marca (atributos);

		//esse 1 é o espaço alocado para a informação quebrada, que são essas variáveis
		this.categoria = categoria[1].trim();
		this.nome = nome[1].trim();
		this.marca = marcaP;
	}


	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}



	@Override
	public String toString() {
		//forma como fica na lista de txt
		return "Produto, categoria= " + categoria + ", nome= " + nome + ", marca= " + marca;
	}


}
