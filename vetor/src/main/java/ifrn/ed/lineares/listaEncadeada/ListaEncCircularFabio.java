package ifrn.ed.lineares.listaEncadeada;

import ifrn.dominio.Aluno;
import ifrn.ed.lineares.util.ElementoInexistenteException;

public class ListaEncCircularFabio {
	
	private NoFabio primeiro = null;
	private NoFabio ultimo = null;
	
	@Override
	public String toString() {
		
		String res = "";
		NoFabio aux = primeiro;
		
		while(aux != ultimo) {
			res += aux.toString();
			aux = aux.getProximo();
		}
		
		res += ultimo.toString();
		
		return res;
	}
	
	public NoFabio getPrimeiro() {
		return this.primeiro;
	}
	
	public void inserir(Aluno aluno) {
		
		NoFabio novoElemento = new NoFabio();
		
		novoElemento.setInfo(aluno);
		novoElemento.setProximo(primeiro);
		
		if(primeiro == null) {
			primeiro = novoElemento;
			ultimo = novoElemento;
		}else {
			primeiro = novoElemento;
		}
		
		ultimo.setProximo(primeiro);
	}
	
	public NoFabio buscar(Aluno aluno) throws ElementoInexistenteException{
		
		NoFabio aux = primeiro;
		
		if(primeiro.getInfo().equals(aluno)) {
			return primeiro;
		}else {
			while(aux != ultimo) {
				if(aux.getProximo().getInfo().equals(aluno)) {
					return aux.getProximo();
				}
				aux = aux.getProximo();
			}
		}
		throw new ElementoInexistenteException();
	}
	
	public void remover(Aluno aluno) throws ElementoInexistenteException{
		
		NoFabio aux = primeiro;
		NoFabio anterior = null;
		NoFabio seguinte = null;
		Aluno alunoNo = null;
		boolean exist = false;
		
		while(aux != ultimo) {
			
			alunoNo = aux.getInfo();
			seguinte = aux.getProximo();
			
			if(alunoNo.equals(aluno)) {
				exist = true;
				if(anterior == null) {
					primeiro = primeiro.getProximo();
					ultimo.setProximo(primeiro);
				}else {
					anterior.setProximo(seguinte);
				}
				aux = ultimo;
			}else {
				anterior = aux;
				aux = seguinte;
			}
		}
		
		if(ultimo.getInfo().equals(aluno)) {
			exist = true;
			anterior.setProximo(primeiro);
			ultimo = anterior;
		}
		
		if(!exist) {
			throw new ElementoInexistenteException();
		}
	}

}
