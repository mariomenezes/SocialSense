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

import java.util.List;



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


    public static void main(String[] args) {


        String string_query = "ufal";

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
            Query query = new Query(string_query);
            QueryResult result;
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
                        String tweet_text = tweet.getUser().getScreenName() +
                                " - " + tweet.getText();

                        //TODO verify if RT is a important metric
                        if( ! tweet_text.contains("RT")) {
                            System.out.println(location);

                            System.out.println("@" + tweet_text + "\n\n\n");
                            ++count;
                        }
                    }
                }


            } while ((query = result.nextQuery()) != null);


            System.out.println("tweets encontrados: " + String.valueOf(count));

            System.exit(0);

        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
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
