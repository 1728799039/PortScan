package snippet;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @(#)MyPortScan.java
 *
 * @author Duola
 * @version 1.00 2015/12/28
 */

public class MyPortScan {


    public MyPortScan() {
    
    }
   
    public static void main(String[] args) {
    	String hostname = "220.181.111.111";
//    	int [] portArray = {21, 22, 23, 25, 69, 79, 80, 110, 113, 119, 220, 443, 8080};
//    	int num = 0;
    	Scan sp1 = new Scan(hostname);
		Scan sp2 = new Scan(hostname);
		Scan sp3 = new Scan(hostname);
		Scan sp4 = new Scan(hostname);
		Scan sp5 = new Scan(hostname);
		sp1.start();
		sp2.start();
		sp3.start();
		sp4.start();
		sp5.start();
		System.out.print("done");
		
    }
}
class Bucket{
	private int [] portArray = {21, 22, 23, 25, 69, 79, 80, 110, 113, 119, 220, 443, 8080};
	static private int num = 0;
	
	public synchronized int getport(){
		if(num == portArray.length)
			return -1;
		num++;
		//System.out.print("bucket num:"+num);
		return portArray[num-1];
	}
}
class Scan extends Thread{
	static Bucket bucket = new Bucket();
	private String hostname;  
    public Scan(){
    }
    public Scan(String hostn){
    	hostname = hostn;
    }
    public void sethostname(String hostn){
    	hostname = hostn;

    }
	public void run(){
		
		int port = bucket.getport();
		while(port >= 0){
				
				try{
					Socket s = new Socket();
					s.connect(new InetSocketAddress(hostname, port), 1000);
					System.out.println("The port " + port + " is open!");
					//System.out.println("Connected to "+ s.getInetAddress() + " on port " + s.getPort() + " from port "+ s.getLocalPort() + " of " + s.getLocalAddress());
				}
				catch(Exception e){
					System.out.println("The port " + port + " is closed!");
				}
				
				//System.out.println("\tgetport:"+port);
				/*try {
					sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				port = bucket.getport();
		}
	}
}
