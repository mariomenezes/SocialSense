package analysis;

import NaiveBayes.ReadFile;
import sun.awt.image.ImageWatched;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class Data {





    public static void main(String[] args) {

        String path = "/home/mario/reps/SocialSense/tweets_unfilteredUFAL_sem_data.csv";
        Files f = new Files();
        f.readFile(path);
        //f.readSplit();
        //f.printSplit();
        //f.printTweetList();
        f.separaPalavrasSalvaLista();
        f.printPalavrasSeparadas();
        //f.contabilizaAparicoes();
        //f.printContabilizadas();
        f.contador();

    }



}


