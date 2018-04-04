package Search;/*
 * Copyright 2007 Yusuke Yamamoto
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



import Search.DoConfiguration;
import twitter4j.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @since Twitter4J 2.1.7
 */
public class SearchTwitter {
    /**
     * Usage: java twitter4j.examples.search.SearchTweets [query]
     *
     * @param args search query
     */


    public static void main(String[] args) throws FileNotFoundException {


        String string_query = "ufal";
        File arquivo;

        arquivo = new File("tweets_unfiltered.txt");
        FileOutputStream fos = new FileOutputStream(arquivo);

        //Para remover links e hashtags do texto.
        //Create Regex pattern to find urls
        String urlPattern = "((https?|ftp|gopher|telnet|file|Unsure|http):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";

//Create a matcher with our 'urlPattern'
        Matcher matcher;

//        if (args.length < 1) {
//            System.out.println("java twitter4j.examples.search.SearchTweets [query]");
//            System.exit(-1);
//        }

        //Twitter twitter = new TwitterFactory().getInstance();
        DoConfiguration doconf = new DoConfiguration();
        Twitter twitter = doconf.getInstance();

        int count = 0;
        String maceio_geo_id = "70d9237ded8be5f4";
        try {
            Date date = new Date();
            Query query = new Query(string_query +" +exclude:retweets");
            QueryResult result;
            String modifiedDate= new SimpleDateFormat("20180301").format(date);
            query.setSince(modifiedDate);
            do {
                result = twitter.search(query);



                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                    String location = twitter.showUser(
                            tweet.getUser().getScreenName()).getLocation();
                    if (location.contains("Maceió")
                            || location.contains("maceió")
                            || location.contains("Brasil")
                            || location.contains("Brazil")
                            || location.contains("Alagoas")
                            || location.contains("AL")) {
                        // TODO  - Only retrive information if tweeted from maceió
//                        String tweet_text = tweet.getUser().getScreenName() +
//                                " - " + tweet.getText();
                        String tweet_text = tweet.getText();

                        //TODO verify if RT is a important metric
                        if( ! tweet_text.contains("RT")) {
                            //System.out.println(location);

                            String tweetWithoutUrl = tweet_text.replaceAll(urlPattern, "");

                            //System.out.println("@" + tweet_text + "\n\n\n");
                            tweetWithoutUrl  = tweetWithoutUrl.replace ("\n", ""); // isto vai funcionar
                            System.out.println(tweetWithoutUrl + "\n\n\n");
                            ++count;

                            try {
                                // Gravando no arquivo

                                //String texto = "quero gravar este texto no arquivo";
                                fos.write(tweetWithoutUrl.getBytes());
                                String jump_line = "\n\n";
                                //texto = "\nquero gravar este texto AQUI TAMBEM";
                                fos.write(jump_line.getBytes());


                                // Lendo do arquivo
                                //arquivo = new File("arquivo.txt");
                               // FileInputStream fis = new FileInputStream(arquivo);

                                //int ln;
                                //while ( (ln = fis.read()) != -1 ) {
                                //    System.out.print( (char)ln );
                               // }

                                //fis.close();
                            }
                            catch (Exception ee) {
                                ee.printStackTrace();
                            }
                        }
                    }
                }


            } while ((query = result.nextQuery()) != null);

            //Fecha arquivo de texto
            fos.close();


            System.out.println("tweets encontrados: " + String.valueOf(count));

            System.exit(0);

        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}


/** Exemplo de como consultar em datas antigas

Query query = new Query("Iron Man");
        Date date = new Date();
        String modifiedDate= new SimpleDateFormat("yyyymmdd").format(date);
        query.setSince(modifiedDate);
        QueryResult result;
            do {
            result = twitter.search(query);
            List<Status> tweets = result.getTweets();
            for (Status tweet : tweets) {
                 System.out.println("@"+tweet.getUser().getScreenName() + "|" + tweet.getText()+"|"+ tweet.isRetweeted() );
                 }
              } while ((query = result.nextQuery()) != null);


 */
