package snippet;

import javax.swing.JOptionPane;

public class MyBucket {
	static private int num;
	static private int begin;
	static private int over;
	static private int [] portArray = {21, 22, 23, 25, 69, 79, 80, 110, 113, 119, 220, 443, 8080};
	static private int mmm = 0;
	static private boolean show = false;

	public MyBucket(int begin, int over){
		this.begin = begin;
		this.over = over;
		this.num = begin;
		mmm = 0;
		show = false;
	}
	public void update(int begin, int over){
		this.begin = begin;
		this.over = over;
		this.num = begin;
		mmm = 0;
		show = false;
	}
	public synchronized void stop(){
		num = over+1;
		mmm = portArray.length;
	}
	public synchronized int getport(){
		if(num > over){
			if(!show){
				JOptionPane.showMessageDialog(null,"扫描完毕！","提示",JOptionPane. INFORMATION_MESSAGE);
				show = true;
				DuolaScan.btnNewButton.setEnabled(true);
				DuolaScan.button.setEnabled(true);
				DuolaScan.button_2.setEnabled(false);
				DuolaScan.textField.setText("停止");
			}
			return -1;
		}
		DuolaScan.progressBar.setValue(num);
		num++;
		//System.out.print("bucket num:"+num);
		return num-1;
	}
	public synchronized int getmport(){
		if(mmm >= portArray.length){
			if(!show){
				JOptionPane.showMessageDialog(null,"扫描完毕！","提示",JOptionPane. INFORMATION_MESSAGE);
				show = true;
				DuolaScan.btnNewButton.setEnabled(true);
				DuolaScan.button.setEnabled(true);
				DuolaScan.button_2.setEnabled(false);
				DuolaScan.textField.setText("停止");
			}
			return -1;
		}
		DuolaScan.progressBar.setValue(mmm);
		mmm++;
		//System.out.print("bucket num:"+num);
		return portArray[mmm-1];
	}
}
