package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;


public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private List<Jogador> jogadores = new ArrayList<>();
	private List<Time> times = new ArrayList<>();
	private Map<Long, Long> capitaes = new HashMap<>();
	

	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		Time novoTime = new Time(id, nome, dataCriacao, corUniformeSecundario, corUniformeSecundario);
		if(timeExiste(novoTime.getId())){
			throw new IdentificadorUtilizadoException();
		}
		times.add(novoTime);
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		Jogador novoJogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
		if(jogadorExiste(novoJogador.getId())){
			throw new IdentificadorUtilizadoException();			
		} else if (!timeExiste(novoJogador.getIdTime())) {
			throw new TimeNaoEncontradoException();
		}
		jogadores.add(novoJogador);
	}

	public void definirCapitao(Long idJogador) {
		if (!jogadorExiste(idJogador)) {
			throw new JogadorNaoEncontradoException();
		}
		for (Jogador jogador : jogadores) {
			if (idJogador.equals(jogador.getId())) {
				capitaes.put(jogador.getIdTime(), jogador.getId());
			}
		}
	}

	public Long buscarCapitaoDoTime(Long idTime) {
		if (!timeExiste(idTime)) {
			throw new TimeNaoEncontradoException();
		} else if ( capitaes.containsKey(idTime)) {
			return capitaes.get(idTime);			
		} else {
			throw new CapitaoNaoInformadoException();
		}
		
	}

	public String buscarNomeJogador(Long idJogador) {
		if (!jogadorExiste(idJogador)) {
			throw new JogadorNaoEncontradoException();
		}
		for (Jogador jogador : jogadores) {
			if (idJogador.equals(jogador.getId())) {
				return jogador.getNome();
			}			
		}
		return null;
	}

	public String buscarNomeTime(Long idTime) {
		if (!timeExiste(idTime)) {
			throw new TimeNaoEncontradoException();
		}
		for (Time time : times) {
			if (idTime.equals(time.getId())){
				return time.getNome();
			}
		}
		return null;
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		if (!timeExiste(idTime)) {
			throw new TimeNaoEncontradoException();			
		}
		List<Long> listaIdJogadores = new ArrayList<>();
		for (Time time : times) {
			if(idTime.equals(time.getId())){
				for (Jogador jogador : jogadores) {
					listaIdJogadores.add(jogador.getId());
				}
				Collections.sort(listaIdJogadores);
			} 
		}
		return listaIdJogadores;
	}
	

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		if (!timeExiste(idTime)) {
			throw new TimeNaoEncontradoException();
		}
		return jogadores.stream()
		.filter(jogador -> jogador.getIdTime().equals(idTime))
		.max(Comparator.comparing(jogador -> jogador.getNivelHabilidade()))
		.get()
		.getId();
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		if (!timeExiste(idTime)) {
			throw new TimeNaoEncontradoException();
		}
		return jogadores.stream()
		.filter(jogador -> jogador.getIdTime().equals(idTime))
		.min(Comparator.comparing(jogador -> jogador.getDataNascimento()))
		.get()
		.getId();
	}

	public List<Long> buscarTimes() {
		List<Long> listaId = new ArrayList<>();
		if(times.isEmpty()){
			return listaId;
		}
			for (Time time : times) {
				listaId.add(time.getId());			
			}
			Collections.sort(listaId);
			return listaId;
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		if (!timeExiste(idTime)) {
			throw new TimeNaoEncontradoException();
		}
		return jogadores.stream()
		.filter(jogador -> jogador.getIdTime().equals(idTime))
		.max(Comparator.comparing(jogador -> jogador.getSalario()))
		.get()
		.getId();
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		if (!jogadorExiste(idJogador)) {
			throw new JogadorNaoEncontradoException();
		}
		for (Jogador jogador : jogadores) {
			if (idJogador.equals(jogador.getId())) {
				return jogador.getSalario();
			}			
		}
		return null;
	}

	public List<Long> buscarTopJogadores(Integer top) {
		List<Long> topJogadores = new ArrayList<>();
		if (jogadores.isEmpty()) {
			return topJogadores;
		}
		Comparator<Jogador> comparadorPorHabilidade = (Jogador a, Jogador b) -> 
				a.getNivelHabilidade().compareTo(b.getNivelHabilidade());
		Collections.sort(jogadores, comparadorPorHabilidade.reversed());
			for ( int i = 0; i < top; i++) {
			topJogadores.add(jogadores.get(i).getId());
		}
		return topJogadores;
	}

	private boolean timeExiste(Long id){
    for (Time time : this.times) {
      if(id.equals(time.getId())){
        return true;
      }
    }
    return false;
  }
 private boolean jogadorExiste(Long id){
		for (Jogador jogador : this.jogadores) {
			if(id.equals(jogador.getId())){
				return true;
			}
		}
		return false;
 }

}
