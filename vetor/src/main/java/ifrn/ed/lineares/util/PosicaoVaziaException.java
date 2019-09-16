package ifrn.ed.lineares.util;

public class PosicaoVaziaException extends Exception {

	public PosicaoVaziaException() {
		super("Nenhum elemento foi encontrado na posição informada!!!");
	}
}
