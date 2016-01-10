package snippet;

import java.net.InetSocketAddress;
import java.net.Socket;

public class MyScan extends Thread {
	static MyBucket bucket;
	private String hostname;  
    public MyScan(){
    }
    public MyScan(String hostn, MyBucket bucket){
    	hostname = hostn;
    	this.bucket = bucket;
    }
    public void sethostname(String hostn){
    	hostname = hostn;

    }
	public void run(){
		
		int port = bucket.getport();
		while(port >= 0){
				
				try{
					//Socket s = new Socket(hostname,port);
					Socket s = new Socket();
					s.connect(new InetSocketAddress(hostname, port), 1000);
					System.out.println("The port " + port + " is open!");
					DuolaScan.textArea_open.append("port " + port + " open.\n");
					//System.out.println("Connected to "+ s.getInetAddress() + " on port " + s.getPort() + " from port "+ s.getLocalPort() + " of " + s.getLocalAddress());
				}
				catch(Exception e){
					System.out.println("The port " + port + " is closed!");
					DuolaScan.textArea_close.append("port " + port + " closed.\n");
				}
				
				//System.out.println("\tgetport:"+port);
				/*try {
					sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				DuolaScan.textField.setText("ÕýÔÚÉ¨Ãè¶Ë¿Ú"+port+"¡¤¡¤¡¤");
				port = bucket.getport();
		}
	}
}
