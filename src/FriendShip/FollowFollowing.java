package FriendShip;

import twitter4j.IDs;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;



public class FollowFollowing {

    public FollowFollowing(){

    }

    private static void getConnections(long id) throws TwitterException {
        Twitter twitter = new TwitterFactory().getInstance();

        long lCursor = -1;
        IDs friendsIDs = twitter.getFriendsIDs(id, lCursor);
        System.out.println(twitter.showUser(id).getName());
        System.out.println("==========================");
        do
        {
            for (long i : friendsIDs.getIDs())
            {
                System.out.println("follower ID #" + i);
                System.out.println(twitter.showUser(i).getName());
            }
        }while(friendsIDs.hasNext());
    }

}
