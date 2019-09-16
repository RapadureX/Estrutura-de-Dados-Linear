package ifrn.ed.lineares.listaEncadeada;

import ifrn.dominio.Aluno;
import ifrn.ed.lineares.util.ElementoInexistenteException;

public class ListaEncadeadaFabio {
	
	private NoFabio primeiro = null;
	
	@Override
	public String toString() {
		String res = "";
		NoFabio aux = primeiro;
		int ind = 0;
		while(aux != null) {
			res += aux.toString();
			ind++;
			aux = aux.getProximo();
		}
	
		return res;
	}
	
	public void inserir(Aluno aluno) {
		
		NoFabio novoElemento = new NoFabio();
		novoElemento.setInfo(aluno);
		novoElemento.setProximo(primeiro);
		primeiro = novoElemento;
		
	}
	
	public NoFabio buscar(Aluno aluno) throws ElementoInexistenteException {
		if(primeiro.buscarNo(aluno) != null) {
			return primeiro.buscarNo(aluno);
		}
		throw new ElementoInexistenteException();	
	}
	
	public void remover(Aluno aluno) throws ElementoInexistenteException {
		
		NoFabio elemento = this.buscar(aluno);
		NoFabio anterior = null;
		
		if(elemento != null) {
			if(!elemento.equals(primeiro)) {
				anterior = primeiro.buscarProximo(elemento);
			}
			if(anterior != null) {
				anterior.setProximo(elemento.getProximo());;
			}else {
				primeiro = primeiro.getProximo();
			}
		}else {
			throw new ElementoInexistenteException();
		}
	}
	
	public void clearList() {
		this.primeiro = null;
	}
	
	public boolean isEmpty() {
		return this.primeiro == null;
	}
}
