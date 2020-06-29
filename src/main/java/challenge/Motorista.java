package challenge;

import java.util.Objects;

public class Motorista {

    private final String nome;

    private final int idade;

    private final int pontos;

    private final String habilitacao;

    private Motorista(String nome, int idade, int pontos, String habilitacao) {
        if(nome == null || nome.equalsIgnoreCase("")){
            throw new NullPointerException("Motorista sem nome");
        }else if(habilitacao == null){
            throw new NullPointerException("Habilitação invalida");
        }else{
            this.nome = nome;
            this.habilitacao = habilitacao;
            this.idade = idade;
            this.pontos = pontos;
        }
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getPontos() {
        return pontos;
    }

    public String getHabilitacao() {
        return habilitacao;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Motorista motorista = (Motorista) o;
        return Objects.equals(habilitacao, motorista.habilitacao);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(habilitacao);
    }

    @Override
    public String toString() {
        return "Motorista{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", pontos=" + pontos +
                ", habilitacao='" + habilitacao + '\'' +
                '}';
    }

    public static MotoristaBuilder builder() {
        return new MotoristaBuilder();
    }


    public static class MotoristaBuilder {

        private String nome;

        private int idade;

        private int pontos;

        private String habilitacao;

        private MotoristaBuilder() {
        }
      
        public MotoristaBuilder withNome(String nome) {
                this.nome = nome;
                return this;
        }

        public MotoristaBuilder withIdade(int idade) {
            if(idade < 0){
                throw new IllegalArgumentException();
            }else{
            this.idade = idade;
            return this;
            }
        }

        public MotoristaBuilder withPontos(int pontos) {
            if(pontos < 0){
                throw new IllegalArgumentException("Pontos incorretos");
            }else{
                this.pontos = pontos;
                return this;
            }
        }

        public MotoristaBuilder withHabilitacao(String habilitacao) {
                this.habilitacao = habilitacao;
                return this;
        }


        public Motorista build() {
            return new Motorista(nome, idade, pontos, habilitacao);
        }
    }
}
