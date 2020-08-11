package com.challenge.desafio;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

public class CalculadorDeClasses implements Calculavel {

	public BigDecimal somar(Object classe) {
		return calcular(classe, Somar.class);
	}

	public BigDecimal subtrair(Object classe) {
		return calcular(classe, Subtrair.class);
	}

	public BigDecimal totalizar(Object classe) {
		return somar(classe).subtract(subtrair(classe));
	}

	private BigDecimal calcular(Object objeto, Class anotacao) {
		BigDecimal resultado = BigDecimal.ZERO;
		Class classe = objeto.getClass();
		for (Field atributo : classe.getDeclaredFields()) {
			if (atributo.getType().equals(BigDecimal.class) && atributo.isAnnotationPresent(anotacao)) {
				atributo.setAccessible(true);
				try {
					resultado = resultado.add((BigDecimal) atributo.get(objeto));
				} catch (IllegalAccessException e) {
						e.printStackTrace();
				}
		}
	}

	return resultado;
	
}

}