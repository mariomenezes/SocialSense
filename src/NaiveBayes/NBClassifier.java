package NaiveBayes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;

import de.daslaboratorium.machinelearning.classifier.bayes.BayesClassifier;
import de.daslaboratorium.machinelearning.classifier.Classifier;

public class NBClassifier {




    public static void main(String[] args) {


        ReadFile r = new ReadFile();
        LinkedList<String> tweet_list;
        tweet_list = r.returnList();

        /*
         * Create a new classifier instance. The context features are
         * Strings and the context will be classified with a String according
         * to the featureset of the context.
         */


        final Classifier<String, String> bayes =
                new BayesClassifier<String, String>();

        /*
         * The classifier can learn from classifications that are handed over
         * to the learn methods. Imagin a tokenized text as follows. The tokens
         * are the text's features. The category of the text will either be
         * positive or negative.
         */
//        final String[] positiveText = "I love sunny days".split("\\s");
//        bayes.learn("positive", Arrays.asList(positiveText));

        //final String[] negativeText = "I hate rain".split("\\s");
        //bayes.learn("negative", Arrays.asList(negativeText));

        //NEGATIVES
        final String[] negativeText1 = "Mais um assalto na ufal agora a noite no bloco de pedagogia.".split("\\s");
        bayes.learn("negative", Arrays.asList(negativeText1));

        final String[] negativeText2 = "Todo dia um assalto novo na Ufal".split("\\s");
        bayes.learn("negative", Arrays.asList(negativeText2));

        final String[] negativeText3 = "Não tem coração a pessoa que vem dá aula na UFAL na véspera de feriado COM REPOSIÇÃO (+2hrs aula), em chuva.".split("\\s");
        bayes.learn("negative", Arrays.asList(negativeText3));

        final String[] negativeText4 = "onde cê chega em Maceió o assunto é o mesmo: assalto na ufal. até parece que o resto da cidade vive num conto de fadas e nada acontece.".split("\\s");
        bayes.learn("negative", Arrays.asList(negativeText4));

        final String[] negativeText5 = "Homem armado invade bloco e assalta alunas e professora dentro do campus da Ufal em Maceió".split("\\s");
        bayes.learn("negative", Arrays.asList(negativeText5));

        final String[] negativeText6 = "@__tais A gente só tem uma matéria de contabilidade de custos. Depois é análise de custos. Essas UFAL são doida mermo.".split("\\s");
        bayes.learn("negative", Arrays.asList(negativeText6));

        final String[] negativeText7 = "vendo como esses estudantes (de comunicação msm) comentam os assaltos na ufal eu fico pensando que vei o dinheiro p…".split("\\s");
        bayes.learn("negative", Arrays.asList(negativeText7));

        final String[] negativeText8 = "A reitoria que trazer a Polícia Militar para dentro do Campus para fazerem ronda lá. Mas uma penca de alunos e prof…".split("\\s");
        bayes.learn("negative", Arrays.asList(negativeText8));

        final String[] negativeText9 = "Boa noite, mas só pra você que largou da Ufal às 21h15, pegou um dos ônibus mais velhos da Real Alagoas às 21h40, d…".split("\\s");
        bayes.learn("negative", Arrays.asList(negativeText9));

        final String[] negativeText10 = "Quando eu penso que a UFAL tá corrida vem ela e fala: MEU AMOR, A GENTE VAI FAZER UMA FUCKING MARATONA DE TIROS.".split("\\s");
        bayes.learn("negative", Arrays.asList(negativeText10));

        final String[] negativeText11 = "Se até os professores do IC tão dizendo que não vão dar aula por causa dos assaltos na ufal, a parada tá absurda de feia já viu.".split("\\s");
        bayes.learn("negative", Arrays.asList(negativeText11));

        final String[] negativeText12 = "Acordo de 6 hrsVou pra UFALQuase chegando descubro que o pneu tá furadoSento no cimentoUm sol de fazer o diabo…".split("\\s");
        bayes.learn("negative", Arrays.asList(negativeText12));

        final String[] negativeText13 = "Toda hora que penso que tenho de ir pra Ufal começo a ter um pico de ansiedade. Eu tô morrendo de medo de pisar lá.…".split("\\s");
        bayes.learn("negative", Arrays.asList(negativeText13));

        //POSITIVES
        final String[] positiveText = "decidi não ir pra ufal hoje pra ficar em casa assistindo séries".split("\\s");
        bayes.learn("positive", Arrays.asList(positiveText));

        final String[] positiveText1 = "Hoje (29), às 16h, acontece o primeiro Ciclo Teatro e Cinema promovido pelo Núcleo de Estudos e Pesquisas das Expre…".split("\\s");
        bayes.learn("positive", Arrays.asList(positiveText1));

        final String[] positiveText2 = "Bom dia, UFAL!".split("\\s");
        bayes.learn("positive", Arrays.asList(positiveText2));

        final String[] positiveText3 = "Descanso, Ufal, é a melhor parte do dia, ver meu Corinthians jogar, se vier a classificação, o dia terminará ainda melhor. Fuiz!".split("\\s");
        bayes.learn("positive", Arrays.asList(positiveText3));

        final String[] positiveText4 = "A quem se interessar, concurso aberto para a Ufal! =)".split("\\s");
        bayes.learn("positive", Arrays.asList(positiveText4));

        final String[] positiveText5 = "Ufal abre inscrições para concurso, com vagas em Delmiro Gouveia".split("\\s");
        bayes.learn("positive", Arrays.asList(positiveText5));

        final String[] positiveText6 = "Em nota, Ufal diz que imagens da câmera vão ajudar a identificar suspeitos".split("\\s");
        bayes.learn("positive", Arrays.asList(positiveText6));

        /*
         * Now that the classifier has "learned" two classifications, it will
         * be able to classify similar sentences. The classify method returns
         * a Classification Object, that contains the given featureset,
         * classification probability and resulting category.
         */
//        final String[] unknownText1 = "today is a sunny day".split("\\s");
//        final String[] unknownText2 = "there will be rain".split("\\s");
//
//        System.out.println( // will output "positive"
//                bayes.classify(Arrays.asList(unknownText1)).getCategory());
//        System.out.println( // will output "negative"
//                bayes.classify(Arrays.asList(unknownText2)).getCategory());

        while(tweet_list.size() > 0){
            String s = tweet_list.pop();
            String temp[] = s.split("\\s");
            System.out.print(s);
            System.out.println(" " + bayes.classify(Arrays.asList(temp)).getCategory());
        }

        /*
         * The BayesClassifier extends the abstract Classifier and provides
         * detailed classification results that can be retrieved by calling
         * the classifyDetailed Method.
         *
         * The classification with the highest probability is the resulting
         * classification. The returned List will look like this.
         * [
         *   Classification [
         *     category=negative,
         *     probability=0.0078125,
         *     featureset=[today, is, a, sunny, day]
         *   ],
         *   Classification [
         *     category=positive,
         *     probability=0.0234375,
         *     featureset=[today, is, a, sunny, day]
         *   ]
         * ]
         */
        //System.out.println(((BayesClassifier<String, String>) bayes).classifyDetailed(
              //  Arrays.asList(unknownText1)));

        /*
         * Please note, that this particular classifier implementation will
         * "forget" learned classifications after a few learning sessions. The
         * number of learning sessions it will record can be set as follows:
         */
        bayes.setMemoryCapacity(500); // remember the last 500 learned classifications
    }


}