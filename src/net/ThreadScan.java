package net;
import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * ʵ��ɨ����������TreadScan
 * @author Administrator
 *
 */

public class ThreadScan {
    
    public static JFrame main = new JFrame("Scaner(V1.0)By Nevermore");    //ע������
    public static JTextArea Result = new JTextArea("", 4, 40);            //��ʾɨ����
    public static JScrollPane resultPane = new 
            JScrollPane( Result, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
    
    public static JTextField nameHost = new JTextField("localhost", 8 );//�����������ı���
    public static JTextField fromip1 = new JTextField("0", 3);            //����IP��ַǰ��λ���ı���
    public static JTextField fromip2 = new JTextField("0", 3);            //����IP��ַ4~6λ���ı���
    public static JTextField fromip3 = new JTextField("0", 3);            //����IP��ַ7~9λ���ı���
    public static JTextField fromip4 = new JTextField("0", 3);            //����IP��ַ����λ���ı���
    
    public static JTextField toip = new JTextField("0", 3);                //����Ŀ��IP��ַ����λ
    
    public static JTextField minPort = new JTextField("0", 4);            //��С�˿������
    public static JTextField maxPort = new JTextField("1000", 4);        //���˿������
    
    public static JTextField maxThread = new JTextField("100", 3);        //����߳���
    public static JDialog DLGError = new JDialog(main, "����");        //������ʾ��
    public static JLabel DLGINFO = new JLabel("");
    public static JLabel type = new JLabel("��ѡ��");
    //ɨ������
    public static JRadioButton radioIP = new JRadioButton("IP��ַ��");
    public static JRadioButton radioHost = new JRadioButton("��������", true);
    //��ѡ��ť��
    public static ButtonGroup group= new ButtonGroup();
    public static JLabel p1 = new JLabel("�˿ڷ�Χ��");
    public static JLabel p2 = new JLabel("~");
    public static JLabel p3 = new JLabel("~");
    public static JLabel Pdot1 = new JLabel(".");
    public static JLabel Pdot2 = new JLabel(".");
    public static JLabel Pdot3 = new JLabel(".");
    public static JLabel TNUM = new JLabel("�߳�����");
    public static JLabel RST = new JLabel("ɨ������");
    public static JLabel con = new JLabel("");
    //���尴ť
    public static JButton Ok = new JButton("ȷ��");
    public static JButton Submit = new JButton("��ʼɨ��");
    public static JButton Cancel = new JButton("�˳�");
    public static JButton saveButton = new JButton("����ɨ����");
    //�˵�����ƣ���һ��ú�ѧϰѧϰ
    public static JMenuBar myBar = new JMenuBar();
    public static JMenu myMenu = new JMenu("�ļ�(F)");
    public static JMenuItem saveItem = new JMenuItem("����ɨ����(S)");
    public static JMenuItem exitItem = new JMenuItem("�˳�(Q)");
    public static JMenu myMenu2 = new JMenu("����");
    public static JMenuItem helpItem = new JMenuItem("�Ķ�");
    
    /**
     * ������
     */
    public static void main( String[] argcs ){
        main.setSize(500, 400);
        main.setLocation(400, 400);
        main.setResizable(false);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        DLGError.setSize(300, 100);
        DLGError.setLocation(400, 400);
        //���"�˵���"
        myMenu.add(saveItem);
        myMenu.add(exitItem);
        
        myMenu2.add(helpItem);
        
        myBar.add(myMenu);//���˵���Ŀ��ӵ��˵�
        myBar.add(myMenu2);
        
        main.setJMenuBar(myBar);//���˵���ӵ����
        //�����ȼ�
        myMenu.setMnemonic('F');
        saveItem.setMnemonic('S');
        //Ϊ"���Ϊ"�齨���ÿ�ݼ�CTRL + S
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        //���ñ���ģʽ����
        Container mPanel = main.getContentPane();
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 0, 0, 10);
        
        c.gridx = 0;// ���ñ������
        c.gridy = 0;
        c.gridwidth = 10;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(type, c);
        
        group.add(radioIP);
        group.add(radioHost);
        
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(radioIP, c);
        
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.CENTER;
        mPanel.add(fromip1, c);
        
        c.gridx = 2;
        c.gridy = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        mPanel.add(Pdot1, c);
        
        c.gridx = 3;
        c.gridy = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(fromip2, c);
        
        c.gridx = 4;
        c.gridy = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(Pdot2, c);
        
        c.gridx = 5;
        c.gridy = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(fromip3, c);
        
        c.gridy = 1;
        c.gridx = 6;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(Pdot3, c);
        
        
        c.gridx = 7;
        c.gridy = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(fromip4, c);
        
        c.gridx = 8;
        c.gridy = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(p2, c);
        
        c.gridx = 9;
        c.gridy = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(toip, c);
        
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(radioHost, c);
        
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(nameHost, c);
        
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(p1, c);
        
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(minPort, c);
        
        c.gridx = 2;
        c.gridy = 3;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(p3, c);
        
        c.gridx = 3;
        c.gridy = 3;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(maxPort, c);
        
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(TNUM, c);
        
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(maxThread, c);
        
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(Submit, c);
    
        
        c.gridx = 3;
        c.gridy = 5;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(saveButton, c);
        
        c.gridx = 6;
        c.gridy = 5;
        c.gridwidth =4;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(Cancel, c);
        
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 10;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(RST, c);
        
        //�����ı�����Ի���
        Result.setLineWrap(true);
        //�����ı��򲻿ɱ༭
        Result.setEditable(false);
        
        
        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 10;
        c.gridheight = 4;
        c.fill = GridBagConstraints.VERTICAL;
        c.anchor = GridBagConstraints.CENTER;
        mPanel.add(resultPane, c);
        
        Container dPanel = DLGError.getContentPane();
        dPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        dPanel.add(DLGINFO);
        dPanel.add(Ok);
        
        
        Submit.addActionListener(new SubmitAction());
        Cancel.addActionListener(new CancelAction());
        Ok.addActionListener(new OkAction());
        
        //ʵ�ֱ��湦��
        saveItem.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e){
                JFileChooser fc = new JFileChooser();
                int returnVal = fc.showSaveDialog(null);
                //�������水ť
                if( 0 == returnVal ){
                    File saveFile = fc.getSelectedFile();
                    try{
                        FileWriter writeOut = new FileWriter( saveFile );
                        writeOut.write(ThreadScan.Result.getText());
                        writeOut.close();
                        
                    }catch( IOException ex ){ System.out.println("����ʧ��");}
                }
            }
        });
        //ʵ���˳�����
        ActionListener li =  new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e){
                System.exit(0);
            }
        };
        exitItem.addActionListener(li);
        //ʵ�ְ�������
        
        ActionListener lil =  new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e){
                System.out.println("some body.");
            }
        };
        helpItem.addActionListener(lil);
        
        ActionListener lill =  new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e){
                JFileChooser fc = new JFileChooser();
                int returnVal = fc.showSaveDialog(null);
                //�������水ť
                if( 0 == returnVal ){
                    File saveFile = fc.getSelectedFile();
                    try{
                        FileWriter writeOut = new FileWriter(saveFile);
                        writeOut.write(ThreadScan.Result.getText());
                        writeOut.close();
                    }catch(IOException ex ){ System.out.println("����ʧ��");}
                }else{
                    return;//����ȡ��
                }
                
            }
        };
        saveButton.addActionListener(lill);
        main.setVisible(true);
    }
}
/**
 * 
 * @author Nevermore
 *    ʵ��ȡ������
 */
