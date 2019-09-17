package ifrn.ed.lineares.listaEncadeada;

import ifrn.dominio.Aluno;
import ifrn.ed.lineares.util.ElementoInexistenteException;
import ifrn.ed.lineares.util.ListaVaziaException;

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
	
	public NoFabio buscar(Aluno aluno) throws ElementoInexistenteException, ListaVaziaException{
		
		if(this.listaVazia()) {
			throw new ListaVaziaException();
		}
		
		NoFabio aux = primeiro.getProximo();
		
		if(primeiro.getInfo().equals(aluno)) {
			return primeiro;
		}else if(ultimo.getInfo().equals(aluno)){
			return ultimo;
		}else {	
			while(aux != ultimo) {
				if(aux.getInfo().equals(aluno)) {
					return aux;
				}
				aux = aux.getProximo();
			}
		}
		
		throw new ElementoInexistenteException();
	}
	
	public void remover(Aluno aluno) throws ElementoInexistenteException, ListaVaziaException{
		
		if(this.listaVazia()) {
			throw new ListaVaziaException();
		}
		
		NoFabio anterior = null;
		NoFabio seguinte = null;
		boolean exist = false;
		
		if((primeiro.equals(ultimo)) && (primeiro.getInfo().equals(aluno))) {
			
			exist = true;
			primeiro = null;
			ultimo = null;
		
		}else if(primeiro.getInfo().equals(aluno)) {
			
			exist = true;
			primeiro = primeiro.getProximo();	
			ultimo.setProximo(primeiro);
			
		}else {
			
			NoFabio aux = primeiro.getProximo();
			Aluno alunoNo = null;
			
			while(aux != ultimo) {
			
				alunoNo = aux.getInfo();
				seguinte = aux.getProximo();
				
				if(alunoNo.equals(aluno)) {
					exist = true;
					anterior.setProximo(seguinte);
					aux = ultimo;
				}else {
					anterior = aux;
					aux = seguinte;
				}
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
	
	public boolean listaVazia() {
		return primeiro == null;
	}
}
