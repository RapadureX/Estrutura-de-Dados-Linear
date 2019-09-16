package ifrn.ed.lineares.listaEncadeada;

import ifrn.dominio.Aluno;

public class NoFabio {
	
	private Aluno info;
	private NoFabio proximo;
	
	public Aluno getInfo() {
		return info;
	}
	public void setInfo(Aluno info) {
		this.info = info;
	}
	public NoFabio getProximo() {
		return proximo;
	}
	public void setProximo(NoFabio proximo) {
		this.proximo = proximo;
	}
	
	public String toString() {
		if(this.getProximo() != null) {
			return "ATUAL | "+info+" | PROXIMO | "+proximo.getInfo()+"\n";
		}else {
			return "ATUAL | "+info+" | PROXIMO | NULL \n";
		}
	}
	
	public NoFabio buscarNo(Aluno aluno) {
		if(this.getInfo().equals(aluno)) {
			return this;
		}else if(this.getProximo() != null) {
			return this.getProximo().buscarNo(aluno);
		}
		return null;
	}
	
	public NoFabio buscarProximo(NoFabio no) {
		if(this.getProximo().equals(no)) {
			return this;
		}else if(this.getProximo()!=null) {
			return this.getProximo().buscarProximo(no);
		}
		return null;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof NoFabio)) {
			return false;
		}
		NoFabio outroNo = (NoFabio) obj;
		return this.info.equals(outroNo.getInfo());
	}
	
	
}
