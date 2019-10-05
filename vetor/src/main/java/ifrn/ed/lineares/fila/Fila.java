package ifrn.ed.lineares.fila;

import ifrn.dominio.Aluno;
import ifrn.ed.lineares.util.EstruturaCheiaException;
import ifrn.ed.lineares.util.EstruturaVaziaException;

public class Fila {
	
	private Aluno alunos[];
	private int inicio;
	private int fim;
	
	public Fila() {
		alunos = new Aluno[(5+1)];
		inicio = 0;
		fim = 0;
	}
	
	public Fila(int size) {
		alunos = new Aluno[(size+1)];
		inicio = 0;
		fim = 0;
	}
	
	public void inserir(Aluno aluno) throws EstruturaCheiaException {
		
		if(inicio == ((fim + 1) % alunos.length)) {
			throw new EstruturaCheiaException();
		}
		
		fim = (fim + 1) % alunos.length;
		alunos[fim] = aluno;
	}
	
	public Aluno remover() throws EstruturaVaziaException {
		
		if(inicio == fim) {
			throw new EstruturaVaziaException();
		}
		
		inicio = (inicio + 1) % alunos.length;
		return alunos[inicio];
	}
	
	public int contAlunos() {
		if(inicio <= fim) {
			return (fim - inicio);
		}
		
		return (alunos.length - (inicio - fim));
	}
	
	@Override
	public String toString() {
		String str = "";
		int cont = 0;
		int p = inicio;
		int u = fim;
		while(cont < contAlunos()) {
			if(p < alunos.length) {
				str += alunos[p++].toString()+"\n";
			}else if ((u-1) < inicio) {
				str += alunos[u++].toString()+"\n";
			}
			cont++;
		}
		
		return str;
	}

}
