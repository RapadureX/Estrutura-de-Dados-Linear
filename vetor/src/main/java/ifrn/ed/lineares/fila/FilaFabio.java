package ifrn.ed.lineares.fila;

import ifrn.dominio.Aluno;
import ifrn.ed.lineares.util.EstruturaCheiaException;
import ifrn.ed.lineares.util.EstruturaVaziaException;

public class FilaFabio {
	
	private Aluno alunos[];
	private int primeiro = 0;
	private int ultimo = 0;
	private int contAluno = 0;
	
	public FilaFabio(int size) {
		alunos = new Aluno[size];
	}
	
	public void inserir(Aluno aluno) throws EstruturaCheiaException {
		
		if(contAluno == alunos.length)  {
			throw new EstruturaCheiaException();
		}
		
		if(ultimo == alunos.length) {
			ultimo = 0;
		}
		
		alunos[ultimo++] = aluno;
		contAluno++;
	}
	
	public void remover() throws EstruturaVaziaException {
		
		if(contAluno == 0) {
			throw new EstruturaVaziaException();
		}
		
		primeiro++;
		
		if(primeiro == alunos.length) {
			primeiro = 0;
		}
		
		contAluno--;
	}
	
	@Override 
	public String toString() { 
		String str = "";
		int cont = 0;
		int p = primeiro;
		int u = ultimo;
		while(cont < contAluno) {
			if(p < alunos.length) {
				str += alunos[p++].toString()+"\n";
			}else if ((u-1) < primeiro) {
				str += alunos[u++].toString()+"\n";
			}
			cont++;
		}
		
		return str;
		
	}
}
