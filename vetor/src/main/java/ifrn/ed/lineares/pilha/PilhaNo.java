package ifrn.ed.lineares.pilha;

import ifrn.dominio.Aluno;
import ifrn.ed.lineares.listaEncadeada.ListaEncIntFabio;
import ifrn.ed.lineares.listaEncadeada.NoFabio;
import ifrn.ed.lineares.util.EstruturaVaziaException;

public class PilhaNo {
	
	private NoFabio topo = null;
	private ListaEncIntFabio lista;
	
	public PilhaNo() {
		lista = new ListaEncIntFabio();
	}
	
	public void empilhar(Aluno aluno) {
		topo = lista.inserir(aluno);
	}
	
	public NoFabio desempilhar() throws EstruturaVaziaException {
		if(topo == null) {
			throw new EstruturaVaziaException();
		}
		NoFabio topoAux = topo;
		topo = topo.getProximo();
		lista.remover(topoAux.getInfo());
		
		return topoAux;
	}
	
	public String toString() {
		return lista.toString();
	}
}
