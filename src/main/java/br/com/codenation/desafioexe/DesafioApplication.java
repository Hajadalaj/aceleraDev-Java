package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {
		int t;
		List<Integer> lista = new ArrayList<>();
		lista.add(0);
		lista.add(1);
		t = lista.size();
		while (lista.get(t-1) < 377){
			lista.add(lista.get(t -1) + lista.get(t -2));
			t = lista.size();
		}
		return lista;
	}

	public static Boolean isFibonacci(Integer a) {
		return fibonacci().contains(a);
	}
}