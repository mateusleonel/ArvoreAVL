import Arvore.Arvore;
import Arvore.ArvoreAVL;
import Arvore.No;

public class App {
    public static void main(String[] args) throws Exception {

       
        
        /*******************************************************************/
        /*                    TESTE DE INICIALIZAÇÃO                       */
        /*******************************************************************/
        /* Inserção de uma árvore conhecida, apresentada em aula para      */ 
        /* validação do algoritmo                                          */
        /*******************************************************************/
        
        System.out.println("""
            /*******************************************************************/
            /*   Execução de validação para a árvore apresentada em aula       */
            /*******************************************************************/
            """);

        Arvore<Integer> arvoreValidacaoABB = new Arvore<>();

        //Arvore<String> arvoreValidacaoABB = new Arvore<>();

        ArvoreAVL<String> arvoreValidacaoAVL = new ArvoreAVL<>();
        /*
        String texto = """
            no meio do caminho tinha uma pedra
             tinha uma pedra no meio do caminho
             tinha uma pedra
             no meio do caminho tinha uma pedra""";
        */

        String texto = "15 5 10 7 12 30 20 18 25 40 37 32 38 35 33 36";
        String[] palavras = texto.split("\\s+");
        System.out.println("\"" + texto + "\"");

        String[] partes = texto.split(" ");

        int[] numeros = new int[partes.length];

        for (int i = 0; i < partes.length; i++) {
            numeros[i] = Integer.parseInt(partes[i]);
        }
        
        for (int numero : numeros) {
            arvoreValidacaoABB.searchInsert(numero);
           // arvoreValidacaoAVL.searchInsert(palavra);  
        }

        //for (String palavra : palavras) {
        //    arvoreValidacaoABB.searchInsert(palavra);
        //    arvoreValidacaoAVL.searchInsert(palavra);  
        //}         
        
        No<Integer> noBusca  = new No<>();
        No<Integer> noMax    = new No<>();
        No<Integer> noMin    = new No<>();
        No<Integer> noPred   = new No<>();
        No<Integer> noSuc    = new No<>();    

        noBusca = arvoreValidacaoABB.search(15)  ;
        
        noMax  = arvoreValidacaoABB.maxChave(noBusca);
        noMin  = arvoreValidacaoABB.minChave(noBusca);
        noPred = arvoreValidacaoABB.predecessor(noBusca);
        noSuc  = arvoreValidacaoABB.sucessor(noBusca);

        System.out.println("Max  : " + noMax.getChave());
        System.out.println("Min  : " + noMin.getChave());
        System.out.println("Pred : " + noPred.getChave());
        System.out.println("Suc  : " + noSuc.getChave());
        
        /*******************************************************************/
        /*                        TESTE DE BUSCA                           */
        /*******************************************************************/
      
        No<Integer> noDireita  = new No<>(); 
        No<Integer> noEsquerda = new No<>(); 
 
        System.out.print("""
            \n/*******************************************************************/
            /*                       Teste de busca                            */
            /*******************************************************************/
            """);
        
        noBusca = arvoreValidacaoABB.search(30);

        Integer key         = noBusca.getChave();
        int ocorrencia     = noBusca.getOcorrencia();
        noDireita          = noBusca.getDireita();
       
        Integer keyDireita = null, keyEsquerda = null;

        if (noDireita != null){
            keyDireita  = noDireita.getChave();
        }
        noEsquerda         = noBusca.getEsquerda(); 
        if (noEsquerda != null){
            keyEsquerda  = noEsquerda.getChave();
        }
  
        System.out.println("Teste de busca      : 30 ");
        System.out.println("Chave               : " + key );
        System.out.println("Frequência da chave : " + ocorrencia );
        System.out.println("Chave à direita     : " + keyDireita);
        System.out.println("Chave à esquerda    : " + keyEsquerda);
       
        /*******************************************************************/
        /*                      TESTE DE INSERÇÃO                          */
        /*******************************************************************/

        System.out.print("""
            \n/*******************************************************************/
            /*                       Teste de insercao                         */
            /*******************************************************************/
            """);
        /* 
        boolean chave1 = arvoreValidacaoABB.insert("pamonha");
        boolean chave2 = arvoreValidacaoABB.insert("caminho");
        boolean chave3 = arvoreValidacaoABB.insert("pamonha");
       
        System.out.println("Chave 1 - inserção \"pamonha\": " + chave1);
        System.out.println("Chave 2 - inserção \"caminho\": " + chave2);
        System.out.println("Chave 3 - inserção \"pamonha\": " + chave3);
        */

        System.out.println("\nÁrvore em in ordem  : " );
        arvoreValidacaoABB.inOrder(arvoreValidacaoABB.getRaiz());
        System.out.println("\nÁrvore em pré ordem : " );
        arvoreValidacaoABB.preOrder(arvoreValidacaoABB.getRaiz());
        System.out.println("\nÁrvore em pos ordem : " );
        arvoreValidacaoABB.posOrder(arvoreValidacaoABB.getRaiz());

        /*******************************************************************/
        /*                      TESTE DE REMOÇÃO                           */
        /*******************************************************************/

        System.out.print("""
            \n/*******************************************************************/
            /*                       Teste de remocão                          */
            /*******************************************************************/
            """);

        boolean rem_chave_0 = arvoreValidacaoABB.remove(5);
        boolean rem_chave_1 = arvoreValidacaoABB.remove(40);
        
        Integer key_remove = 30;
        boolean rem_chave_2 = arvoreValidacaoABB.remove(key_remove);

        noBusca = arvoreValidacaoABB.search(15);
        
        System.out.println("Chave 1 - remoção ("+key_remove+"): "   + rem_chave_2);
            
            

        key         = noBusca.getChave();
        ocorrencia  = noBusca.getOcorrencia();
        noDireita   = noBusca.getDireita();
       
      

        if (noDireita != null){
            keyDireita  = noDireita.getChave();
        }
        noEsquerda         = noBusca.getEsquerda(); 
        if (noEsquerda != null){
            keyEsquerda  = noEsquerda.getChave();
        }
  
        System.out.println("Teste de busca      : " + noBusca.getChave());
        System.out.println("Chave               : " + key );
        System.out.println("Frequência da chave : " + ocorrencia );
        System.out.println("Chave à direita     : " + keyDireita);
        System.out.println("Chave à esquerda    : " + keyEsquerda);
       

        /*******************************************************************/
        /*                   EXECUAÇÃO DA VALIDAÇÃO                        */
        /*******************************************************************/

        int h = 0 ;

        int harvoreValidacaoABB = arvoreValidacaoABB.getAltura(arvoreValidacaoABB.getRaiz());
        int totPalavrasarvoreValidacaoABB = arvoreValidacaoABB.getPalavras();
        int totPalavrasArvoreDistintasABB = arvoreValidacaoABB.getPalavrasDistintas();
        int alturaMinima = (int) (Math.log(totPalavrasArvoreDistintasABB + 1) / Math.log(2));

        System.out.println("\nÁrvore em in ordem  : " );
        arvoreValidacaoABB.inOrder(arvoreValidacaoABB.getRaiz());
        System.out.println("\nÁrvore em pré ordem : " );
        arvoreValidacaoABB.preOrder(arvoreValidacaoABB.getRaiz());
        System.out.println("\nÁrvore em pos ordem : " );
        arvoreValidacaoABB.posOrder(arvoreValidacaoABB.getRaiz());

        System.out.print("""
            \n
            /*******************************************************************/
            /*                  Execução da árvore de validação                */
            /*******************************************************************/
            """);

        System.out.println("[ A  ] - Total palavras                            : " + totPalavrasarvoreValidacaoABB);
        System.out.println("[ B  ] - Total palavras distintas                  : " + totPalavrasArvoreDistintasABB);
        System.out.println("[ C  ] - Altura mínima da árvore                   : " + alturaMinima);
        System.out.println("[ D  ] - Altura árvore ABB                         : " + harvoreValidacaoABB);
        System.out.println("[ E  ] - Comparação de palavras ABB                : " + h);
        System.out.println("[ F  ] - Altura árvore AVL                         : " + h);
        System.out.println("[ G  ] - Comparação de palavras na árvore AVL      : " + h);
        System.out.println("[ H  ] - Rotações totais na busca com inserção AVL : " + h);
        System.out.println("[ H1 ] - Rotações LL na busca com inserção AVL     : " + h);
        System.out.println("[ H2 ] - Rotações RR na busca com inserção AVL     : " + h);
        System.out.println("[ H3 ] - Rotações LR na busca com inserção AVL     : " + h);
        System.out.println("[ H4 ] - Rotações RL na busca com inserção AVL     : " + h);
        System.out.println("[ I  ] - Média de comparaçoes por palavra (G/B)    : " + h);
        System.out.println("[ J  ] - Media de rotações distintas (H/A)         : " + h);
        
        

    }
}
