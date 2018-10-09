package montecarlo;
import javax.swing.UIManager;

import montecarlo.Frame;

public class MainClass {

	public static void main(String[] args) 
	{
		try {
			new Frame();
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    }catch(Exception ex) {
	        ex.printStackTrace();
	    }
	}
}
