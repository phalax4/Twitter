package Access;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.Status;


public class Driver {
<<<<<<< HEAD


	public static void main(String args[]) throws Exception {

=======
	
	
	public static void main(String args[]) throws Exception {
		
>>>>>>> e90d25afe17a66d5439e2fe0d745f5463cd21a71
		Tweet dave = new Tweet();
		Scanner sc = new Scanner(System.in);
		System.out.println("Have you already authorized this app? (y/n): ");
		String dec = sc.nextLine();
<<<<<<< HEAD


		if(dec.equals("n")){
			dave.start();
		}else{

			dave.getCreds();	
			dave.runF();
		}



   }


=======
		
		if(dec.equals("n")){
			dave.start();
		}else{
			dave.getCreds();
			dave.runF();
		}

	}
	
	
>>>>>>> e90d25afe17a66d5439e2fe0d745f5463cd21a71
}
