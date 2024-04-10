import Arvore.Arvore;
import Arvore.ArvoreAVL;
import Arvore.No;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
  
        /*
        String texto = """
            no meio do caminho tinha uma pedra
             tinha uma pedra no meio do caminho
             tinha uma pedra
             no meio do caminho tinha uma pedra""";
        */

        String texto = "15 5 10 7 12 30 20 18 25 40 37 32 38 35 33 36";
        System.out.println("\"" + texto + "\"");

        String[] partes = texto.split(" ");

        int[] numeros = new int[partes.length];

        for (int i = 0; i < partes.length; i++) {
            numeros[i] = Integer.parseInt(partes[i]);
        }
        
        for (int numero : numeros) {
            arvoreValidacaoABB.searchInsert(numero);
        }

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

        arvoreValidacaoABB.printTree(arvoreValidacaoABB.getRaiz(), "", true);
        
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
            /*                       Teste de insercao AVL                     */
            /*******************************************************************/
            """);

            ArvoreAVL<String> arvoreValidacaoAVL = new ArvoreAVL<>();
            
            System.out.print("\n INSERINDO MAI ------------------------------------\n");
            arvoreValidacaoAVL.searchInsert("MAI");
            arvoreValidacaoAVL.printTree(arvoreValidacaoAVL.getRaiz(), "", true);
       
            
            System.out.print("\n INSERINDO MAR ------------------------------------\n");
            arvoreValidacaoAVL.searchInsert("MAR");
            arvoreValidacaoAVL.printTree(arvoreValidacaoAVL.getRaiz(), "", true);
            
             
            System.out.print("\n INSERINDO NOV ------------------------------------\n");
            arvoreValidacaoAVL.searchInsert("NOV");
            arvoreValidacaoAVL.printTree(arvoreValidacaoAVL.getRaiz(), "", true);
            
            
            System.out.print("\n INSERINDO AGO ------------------------------------\n");
            arvoreValidacaoAVL.searchInsert("AGO");
            arvoreValidacaoAVL.printTree(arvoreValidacaoAVL.getRaiz(), "", true);

            
            System.out.print("\n INSERINDO ABR ------------------------------------\n");
            arvoreValidacaoAVL.searchInsert("ABR");
            arvoreValidacaoAVL.printTree(arvoreValidacaoAVL.getRaiz(), "", true);
            
            System.out.print("\n INSERINDO JAN ------------------------------------\n");
            arvoreValidacaoAVL.searchInsert("JAN");
            arvoreValidacaoAVL.printTree(arvoreValidacaoAVL.getRaiz(), "", true);

            
            System.out.print("\n INSERINDO DEZ ------------------------------------\n");
            arvoreValidacaoAVL.searchInsert("DEZ");
            arvoreValidacaoAVL.printTree(arvoreValidacaoAVL.getRaiz(), "", true);

             
            System.out.print("\n INSERINDO JUL ------------------------------------\n");
            arvoreValidacaoAVL.searchInsert("JUL");
            arvoreValidacaoAVL.printTree(arvoreValidacaoAVL.getRaiz(), "", true);
           
             
            System.out.print("\n INSERINDO FEV ------------------------------------\n");
            arvoreValidacaoAVL.searchInsert("FEV");
            arvoreValidacaoAVL.printTree(arvoreValidacaoAVL.getRaiz(), "", true);
            
            System.out.print("\n INSERINDO JUN ------------------------------------\n");
            arvoreValidacaoAVL.searchInsert("JUN");
            arvoreValidacaoAVL.printTree(arvoreValidacaoAVL.getRaiz(), "", true);
            
            System.out.print("\n INSERINDO OUT ------------------------------------\n");
            arvoreValidacaoAVL.searchInsert("OUT");
            arvoreValidacaoAVL.printTree(arvoreValidacaoAVL.getRaiz(), "", true);
            
        
        /*******************************************************************/
        /*                      TESTE DE REMOÇÃO                           */
        /*******************************************************************/

        System.out.print("""
            \n/*******************************************************************/
            /*                       Teste de remocão                          */
            /*******************************************************************/
            """);
         
        ArvoreAVL<Integer> arvoreValidacaoAVLRem = new ArvoreAVL<>();
        
        arvoreValidacaoAVLRem.searchInsert(300);  
        arvoreValidacaoAVLRem.searchInsert(100);
        arvoreValidacaoAVLRem.searchInsert(500);
      
       // arvoreValidacaoAVLRem.printTree(arvoreValidacaoAVLRem.getRaiz(), "", true);
      
        arvoreValidacaoAVLRem.searchInsert(50);
        arvoreValidacaoAVLRem.searchInsert(200);
        arvoreValidacaoAVLRem.searchInsert(350);
        arvoreValidacaoAVLRem.searchInsert(700);
        arvoreValidacaoAVLRem.searchInsert(30);
        arvoreValidacaoAVLRem.searchInsert(375);
        arvoreValidacaoAVLRem.searchInsert(600);
        
        
        int key_remove = 200;
        boolean rem_chave_2 = arvoreValidacaoAVLRem.remove(key_remove);

        key_remove = 500;
        rem_chave_2 = arvoreValidacaoAVLRem.remove(key_remove);

        key_remove = 700;
        rem_chave_2 = arvoreValidacaoAVLRem.remove(key_remove);

        key_remove = 50;
        rem_chave_2 = arvoreValidacaoAVLRem.remove(key_remove);

        System.out.print("\n Arvore Final ------------------------------------\n");
        arvoreValidacaoAVLRem.printTree(arvoreValidacaoAVLRem.getRaiz(), "", true);
             
           
        arvoreValidacaoAVLRem.setRaiz(null);
       
        arvoreValidacaoAVLRem.searchInsert(500);
        arvoreValidacaoAVLRem.searchInsert(100);
        arvoreValidacaoAVLRem.searchInsert(700);
        arvoreValidacaoAVLRem.searchInsert(300);
        arvoreValidacaoAVLRem.searchInsert(600);
        arvoreValidacaoAVLRem.searchInsert(800);
        arvoreValidacaoAVLRem.searchInsert(550);
       
        System.out.print("\n Arvore Inicial ------------------------------------\n");
        arvoreValidacaoAVLRem.printTree(arvoreValidacaoAVLRem.getRaiz(), "", true);
      
        key_remove = 800;
        rem_chave_2 = arvoreValidacaoAVLRem.remove(key_remove);

        System.out.print("\n Arvore Final ------------------------------------\n");
        arvoreValidacaoAVLRem.printTree(arvoreValidacaoAVLRem.getRaiz(), "", true);
      
        /*******************************************************************/
        /*                   IMPRESSÃO DA ARVORE                           */
        /*******************************************************************/
        System.out.print("""
            \n
            /*******************************************************************/
            /*                  Impressão das ordens                           */
            /*******************************************************************/
            """);

            System.out.println("\nÁrvore em in ordem  : " );
            arvoreValidacaoABB.inOrder(arvoreValidacaoABB.getRaiz());
            System.out.println("\nÁrvore em pré ordem : " );
            arvoreValidacaoABB.preOrder(arvoreValidacaoABB.getRaiz());
            System.out.println("\nÁrvore em pos ordem : " );
            arvoreValidacaoABB.posOrder(arvoreValidacaoABB.getRaiz());
    


        System.out.print("""
            \n
            /*******************************************************************/
            /*                  Impressão das árvores                          */
            /*******************************************************************/
            """);

            System.out.println("\n");
      
            arvoreValidacaoABB.printTree(arvoreValidacaoABB.getRaiz(), "", true);
       

        /*******************************************************************/
        /*                   EXECUAÇÃO DA VALIDAÇÃO                        */
        /*******************************************************************/

        
        System.out.print("""
            \n
            /*******************************************************************/
            /*                  Execução da árvore de validação                */
            /*******************************************************************/
            """);

        String caminhoArquivo = "AED-Arvores/resources/bible-kjv-na-np-lo.txt";

        File arquivo = new File(caminhoArquivo);

        StringBuilder conteudoArquivo = new StringBuilder();

        try {
            // Criar um FileReader para ler o arquivo
            FileReader fileReader = new FileReader(arquivo);

            // Criar um BufferedReader para ler linhas do arquivo
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Ler cada linha do arquivo e adicionar ao StringBuilder
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                conteudoArquivo.append(linha).append("\n"); // Adiciona a linha ao conteúdo com quebra de linha
            }

            // Fechar o BufferedReader e o FileReader
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArvoreAVL<String> arvoreExecucaoAVL = new ArvoreAVL<>();
        Arvore<String> arvoreExecucaoABB = new Arvore<>();

        String bibString = conteudoArquivo.toString();

        String[] palavras = bibString.split("\\P{Alpha}+");

        for (String palavra : palavras) {
            palavra = palavra.trim();
            palavra = palavra.toUpperCase();
            arvoreExecucaoABB.searchInsert(palavra);
        }         
        
        for (String palavra : palavras) {
            palavra = palavra.trim();
            palavra = palavra.toUpperCase();
            arvoreExecucaoAVL.searchInsert(palavra);
        }  

       

        int hArvoreExecucaoAVL                = arvoreExecucaoAVL.getAltura(arvoreExecucaoAVL.getRaiz());
        int totPalavrasArvoreExecucaoAVL      = arvoreExecucaoAVL.getPalavras();
        int totPalDistintasArvoreExecucaoAVL  = arvoreExecucaoAVL.getPalavrasDistintas();
        int alturaMinima = (int) (Math.log(totPalDistintasArvoreExecucaoAVL + 1) / Math.log(2));

        int hArvoreExecucaoABB                = arvoreExecucaoABB.getAltura(arvoreExecucaoABB.getRaiz());
        int totPalavrasArvoreExecucaoABB      = arvoreExecucaoABB.getPalavras();
        int totPalDistintasArvoreExecucaoABB  = arvoreExecucaoABB.getPalavrasDistintas();
     

        System.out.println("[ A  ] - Total palavras                            : " + "AVL : " + totPalavrasArvoreExecucaoAVL + " / ABB : " + totPalavrasArvoreExecucaoABB);
        System.out.println("[ B  ] - Total palavras distintas                  : " + "AVL : " + totPalDistintasArvoreExecucaoAVL + " / ABB : " + totPalDistintasArvoreExecucaoABB);
        System.out.println("[ C  ] - Altura mínima da árvore                   : " + alturaMinima);
        System.out.println("[ D  ] - Altura árvore ABB                         : " + hArvoreExecucaoABB );
        System.out.println("[ E  ] - Comparação de palavras ABB                : " + arvoreExecucaoABB.getComparaces());
        System.out.println("[ F  ] - Altura árvore AVL                         : " + hArvoreExecucaoAVL);
        System.out.println("[ G  ] - Comparação de palavras na árvore AVL      : " + arvoreExecucaoAVL.getComparaces());
        System.out.println("[ H  ] - Rotações totais na busca com inserção AVL : " + arvoreExecucaoAVL.getRotacoes(null));
        System.out.println("[ H1 ] - Rotações LL na busca com inserção AVL     : " + arvoreExecucaoAVL.getRotacoes("LL"));
        System.out.println("[ H2 ] - Rotações RR na busca com inserção AVL     : " + arvoreExecucaoAVL.getRotacoes("RR"));
        System.out.println("[ H3 ] - Rotações LR na busca com inserção AVL     : " + arvoreExecucaoAVL.getRotacoes("LR"));
        System.out.println("[ H4 ] - Rotações RL na busca com inserção AVL     : " + arvoreExecucaoAVL.getRotacoes("RL"));
        System.out.println("[ I  ] - Média de comparaçoes por palavra (G/A)    : " + ((double) arvoreExecucaoAVL.getComparaces()/totPalavrasArvoreExecucaoAVL));
        System.out.println("[ J  ] - Media de rotações distintas (H/B)         : " + ((double) arvoreExecucaoAVL.getRotacoes(null)/totPalDistintasArvoreExecucaoAVL));

    }
}
