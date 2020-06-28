package br.com.codenation;

public class StatisticUtil {

		public static int average(int[] elements) {
			int avg = 0;
			int sum = 0;
			for (int i : elements) {
				sum = sum + i;
			}
			avg = sum / elements.length;
			return avg;
		}

		public static int mode(int[] elements) {
			int countIn = 0;
			int countOut = 0;
			int modelIn = 0;
			int modelOut = 0;
			for(int i = 0; i < elements.length; i++){
				modelIn = elements[i];
				for(int j = 0; j < elements.length; j++){
					if(elements[i] == elements[j]){
						countIn++;
					}
				}
				if(countIn > countOut){
					countOut = countIn;
					modelOut = modelIn;
				}
				countIn = 0;
			}
			return modelOut;
		}

		public static int median(int[] elements) {
			int index = 0;
			int retorno = 0;

			int[] vAux = sort(elements);

			for(int i = 0; i < vAux.length; i++){
				System.out.println(vAux[i]);
			}

			if(elements.length % 2 == 0){
				index = elements.length / 2;
				retorno = (elements[index] + elements[index - 1]) / 2;
			} else{
				index = elements.length / 2;
				retorno = elements[index];
			}
			
			return retorno;
		}

		private static int[] sort(int[] elements){
			int aux = 0;
			
			for(int i = 1; i < elements.length; i++){
				for(int j = 0; j < elements.length -1; j++){
					if(elements[j] > elements[j + 1]){
						aux = elements[j + 1];
						elements[j + 1] = elements[j];
						elements[j] = aux;
					}
				}
			}

			return elements;
		}

}