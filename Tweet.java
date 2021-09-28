

package project1;

public class Tweet {

		private int polarity;
		private long id;
		private String username;
		private String message;

		
		public Tweet (int polarity, long id, String username, String msg)
		{
			this.polarity = polarity;
			this.id = id;
			this.username = username;
			this.message = msg;
		}
		
		public boolean equals(Tweet tw) {
			if(this.id==tw.getId())
				return true;
			else
				return false;
		}

		public int getPolarity() {
			return polarity;
		}

		public void setPolarity(int polarity) {
			this.polarity = polarity;
		}

		public long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
		
		public String toString() {
			String toReturn = new String();
			toReturn = ("{" + this.polarity + "," + this.id + "," + this.username + "," + this.message + "}");
			return toReturn;
		}
		
	
	
	}
