package ifrn.ed.lineares.fila;

import ifrn.dominio.Aluno;
import ifrn.ed.lineares.listaEncadeada.NoDuplaFabio;
import ifrn.ed.lineares.listaEncadeada.NoFabio;
import ifrn.ed.lineares.util.EstruturaVaziaException;

public class FilaNo {
	
	NoDuplaFabio inicio = null;
	NoDuplaFabio fim = null;
	
	public void enfileirar(Aluno aluno) {
		
		NoDuplaFabio novo = new NoDuplaFabio();
		novo.setInfo(aluno);
		novo.setProximoNo(fim);
		novo.setNoAnterior(null);
		
		if(inicio == null) {
			inicio = novo;
		}else {
			fim.setNoAnterior(novo);
		}
		
		fim = novo;
	}
	
	public NoDuplaFabio desenfileirar() throws EstruturaVaziaException {
		
		if(fim == null) {
			throw new EstruturaVaziaException();		
		}
		
		NoDuplaFabio noAux = inicio;
		inicio.getNoAnterior().setProximoNo(null);
		inicio = inicio.getNoAnterior();
		
		return noAux;
		
	}
	
	public String toString() {
		
		String res = "";
		NoDuplaFabio aux = fim;
		
		while(aux != null) {
			
			res += aux.toString();
			aux = aux.getProximoNo();
		
		}
		
		return res;
	}
	
}
