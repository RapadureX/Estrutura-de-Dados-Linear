package ifrn.ed.lineares.listaEncadeada;

import ifrn.dominio.Aluno;
import ifrn.ed.lineares.util.ElementoInexistenteException;
import ifrn.ed.lineares.util.ListaVaziaException;

public class ListaEncIntFabio {
	
	private NoFabio inicio = null;
	
	@Override
	public String toString() {
		String res = "";
		NoFabio aux = inicio;
		while(aux != null) {
			res += aux.toString();
			aux = aux.getProximo();
		}
	
		return res;
	}
	
	public void inserir(Aluno aluno) {
		
		NoFabio novoElemento = new NoFabio();
		
		novoElemento.setInfo(aluno);
		novoElemento.setProximo(inicio);
		
		inicio = novoElemento;
		
	}
	
	public NoFabio buscar(Aluno aluno) throws ElementoInexistenteException {
		
		NoFabio aux = inicio;
		
		while(aux != null) {
			if(aux.getInfo().equals(aluno)) {
				return aux;
			}
			aux = aux.getProximo();
		}
		throw new ElementoInexistenteException();
	}
	
	/*public void remover(Aluno aluno) throws ElementoInexistenteException {
		
		NoFabio noAnterior = null;
		NoFabio no = this.buscar(aluno);
		NoFabio noAux = inicio;
		
		if(!no.equals(inicio)) {
			while(noAux != null) {
				if(noAux.getProximo() != null) {
					if(noAux.getProximo().equals(no)) {
						noAnterior = noAux;
					}
				}	
				noAux = noAux.getProximo();
			}
		}
			
		if(noAnterior != null) {
			noAnterior.setProximo(no.getProximo());
		}else {
			inicio = inicio.getProximo();
		}
	}*/
	
	public void remover(Aluno aluno) {
		
		NoFabio noAux = inicio;
		Aluno alunoNo = null;
		NoFabio noSeguinte = null;
		NoFabio noAnterior = null;
		
		while(noAux != null) {
			alunoNo = noAux.getInfo();
			noSeguinte = noAux.getProximo();
			
			if(alunoNo.equals(aluno)) {
				if(noAnterior == null) {
					inicio = inicio.getProximo();
				}else {
					if(noAux.getProximo() == null) {
						noAnterior.setProximo(null);
					}else {
						noAnterior.setProximo(noSeguinte);
					}
				}	
				noAux = null;
			}else {
				noAnterior = noAux;
				noAux = noSeguinte;
			}
	
		}
	}
	
	public void removerTodos(Aluno aluno) throws ElementoInexistenteException {
		
		NoFabio noAux = inicio;
		int cont = 0;
		while(noAux != null) {
			if(noAux.getInfo().equals(aluno)) {
				cont++;
			}
			noAux = noAux.getProximo();
		}
		
		for(int i = 0; i < cont; i++) {
			this.remover(aluno);
		}

	}
	
	public void limparLista() {
		this.inicio = null;
	}
	
	public boolean estaVazio() {
		return this.inicio == null;
	}
	
	public int length() throws ListaVaziaException{
		int cont = 0;
		NoFabio noAux = inicio;
		if(!this.estaVazio()) {
			while(noAux != null) {
				cont++;
				noAux = noAux.getProximo();
			}
			return cont;
		}else {
			throw new ListaVaziaException();
		}
		
	}
}
