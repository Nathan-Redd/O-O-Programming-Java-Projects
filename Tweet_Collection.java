package project1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class Tweet_Collection {

		private HashMap <Long, Tweet> myTwitter;
		private String[] tokens;
		
		
		public Tweet_Collection () {
			myTwitter = new HashMap<Long, Tweet>();
		}

		public void addTweet(Tweet tw) {
			myTwitter.put(tw.getId(), tw);
		}
		
		public void deleteTweet(long id) {
			if(myTwitter.isEmpty()) {
				System.out.println("ERROR: There are no Tweets.");
			}
			else if(myTwitter.containsKey(id)) {
				myTwitter.remove(id);
				System.out.println("Tweet deleted successfully.");
			}
			else {
				System.out.println("ERROR: Tweet was not found");
			}
		}
		
		public int size() {
			return myTwitter.size();
		}
		
		public Tweet getTweetById(Long id) {
			Tweet toReturn = new Tweet(0,0,"0","0");
			toReturn = myTwitter.get(id);
			if(toReturn == null) {
				System.out.println("ERROR: There is no Tweet with that id. Expected: null");
			}
			return toReturn;
		}
		
		public Tweet getTweetByUsername(String username) {
			Tweet tempT = new Tweet(0,0,"0","0");
			
			for(Map.Entry<Long, Tweet> set : myTwitter.entrySet()) {
				tempT = set.getValue();	
				if(tempT.getUsername().equals(username)) {
					return tempT;
				}
			}
			System.out.println("ERROR: There is no Tweet with that username. Expected: null");
			return null;
		}
		
		public ArrayList<Long> getIds() {
			ArrayList<Long> idPool = new ArrayList<Long>();
			Tweet tempT = new Tweet(0,0,"0","0");
			
			for(Map.Entry<Long, Tweet> set : myTwitter.entrySet()) {
				tempT = set.getValue();
				idPool.add(tempT.getId());
			}
			return idPool;
		}
		
		public ArrayList<Long> getIdsByUser(String username) {
			ArrayList<Long> idPool = new ArrayList<Long>();
			Tweet tempT = new Tweet(0,0,"0","0");

			for(Map.Entry<Long, Tweet> set : myTwitter.entrySet()) {
				tempT = set.getValue();
				if(tempT.getUsername().equals(username)) {
					idPool.add(tempT.getId());
				}
			}
			return idPool;
		}
		

		
		public int tweetPrediction(Tweet tw) {
			return(4);
		}
		
		public double collectionPrediction(Tweet_Collection myTweets) {
			double numCorrect = 0.0;
			Tweet tempT = new Tweet(0,0,"0","0");
			
			
			for(Map.Entry<Long, Tweet> set : myTwitter.entrySet()) {
				tempT = set.getValue();
				if(tempT.getPolarity() == (myTweets.tweetPrediction(tempT))) {
					numCorrect++;
				}
			}
			return((numCorrect/myTweets.size())*100);
		}
		
		public String toString() {
			String toReturn = new String();
			int i = 0;
			
			if(myTwitter.isEmpty()) {
				return("There are no Tweets.");
			}
			
			for(Map.Entry<Long, Tweet> set : myTwitter.entrySet()) {
				toReturn += set.getValue();
				toReturn += "\n";
				i++;
				if(i > 100) {
					break;
				}
			}
			
			return toReturn;

		}
		public void readFile1(String fn) {
			BufferedReader lineReader = null;
			Tweet tempTweet = new Tweet(0, 0, "0", "0");
			try {
				FileReader fr = new FileReader(fn);
				lineReader = new BufferedReader(fr);
				String line = null;
				while ((line = lineReader.readLine()) != null) {
				
					String[] tokens = line.split(",");
					tempTweet = new Tweet(Integer.parseInt(tokens[0]), Long.parseLong(tokens[1]), tokens[2], tokens[3]);
					myTwitter.put(tempTweet.getId(), tempTweet);
				}
			}
				catch (Exception ex) {
					System.out.println("There was a problem with the file reader, try a different file.");
				}
			
		}
		
		public void writeFile(String fn) {
			try {
				FileWriter fw = new FileWriter(fn);
				BufferedWriter myOutFile = new BufferedWriter(fw);
				Tweet tempTweet = new Tweet(0, 0, "0", "0");
				
				for(Map.Entry<Long, Tweet> set : myTwitter.entrySet())
				{
					tempTweet = set.getValue();
					myOutFile.write(tempTweet.toString() + "\n");
				}
				
				myOutFile.flush();
				myOutFile.close();
			}
			catch(Exception ex) {
				ex.printStackTrace();
				System.out.println("File did not save to:" + fn);
			}
		}
		
		
}


