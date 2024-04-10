
package Arvore;

public class ArvoreAVL<T extends Comparable<T>> extends Arvore<T> {

    boolean[] height = new boolean[1];
  
    private int totalPalavras;
    private int totalPalavrasDistintas;
    private int totalComparacoes;
    private int rotacoes;
    private int rotacoesLL;
    private int rotacoesLR;
    private int rotacoesRR;
    private int rotacoesRL;
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
    /* Método     : getRotacoes()                                     */
    /* Função     : Retorna o número de rotação de acordo com o       */
    /*              parametro. null (total), RR, LL, LR, RL           */
    /* Parâmetros : String - tipo                                     */
    /* Retorno    : int totalRotacoes                                 */
    /******************************************************************/
    public int getRotacoes(String tipo) {

        if(tipo == null)
            return rotacoes;
        else if (tipo == "LL")
            return rotacoesLL;
        else if (tipo == "RR")
            return rotacoesRR;
        else if (tipo == "LR")
            return rotacoesLR;
        else if (tipo == "RL")
            return rotacoesRL;
        else 
            return 0;                    
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
    /* Método     : insert(T key)                                     */
    /* Função     : Recebe uma chave para inserir na árvore, se a     */
    /*              a chave não existir, o nó é inserido, caso        */
    /*              contrário não é realizada nenhuma operação        */ 
    /* Parâmetros : T key - valor da chave para inserção              */
    /* Retorno    : retorn true em caso de sucesso, false contrário   */
    /******************************************************************/
    public boolean insert(T key) {
        
        No<T> root = getRaiz(); 
        
        if (insert(root, key) == null){
            return false;
        }
        else{
            return true;
        }
       
    }

    /******************************************************************/
    /* Método     : insert(No<T> root, key, boolean height)           */
    /* Função     : Recebe uma chave para inserir na árvore, se a     */
    /*              a chave não existir, o nó é inserido, caso        */
    /*              contrário não é realizada nenhuma operação        */ 
    /* Parâmetros : T key - valor da chave para inserção              */
    /* Retorno    : retorn true em caso de sucesso, false contrário   */
    /******************************************************************/
    public No<T> insert(No<T> root, T key, boolean[] height) {
        
        No<T> novo_no = new No<T>();
        
        if (isEmpty()) {
            novo_no = new No<T>(key);
            setRaiz(novo_no);
            this.totalPalavrasDistintas++;
            novo_no.addOcorrencia();
            novo_no.setBalanceamento(0);
            height[0] = true;
            return novo_no;
        } else {
            if (root == null){
                novo_no = new No<T>(key);
                novo_no.addOcorrencia();
                novo_no.setBalanceamento(0);
                height[0] = true;
                this.totalPalavrasDistintas++;
                return novo_no;
            }
            if (key.compareTo(root.getChave()) < 0) {
                totalComparacoes ++;
                root.setEsquerda(insert(root.getEsquerda(), key, height));
                if (height[0]){

                   novo_no = root.getEsquerda();
                   switch (root.getBalanceamento()) {
                       case  -1:
                           root.setBalanceamento(0);
                           height[0] = false;
                           break;
                       case  0:
                           root.setBalanceamento(1);
                           height[0] = true;
                           break;
                       case  1:  
                           
                            if (novo_no.getBalanceamento() > 0){
                                rotacoes ++;
                                rotacoesLL++;
                                root = rotacaoLL(root);
                                defineFB(root);
                                height[0] = false;
                            } 
                            else{
                                rotacoes ++;
                                rotacoesLR++;
                                root = rotacaoLR(root);
                                defineFB(root);
                                height[0] = false;
                            }
                           
                           break;
                         
                   }
               }
               return root;
           
           }
           else if (key.compareTo(root.getChave()) > 0){   
               totalComparacoes = totalComparacoes + 2;  
               root.setDireita(searchInsert(root.getDireita(), key, height));
               
               if (height[0]){
    
                   novo_no = root.getDireita();

                   switch (root.getBalanceamento()) {
                       case  1:
                           root.setBalanceamento(0);
                           height[0] = false;
                           break;
                       case  0:
                           root.setBalanceamento(-1);
                           height[0] = true;
                           break;
                       case  -1:  
                           
                            if (novo_no.getBalanceamento() < 0){
                                rotacoes ++;
                                rotacoesRR++;
                                root = rotacaoRR(root);
                                defineFB(root);
                                height[0] = true;
                            } 
                            else{
                                rotacoes ++;
                                rotacoesRL++;
                                root = rotacaoRL(root);
                                defineFB(root);
                                height[0] = true;
                            }
                              
                       
                   }
              }
              
              return root;
           }  
        }

        return root;
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
        
        No<T> raiz = getRaiz(); 
        
        if (remove(raiz, key,height) == null){
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
    public No<T> remove(No<T> root, T key, boolean[] height) {
        
         
            No<T> tempNo  = new No<T>();
            No<T> novo_no = new No<T>();

            if (key.compareTo(root.getChave()) < 0) {
                root.setEsquerda(remove(root.getEsquerda(), key, height));

                if (height[0]){
                    novo_no = root.getDireita();
                    switch (root.getBalanceamento()) {
                        case  1:
                            root.setBalanceamento(0);
                            height[0] = false;
                            break;
                        case  0:
                            root.setBalanceamento(-1);
                            height[0] = true;
                            break;
                        case  -1:  
                            
                            if (novo_no.getBalanceamento() <= 0){
                                root = rotacaoRR(root);
                                height[0] = false;
                            } 
                            else{
                                root = rotacaoRL(root);
                                defineFB(root);
                                height[0] = false;
                            }
                            
                            break;
                        
                    }
                }    

            }
            else if (key.compareTo(root.getChave()) > 0) {
                root.setDireita(remove(root.getDireita(), key, height));
                if (height[0]){
                    switch (root.getBalanceamento()) {
                        case  -1:
                            root.setBalanceamento(0);
                            height[0] = false;
                            break;
                        case  0:
                            root.setBalanceamento(-1);
                            height[0] = true;
                            break;
                        case  1: 
                            novo_no = root.getEsquerda();
                            
                            if (novo_no.getBalanceamento() >= 0){
                                root = rotacaoLL(root);
                                height[0] = false;
                            } 
                            else{
                                root = rotacaoLR(root);
                                defineFB(root);
                                height[0] = false;
                            }
                            
                            break;
                        
                    }
                }    

            }
            else{

                if (root.getEsquerda() == null || root.getDireita() == null) {
                    
                    tempNo = null;
                   
                    if (tempNo == root.getEsquerda()) {
                        tempNo = root.getDireita();
                    } else {
                        tempNo = root.getEsquerda();
                    }
                    
                    if (tempNo == null) {
                        tempNo = root;
                        root = null;
                        height[0] = true;
                    } else {
                        root = tempNo; 
                    }

                } else {
                    
                    tempNo = sucessor(root);
                
                    root.setChave(tempNo.getChave());
                    
                    height[0] = false;
                    root.setDireita(remove(root.getDireita(), tempNo.getChave(),height));
                    defineFB(root);    
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
        if (searchInsert(root, key, height) != null){
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
    public No<T> searchInsert(No<T> root, T key, boolean[] height) {
        
        No<T> novo_no  = new No<T>();
        No<T> novo_bal = new No<T>();
        
        if (isEmpty()) {
            
            novo_no = new No<T>(key);
            setRaiz(novo_no);
            this.totalPalavrasDistintas++;
            novo_no.addOcorrencia();
            novo_no.setBalanceamento(0);
            height[0] = true;
            return novo_no;
           
        } else {

            if (root == null){
                novo_no = new No<T>(key);
                novo_no.addOcorrencia();
                novo_no.setBalanceamento(0);
                height[0] = true;
                this.totalPalavrasDistintas++;
                return novo_no;
            }
           
            if (key.compareTo(root.getChave()) < 0) {
                 totalComparacoes ++;
                 root.setEsquerda(searchInsert(root.getEsquerda(), key, height));
                 if (height[0]){

                    novo_no = root.getEsquerda();
                    switch (root.getBalanceamento()) {
                        case  -1:
                            root.setBalanceamento(0);
                            height[0] = false;
                            break;
                        case  0:
                            root.setBalanceamento(1);
                            height[0] = true;
                            break;
                        case  1:  
                           
                            if (novo_no.getBalanceamento() > 0){
                                rotacoes ++;
                                rotacoesLL++;
                                root = rotacaoLL(root);
                                defineFB(root);
                                height[0]=false;
                                
                            } 
                            else{
                                rotacoes ++;
                                rotacoesLR++;
                                root = rotacaoLR(root);
                                defineFB(root);
                                height[0]=false;
                                
                            }
                            
                            break;
                          
                    }
                }
                return root;
            
            }
            else if (key.compareTo(root.getChave()) > 0){  
                totalComparacoes = totalComparacoes + 2;    
                root.setDireita(searchInsert(root.getDireita(), key, height));
                if (height[0]){
     
                    novo_no = root.getDireita();

                    switch (root.getBalanceamento()) {
                        case  1:
                            root.setBalanceamento(0);
                            height[0] = false;
                            break;
                        case  0:
                            root.setBalanceamento(-1);
                            height[0] = true;
                            break;
                        case  -1:  
                            
                            if (novo_no.getBalanceamento() < 0){
                                rotacoes ++;
                                rotacoesRR++;
                                root = rotacaoRR(root);
                                
                                height[0]=false;
                            } 
                            else{
                                rotacoes ++;
                                rotacoesRL++;
                                root = rotacaoRL(root);
                                defineFB(root);
                                height[0]=false;
                                
                            }
                              
                        
                    }
               }
               
               return root;
           
            } else {
                 root.addOcorrencia();
                 height[0] = false;
                 return root;
            }
        }
        
    }
    
    public void defineFB(No<T> root) {
        root.setBalanceamento(getAltura(root.getEsquerda()) - getAltura(root.getDireita()));
        if (root.getDireita() != null) {
            defineFB(root.getDireita());
        }
        if (root.getEsquerda() != null) {
            defineFB(root.getEsquerda());
        }
    }
    

    private No<T> rotacaoLL(No<T> root) {
      
        No<T> tempNo = new No<T>();
        

        tempNo = root.getEsquerda();
        
        if (root == getRaiz()){
            setRaiz(tempNo);                        
        }

        root.setEsquerda(tempNo.getDireita());
        tempNo.setDireita(root);
     
        root.subBalanceamento();
        tempNo.subBalanceamento();
        
        return tempNo;

    }


    private No<T> rotacaoRR(No<T> root) {
         
        No<T> tempNo = new No<T>();

        tempNo = root.getDireita();
        
        if (root == getRaiz()){
            setRaiz(tempNo);                        
        }

        root.setDireita(tempNo.getEsquerda());
        tempNo.setEsquerda(root);
     
        root.addBalanceamento();
        tempNo.addBalanceamento();

        return tempNo;
    }

    private No<T> rotacaoLR(No<T> root) {
       
        No<T> tempNo = new No<T>();
        No<T> tempNo2 = new No<T>();

        tempNo = root.getEsquerda();
    
        root.setEsquerda(rotacaoRR(tempNo));

        tempNo2 = rotacaoLL(root);

        return tempNo2;
    }
    
    private No<T> rotacaoRL(No<T> root) {

        No<T> tempNo = new No<T>();
        No<T> tempNo2 = new No<T>();
    
        tempNo = root.getDireita();
    
        root.setDireita(rotacaoLL(tempNo));

        tempNo2 = rotacaoRR(root);

        return tempNo2;

    }

    
}
