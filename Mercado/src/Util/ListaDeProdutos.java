package Util;

import java.util.ArrayList;
import java.util.List;

import Mercadorias.Produtos;
//pacote para todas as utilidades
// método para não ter que criar a instância da lista várias vezes
public class ListaDeProdutos {

	private static List<Produtos> listaDeProdutos = new ArrayList <Produtos>();
	
	public static List<Produtos> getInstance () {
		return listaDeProdutos;
	}
}
