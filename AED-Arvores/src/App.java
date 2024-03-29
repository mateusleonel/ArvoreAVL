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
        
        Arvore<String> arvoreValidacaoABB = new Arvore<>();

        ArvoreAVL<String> arvoreValidacaoAVL = new ArvoreAVL<>();

        String texto = """
            no meio do caminho tinha uma pedra
             tinha uma pedra no meio do caminho
             tinha uma pedra
             no meio do caminho tinha uma pedra""";

        String[] palavras = texto.split("\\s+");
        System.out.println("\"" + texto + "\"");
        
        for (String palavra : palavras) {
            arvoreValidacaoABB.searchInsert(palavra);
            arvoreValidacaoAVL.searchInsert(palavra);  
        }                
      
        
        /*******************************************************************/
        /*                        TESTE DE BUSCA                           */
        /*******************************************************************/
      
        No<String> noBusca    = new No<>();
        No<String> noDireita  = new No<>(); 
        No<String> noEsquerda = new No<>(); 
 
        System.out.print("""
            \n/*******************************************************************/
            /*                       Teste de busca                            */
            /*******************************************************************/
            """);
        
        noBusca = arvoreValidacaoABB.search("tinha");

        String key         = noBusca.getChave();
        int ocorrencia     = noBusca.getOcorrencia();
        noDireita          = noBusca.getDireita();
       
        String keyDireita = null, keyEsquerda = null;

        if (noDireita != null){
            keyDireita  = noDireita.getChave();
        }
        noEsquerda         = noBusca.getEsquerda(); 
        if (noEsquerda != null){
            keyEsquerda  = noEsquerda.getChave();
        }
  
        System.out.println("Teste de busca     : tinha ");
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
        
        boolean chave1 = arvoreValidacaoABB.insert("pamonha");
        boolean chave2 = arvoreValidacaoABB.insert("caminho");
        boolean chave3 = arvoreValidacaoABB.insert("pamonha");
       
        System.out.println("Chave 1 - inserção \"pamonha\": " + chave1);
        System.out.println("Chave 2 - inserção \"caminho\": " + chave2);
        System.out.println("Chave 3 - inserção \"pamonha\": " + chave3);
        
        /*******************************************************************/
        /*                   Execução da validação                         */
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
