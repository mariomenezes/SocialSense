package Search;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class DoConfiguration {


    Twitter twitter;
    public  DoConfiguration(){

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("uOOKMHiGzd9LZrZz7TSpOflm3")
                .setOAuthConsumerSecret("nmBWnWdXipxby3LBxEtHsBxuyfgSufncJej2ak3axmMLidDGMM")
                .setOAuthAccessToken("35617638-3kM7oX8NnTeBBUXlgVIyaT7hxd7SZS2dE96XMOIUS")
                .setOAuthAccessTokenSecret("Wd2Ax10wsAfLpYa5ffOHYiI7BvhgKLYHqFd3m1RwdLAWs");
        TwitterFactory tf = new TwitterFactory(cb.build());
       // Twitter twitter = tf.getInstance();
        twitter = tf.getInstance();

        //return twitter;

    }

    public Twitter getInstance(){
        return twitter;
    }
}
