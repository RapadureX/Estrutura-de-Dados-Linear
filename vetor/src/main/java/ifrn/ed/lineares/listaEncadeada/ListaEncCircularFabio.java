package ifrn.ed.lineares.listaEncadeada;

import ifrn.dominio.Aluno;
import ifrn.ed.lineares.util.ElementoInexistenteException;
import ifrn.ed.lineares.util.EstruturaVaziaException;

public class ListaEncCircularFabio {
	
	private NoFabio primeiro = null;
	private NoFabio ultimo = null;
	
	@Override
	public String toString() {
		
		String res = "";
		NoFabio aux = primeiro;
		
		while(aux != ultimo) {
			res += aux.toString();
			aux = aux.getProximo();
		}
		
		res += ultimo.toString();
		
		return res;
	}
	
	/*
	 * Método de inserção, que recebe como parâmetro um objeto do 
	 * tipo aluno que será inserido na lista.
	*/
	public void inserir(Aluno aluno) {
		
		//Criando um novo nó.
		NoFabio novoElemento = new NoFabio();
		
		//inserindo a informação do aluno no novo nó criado.
		novoElemento.setInfo(aluno);
		
		//inserindo a referencia para o próximo nó do novo nó criado.
		novoElemento.setProximo(primeiro);
		
		/*
		 * Condicional: Se o primeiro for igual a nulo, quer dizer que
		 * é o primeiro aluno a ser inserido na lista.
		 */
		if(primeiro == null) {
			
			//O primeiro passará a ser o novo nó.
			primeiro = novoElemento;
			
			/* 
			 * O último passará a ser o novo nó, assim guardando 
			 * a referencia do último nó da lista.
			 */ 
			ultimo = novoElemento;
			
		/*
		 * Se não quer dizer que o primeiro já foi inserido, 
		 * então o primeiro receberá os novos nós que são criados.
		 */
		}else {
			
			//O primeiro passará a ser o novo nó.
			primeiro = novoElemento;
		}
		
		/*
		 * E sempre que inserir um novo aluno, o ultimo setará 
		 * o seu próximo nó como primeiro, que será sempre o novo nó criado.
		 */
		ultimo.setProximo(primeiro);
	}
	
	/*
	 * Método de buscar, que recebe como parâmetro um objeto do 
	 * tipo aluno, que percorrerá a estrutura da lista até encontrar o aluno.
	*/
	public NoFabio buscar(Aluno aluno) throws ElementoInexistenteException, EstruturaVaziaException{
		
		//Condicional: Se a lista estiver vazia lance a exceção ListaVaziaException.
		if(this.listaVazia()) {
			throw new EstruturaVaziaException();
		}
		
		/*
		 * Condicional: Se o primeiro nó da lista que contém 
		 * um aluno for igual ao aluno passado por parâmentro
		 * , me retorne o primeiro nó.
		 */
		if(primeiro.getInfo().equals(aluno)) {
			
			// Retornando o primeiro nó da lista.
			return primeiro;
		
		/*
		* Se não mais um condicional: Se o último nó da lista que contém 
		* um aluno for igual ao aluno passado por parâmentro
		* , me retorne o último nó.
		*/	
		}else if(ultimo.getInfo().equals(aluno)){
			
			// Retornando o último nó da lista.
			return ultimo;
			
		/*
		* Se não fará uma busca no restante da lista 
		* até encontrar o nó que contenha o alunos 
		* desejado.
		*/		
		}else {
			
			/* Nó auxiliar que receberá iniciamente 
			 * o próximo nó do primeiro nó, que será utilizada 
			 * para percorrer a lista.
			 */
			NoFabio aux = primeiro.getProximo();
			
			/* Estrutura de repetição: Enquanto o nó auxiliar 
			 * for diferente do último nó, percorra a lista. 
			 */
			while(aux != ultimo) {
				
				/* Condicional: Se o aluno que está contido no nó auxiliar
				 * for igual ao aluno passado por parâmetro, retorne o nó
				 * auxiliar.
				 */
				if(aux.getInfo().equals(aluno)) {
					
					// Retronando o nó auxiliar.
					return aux;
				}
				
				// Não é o nó do aluno desejado, passe para o próximo nó.
				aux = aux.getProximo();
			}
		}
		
		/* O aluno não foi encontrado na lista a exceção 
		 * ElementoInexistenteException será lançada.
		 */
		throw new ElementoInexistenteException();
	}
	
	public void remover(Aluno aluno) throws ElementoInexistenteException, EstruturaVaziaException{
		
		if(this.listaVazia()) {
			throw new EstruturaVaziaException();
		}
		
		boolean exist = false;
		
		if(primeiro.getInfo().equals(aluno)) {
			if(primeiro.equals(ultimo)) {
				
				exist = true;
				primeiro = null;
				ultimo = null;
				
			}else {
				
				exist = true;
				primeiro = primeiro.getProximo();	
				ultimo.setProximo(primeiro);
				
			}
		}else {
			
			NoFabio aux = primeiro.getProximo();
			NoFabio anterior = primeiro;
			Aluno alunoNo = null;
			
			while(aux != primeiro) {
			
				alunoNo = aux.getInfo();
				
				if(alunoNo.equals(aluno)) {
					exist = true;
					if(aux.equals(ultimo)) {
						ultimo = anterior;
					}
					anterior.setProximo(aux);
					aux = primeiro;
				}else {
					anterior = aux;
					aux = aux.getProximo();
				}
			}
		}	
		
		if(!exist) {
			throw new ElementoInexistenteException();
		}
	}
	
	public boolean listaVazia() {
		return primeiro == null;
	}
}
