package ifrn.ed.lineares.pilha;

import ifrn.dominio.Aluno;
import ifrn.ed.lineares.listaEncadeada.NoFabio;
import ifrn.ed.lineares.util.EstruturaVaziaException;

public class PilhaNo2 {
	
	private NoFabio topo = null;
	
	public void empilhar(Aluno aluno) {
		NoFabio novo = new NoFabio();
		novo.setInfo(aluno);
		novo.setProximo(topo);
		topo = novo;
	}
	
	public NoFabio desempilhar() throws EstruturaVaziaException {
		if(topo == null) {
			throw new EstruturaVaziaException();
		}
		
		NoFabio topoAux = topo;
		topo = topo.getProximo();
		
		return topoAux;
	}
	
	public String toString() {
		String res = "";
		NoFabio aux = topo;
		while(aux != null) {
			res += aux.toString();
			aux = aux.getProximo();
		}
	
		return res;
	}
}
