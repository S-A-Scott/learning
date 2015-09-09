import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class TankClient extends Frame {
	
	// creat constant to make codes more changeable
	public final static int GAME_WIDTH = 800;
	public final static int GAME_HEIGHT = 600;
	
	Tank myTank = new Tank(50, 50, this);
	List<Missile> missiles = new ArrayList<Missile>();
	// using double buffer
	Image offScreenImage = null;
	
	public void update(Graphics g) {
		// use if statement to avoid repeating to creat variable 
		if(offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.GREEN);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	public void paint(Graphics g) {
		g.drawString("missiles count:" + missiles.size(), 100, 200);
		
		myTank.draw(g);
		for (int i=0; i<missiles.size(); i++) {
			Missile m = missiles.get(i);
			if(!m.isLive()) {
				missiles.remove(m);
			}
			else m.draw(g);
		}
	}

	public void launchFrame() {
		this.setLocation(400, 300);
		this.setSize(GAME_WIDTH, GAME_HEIGHT);
		this.addKeyListener(new KeyMonitor());
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("TankWar");
		this.setBackground(Color.GRAY);
		this.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		new Thread(new PaintThread()).start();
	}
		
	public static void main(String[] args) {
		TankClient tc = new TankClient();
		tc.launchFrame();

	}
	
	private class PaintThread implements Runnable {
		
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private class KeyMonitor extends KeyAdapter {

		public void keyPressed(KeyEvent e) {
			myTank.keyPressed(e);
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
 			myTank.KeyReleased(e);
		}
		
	}
}
