package Access;

//Original code at http://www.java-tutorial.ch/framework/twitter-with-java-tutorial
import java.io.BufferedReader;
import java.util.List;
import java.io.IOException;
import java.io.InputStreamReader;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.Status;

import java.net.URISyntaxException;
import java.awt.Desktop;
import java.net.URI;

public class Tweet {
	
	private boolean counter = true;
   private final static String CONSUMER_KEY = "hyL303lpgZpSt6cMmilBw";
   private final static String CONSUMER_KEY_SECRET = "EqgkdjEPuhP4KyVm3PEV926YuDrPcZAG249FxwXE9Q";
   
   Twitter twitter = new TwitterFactory().getInstance();
   public void start() throws TwitterException, IOException,URISyntaxException {



twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);
RequestToken requestToken = twitter.getOAuthRequestToken();
System.out.println("Going to "+ requestToken.getAuthorizationURL());
String web = requestToken.getAuthorizationURL();

Desktop.getDesktop().browse(new URI(web));

AccessToken accessToken = null;

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
while (null == accessToken) {
    try {
 System.out.print("Input PIN here: ");
 String pin = br.readLine();

 accessToken = twitter.getOAuthAccessToken(requestToken, pin);

    } catch (TwitterException te) {

 System.out.println("Failed to get access token, caused by: "
  + te.getMessage());

 System.out.println("Pin Error");

    }



System.out.println("Access Token: " + accessToken.getToken());
System.out.println("Access Token Secret: "
 + accessToken.getTokenSecret());

}


 //twitter.updateStatus("Hello Twitter");

   }
   public void homeTime() throws TwitterException{
	   List<Status> statuses = twitter.getHomeTimeline();
	   System.out.println("Timeline Loading...");
	   for (Status status : statuses) {
	       System.out.println(status.getUser().getName() + ":" +
	                          status.getText());
	   }
   }
   
  
 
 private static void storeAccessToken(int useId, AccessToken accessToken){
   //store accessToken.getToken()
   //store accessToken.getTokenSecret()
 }

   public static void main(String[] args) throws Exception {
  	 new Tweet().start();
   }
}