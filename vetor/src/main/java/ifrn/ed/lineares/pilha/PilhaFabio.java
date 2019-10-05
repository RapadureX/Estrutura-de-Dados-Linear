package ifrn.ed.lineares.pilha;

import ifrn.dominio.Aluno;
import ifrn.ed.lineares.util.EstruturaVaziaException;

public class PilhaFabio {
	
	private Aluno alunos[];
	private int top = 0;
	
	public PilhaFabio(int size) {
		alunos = new Aluno[size];
	}
	
	public void inserir(Aluno aluno) {
		if(top == alunos.length) {
			this.aumentarSizePilha();
		}else {
			alunos[top++] = aluno;
		}

	}
	
	public Aluno remover() throws EstruturaVaziaException {
		if(top == 0) {
			throw new EstruturaVaziaException();
		}
		
		return alunos[--top];
	}
	
	public void aumentarSizePilha() {
		
		int size = alunos.length + 5;
		Aluno aux[] = alunos;
		alunos = new Aluno[size];
		for(int i=0; i < aux.length; i++) {
			alunos[i] = aux[i];
		}
		
	}
	
	@Override
	public String toString() {
		String str = "";
		for(int i = 0; i < top; i++) {
			str += alunos[i].toString();
		}
		
		return str;
	}
	
	public int lengtn() {
		return alunos.length;
	}
}
