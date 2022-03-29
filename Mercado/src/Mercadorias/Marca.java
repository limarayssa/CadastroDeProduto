package Mercadorias;

public class Marca {

	private String nomeMarca;
	private String preco;
	
	//getters and setters dps atributos dentro de marca
	
	public Marca() {
	}

	public Marca(String [] marcas) {
		
		String [] preco = marcas[4].split("=");
		String [] nomeMarca = marcas[3].split("=");
		this.nomeMarca = nomeMarca[1].trim();
		this.preco = preco[1].trim();
	}
	
	public String getNomeMarca() {
		return nomeMarca;
	}
	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	@Override
	public String toString() {
		return  nomeMarca + ",preço= " + preco;
	}

	
}
