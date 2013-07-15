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
	
	
	public static void main(String args[]) throws Exception {
		
		Tweet dave = new Tweet();
		Scanner sc = new Scanner(System.in);
		System.out.println("Have you already authorized this app? (y/n): ");
		String dec = sc.nextLine();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
		sc.close();
=======
>>>>>>> fd7d5901fa51615b06d5691a580405e5b9741c12
=======
>>>>>>> fd7d5901fa51615b06d5691a580405e5b9741c12
=======
>>>>>>> fd7d5901fa51615b06d5691a580405e5b9741c12
		
		if(dec.equals("n")){
			dave.start();
		}else{
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
			dave.getCreds();	
		}
		dave.homeTimeLn();
=======
			dave.getCreds();
			dave.runF();
		}
>>>>>>> fd7d5901fa51615b06d5691a580405e5b9741c12
=======
			dave.getCreds();
			dave.runF();
		}
>>>>>>> fd7d5901fa51615b06d5691a580405e5b9741c12
=======
			dave.getCreds();
			dave.runF();
		}
>>>>>>> fd7d5901fa51615b06d5691a580405e5b9741c12

	}
	
	
}
