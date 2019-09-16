package ifrn.ed.lineares.listaEncadeada;

import ifrn.dominio.Aluno;
import ifrn.ed.lineares.util.ElementoInexistenteException;

public class ListaDuplamenteEncadFabio {
	
	private NoDuplaFabio inicio = null;
	private NoDuplaFabio fim = null;

	@Override
	public String toString() {
		
		String res = "";
		NoDuplaFabio aux = inicio;
		
		while(aux != null) {
			
			res += aux.toString();
			aux = aux.getProximoNo();
		
		}
		
		return res;
	}

	public void inserir(Aluno aluno) {
		
		NoDuplaFabio novoElemento = new NoDuplaFabio();
		
		novoElemento.setInfo(aluno);
		novoElemento.setProximoNo(inicio);
		novoElemento.setNoAnterior(null);
		
		if(inicio == null) {
			
			fim = novoElemento;
			
		}else {
			
			inicio.setNoAnterior(novoElemento);
			
		}
		
		inicio = novoElemento;
	}
	
	public NoDuplaFabio buscar(Aluno aluno) throws ElementoInexistenteException{
		
		NoDuplaFabio aux1 = inicio;
		NoDuplaFabio aux2 = fim;
		Aluno alunoAnterior;
		Aluno alunoSeguinte;
		
		while(aux1 != null) {
			
			alunoSeguinte = aux1.getInfo();
			alunoAnterior = aux2.getInfo();
			
			if(!alunoSeguinte.equals(alunoAnterior)) {
				
				if(alunoSeguinte.equals(aluno)) {
					
					return aux1;
					
				}else if(alunoAnterior.equals(aluno)) {
					
					return aux2;
					
				}
				
				if(aux1 != null) {
					if(aux1.getProximoNo().equals(aux2)) {
						
						aux1 = null;
						
					}
				}	
				
			}else if(alunoSeguinte.equals(aluno)){
				
				return aux1;
				
			}else if(aux1.getNoAnterior() != null && aux2.getProximoNo() != null) {
				
				aux1 = null;
				
			}
			
			if(aux1 != null) {
				
				aux1 = aux1.getProximoNo();
				aux2 = aux2.getNoAnterior();
				
			}
			
		}
		
		throw new ElementoInexistenteException();
	}
	
	public void remover(Aluno aluno) throws ElementoInexistenteException {
		
		NoDuplaFabio aux1 = inicio;
		NoDuplaFabio aux2 = fim;
		Aluno alunoAnterior;
		Aluno alunoSeguinte;
		boolean existe = false;
		
		while(aux1 != null) {
			
			alunoSeguinte = aux1.getInfo();
			alunoAnterior = aux2.getInfo();
			
			if(!alunoSeguinte.equals(alunoAnterior)) {
				
				if(alunoSeguinte.equals(aluno)) {
					
					existe = true;
					
					if(aux1.equals(inicio)) {
						
						inicio = inicio.getProximoNo();
						inicio.setNoAnterior(null);
						
					}else {
						
						aux1.getNoAnterior().setProximoNo(aux1.getProximoNo());
						aux1.getProximoNo().setNoAnterior(aux1.getNoAnterior());
					}
					
					aux1 = null;
					
				}else if(alunoAnterior.equals(aluno)) {
					
					existe = true;
					
					if(aux2 .equals(fim)) {
						
						fim = fim.getNoAnterior();
						fim.setProximoNo(null);
					
					}else {
						
						aux2.getNoAnterior().setProximoNo(aux2.getProximoNo());
						aux2.getProximoNo().setNoAnterior(aux2.getNoAnterior());
					
					}
					
					aux1 = null;
				
				}
				
				if(aux1 != null) {
					if(aux1.getProximoNo().equals(aux2)) {
						
						aux1 = null;
						
					}
				}	
				
			}else if(alunoSeguinte.equals(aluno)){
				
				existe = true;
				
				if(aux1.equals(inicio)) {
					
					inicio = inicio.getProximoNo();
					inicio.setNoAnterior(null);
				
				}else {
					
					aux1.getNoAnterior().setProximoNo(aux2.getProximoNo());
					aux1.getProximoNo().setNoAnterior(aux1.getNoAnterior());
			
				}
				
				aux1 = null; 
				
			}else if(aux1.getNoAnterior() != null && aux2.getProximoNo() != null) {
				
				aux1 = null;
				
			}
			
			if(aux1 != null) {
				aux1 = aux1.getProximoNo();
				aux2 = aux2.getNoAnterior();
			}	
		}
		
		if(!existe) {
			
			throw new ElementoInexistenteException();
			
		}	
	}

}
