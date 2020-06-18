package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		if(salarioBase < 1039.00){
			return Math.round(0.0);
		}
        salarioBase = calcularInss(salarioBase);
        salarioBase = calcularIRRF(salarioBase);
        
		return Math.round(salarioBase);
	}

	private double calcularInss(double salarioBase) {
		if(salarioBase < 1500.01){
			salarioBase = salarioBase - salarioBase * 0.08;
		}else if(salarioBase < 4000.01){
            salarioBase = salarioBase - salarioBase * 0.09;
        } else{
            salarioBase = salarioBase - salarioBase * 0.11;
        }
		return salarioBase;
    }
    
    private double calcularIRRF(double salarioBrutoInss){
        if(salarioBrutoInss > 3000.00 && salarioBrutoInss < 6000.01){
            salarioBrutoInss = salarioBrutoInss - salarioBrutoInss * 0.075;
        }else if(salarioBrutoInss > 6000.00){
            salarioBrutoInss = salarioBrutoInss - salarioBrutoInss * 0.15;

        }
        return salarioBrutoInss;
    }
}



