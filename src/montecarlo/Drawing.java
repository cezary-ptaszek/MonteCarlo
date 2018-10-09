package montecarlo;

import java.awt.*;
import java.awt.geom.*;

import javax.swing.JPanel;

public class Drawing extends JPanel 
{
	private static final long serialVersionUID = 1L;

	public Drawing() 
	{
		setPreferredSize(new Dimension(400, 400));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		//prostokat
		Rectangle2D rect = new Rectangle2D.Double(5, 5, 700, 700);
		//kolo
		Ellipse2D circ = new Ellipse2D.Double(5, 5, 700, 700);
		//linie
		Line2D lineX = new Line2D.Double(0, 355, 710, 355);
		Line2D lineY = new Line2D.Double(355, 0, 355, 710);
		
		int quan = Integer.parseInt(Frame.tNumber.getText());
		
		//System.out.println(quan);
		for (int i=0; i<quan; i++)
		{
			double x = Frame.Points.get(2*i);
			double y = Frame.Points.get(2*i+1);

			Line2D line = new Line2D.Double(x*350+355, y*350+355, x*350+355, y*350+355);
			g2.draw(line);
		}
		
		g2.setPaint(Color.RED);
		g2.draw(rect);
		g2.draw(circ);
		g2.draw(lineX);
		g2.draw(lineY);
	}
}