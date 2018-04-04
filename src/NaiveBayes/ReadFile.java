package NaiveBayes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class ReadFile {

    LinkedList<String> tweet_list = new LinkedList<String>();

    public ReadFile() {

        int count = 0;
        try {
            FileReader arq;
            arq = new FileReader("tweets_pos_neg.txt");
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

    public LinkedList<String> returnList(){
        return tweet_list;
    }
}
