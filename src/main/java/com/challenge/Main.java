package com.challenge;

import com.challenge.desafio.CalculadorDeClasses;
import com.challenge.desafio.Salario;

public class Main {
 public static void main(String[] args) {
  CalculadorDeClasses calcular = new CalculadorDeClasses();
  System.out.println(calcular.somar(Salario.class));
  System.out.println(calcular.subtrair(Salario.class));
  System.out.println(calcular.totalizar(Salario.class));
 }
 
}