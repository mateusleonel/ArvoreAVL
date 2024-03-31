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
        return insert(raiz, key);
    }

    /******************************************************************/
    /* Método     : insert(No<T> root, key)                           */
    /* Função     : Recebe uma chave para inserir na árvore, se a     */
    /*              a chave não existir, o nó é inserido, caso        */
    /*              contrário não é realizada nenhuma operação        */ 
    /* Parâmetros : T key - valor da chave para inserção              */
    /* Retorno    : retorn true em caso de sucesso, false contrário   */
    /******************************************************************/
    public boolean insert(No<T> root, T key) {

        if (isEmpty()){
            No<T> novo_no = new No<T>(key);
            raiz = novo_no;
            this.totalPalavras ++;
            this.totalPalavrasDistintas ++;
            return true;
        }
        else{
            if (key.compareTo(root.getChave()) < 0){
                if (root.getEsquerda() == null) {
                    No<T> novo_no = new No<T>(key);
                    root.setEsquerda(novo_no);
                    novo_no.setPai(root);
                    this.totalPalavras ++;
                    this.totalPalavrasDistintas ++;
                    return true;
                } else {
                    return insert(root.getEsquerda(), key);
                }
            }
            else if (key.compareTo(root.getChave()) > 0){
                
                if (root.getDireita() == null) {
                    No<T> novo_no = new No<T>(key);
                    root.setDireita(novo_no);
                    novo_no.setPai(root);
                    this.totalPalavras ++;
                    this.totalPalavrasDistintas ++;
                    return true;
                }
                else { 
                    return insert(root.getDireita(), key);
                }
            }    
            else{
                return false;
            }
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
        return remove(raiz, key);
    }

    /******************************************************************/
    /* Método     : remove(T key)                                     */
    /* Função     : Recebe uma chave para remover na árvore, se a     */
    /*              a chave não existir, o nó é removido, caso        */
    /*              contrário não é realizada nenhuma operação        */ 
    /* Parâmetros : T key - valor da chave para remoção              */
    /* Retorno    : retorn true em caso de sucesso, false contrário   */
    /******************************************************************/
    public boolean remove(No<T> root, T key)  {
        
        if (isEmpty()){
            return false;
        } else {
         
            No<T> noPai = root.getPai();
            No<T> noSucessor    = sucessor(root);
          
            if (key.compareTo(root.getChave()) == 0) {
                    
                if (root.getDireita() == null && root.getEsquerda() == null){
                    if (root.getPai() == null) {
                        raiz = null; 
                    } else if (root.getPai().getEsquerda() == root) {
                        root.getPai().setEsquerda(null);
                    } else {
                        root.getPai().setDireita(null);
                    }
                }

                else if (root.getEsquerda() != null && root.getDireita() != null) {

                    if (noPai.getEsquerda() == root){
                       noPai.setEsquerda(noSucessor);
                    }
                    else{
                       noPai.setDireita(noSucessor);
                    }

                    root.getDireita().setEsquerda(noSucessor.getDireita());
                    noSucessor.setEsquerda(root.getEsquerda());
                    noSucessor.setDireita(root.getDireita());
                }
                else{
                     if (noPai.getEsquerda() == root){
                        if(root.getEsquerda() != null){
                            noPai.setEsquerda(root.getEsquerda()); 
                        }
                        else{
                            noPai.setEsquerda(root.getDireita());  
                        }  
                     }
                     else{
                        if(root.getEsquerda() != null){
                            noPai.setDireita(root.getEsquerda());
                        }
                        else{
                            noPai.setDireita(root.getDireita());
                        }     
                     }  
                }    
                
                return true;
    
            } else if (key.compareTo(root.getChave()) < 0) {
                return remove(root.getEsquerda(), key); 
            } else {
                return remove(root.getDireita(), key); 
            }
        }
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
    /*              Derivação do método                               */
    /* Função     : Recebe uma chave para buscar e inserir na árvore, */
    /*              quando a chave não existir, será inserida da      */
    /*              arvore, quando existir o número de ocorrências    */
    /*              será atualizado.                                  */
    /* Parâmetros : No <T> - Nó da árvore em que será inserido        */
    /*              T key  - Valor para ser inserido                  */
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
    /* Método     : getAltura()                                         */
    /* Função     : Retorna a altura da árvore                       */
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


    /* 
    TODO - REMOCAO
         - PREDECESSOR
         - SUCESSOR
         - AVL - ROTACOES
         - AVL - FATOR DE BALANCEAMENTO
    */    
}