class CancelAction implements ActionListener{
    public void actionPerformed( ActionEvent e){
        System.exit(0);
    }
}
/**
 * 
 * @author Nevermore
 *    ʵ��ȷ����ť
 */
class SubmitAction implements ActionListener{
    public void actionPerformed( ActionEvent a){
        int minPort;
        int maxPort;
        int maxThread;
        
        int ip1 = 0;
        int ip2 = 0;
        int ip3 = 0;
        int ipstart = 0;
        int ipend = 0;
        
        String ipaddress = "";
        String nameHost = "";
        ThreadScan.Result.setText("");
        if( ThreadScan.Submit.isEnabled()){
            ThreadScan.Submit.setEnabled(false);
        }
        /**
         * �ж�ɨ������
         * ����IP��ַɨ�� type = 0
         *������������ɨ��type = 1
         */
        if( ThreadScan.radioIP.isSelected()){
            TcpThread.type = 0;
            //�ж�IP��ַ��ǰ��λ�Ƿ���int��
            try{
                ip1 = Integer.parseInt(ThreadScan.fromip1.getText());
            }catch( NumberFormatException e ){
                ThreadScan.DLGINFO.setText("�����IP��ַ");
                ThreadScan.DLGError.setVisible(true);
                return;
            }
            try{
                ip2 = Integer.parseInt(ThreadScan.fromip2.getText());
            }catch( NumberFormatException e ){
                ThreadScan.DLGINFO.setText("�����IP��ַ");
                ThreadScan.DLGError.setVisible(true);
                return;
            }
            try{
                ip3 = Integer.parseInt(ThreadScan.fromip3.getText());
            }catch( NumberFormatException e ){
                ThreadScan.DLGINFO.setText("�����IP��ַ");
                ThreadScan.DLGError.setVisible(true);
                return;
            }
            try{
                ipstart = Integer.parseInt(ThreadScan.fromip4.getText());
            }catch( NumberFormatException e ){
                ThreadScan.DLGINFO.setText("�����IP��ַ");
                ThreadScan.DLGError.setVisible(true);
                return;
            }
            try{
                ipend = Integer.parseInt(ThreadScan.toip.getText());
            }catch( NumberFormatException e ){
                ThreadScan.DLGINFO.setText("�����IP��ַ");
                ThreadScan.DLGError.setVisible(true);
                return;
            }
            
            //�ж��Ƿ��Ǻ����IP��ַ
            if(ip1 < 0 || ip1 > 255 || ip2 < 0 || ip2 > 255 ||
               ip3 < 0 || ip3 > 255 || ipstart < 0 || ipstart > 255 ){
                ThreadScan.DLGINFO.setText("IP��ַΪ0~255������");
                ThreadScan.DLGError.setVisible(true);
                return ;
            }else{
                TcpThread.ip1 = ip1;
                TcpThread.ip2 = ip2;
                TcpThread.ip3 = ip3;
                TcpThread.ipstart = ipstart;
            }
            //�ж�Ŀ��IP���Ƿ����
            if( ipend < 0 || ipend > 255 ){
                ThreadScan.DLGINFO.setText("Ŀ��IP��ַ�ķ�Χ��0~255");
                ThreadScan.DLGError.setVisible(true);
                return;
            }else{
                TcpThread.ipend = ipend;
            }
            
            ipaddress = "" + ip1 + ip2 + ip3 + ipstart;
            
            /**
             * �ж�IP��ַ����Ч��
             */
            try{
                TcpThread.hostAddress = InetAddress.getByName(ipaddress);
            }catch( UnknownHostException e){
                ThreadScan.DLGINFO.setText("�����IP��IP��ַ���ɵ��");
                ThreadScan.DLGError.setVisible(true);
                return;
            }
            
            if( ThreadScan.radioHost.isSelected()){
                TcpThread.type = 1;
                /**
                 * �ж�����������Ч��
                 */
                try{
                    TcpThread.hostAddress = InetAddress.getByName(ThreadScan.nameHost.getText());
                }catch( UnknownHostException e){ 
                    ThreadScan.DLGINFO.setText("������������ַ���ɵ��");
                    ThreadScan.DLGError.setVisible(true);
                    return;
                }
            }
            /**
             * �ж϶˿ںŵ���Ч��
             */
            try{
                minPort = Integer.parseInt(ThreadScan.minPort.getText());
                maxPort = Integer.parseInt(ThreadScan.maxPort.getText());
                maxThread = Integer.parseInt(ThreadScan.maxThread.getText());
            }catch( NumberFormatException e ){
                ThreadScan.DLGINFO.setText("����Ķ˿ںŻ�˿ںź��߳�������Ϊ����");
                ThreadScan.DLGError.setVisible(true);
                return;
            }
            /**
             * �ж���С�˿ںŵ���Ч��Χ
             * �ж���������0С��65535���˿ںŴ�����С�˿ں�
             */
            if( minPort < 0 || minPort > 65535 || minPort > maxPort ){
                ThreadScan.DLGINFO.setText("�˿ںŷ�Χ��0~65535,�������˿ں�Ӧ������С�˿ںţ�");
                ThreadScan.DLGError.setVisible(true);
                return;
            }else{
                TcpThread.MIN_port = minPort;
            }
            /**
             * �ж����˿ںŵ���Ч��Χ
             */
            if( maxPort < 0 || maxPort > 65535 || maxPort < minPort ){
                ThreadScan.DLGINFO.setText("�˿ںŷ�Χ��0~65535,�������˿ں�Ӧ������С�˿ںţ�");
                ThreadScan.DLGError.setVisible(true);
                return;
            }else{
                TcpThread.MAX_port = maxPort;
            }
            /**
             * �ж��߳�������Ч��Χ
             * �ж����� ����1��С��200
             */
            if( maxThread < 1 || maxThread > 200 ){
                ThreadScan.DLGINFO.setText("�߳�������Ч��Χ��1~200");
                ThreadScan.DLGError.setVisible(true);
                return;
            }
            ThreadScan.Result.append("�߳���" + ThreadScan.maxThread.getText() + "\n");
            
            /**
             * �����߳�
             */
            for( int i = 0; i < maxThread; i++ ){
                new TcpThread("T" + i, i).start();
            }
        }    
    }
}
/**
 * 
 * @author Administrator
 *    ����Ի���
 */
class OkAction implements ActionListener{
    public void actionPerformed( ActionEvent e){
        ThreadScan.DLGError.dispose();
    }
}
