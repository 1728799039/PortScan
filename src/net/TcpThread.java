package net;
import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TcpThread extends Thread{
    
    //�������
    public static InetAddress hostAddress;//����IP��ַ
    public static int MIN_port;            //The minimal number of port
    public static int MAX_port;            //The maximal number of port
    private int NUM_thread;                //�߳�����
    public static int type;                //��ѯ��ʽ��0ΪIP��ʽ1Ϊ��������ѯ��ʽ
    
    public static int ip1;//IPǰ��λ
    public static int ip2;//IP4~6λ
    public static int ip3;//IP7~9λ
    public static int ipstart;//��ʼIP��ַ�����λ
    public static int ipend;//����IP��ַ�����λ
    public static String ipAll;//������IP��ַ
    
    String nameHost = "";//ɨ����������ƻ�IP��ַ
    String typeport = "0";//�˿����
    
    /**
     * ���캯��
     */
    public TcpThread( String name, int numthread ){
        super(name);
        this.NUM_thread = numthread;
    }
    
    /**
     * run()���к���
     */
    public void run( ) {
        
        int h = 0;//IP address
        int i = 0;//port number
        
        Socket theTcpSocket;
        
        //����IP��ַ����ɨ��
        if( 0 == type ){
            //IP��ַѭ��ɨ��
            for( h = ipstart; h <= ipend; h++){
                ipAll = "" + ip1 + "." + ip2 + "." + ip3 + "." + h;
                nameHost = ipAll;
                
                try{
                    hostAddress = InetAddress.getByName( ipAll );
                }catch( UnknownHostException e){}
                
                //��ͬ�˿�ѭ��ɨ��
                for( i = MIN_port; i < MAX_port + Integer.parseInt( ThreadScan.maxThread.getText() );
                        i += Integer.parseInt(ThreadScan.maxThread.getText() ) ){
                    try{
                        theTcpSocket = new Socket(hostAddress, i);
                        theTcpSocket.close();
                        
                        ThreadScan.Result.append( nameHost +":"+i);
                        
                        switch( i ){//��ʵ������Բ���switch��ֱ���ø�hash���¼�Ϳ���
                            case 21:
                                typeport = "(FTP)";
                                break;
                            case 23:
                                typeport = "(TELNET)";
                                break;
                            case 25:
                                typeport = "SMTP";
                                break;
                            case 80:
                                typeport = "HTTP";
                                break;
                            case 110:
                                typeport = "POP";
                                break;
                            case 139:
                                typeport = "netBIOS";
                                break;
                            case 1433:
                                typeport = "SQL Server";
                                break;
                            case 3389:
                                typeport = "Terminal Service";
                                break;
                            case 443:
                                typeport = "HTTPS";
                                break;
                            case 1521:
                                typeport = "Oracle";
                                break;
                        }
                        
                        //�˿�û���ض�����
                        if( typeport.equals("0")){
                            ThreadScan.Result.append("\n");
                        }else{
                            ThreadScan.Result.append(":" + typeport + "\n");
                        }            
                    }catch( IOException e){}
                }
            }
            if( i == MAX_port + Integer.parseInt(ThreadScan.maxThread.getText())){
                ThreadScan.Result.append("\n" + "ɨ�����...");
                //��"ȷ��"��ť����Ϊ����
                ThreadScan.Submit.setEnabled( true );
            }
        }
        
        //�����������ж˿�ɨ��
        if( 1 == type ){
            for( i = MIN_port + NUM_thread; i < MAX_port + Integer.parseInt(ThreadScan.maxThread.getText());
                    i += Integer.parseInt( ThreadScan.maxThread.getText( ) ) ) {
                try{
                    theTcpSocket = new Socket( hostAddress, i );
                    theTcpSocket.close();
                    ThreadScan.Result.append(" " + i);
                    switch( i ){//��ʵ������Բ���switch��ֱ���ø�hash���¼�Ϳ���
                        case 21:
                            typeport = "(FTP)";
                            break;
                        case 23:
                            typeport = "(TELNET)";
                            break;
                        case 25:
                            typeport = "SMTP";
                            break;
                        case 80:
                            typeport = "HTTP";
                            break;
                        case 110:
                            typeport = "POP";
                            break;
                        case 139:
                            typeport = "netBIOS";
                            break;
                        case 1433:
                            typeport = "SQL Server";
                            break;
                        case 3389:
                            typeport = "Terminal Service";
                            break;
                        case 443:
                            typeport = "HTTPS";
                            break;
                        case 1521:
                            typeport = "Oracle";
                            break;
                    }
                    if( typeport.equals("0") ){
                        ThreadScan.Result.append("\n");
                    }else{
                        ThreadScan.Result.append(":" + typeport + "\n");
                    }
                }catch( IOException e){
                    
                }
            }
            if( i == MAX_port + Integer.parseInt(ThreadScan.maxThread.getText())){
                ThreadScan.Result.append("\n" + "ɨ�����...");
                if( !ThreadScan.Submit.isEnabled()){
                    ThreadScan.Submit.setEnabled( true );
                }
            }        
        }//End of if
    }
}