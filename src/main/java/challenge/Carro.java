package challenge;

import java.util.Objects;

public class Carro {

    private final Motorista motorista;

    private final String placa;

    private final Cor cor;

    private Carro(Motorista motorista, String placa, Cor cor) {
        if(placa == null || placa.equalsIgnoreCase("")){
            throw new NullPointerException("Carro sem Placa");
        }else{
            this.placa = placa;
        }
        if(cor == null){
            throw new NullPointerException("Carro sem Cor");
        }else{
            this.cor = cor;
        }
        this.motorista = motorista;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public String getPlaca() {
        return placa;
    }

    public Cor getCor() {
        return cor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Carro carro = (Carro) o;
        return Objects.equals(motorista, carro.motorista) &&
                Objects.equals(placa, carro.placa) &&
                cor == carro.cor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(motorista, placa, cor);
    }

    @Override
    public String toString() {
        return "Carro{" +
                "motorista=" + motorista +
                ", placa='" + placa + '\'' +
                ", cor=" + cor +
                '}';
    }
    public void validador(){
        if(this.getMotorista() == null){
                throw new EstacionamentoException("naoDeveTerCarroAutonomo");
            }
        if(this.getMotorista().getIdade() < 18){
                throw new EstacionamentoException("naoDeveTerMotoristaDeMenor");
        }
        if(this.getMotorista().getPontos() > 20){
            throw new EstacionamentoException("naoDeveEstacionarMotoristaSemPontos");
    }
    }
    public static CarroBuilder builder() {
        return new CarroBuilder();
    }


    public static class CarroBuilder {

        private Motorista motorista;

        private String placa;

        private Cor cor;

        private CarroBuilder() {
        }

        public CarroBuilder withMotorista(Motorista motorista) {
            this.motorista = motorista;
            return this;
        }

        public CarroBuilder withPlaca(String placa) {
            this.placa = placa;
            return this;
        }

        public CarroBuilder withCor(Cor cor) {
            this.cor = cor;
            return this;
        }

        public Carro build() {
            return new Carro(motorista, placa, cor);
        }
    }
}
