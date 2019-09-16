package ifrn.ed.lineares.listaEncadeada;

import ifrn.dominio.Aluno;

public class NoDuplaFabio {
	
	private Aluno info;
	private NoDuplaFabio noAnterior;
	private NoDuplaFabio proximoNo;
	
	public Aluno getInfo() {
		return info;
	}
	
	public void setInfo(Aluno info) {
		this.info = info;
	}
	
	public NoDuplaFabio getNoAnterior() {
		return noAnterior;
	}
	
	public void setNoAnterior(NoDuplaFabio noAnterior) {
		this.noAnterior = noAnterior;
	}
	
	public NoDuplaFabio getProximoNo() {
		return proximoNo;
	}
	
	public void setProximoNo(NoDuplaFabio proximoNo) {
		this.proximoNo = proximoNo;
	}
	
	public String toString() {
		if(this.getProximoNo() == null && this.getNoAnterior() == null) {
			return "ATUAL | "+info+" | ANTERIOR | NULL | PROXIMO | NULL \n";
		}else if(this.getNoAnterior() == null){
			return "ATUAL | "+info+" | ANTERIOR | NULL | PROXIMO | "+proximoNo.getInfo()+"\n";
		}else if(this.getProximoNo() == null){
			return "ATUAL | "+info+" | ANTERIOR | "+noAnterior.getInfo()+" | PROXIMO | NULL \n";
		}else {
			return "ATUAL | "+info+" | ANTERIOR | "+noAnterior.getInfo()+" | PROXIMO | "+proximoNo.getInfo()+"\n";
		}
	}

}
