import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;

public class ChatClient extends Frame {
	
	// constructor 
	ChatClient(String s) {
		super(s);
	}
	
	TextField tfTxt = new TextField();
	TextArea taContent = new TextArea();
	Socket s = null;
	DataOutputStream dos = null;
	DataInputStream dis = null;
	private boolean bConnected = false;
	
	Thread tRecv = new Thread(new RecvThread());
	
	public static void main(String[] args) {
		new ChatClient("Chat Client").launchFrame();

	}

	public void launchFrame() {
		this.setLocation(400, 300);
		this.setSize(300, 300);
		this.add(tfTxt, BorderLayout.SOUTH);
		add(taContent, BorderLayout.NORTH);
		pack();
		setVisible(true);
		tfTxt.addActionListener(new TFlistener());
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				disconnect();
				System.exit(0);
			}
			
		});
		conntect();
		
		tRecv.start();
	} // end launchFrame
	
	public void conntect() {
		try {
			s = new Socket("192.168.1.118", 8888);
			System.out.println("connected");
			dos = new DataOutputStream(s.getOutputStream());
			dis = new DataInputStream(s.getInputStream());
			bConnected = true;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 
	
	public void disconnect() {
		
		try {
			dos.close();
			dis.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		try {
			bConnected = false;
			tRecv.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dos.close();
				dis.close();
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		*/
		
	} // end disconnect method
	
	
	// inner class to implements ActionListener
	private class TFlistener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String str = tfTxt.getText().trim();
			tfTxt.setText("");
			
			try {
				dos.writeUTF(str);
				dos.flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	private class RecvThread implements Runnable {

		public void run() {
			try {
				while(bConnected) {
					String str = dis.readUTF();
					//System.out.println(str);
					taContent.setText(taContent.getText()+str+'\n');
				}
			} catch (SocketException e) {
				System.out.println("bye-bye");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
} // end ChatClient