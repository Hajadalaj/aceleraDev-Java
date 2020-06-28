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
        validador(carro);
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
        for(int i = 0; i < this.estacionamento.size();i++){
            msg = msg + this.estacionamento.get(i).getPlaca() + "| ";
        }
        return msg;
    }

    private void validador(Carro carro){
        if(carro.getMotorista() == null){
                throw new EstacionamentoException("naoDeveTerCarroAutonomo");
            }
        if(carro.getMotorista().getIdade() < 18){
                throw new EstacionamentoException("naoDeveTerMotoristaDeMenor");
        }
        if(carro.getMotorista().getPontos() > 20){
            throw new EstacionamentoException("naoDeveEstacionarMotoristaSemPontos");
    }
    }

}
