package ifrn.ed.lineares.vetor;

import ifrn.dominio.Aluno;
import ifrn.ed.lineares.util.ElementoInexistenteException;
import ifrn.ed.lineares.util.EstruturaCheiaException;
import ifrn.ed.lineares.util.PosicaoInexistenteException;
import ifrn.ed.lineares.util.PosicaoVaziaException;

public class VetorFabioML implements Vetor{
	
	private Aluno[] alunos;
	private int posicao = 0;
	
	public VetorFabioML(int tamanho) {
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
			if(indice >=0 && indice < alunos.length) {
				if(alunos[indice] != null) {
					Aluno aux = alunos[indice];
					alunos[indice] = aluno;
					this.inserir(aux, indice++);
					posicao++;
				}else {
					alunos[indice] = aluno;
					posicao++;
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
		int ind = 0;
		if(alunos[ind].equals(aluno)) {
			ind++;
			this.buscar(aluno);
			return ind;
		}
		throw new ElementoInexistenteException();
	}

	@Override
	public void remover(int indice) throws PosicaoInexistenteException, PosicaoVaziaException {
		if(indice >=0 && indice < alunos.length) {
			if(alunos[indice] != null) {
				if(indice == (alunos.length-1)) {
					posicao--;
				}else {
					alunos[indice] = alunos[indice+1];
					this.remover(indice++);
					posicao--;
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
		int j;
		for(int i=0; i < posicao; i++) {
			if(alunos[i].equals(aluno)) {
				j = i;
				if(j < (posicao-1)) {
					alunos[j] = alunos[j+1];
					j++;
					this.remover(aluno);
					posicao--;
				}
			}else {
				throw new ElementoInexistenteException();
			}
		}
	}

}
