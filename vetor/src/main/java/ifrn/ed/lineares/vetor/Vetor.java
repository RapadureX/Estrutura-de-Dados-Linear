package ifrn.ed.lineares.vetor;

import ifrn.dominio.Aluno;
import ifrn.ed.lineares.util.ElementoInexistenteException;
import ifrn.ed.lineares.util.EstruturaCheiaException;
import ifrn.ed.lineares.util.PosicaoInexistenteException;
import ifrn.ed.lineares.util.PosicaoVaziaException;

/**
 * Estrutura de dados é uma disciplina que estuda os diversos mecanismos de
 * organização de dados para atender aos diferentes requisitos e contextos.
 *
 * Em computação, um Vetor ou arranjo (Array) é o nome de uma matriz
 * unidimensional considerada a mais simples das estruturas de dados. Um vetor,
 * ou arranjo (= array), é uma estrutura de dados que armazena uma sequência de
 * objetos, todos do mesmo tipo, em posições consecutivas da memória RAM (=
 * random access memory) do computador.
 *
 * Como procurar um determinado objeto em um vetor? Como inserir um novo objeto
 * no vetor? Como remover um elemento do vetor?
 *
 * Esses problemas serão usados como pretexto para exibir exemplos de algoritmos
 * e para ilustrar os conceitos de correção, eficiência e elegância de código.
 * Esses problemas/desafios (busca, inserção e remoção) reaparecerão em muitas
 * outras estruturas.
 *
 * Especificação : - Geralmente é constituída por dados do mesmo tipo; -
 * Agrupados continuamente na memória; - Acessados por sua posição, ou seja,
 * permite acesso aleatório; - O seu tamanho geralmente é determinado na
 * inicialização e não se modifica.
 */
public interface Vetor {

	/**
	 * O elemento <code>aluno</code> deverá ser inserido no primeiro espaço livre da
	 * estrutura, levando em consideração a sua organização da esquerda para
	 * direita. Essa inserção acontecerá se os seguintes pontos forem atendidos:
	 *
	 * - Exista espaço livre para inserir o elemento e, ou seja, o tamanho da
	 * estrutura seja maior que a quantidade de elementos já inseridos.
	 *
	 * @param aluno O elemento a ser inserido.
	 * @throws EstruturaCheiaException é lançada caso não exista nenhum espaço
	 *                                 vazio.
	 */
	public void inserir(Aluno aluno) throws EstruturaCheiaException;

	/**
	 * O elemento <code>aluno</code> deverá ser inserido na posição da estrutura
	 * informada, levando em consideração a sua organização da esquerda para
	 * direita. Essa inserção acontecerá se os seguintes pontos forem atendidos:
	 *
	 * - Exista espaço livre para inserir o elemento e, ou seja, o tamanho da
	 * estrutura seja maior que a quantidade de elementos já inseridos;
	 *
	 * - A posição informada esteja dentro das possibilidades existentes;
	 *
	 * - Caso a posição informada já esteja sendo ocupada por um outro elemento, a
	 * inserção deverá reposicionar o 'elemento ocupante' para a posição seguinte.
	 * Ao reposicionar o 'elemento ocupante', o procedimento deverá ter as mesmas
	 * preocupações.
	 *
	 * @param aluno  é elemento a ser inserido.
	 * @param indice é a posição que o elemeto deverá ser inserido.
	 *
	 * @throws EstruturaCheiaException     é lançada caso não exista nenhum espaço
	 *                                     vazio.
	 * @throws PosicaoInexistenteException é lançada caso não exista a posição.
	 */
	public void inserir(Aluno aluno, int indice) throws EstruturaCheiaException, PosicaoInexistenteException;

	/**
	 * Busca por um elemento em uma determinada posição da estrutura.
	 *
	 * @param indice é a posição que deseja
	 *
	 * @throws PosicaoInexistenteException é lançada caso não exista a posição.
	 * @throws PosicaoVaziaException       é lançada caso não exista elemento na
	 *                                     posição.
	 *
	 * @return o elemento {Aluno} encontrado na posição desejada.
	 */
	public Aluno buscar(int indice) throws PosicaoInexistenteException, PosicaoVaziaException;

	/**
	 * Busca a posição do elemento na estrutura.
	 *
	 * @param aluno é o elemento no qual se deseja saber a posição.
	 *
	 * @throws ElementoInexistenteException é lançada caso o elemento não esteja na
	 *                                      estrutura.
	 *
	 * @return a posição do elemento {Aluno} desejado.
	 */
	public int buscar(Aluno aluno) throws ElementoInexistenteException;

	/**
	 * Remove o elemento da estrutura. Caso a posição seguinte esteja sendo ocupado,
	 * os elementos deverão ser reposicionados para que todas as posições estejam
	 * ocupadas em sequência e consecutivas.
	 *
	 * @param indice é a posição do elemento que se deseja excluir.
	 *
	 * @throws PosicaoInexistenteException é lançada caso não exista a posição.
	 * @throws PosicaoVaziaException       é lançada caso não exista elemento na
	 *                                     posição.
	 *
	 */
	public void remover(int indice) throws PosicaoInexistenteException, PosicaoVaziaException;;

	/**
	 * Remove o elemento da estrutura. Caso a posição seguinte esteja sendo ocupado,
	 * os elementos deverão ser reposicionados para que todas as posições estejam
	 * ocupadas em sequência e consecutivas.
	 *
	 * @throws ElementoInexistenteException é lançada caso o elemento não esteja na
	 *                                      estrutura.
	 *
	 * @param aluno é o elemento no qual se deseja remover.
	 */
	public void remover(Aluno aluno) throws ElementoInexistenteException;
}
