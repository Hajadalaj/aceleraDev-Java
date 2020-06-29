package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    private List<Carro> estacionamento = new ArrayList<>(); 

    public Estacionamento() {
    }
    
    public List<Carro> getEstacionamento() {
        return estacionamento;
    }
    
    public void estacionar(Carro carro) {
        carro.validador();
      if(carrosEstacionados() < 10){
        estacionamento.add(carro);
        System.out.println(carro.getPlaca());
          
      }else{
        for(int i = 0, gatilho = 0; gatilho != 1 &&
        i < estacionamento.size()-1; i++){
            if(estacionamento.get(i).getMotorista().getIdade()<55){
                estacionamento.set(i,carro);
                gatilho = 1;
            }
        }
        if(!carroEstacionado(carro)){
          throw new EstacionamentoException("Estacionamento Cheio");
        }
      }
    }

    public int carrosEstacionados() {
        return estacionamento.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return estacionamento.contains(carro);
    }

    @Override
    public String toString(){
        String msg = "";
        for(Carro car:estacionamento){
            msg = msg + car.getPlaca() + "| ";
        }
        return msg;
    }

}
