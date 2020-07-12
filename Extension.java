package module6;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;

import de.fhpotsdam.unfolding.marker.Marker;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Extension {

	private JFrame frame;
	private JRadioButton rdbtnShallow, rdbtnIntermediate, rdbtnDeep, rdbtnPastHour;
	int counter=1;

	//EarthquakeCityMap e = new EarthquakeCityMap();

	
	/**
	 * Launch the application.
	 */
	public void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Extension() {
		if(counter == 1)
		{
			initialize();
			counter += 1;
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(700, 350, 200, 200);
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		rdbtnShallow = new JRadioButton("Shallow");
		rdbtnShallow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(Marker m: EarthquakeCityMap.quakeMarkers)
				{
					if(Float.parseFloat(m.getProperty("depth").toString()) >= 70)
						m.setHidden(true);
				}
				if(rdbtnShallow.isSelected() == false)
					EarthquakeCityMap.unhideMarkers();
			}
		});
		rdbtnShallow.setBounds(6, 6, 103, 21);
		frame.getContentPane().add(rdbtnShallow);
		
		rdbtnIntermediate = new JRadioButton("Intermediate");
		rdbtnIntermediate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(Marker m: EarthquakeCityMap.quakeMarkers)
				{
					if(Float.parseFloat(m.getProperty("depth").toString()) < 70 || Float.parseFloat(m.getProperty("depth").toString()) >= 300)
						m.setHidden(true);
				}
				if(rdbtnIntermediate.isSelected() == false)
					EarthquakeCityMap.unhideMarkers();
			}
		});
		rdbtnIntermediate.setBounds(6, 51, 103, 21);
		frame.getContentPane().add(rdbtnIntermediate);
		
		rdbtnDeep = new JRadioButton("Deep");
		rdbtnDeep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(Marker m: EarthquakeCityMap.quakeMarkers)
				{
					if(Float.parseFloat(m.getProperty("depth").toString()) < 300)
						m.setHidden(true);
				}
				if(rdbtnDeep.isSelected() == false)
					EarthquakeCityMap.unhideMarkers();
			}
		});
		rdbtnDeep.setBounds(6, 93, 103, 21);
		frame.getContentPane().add(rdbtnDeep);
		
		rdbtnPastHour = new JRadioButton("Past Hour");
		rdbtnPastHour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(Marker m: EarthquakeCityMap.quakeMarkers)
				{
					String age = m.getProperty("age").toString();
					
					if(age.contains("Hour") || age.contains("Day"))
						m.setHidden(false);
					else
						m.setHidden(true);
				}
				if(rdbtnPastHour.isSelected() == false)
					EarthquakeCityMap.unhideMarkers();
			}
		});
		rdbtnPastHour.setBounds(6, 136, 103, 21);
		frame.getContentPane().add(rdbtnPastHour);
	}

}
