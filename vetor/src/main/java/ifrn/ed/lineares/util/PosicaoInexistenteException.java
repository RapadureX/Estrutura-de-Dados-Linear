package ifrn.ed.lineares.util;

public class PosicaoInexistenteException extends Exception {

	public PosicaoInexistenteException() {
		super("Tentando adicionar o elemento em uma posição inexistente!!!");
	}
}
