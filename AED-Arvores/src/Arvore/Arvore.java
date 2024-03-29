package Arvore;

public class Arvore<T extends Comparable<T>> {

    private No<T> raiz;
    private int totalPalavras;
    private int totalPalavrasDistintas;
    
    /******************************************************************/
    /* Método     : Arvore()                                          */
    /* Função     : Construtor da aŕvore                              */
    /* Parâmetros : Não possui                                        */
    /* Retorno    : Não possui                                        */
    /******************************************************************/
    public Arvore() {
        raiz = null;
    }

    /******************************************************************/
    /* Método     : isEmpty()                                         */
    /* Função     : Verifica se a árvore está vazia                   */
    /* Parâmetros : Não possui                                        */
    /* Retorno    : Boolean                                           */
    /******************************************************************/
    public boolean isEmpty() {
        return raiz == null;
    }

    /******************************************************************/
    /* Método     : getRaiz()                                         */
    /* Função     : Retorna o nó raiz da árvore                       */
    /* Parâmetros : Não possui                                        */
    /* Retorno    : No - estrutura da árvore                          */
    /******************************************************************/
    public No<T> getRaiz() {
        return raiz;
    }

    /******************************************************************/
    /* Método     : search(T key)                                     */
    /* Função     : Recebe uma chave para buscar na árvore e retorna  */
    /*              o nó da chave, caso encontre                      */ 
    /* Parâmetros : T key - valor da chave para busca                 */
    /* Retorno    : No - estrutura da árvore                          */
    /******************************************************************/
    public No<T> search(T key) {
        
        return null;

    } 
    
     /******************************************************************/
    /* Método     : insert(T key)                                     */
    /* Função     : Recebe uma chave para inserir na árvore, se a     */
    /*              a chave não existir, o nó é inserido, caso        */
    /*              contrário não é realizada nenhuma operação        */ 
    /* Parâmetros : T key - valor da chave para inserção              */
    /* Retorno    : retorn true em caso de sucesso, false contrário   */
    /******************************************************************/
    public boolean insert(T key) {
        
        return false;

    }


    /******************************************************************/
    /* Método     : searchInsert(T key)                               */
    /* Função     : Recebe uma chave para buscar e inserir na árvore, */
    /*              quando a chave não existir, será inserida da      */
    /*              arvore, quando existir o número de ocorrências    */
    /*              será atualizado.                                  */
    /* Parâmetros : T key - valor da chave para inserção              */
    /* Retorno    : No - estrutura da árvore                          */
    /******************************************************************/
    public void searchInsert(T key) {
        this.totalPalavras ++;
        raiz = this.getRaiz();
        searchInsert(raiz, key);
    } 
    
    
    /******************************************************************/
    /* Método     : searchInsert(No<T> root, T key)                   */
    /*              Derivação do método                                                  */
    /* Função     : Recebe uma chave para buscar e inserir na árvore, */
    /*              quando a chave não existir, será inserida da      */
    /*              arvore, quando existir o número de ocorrências    */
    /*              será atualizado.                                  */
    /* Parâmetros : No <T> - Nó da árvore em que será inserido        */
    /*              T key  - Valor para ser inserido                  */
    /*            : height - Indica de houve atualização na altura da */
    /*                       árvore                                   */
    /*                                                                */
    /* Retorno    : No - estrutura da árvore                          */
    /******************************************************************/
    public void searchInsert(No<T> root, T key){
       
        if (isEmpty()){
            No<T> novo_no = new No<T>(key);
            raiz = novo_no;
            this.totalPalavrasDistintas ++;
            raiz.addOcorrencia();
        }

        else{

            if (key.compareTo(root.getChave()) < 0){
                if (root.getEsquerda() == null) {
                    No<T> novo_no = new No<T>(key);
                    root.setEsquerda(novo_no);
                    novo_no.setPai(root);
                    novo_no.addOcorrencia();
                    this.totalPalavrasDistintas ++;
                } else {
                    searchInsert(root.getEsquerda(), key);
                }
            }
            else if (key.compareTo(root.getChave()) > 0){
                
                if (root.getDireita() == null) {
                    No<T> novo_no = new No<T>(key);
                    root.setDireita(novo_no);
                    novo_no.setPai(root);
                    novo_no.addOcorrencia();
                    this.totalPalavrasDistintas ++;
                }
                else { 
                    searchInsert(root.getDireita(), key);
                }
            }    
            else{
                root.addOcorrencia();
            }

        }
    }

    /******************************************************************/
    /* Método     : getRaiz()                                         */
    /* Função     : Retorna o nó raiz da árvore                       */
    /* Parâmetros : no - Nó da árvore para verificar a altura         */
    /* Retorno    : int altura da árvore                              */
    /******************************************************************/
    public int getAltura(No<T> no) {
        if(no == null || (no.getEsquerda() == null && no.getDireita() == null))
          return 1;
        else {
          if (getAltura(no.getEsquerda()) > getAltura(no.getDireita()))
             return ( 1 + getAltura(no.getEsquerda()) );
          else
          return ( 1 + getAltura(no.getDireita()) );
        }
    }

    /******************************************************************/
    /* Método     : getPalavras()                                     */
    /* Função     : Retorna o número de palavras em um nó da árvore   */
    /* Parâmetros : Não possui                                        */
    /* Retorno    : int totalPalavras                                 */
    /******************************************************************/
    public int getPalavras() {
        return totalPalavras;
    }

    /******************************************************************/
    /* Método     : getPalavrasDistintas()                            */
    /* Função     : Retorna o número de palavras distintas em um nó   */
    /*              da árvore                                         */
    /* Parâmetros : Não possui                                        */
    /* Retorno    : int totalPalavrasDistintas                        */
    /******************************************************************/
    public int getPalavrasDistintas() {
        return totalPalavrasDistintas;
    }

    /******************************************************************/
    /* Método     : inOrder(No<T> no)                                 */
    /* Função     : Imprime os nós da árvore em ordem                 */
    /* Parâmetros : no - Nó da arvore para ser impresso               */
    /* Retorno    : Não possuí                                        */
    /******************************************************************/
    public void inOrder(No<T> no) {
   
        if (no != null) {
          inOrder(no.getEsquerda());
          System.out.print(no.getChave() + "("+ no.getOcorrencia() +")" + " ");
          inOrder(no.getDireita());
        }
    }
      
    /******************************************************************/
    /* Método     : preOrder(No<T> no)                                 */
    /* Função     : Imprime os nós da árvore em pré-ordem                 */
    /* Parâmetros : no - Nó da arvore para ser impresso               */
    /* Retorno    : Não possuí                                        */
    /******************************************************************/
    public void preOrder(No<T> no) {
    
        if (no != null) {
            System.out.print(no.getChave() + "("+ no.getOcorrencia() +")" + " ");
            preOrder(no.getEsquerda());
            preOrder(no.getDireita());
        }
    }
    
    /******************************************************************/
    /* Método     : posOrder(No<T> no)                                 */
    /* Função     : Imprime os nós da árvore em pós-ordem                 */
    /* Parâmetros : no - Nó da arvore para ser impresso               */
    /* Retorno    : Não possuí                                        */
    /******************************************************************/
    public void posOrder(No<T> no) {
    
        if (no != null) {
          posOrder(no.getEsquerda());
          posOrder(no.getDireita());
          System.out.print(no.getChave() + "("+ no.getOcorrencia() +")" + " ");
        }
    }  


}
