package Arvore;

public class ArvoreAVL<T extends Comparable<T>> extends Arvore<T> {

    private No<T> raiz;
    private int totalPalavras;
    private int totalPalavrasDistintas;
    //private int totalRotacoes ;
    //private int totalRotacoesLL ; 
    //private int totalRotacoesRR ;
    //private int totalRotacoesLR ;
    //private int totalRotacoesRL ;

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
        boolean height = false;
        return insert(raiz, key, height);
    }

    /******************************************************************/
    /* Método     : insert(No<T> root, key, boolean height)                           */
    /* Função     : Recebe uma chave para inserir na árvore, se a     */
    /*              a chave não existir, o nó é inserido, caso        */
    /*              contrário não é realizada nenhuma operação        */ 
    /* Parâmetros : T key - valor da chave para inserção              */
    /* Retorno    : retorn true em caso de sucesso, false contrário   */
    /******************************************************************/
    public boolean insert(No<T> root, T key, boolean height) {

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
        boolean height = false;
        raiz = this.getRaiz();
        searchInsert(raiz, key, height);
    } 
    
    
    /******************************************************************/
    /* Método     : searchInsert(No<T> root, T key, boolean height)                   */
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
    public void searchInsert(No<T> root, T key, boolean height){
       
        if (isEmpty()){
            No<T> novo_no = new No<T>(key);
            raiz = novo_no;
            this.totalPalavrasDistintas ++;
            raiz.addOcorrencia();
            height = true ; 
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
                if (height){
                    int i = 0 ;
                    //TODO: Rotações 
                }
            }

        }
    }

    private void rotacaoLL(No raizSubarvore) {
        // Implemente a rotação à esquerda aqui
    }

    private void rotacaoRR(No raizSubarvore) {
        // Implemente a rotação à direita aqui
    }

    private void rotacaoLR(No raizSubarvore) {
        // Implemente a rotação dupla à esquerda aqui
    }

    private void rotacaoRL(No raizSubarvore) {
        // Implemente a rotação dupla à direita aqui
    }
}
