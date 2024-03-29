import Arvore.Arvore;
import Arvore.ArvoreAVL;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

       
        /* Inserção de uma árvore conhecida, apresentada em aula para validação
           do algoritmo  */

        Arvore<String> arvoreABB = new Arvore<>();

        ArvoreAVL<String> arvoreAVL = new ArvoreAVL<>();

        String texto = """
                        no meio do caminho tinha uma pedra
                        tinha uma pedra no meio do caminho
                        tinha uma pedra
                        no meio do caminho tinha uma pedra""";

        String[] palavras = texto.split("\\s+");

        // Exibindo as palavras
        for (String palavra : palavras) {
            //arvoreABB.searchInsert(palavra);
            arvoreAVL.searchInsert(palavra);  
        }                
        int h = 0 ;

        int hArvoreABB = arvoreABB.getAltura(arvoreABB.getRaiz());
        int totPalavrasArvoreABB = arvoreABB.getPalavras();
        int totPalavrasArvoreDistintasABB = arvoreABB.getPalavrasDistintas();
        int alturaMinima = (int) (Math.log(totPalavrasArvoreDistintasABB + 1) / Math.log(2));

         System.out.println("\n");

         System.out.println("[ A  ] - Total palavras                            : " + totPalavrasArvoreABB);
         System.out.println("[ B  ] - Total palavras distintas                  : " + totPalavrasArvoreDistintasABB);
         System.out.println("[ C  ] - Altura mínima da árvore                   : " + alturaMinima);
         System.out.println("[ D  ] - Altura árvore ABB                         : " + hArvoreABB);
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
         

        arvoreABB.preOrder(arvoreABB.getRaiz());

         /*********************************************** */
    }
}
