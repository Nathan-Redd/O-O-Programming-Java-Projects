package project1;

import project1.Tweet;
import project1.Tweet_Collection;

public class Tweet_Tester {



	public static void main(String[] args) {
		//Testing tweet constructor
				Tweet tweet1 = new Tweet(4,123,"John", "I like dogs");
				Tweet tweet2 = new Tweet(0,456,"Jane", "I hate dogs");
				Tweet tweet3 = new Tweet(2,789,"lisa", "I dont care about dogs");
				
				//Testing Tweet_Collection constructor
				Tweet_Collection myTweets = new Tweet_Collection();
				System.out.println(myTweets);
				
				//Testing addTweets method
				myTweets.addTweet(tweet1);
				myTweets.addTweet(tweet2);
				myTweets.addTweet(tweet3);
				System.out.println(myTweets);

				//Testing deleteTweet method
				myTweets.deleteTweet(000);
				myTweets.deleteTweet(123);
				System.out.println(myTweets);

				
				//Testing getTweetById method
				System.out.println(myTweets.getTweetById((long) 123));
				System.out.println(myTweets.getTweetById((long) 456));
				
				//Testing getTweetByUsername method
				System.out.println(myTweets.getTweetByUsername("John"));
				System.out.println(myTweets.getTweetByUsername("Jane"));
				
				//Testing getIds method
				System.out.println(myTweets.getIds());
				
				//Testing getIds by username method
				Tweet tweet4 = new Tweet(0,111,"Jane","I like cats");
				Tweet tweet5 = new Tweet(0,222,"Jane","I like cake");
				myTweets.addTweet(tweet4);
				myTweets.addTweet(tweet5);
				System.out.println(myTweets.getIdsByUser("Jane"));
				
				//Testing collection prediction
				System.out.println("Prediction accuracy: " + myTweets.collectionPrediction(myTweets));

				Tweet_Collection myTwitter2 = new Tweet_Collection();
				myTwitter2.readFile1("Tester");
				System.out.println(myTwitter2);
	}

}
