package analysis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Files {

     LinkedList<String> tweet_list = new LinkedList<String>();
     LinkedList<CustomDataType> palavras = new LinkedList<>();

    LinkedList<String> palavras_separadas = new LinkedList<String>();
    LinkedList<CustomDataType> palavras_contabilizadas = new LinkedList<>();

    public  void readFile(String path){
        int count = 0;
        try {
            FileReader arq;
            arq = new FileReader(path);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine(); // lê a primeira linha

            // String temp = linha;
// a variável "linha" recebe o valor "null" quando o processo
// de repetição atingir o final do arquivo texto
            //if (linha == "\n")

            while (linha != null) {

                //linha = linha.replaceAll("(?m)^[ \t]*\r?\n", "");
                //int line_lenght = linha.length();
                if (Integer.valueOf(linha.length()) != 0) {
                    //System.out.println(linha + " = " + linha.length());

                    //linha = lerArq.readLine(); // lê da segunda até a última linha
                    ++count;
                    tweet_list.add(linha);
                }

                linha = lerArq.readLine(); // lê da segunda até a última linha

            }
            //arq.close();
            System.out.println("numero de tweets ]= " + String.valueOf(count));
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }
    public void printTweetList(){
        for (int i = 0; i < tweet_list.size(); ++i){
            System.out.println(tweet_list.get(i));
        }
    }

    int contando = 0;

    public void separaPalavrasSalvaLista() {
        for(int i = 0; i < tweet_list.size(); ++i){
            String[] s = new String[] {};
            s = tweet_list.get(i).split("\\s");
            for(int j = 0; j < s.length; ++j) {
                palavras_separadas.add(s[j]);
            }
        }
    }

    public void contador(){

        @SuppressWarnings("serial")
        /*ArrayList<String> seussCountActivities = new ArrayList<String>() {
            {
                add("findow");
                add("Balloons");
                add("Elephants");
                add("Boom Bands");
                add("findow");
                add("Hakken-Kraks");
                add("Hakken-Kraks");
                add("Hakken-Kraks");
                add("Elephants");
            }
        };*/

        Map<String, Integer> seussCount = new HashMap<String, Integer>();
        for (String t : palavras_separadas) {
            Integer i = seussCount.get(t);
            if (i == null) {
                i = 0;
            }
            seussCount.put(t, i + 1);
        }

        System.out.println(seussCount);

        //int numberOfElephants = seussCount.get("Elephants");
        //assertEquals(2, numberOfElephants);
    }

    public void printPalavrasSeparadas(){

        for(int i = 0; i < palavras_separadas.size(); ++i){
            System.out.println(palavras_separadas.get(i));
        }
    }


    public void lerPalavrasRemover(){

    }



















//    public void contabilizaAparicoes(){
//
//        for(int i = 0; i < palavras_separadas.size(); ++i){
//            int aparicoes = 1;
//            String s = palavras_separadas.get(i);
//            int j = i +1;
//            for(; j < palavras_separadas.size(); ++j){
//                if(palavras_separadas.get(i).contains(s)){
//                    ++aparicoes;
//                }
//            }
//            aparicoes = 1;
//            CustomDataType c = new CustomDataType(palavras_separadas.get(i), aparicoes);
//            palavras_contabilizadas.add(c);
//
//        }
   // }

//    public void printContabilizadas(){
//        for (int i = 0; i < palavras_contabilizadas.size(); ++i){
//            CustomDataType c = palavras_contabilizadas.get(i);
//            System.out.println("PALAVRA: " + c.getPalavra() + " CONT: " + c.getOcorrencias());
//        }
//    }



//    public void readSplit(){
//
//        //lê o array com tweets sem data
//        for(int i = 0; i < tweet_list.size(); ++i){
//            contando++;
//            //separa cade tweet em palavras
//            String[] s = new String[] {};
//            //String[] s = tweet_list.get(i).split("\\s");
//            s = tweet_list.get(i).split("\\s");
//            // pega cada palavra do tweet
//            for(int j = 0; j < s.length; ++j){
//                // constrói um objeto com palavra e 0 ocorrências
//                CustomDataType c = new CustomDataType(s[j],1);
//                //se retornar verdadeiro, a palavra ja foi adicionada e soma +1
//                //se falso, apenas adiciona a palavra e 1
//                //System.out.println("Palavra " + j + " " + s[j]);
//                if (palavraExiste(s[j])){}
//                else{
//                    palavras.add(c);
//                }
//            }
//
//        }
//    }



//    public  boolean palavraExiste(String palavra) {
//        //varre o array de palavras separadas
//        System.out.println("PALAVRA QUE CHEGOU: " + palavra);
//        for (int i = 0; i < palavras.size(); ++i) {
//            CustomDataType c = new CustomDataType();
//            c = palavras.get(i);
//            System.out.println("PALAVRAAAAAAA: " + c.getPalavra() + " COMPARADA A: " + palavra);
//            try {
//                Thread.sleep( 0 );
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            //caso a palavra já esteja na lista, é adicionado +1 em ocorrencias e retorna true
//            if (c.getPalavra() == palavra) {
//                System.out.println("Palavra: " + c.getPalavra() + " JA ADDED, num de ocorr: " + c.getOcorrencias() );
//                c.setOcorrencias(35);
//                System.out.println("Novo num de ocorr: " + c.getOcorrencias());
//                palavras.add(i,c);
//                return true;
//            } else {
//                return false;
//            }
//        }
//
//        return false;
//    }

//    public  void printSplit(){
//        for (int i = 0; i < palavras.size(); ++i){
//            CustomDataType c = palavras.get(i);
//            System.out.println("Palavra: " + c.getPalavra() + " | - | Ocorr: " + c.getOcorrencias());
//
//        }
//        System.out.println("tamanho do array: " + palavras.size());
//    }
}
