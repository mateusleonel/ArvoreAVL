package Arvore;

public class Arvore<T extends Comparable<T>> {

    private No<T> raiz;
    private int totalPalavras;
    private int totalPalavrasDistintas;
    private int totalComparacoes;
    
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
    /* Método     : setRaiz()                                         */
    /* Função     : Seta o nó raiz da árvore                          */
    /* Parâmetros : No - estrutura da árvore                          */               
    /* Retorno    : Não possui                                        */
    /******************************************************************/
    public void setRaiz(No<T> raiz) {
        this.raiz = raiz;
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
    /* Método     : search(No<T> root, T key)                         */
    /* Função     : Recebe uma chave para buscar na árvore e retorna  */
    /*              o nó da chave, caso encontre                      */ 
    /* Parâmetros : No <T> - Nó da árvore em que será inserido        */
    /* Retorno    : No - estrutura da árvore                          */
    /******************************************************************/
    public No<T> search(T key) {
        raiz = this.getRaiz();
        return search(raiz, key);
    }

    /******************************************************************/
    /* Método     : search(No<T> root, T key)                         */
    /* Função     : Recebe uma chave para buscar na árvore e retorna  */
    /*              Derivação do método                               */                   
    /*              o nó da chave, caso encontre                      */ 
    /* Parâmetros : No <T> - Nó da árvore em que será inserido        */
    /*              T key  - Valor para ser inserido                  */
    /* Retorno    : No - estrutura da árvore                          */
    /******************************************************************/
    public No<T> search(No<T> root, T key) {
        
        if (isEmpty()) {
            return null; 
        }
        else{
            if (key.compareTo(root.getChave()) == 0) {
                return root;
            } else if (key.compareTo(root.getChave()) < 0) {
                return search(root.getEsquerda(), key); 
            } else {
                return search(root.getDireita(), key); 
            }
        }
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
        raiz = this.getRaiz();
        if (insert(raiz, key) == null){
            return false;
        }
        else{
            return true;
        }
    }

    /******************************************************************/
    /* Método     : insert(No<T> root, key)                           */
    /* Função     : Recebe uma chave para inserir na árvore, se a     */
    /*              a chave não existir, o nó é inserido, caso        */
    /*              contrário não é realizada nenhuma operação        */ 
    /* Parâmetros : T key - valor da chave para inserção              */
    /* Retorno    : retorna T key                                     */
    /******************************************************************/
    public No<T> insert(No<T> root, T key) {
        
        if (isEmpty()){
            No<T> novo_no = new No<T>(key);
            raiz = novo_no;
            this.totalPalavrasDistintas ++;
            raiz.addOcorrencia();
            return novo_no;
        }

        else{

            if (key.compareTo(root.getChave()) < 0){
                
                totalComparacoes ++ ;
                
                if (root.getEsquerda() == null) {
                    No<T> novo_no = new No<T>(key);
                    root.setEsquerda(novo_no);
                    novo_no.addOcorrencia();
                    this.totalPalavrasDistintas ++;
                    return novo_no;
                } else {
                    searchInsert(root.getEsquerda(), key);
                }
            }
            else if (key.compareTo(root.getChave()) > 0){
                
                totalComparacoes = totalComparacoes + 2;
                
                if (root.getDireita() == null) {
                    No<T> novo_no = new No<T>(key);
                    root.setDireita(novo_no);
                    novo_no.addOcorrencia();
                    this.totalPalavrasDistintas ++;
                    return novo_no;
                }
                else { 
                    searchInsert(root.getDireita(), key);
                }
            }    
            
            return root;

        }
        
    }
    

    /******************************************************************/
    /* Método     : remove(T key)                                     */
    /* Função     : Recebe uma chave para remover na árvore, se a     */
    /*              a chave não existir, o nó é removido, caso        */
    /*              contrário não é realizada nenhuma operação        */ 
    /* Parâmetros : T key - valor da chave para remoção              */
    /* Retorno    : retorn true em caso de sucesso, false contrário   */
    /******************************************************************/
    public boolean remove(T key) {
        raiz = this.getRaiz();
        if (remove(raiz, key) == null){
            return false;
        }
        else{
            return true;
        }
    }

    /******************************************************************/
    /* Método     : remove(T key)                                     */
    /* Função     : Recebe uma chave para remover na árvore, se a     */
    /*              a chave não existir, o nó é removido, caso        */
    /*              contrário não é realizada nenhuma operação        */ 
    /* Parâmetros : T key - valor da chave para remoção              */
    /* Retorno    : retorn true em caso de sucesso, false contrário   */
    /******************************************************************/
    public No<T> remove(No<T> root, T key)  {
        
            No<T> tempNo = new No<T>();
                 
            if (key.compareTo(root.getChave()) < 0) {
                root.setEsquerda(remove(root.getEsquerda(), key));
            }
            else if (key.compareTo(root.getChave()) > 0) {
                root.setDireita(remove(root.getDireita(), key));
            }
            else{

                if (root.getEsquerda() == null || root.getDireita() == null) {
                    
                    tempNo = null;
                    
                    if (root.getEsquerda() == null) {
                        tempNo = root.getDireita();
                    } else {
                        tempNo = root.getEsquerda();
                    }
                    
                    if (tempNo == null) {
                        tempNo = root;
                        root = null;
                    } else {
                        root = tempNo; 
                    }

                } else {
                    
                    tempNo = sucessor(root);
                
                    root.setChave(tempNo.getChave());
                    
                    root.setDireita(remove(root.getDireita(), tempNo.getChave()));
                }

            }

            return root;
        
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
    public boolean searchInsert(T key) {
    
        this.totalPalavras ++;
        No<T> root = getRaiz();
        
        if (searchInsert(root, key) != null){
            return false;
        }
        else{
            return true;
        }    


    } 
    
    
    /******************************************************************/
    /* Método     : searchInsert(No<T> root, T key, boolean height)  */
    /*              Derivação do método                              */
    /* Função     : Recebe uma chave para buscar e inserir na árvore, */
    /*              quando a chave não existir, será inserida da      */
    /*              arvore, quando existir o número de ocorrências    */
    /*              será atualizado.                                  */
    /* Parâmetros : No <T> - Nó da árvore em que será inserido        */
    /*              T key  - Valor para ser inserido                  */
    /*            : height - Indica de houve atualização na altura da */
    /*                       árvore                                   */
    /* Retorno    : No - estrutura da árvore                          */
    /******************************************************************/
    public No<T> searchInsert(No<T> root, T key) {
          
        if (isEmpty()){
            No<T> novo_no = new No<T>(key);
            raiz = novo_no;
            this.totalPalavrasDistintas ++;
            raiz.addOcorrencia();
            return novo_no;
        }

        else{

            if (key.compareTo(root.getChave()) < 0){
                
                totalComparacoes ++ ;
                
                if (root.getEsquerda() == null) {
                    No<T> novo_no = new No<T>(key);
                    root.setEsquerda(novo_no);
                    novo_no.addOcorrencia();
                    this.totalPalavrasDistintas ++;
                    return novo_no;
                } else {
                    searchInsert(root.getEsquerda(), key);
                }
            }
            else if (key.compareTo(root.getChave()) > 0){
                
                totalComparacoes = totalComparacoes + 2;
                
                if (root.getDireita() == null) {
                    No<T> novo_no = new No<T>(key);
                    root.setDireita(novo_no);
                    novo_no.addOcorrencia();
                    this.totalPalavrasDistintas ++;
                    return novo_no;
                }
                else { 
                    searchInsert(root.getDireita(), key);
                }
            }    
            else{
                root.addOcorrencia();
                return root;
            }

            return root;

        }
        
    }

    /******************************************************************/
    /* Método     : getAltura()                                         */
    /* Função     : Retorna a altura da árvore                       */
    /* Parâmetros : no - Nó da árvore para verificar a altura         */
    /* Retorno    : int altura da árvore                              */
    /******************************************************************/
    public int getAltura(No<T> no) {
        if (no == null) {
            return -1; 
        } else {
            int alturaEsquerda = getAltura(no.getEsquerda());
            int alturaDireita = getAltura(no.getDireita());
            
            // A altura de um nó é o máximo entre as alturas das subárvores esquerda e direita, mais 1 para contar o próprio nó
            return Math.max(alturaEsquerda, alturaDireita) + 1;
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
    /* Método     : getComparaces()                                   */
    /* Função     : Retorna o número de rotação de comparacoes entre  */
    /*              chaves                                            */
    /* Parâmetros : Não possui                                        */
    /* Retorno    : int totalComparacoes                              */
    /******************************************************************/
    public int getComparaces(){
        return totalComparacoes;
    }



    /******************************************************************/
    /* Método     : maxValue(No<T> root)                              */
    /* Função     : Retorna o valor máximo de uma árvore              */
    /* Parâmetros : No <T> - Nó da árvore em que será inserido        */
    /* Retorno    : No - estrutura da árvore                          */
    /******************************************************************/
    public No<T> maxChave(No<T> no) {

        if (no == null){
            return null;
        }
        else{
            if(no.getDireita() == null && no.getEsquerda() == null ){
                return no;
            }
            else if(no.getDireita() == null && no.getEsquerda() != null){
                return no;
            }
            else if(no.getDireita() != null){
                return maxChave(no.getDireita());    
            }
            else if(no.getDireita() == null && no.getEsquerda() != null){
                return  maxChave(no.getEsquerda());    
            }
            else {
                return null ;
            }
        
        }
    }    

    /******************************************************************/
    /* Método     : maxValue(No<T> root)                              */
    /* Função     : Retorna o valor máximo de uma árvore              */
    /* Parâmetros : No <T> - Nó da árvore em que será inserido        */
    /* Retorno    : No - estrutura da árvore                          */
    /******************************************************************/
    public No<T> minChave(No<T> no) {

        if (no == null){
            return null;
        }
        else{
            if(no.getDireita() == null && no.getEsquerda() == null ){
                return no;
            }
            else if(no.getEsquerda() == null && no.getDireita() != null){
                return no;
            }
            else if(no.getEsquerda() != null){
                return minChave(no.getEsquerda());    
            }
            else if(no.getEsquerda() == null && no.getDireita() != null){
                return  minChave(no.getDireita());    
            }
            else {
                return null ;
            }
        
        }
    }    

    /******************************************************************/
    /* Método     : predecessor(No<T> root)                           */
    /* Função     : Retorna o nó predecessor                          */
    /* Parâmetros : No <T> - Nó da árvore em que será inserido        */
    /* Retorno    : No - estrutura da árvore                          */
    /******************************************************************/
    public No<T> predecessor(No<T> no) {

        if (no == null){
            return null;
        }
        else{
            if(no.getEsquerda() != null){
               return(maxChave(no.getEsquerda()));     
            }
           
            No<T> predecessor = null;
            No<T> atual = raiz;
            while (atual != null) {
               
                if (no.getChave().compareTo(atual.getChave()) > 0) {
                    predecessor = atual;
                    atual = atual.getDireita();
                } else if (no.getChave().compareTo(atual.getChave()) < 0) {
                    atual = atual.getEsquerda();
                } else {
                    break; 
                }
             }
            
            return predecessor;
        }
    }    

    /******************************************************************/
    /* Método     : predecessor(No<T> root)                           */
    /* Função     : Retorna o nó predecessor                          */
    /* Parâmetros : No <T> - Nó da árvore em que será inserido        */
    /* Retorno    : No - estrutura da árvore                          */
    /******************************************************************/
    public No<T> sucessor(No<T> no) {
        if (no == null) {
            return null;
        }
    
        if (no.getDireita() != null) {
            return minChave(no.getDireita());
        }
    
        No<T> sucessor = null;
        No<T> atual = raiz;
    
        while (atual != null) {
            if (no.getChave().compareTo(atual.getChave()) < 0) {
                sucessor = atual;
                atual = atual.getEsquerda();
            } else if (no.getChave().compareTo(atual.getChave()) > 0) {
                atual = atual.getDireita();
            } else {
                break; 
            }
        }
    
        return sucessor;
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
          System.out.print(no.getChave() + " ");
          inOrder(no.getDireita());
        }
    }
      
    /******************************************************************/
    /* Método     : preOrder(No<T> no)                                */
    /* Função     : Imprime os nós da árvore em pré-ordem             */
    /* Parâmetros : no - Nó da arvore para ser impresso               */
    /* Retorno    : Não possuí                                        */
    /******************************************************************/
    public void preOrder(No<T> no) {
    
        if (no != null) {
            System.out.print(no.getChave() + " ");
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
          System.out.print(no.getChave() + " ");
        }
    }  

    public void printTree(No<T> root, String prefix, boolean isLeft) {
        if (root != null) {
            if (root.getDireita() != null) {
                printTree(root.getDireita(), prefix + (isLeft ? "│   " : "    "), false);
            }
            System.out.println(prefix + (isLeft ? "└── " : "┌── ") +  " [Chave : " + root.getChave() + " - Freq : " + root.getOcorrencia() + " - Balanc : " + root.getBalanceamento() + "]" );
            if (root.getEsquerda() != null) {
                printTree(root.getEsquerda(), prefix + (isLeft ? "    " : "│   "), true);
            }
        }
    }
    
   
}
