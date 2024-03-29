package Arvore;

public class No<T> {

    private No<T> esquerda;
	private No<T> direita;
	private No<T> pai;
	private T chave;
	private int ocorrencia;
	private int balanceamento;
	

	/******************************************************************/
    /* Método     : No()                                              */
    /* Função     : Construtor da nó                                  */
    /* Parâmetros : k - chave do nó                                   */
    /* Retorno    : Não possui                                        */
    /******************************************************************/
   public No(T k) {
        setPai(null);
		setEsquerda(null);
        setDireita(null);
		setBalanceamento(0);
		setChave(k);
		setOcorrencia(0);
	}



	/******************************************************************/
    /* Método     : getChave()                                        */
    /* Função     : Recupera o valor da chave no nó                   */
    /* Parâmetros : Não possui                                        */
    /* Retorno    : T chave                                         */
    /******************************************************************/
    public T getChave() {
		return chave;
	}

	/******************************************************************/
    /* Método     : setChave()                                        */
    /* Função     : seta o valor da chave no nó                       */
    /* Parâmetros : T chave                                         */
    /* Retorno    : não possui                                        */
    /******************************************************************/
	public void setChave(T chave) {
		this.chave = chave;
	}

	/******************************************************************/
    /* Método     : getBalanceamento()                                */
    /* Função     : Recupera o fator de balanceamento do nó           */
    /* Parâmetros : Não possui                                        */
    /* Retorno    : int balanceamento                                 */
    /******************************************************************/
	public int getBalanceamento() {
		return balanceamento;
	}

	/******************************************************************/
    /* Método     : setBalanceamento()                                */
    /* Função     : Seta o fator de balanceamento do nó               */
    /* Parâmetros : int balanceamento                                 */
    /* Retorno    : Não possui                                        */
    /******************************************************************/
	public void setBalanceamento(int balanceamento) {
		this.balanceamento = balanceamento;
	}


    /******************************************************************/
    /* Método     : getOcorrencia()                                   */
    /* Função     : Recupera o número de ocorrências do nó            */
    /* Parâmetros : Não possui                                        */
    /* Retorno    : ocorrencia                                        */
    /******************************************************************/
	public int getOcorrencia() {
		return ocorrencia;
	}

	/******************************************************************/
    /* Método     : setOcorrencia()                                   */
    /* Função     : Seta o número de ocorrências do nó                */
    /* Parâmetros : int ocorrencia                                    */
    /* Retorno    : Não possui                                        */
    /******************************************************************/
	public void setOcorrencia(int ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

	/******************************************************************/
    /* Método     : addOcorrencia()                                   */
    /* Função     : Adiciona uma ocorrências ao nó                    */
    /* Parâmetros : Não possui                                        */
    /* Retorno    : int ocorrencia                                    */
    /******************************************************************/
	public void addOcorrencia() {
		this.ocorrencia ++ ;
	}

	/******************************************************************/
    /* Método     : getPai()                                          */
    /* Função     : Retorna o nó pai                                  */
    /* Parâmetros : Não possui                                        */
    /* Retorno    : No<T> pai                                         */
    /******************************************************************/
	public No<T> getPai() {
		return pai;
	}

	/******************************************************************/
    /* Método     : setPai(No<T> pai)                                 */
    /* Função     : Seta o nó pai                                     */
    /* Parâmetros : No<T> pai                                         */
    /* Retorno    : No<t> pai                                         */
    /******************************************************************/
	public No<T> setPai(No<T> pai) {
		this.pai = pai;
		return pai;
	}

	/******************************************************************/
    /* Método     : getDireita()                                      */
    /* Função     : Retorna o nó da direita                           */
    /* Parâmetros : Não possui                                        */
    /* Retorno    : direita                                           */
    /******************************************************************/
	public No<T> getDireita() {
		return direita;
	}
	/******************************************************************/
    /* Método     : setDireita(No<T> direita)                         */
    /* Função     : Seta o nó da direita                              */
    /* Parâmetros : No<T> direita                                     */
    /* Retorno    : Não possui                                        */
    /******************************************************************/
	public No<T> setDireita(No<T> direita) {
		this.direita = direita;
		return direita;
	}

	/******************************************************************/
    /* Método     : getEsquerda()                                     */
    /* Função     : Retorna o nó da esquerda                          */
    /* Parâmetros : Não possui                                        */
    /* Retorno    : esquerda                                          */
    /******************************************************************/
	public No<T> getEsquerda() {
		return esquerda;
	}

	/******************************************************************/
    /* Método     : setEsquerda(No<T> esquerda)                       */
    /* Função     : Seta o nó da esquerda                             */
    /* Parâmetros : No<T> esquerda                                    */
    /* Retorno    : Não possui                                        */
    /******************************************************************/
	public void setEsquerda(No<T> esquerda) {
		this.esquerda = esquerda;
	}

}
