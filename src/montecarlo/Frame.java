package montecarlo;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Frame	 
{
	private static JFrame frame;
	private static JButton bCalculate;
	private static JButton bAbout;
	private static JButton bChart;
	private static JLabel lNumber;
	private static JLabel lSolution;
	public static JTextField tNumber;
	private static JTextField tSolution;
	public static List<Double> Points;
	private static double PI;
	
	public Frame() 
	{
		gui();
	}
	
	public static void gui()
	{
		//wyglad okna
		frame = new JFrame("Obliczanie PI");
		frame.setSize(300, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridBagLayout());
		frame.setBackground(Color.WHITE);
		GridBagConstraints patt = new GridBagConstraints();
		patt.gridwidth = GridBagConstraints.REMAINDER;
		patt.fill = GridBagConstraints.HORIZONTAL;
	
		bAbout = new JButton("O programie");
		bAbout.setBackground(Color.LIGHT_GRAY);
		tNumber = new JTextField();
		bCalculate = new JButton("Oblicz");
		bCalculate.setBackground(Color.LIGHT_GRAY);
		bChart = new JButton("Wykres");
		bChart.setBackground(Color.LIGHT_GRAY);
		tSolution = new JTextField("Wynik");
		tSolution.setEditable(false);
		lSolution = new JLabel("Wynik:");
		lSolution.setFont(lSolution.getFont().deriveFont(15.0f));
		lNumber = new JLabel("Wpisz ilosc probek:");
		lNumber.setFont(lNumber.getFont().deriveFont(15.0f));
		
		frame.add(lNumber, patt);
		frame.add(tNumber, patt);
		frame.add(bCalculate, patt);
		frame.add(lSolution, patt);
		frame.add(tSolution, patt);
		frame.add(bChart,patt);
		frame.add(bAbout, patt);
		frame.setVisible(true);
		
		//akcje przycisków
		bCalculate.addActionListener(new ActionListener() 
		{

			public void actionPerformed(ActionEvent e) 
			{
				Random random = new Random();
				int pkt_square = 0; 
				int pkt_circle = 0; 
	
				try {
				String line = tNumber.getText();
				pkt_square = Integer.parseInt(line);
				}catch (NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null,"Wprowadz prawidlowy format liczby!");
				}
				 
				int x, y;
				Points = new ArrayList<Double>();
				for(int i=0; i < pkt_square; ++i)
				{
					x = random.nextInt(2000000001)-1000000000;
					y = random.nextInt(2000000001)-1000000000;
					
					double xd, yd;
					xd=(double)x/1000000000;
					yd=(double)y/1000000000;
					Points.add(xd);
					Points.add(yd);
					
					if(xd*xd + yd*yd <= 1)
					{
						++pkt_circle;
					}
				}
				
				if(pkt_circle==0)
				{
					PI=0;
				}
				else 
				{
					PI =  4. * pkt_circle / pkt_square;
				}
				String Pi = String.valueOf(PI);
				tSolution.setText(Pi);
				
			}
			
		});
		bAbout.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(null,"Program oblicza przyblizenie liczby PI metoda Monte Carlo.\nProgram przyjmuje liczby calkowite jako dane wejsciowe bez przecinka/kropki np.\n2500\n30000\n\nAll rights reserved \u00a9 Create by Cezary Ptaszek.");
			}
		});
		bChart.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//System.out.println(PI);
				if(PI==0)
				{
					JOptionPane.showMessageDialog(null,"Wpisz prawidlowe dane!");
				}
				else 
				{
					frame = new JFrame("Wykres");
					frame.setSize(750, 750);
					frame.setVisible(true);
			
					Drawing draw = new Drawing();
					frame.add(draw);
				}
				
			}
		});
		
	}
}

