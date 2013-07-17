package Access;

import java.util.Scanner;

import com.google.gson.JsonArray;
// requires gson jars and temboo jars
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.temboo.Library.Twitter.Search.Tweets;
import com.temboo.Library.Twitter.Search.Tweets.TweetsInputSet;
import com.temboo.Library.Twitter.Search.Tweets.TweetsResultSet;
import com.temboo.core.TembooSession;


public class TembooTwitterLister {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// Get these from www.temboo.com
		String acctName, appKeyName, appKeyValue;
		
		// Get these from dev.twitter.com
		String twAccessToken, twAccessSecret, twConsumerKey, twConsumerSecret;
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Account Name");
		acctName = in.nextLine();
		System.out.println("Enter App Key Name");
		appKeyName = in.nextLine();
		System.out.println("Enter App Key Value");
		appKeyValue = in.nextLine();
		System.out.println("Enter Twitter Access Token");
		twAccessToken = in.nextLine();
		System.out.println("Enter Twitter Access Secret");
		twAccessSecret = in.nextLine();
		System.out.println("Enter Twitter Consumer Key");
		twConsumerKey = in.nextLine();
		System.out.println("Enter Twitter Consumer Secret");
		twConsumerSecret = in.nextLine();
		
		// Instantiate the Choreo, using a previously instantiated TembooSession object, eg:
		TembooSession session = new TembooSession(acctName, appKeyName, appKeyValue);
		Tweets tweetsChoreo = new Tweets(session);

		// Get an InputSet object for the choreo
		TweetsInputSet tweetsInputs = tweetsChoreo.newInputSet();

		// Set inputs
		tweetsInputs.set_AccessToken(twAccessToken);
		tweetsInputs.set_AccessTokenSecret(twAccessSecret);
		tweetsInputs.set_ConsumerKey(twConsumerKey);
		tweetsInputs.set_ConsumerSecret(twConsumerSecret);
		tweetsInputs.set_Query("MLB");
		
		// Execute Choreo
		TweetsResultSet statusesShowResults = tweetsChoreo.execute(tweetsInputs);
		
		System.out.println(statusesShowResults.get_Response());
		
		// Parse the json with gson
    	JsonParser jp = new JsonParser();
    	JsonElement root = jp.parse(statusesShowResults.get_Response());
    	JsonObject rootobj = root.getAsJsonObject(); // may be Json Array if it's an array, or other type if a primitive
    	
    	JsonArray statuses = rootobj.get("statuses").getAsJsonArray();
    	for(int i = 0; i < statuses.size(); i++) {
    		JsonObject status = statuses.get(i).getAsJsonObject();
    		
    		String text = status.get("text").getAsString();
    		String screen_name = status.get("user").getAsJsonObject().get("screen_name").getAsString();
    		
    		System.out.println(screen_name + " said " + text);
    	}
	}

}
