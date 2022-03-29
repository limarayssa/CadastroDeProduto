package Util;

import java.util.ArrayList;
import java.util.List;

import Mercadorias.Produtos;
//pacote para todas as utilidades
// m�todo para n�o ter que criar a inst�ncia da lista v�rias vezes
public class ListaDeProdutos {

	private static List<Produtos> listaDeProdutos = new ArrayList <Produtos>();
	
	public static List<Produtos> getInstance () {
		return listaDeProdutos;
	}
}
