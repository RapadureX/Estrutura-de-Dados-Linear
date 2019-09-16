package ifrn.ed.lineares.vetor;

import ifrn.dominio.Aluno;
import ifrn.ed.lineares.util.ElementoInexistenteException;
import ifrn.ed.lineares.util.EstruturaCheiaException;
import ifrn.ed.lineares.util.PosicaoInexistenteException;
import ifrn.ed.lineares.util.PosicaoVaziaException;

public class VetorFabioMiguel implements Vetor {
	
	private Aluno[] alunos;
	private int posicao = 0;
	
	public VetorFabioMiguel(int tamanho) {
		alunos = new Aluno[tamanho];
	}
	
	@Override
	public String toString() {
		String res = "";
		for (int i = 0; i < posicao; i++) {
			res += "| "+ i + " " + alunos[i].toString();
		}
		return res;
	}
	
	@Override
	public void inserir(Aluno aluno) throws EstruturaCheiaException {
		if(posicao < alunos.length) {
			alunos[posicao++] = aluno;
		}else {
			throw new EstruturaCheiaException();
		}
	}

	@Override
	public void inserir(Aluno aluno, int indice) throws EstruturaCheiaException, PosicaoInexistenteException {
		if(posicao < alunos.length) {
			if(indice >= 0 && indice < alunos.length) {
				if(alunos[indice] != null) {
					for(int i = indice; i < posicao+1; i++) {
						Aluno aux = alunos[i];
						alunos[i] = aluno;
						aluno = aux;
					}
					posicao++;
				}else {
					alunos[posicao++] = aluno;
				}
			}else {
				throw new PosicaoInexistenteException();
			}
		}else {
			throw new EstruturaCheiaException();
		}
	}

	@Override
	public Aluno buscar(int indice) throws PosicaoInexistenteException, PosicaoVaziaException {
		if(indice >= 0 && indice < alunos.length) {
			if(alunos[indice] != null) {
				return alunos[indice];
			}else {
				throw new PosicaoVaziaException();
			}
		}else {
			throw new PosicaoInexistenteException();
		}
	}

	@Override
	public int buscar(Aluno aluno) throws ElementoInexistenteException {
		for(int i = 0; i < posicao; i++) {
			if(alunos[i].equals(aluno)) {
				return i; 
			}
		}
		throw new ElementoInexistenteException();
	}

	@Override
	public void remover(int indice) throws PosicaoInexistenteException, PosicaoVaziaException {
		if(indice >=0 && indice < alunos.length) {
			if(alunos[indice] != null) {
				if(indice == (alunos.length-1)) {
					posicao--;
					alunos[indice] = null;
				}else {
					for(int i = indice; i < posicao-1; i++) {
						alunos[i] = alunos[i+1];
					}
					posicao--;
					alunos[posicao] = null;
				}	
			}else {
				throw new PosicaoVaziaException();
			}
		}else {
			throw new PosicaoInexistenteException();
		}
	}

	@Override
	public void remover(Aluno aluno) throws ElementoInexistenteException {
		int existe = 0;
		for(int i = 0; i < posicao; i++) {
			if(alunos[i].equals(aluno)) {
				existe = 1;
				if(i == (alunos.length-1)) {
					posicao--;
					alunos[i] = null;
				}else {
					for(int j = i; j < posicao-1; j++) {
						alunos[j] = alunos[j+1];
					}
					posicao--;
					alunos[posicao] = null;
				}
				break;
			}
		}
		if(existe == 0) {
			throw new ElementoInexistenteException();
		}
			
	}
	
}
