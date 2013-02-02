import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.text.*;

public class input extends JDialog{
    private JLabel actvalueLabel;
    private JButton button;
    private JButton button_1;
    JFormattedTextField powerdc;
    JFormattedTextField power;
    JFormattedTextField freq;
    JFormattedTextField formattedTextField;
    JFormattedTextField formattedTextField_1;
    JFormattedTextField formattedTextField_2;
    JFormattedTextField formattedTextField_3;
    private NumberFormat percentFormat;
    private NumberFormat frequency;
    
    JRadioButton rdbtnNewRadioButton;
    JRadioButton rdbtnAcsquareWave;
    JRadioButton rdbtnDc;

    private int exponent = 3;
    
    public input() {
    	setTitle("Power Supply");
        setSize(506,483);
        actvalueLabel = new JLabel("Frequency of AC");
        actvalueLabel.setBounds(149, 166, 103, 27);
        JPanel labelPane = new JPanel();
        labelPane.setLayout(null);
        labelPane.add(actvalueLabel);
 
        //Layout the text fields in a panel.
        JPanel fieldPane = new JPanel(new GridLayout(0,1));

        //Put the panels in this panel, labels on left,
        //text fields on right.
        //setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        getContentPane().add(labelPane, BorderLayout.CENTER);
        

        percentFormat = NumberFormat.getNumberInstance();
        percentFormat.setMinimumFractionDigits(4);
		power =new JFormattedTextField(percentFormat);
		power.setBounds(256, 136, 74, 27);
		labelPane.add(power);
		power.setValue(100);
        power.setColumns(10);
        
        frequency = NumberFormat.getNumberInstance();
        frequency.setMinimumFractionDigits(4);
        freq = new JFormattedTextField(frequency);
        freq.setColumns(10);
        freq.setBounds(256, 166, 74, 27);
        labelPane.add(freq);
		freq.setValue(1000);
        
		 powerdc =new JFormattedTextField(percentFormat);
			powerdc.setBounds(256, 216, 74, 27);
			labelPane.add(powerdc);
			powerdc.setValue(100);
	        powerdc.setColumns(10);
	    

        rdbtnNewRadioButton = new JRadioButton("AC (Sinusoidal)");
        rdbtnNewRadioButton.setBounds(79, 62, 127, 25);
        labelPane.add(rdbtnNewRadioButton);
        rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		power.setEditable(true);
                freq.setEditable(true);
                powerdc.setEditable(false);
        	}
        });
        
        rdbtnAcsquareWave = new JRadioButton("AC(Square Wave)");
        rdbtnAcsquareWave.setBounds(222, 62, 151, 25);
        labelPane.add(rdbtnAcsquareWave);
        rdbtnAcsquareWave.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		power.setEditable(true);
                freq.setEditable(true);
                powerdc.setEditable(false);
        	}
        });
        
        rdbtnDc = new JRadioButton("DC");
        rdbtnDc.setBounds(194, 102, 127, 25);
        labelPane.add(rdbtnDc);
        rdbtnDc.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		power.setEditable(false);
                powerdc.setEditable(true);
                freq.setEditable(false);
        	}
        });
        
        ButtonGroup group= new ButtonGroup();	
        group.add(rdbtnNewRadioButton);
        group.add(rdbtnAcsquareWave);
        group.add(rdbtnDc);
        
	    rdbtnNewRadioButton.setSelected(true); 
		
        if(rdbtnNewRadioButton.isSelected() || rdbtnAcsquareWave.isSelected())
        {

        	power.setEditable(true);
            freq.setEditable(true);
            powerdc.setEditable(false);
        }
        else 
        {power.setEditable(false);
        powerdc.setEditable(true);
        freq.setEditable(false);
        }
        
		JLabel freqLabel = new JLabel("Peak Voltage for AC");
		freqLabel.setBounds(127, 136, 119, 27);
        labelPane.add(freqLabel);
        
        
        button = new JButton("OK");
        button.addMouseListener(new MouseAdapter() {
        	BufferedWriter out = null;

        	
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		try {
            	    out = new BufferedWriter(new FileWriter("output.txt", true));
            	    if(((Integer)((Number)formattedTextField.getValue()))<=24 && ((Integer)((Number)formattedTextField.getValue()))>0 && ((Integer)((Number)formattedTextField_1.getValue()))<=23 && ((Integer)((Number)formattedTextField_1.getValue()))>0 && ((Integer)((Number)formattedTextField_2.getValue()))<=14 && ((Integer)((Number)formattedTextField_2.getValue()))>0 && ((Integer)((Number)formattedTextField_3.getValue()))<=14 && ((Integer)((Number)formattedTextField_3.getValue()))>0 )
            		{
            			if(rdbtnAcsquareWave.isSelected())
       				 	{
       					 	System.out.println("rdbtnAcsquareWave");
       					 	out.write("AcsquareWave "+((Integer)((Number)formattedTextField.getValue()))+" "+((Integer)((Number)formattedTextField_2.getValue()))+"  "+((Integer)((Number)formattedTextField_1.getValue())) +" "+((Integer)((Number)formattedTextField_3.getValue())) +" "+power.getValue()+" "+freq.getValue());
       				 	}
    	   				 if(rdbtnDc.isSelected())
       				 	{
       					 	System.out.println("rdbtnDc");
       					 	out.write("Dc "+((Integer)((Number)formattedTextField.getValue()))+" "+((Integer)((Number)formattedTextField_2.getValue()))+"  "+((Integer)((Number)formattedTextField_1.getValue())) +" "+((Integer)((Number)formattedTextField_3.getValue())) +" "+powerdc.getValue());
       					 	
       				 	}	
    	   				 if(rdbtnNewRadioButton.isSelected())
    	   				 {
    	   					 System.out.println("rdbtnNewRadioButton");
    	   					out.write("Acsinusoidal "+((Integer)((Number)formattedTextField.getValue()))+" "+((Integer)((Number)formattedTextField_2.getValue()))+"  "+((Integer)((Number)formattedTextField_1.getValue())) +" "+((Integer)((Number)formattedTextField_3.getValue())) +" "+power.getValue()+" "+freq.getValue());
    	   				 }
    	   				 out.close();
    	   				 System.out.println("written to output.txt");
            			setVisible(false);
            			setAlwaysOnTop(true);
            			JPanel labelPane = new JPanel();
                		
            	    	JOptionPane.showMessageDialog(labelPane,
            	    			"Done! with the circuit. Matrix repesentation is written into output.txt. Download it from website.",
            	    			"Successful",
            	    			JOptionPane.INFORMATION_MESSAGE);
            		}
            	    else
            		{
            			finalalert warner = new finalalert();
            			warner.setAlwaysOnTop(true);
            		}
            	} catch (IOException ioe) {
            	    ioe.printStackTrace();
            	}
        		
        		
        	}
        });
        button.setActionCommand("OK");
        button.setBounds(216, 388, 60, 23);
        labelPane.add(button);
        
        JLabel lblEnterTheValue = new JLabel("Select the type of power supply for the circuit");
        lblEnterTheValue.setBounds(90, 39, 283, 14);
        labelPane.add(lblEnterTheValue);
        
        JLabel lblIfYouPress = new JLabel("If you directly click exit default values will be set");
        lblIfYouPress.setBounds(110, 361, 314, 14);
        labelPane.add(lblIfYouPress);
      
        JLabel  volt = new JLabel();
        volt.setText("V");
        volt.setBounds(342, 137, 35, 25);
        labelPane.add(volt);

       
		
        JLabel lblHz = new JLabel();
        lblHz.setText("Hz");
        lblHz.setBounds(338, 169, 35, 25);
        labelPane.add(lblHz);
        
        JLabel lblConstantDcVoltage = new JLabel("Constant DC Voltage");
        lblConstantDcVoltage.setBounds(127, 216, 127, 27);
        labelPane.add(lblConstantDcVoltage);
        
        JLabel label_1 = new JLabel();
        label_1.setText("V");
        label_1.setBounds(342, 219, 35, 25);
        labelPane.add(label_1);
        
        formattedTextField = new JFormattedTextField();
        formattedTextField.setValue(3);
        exponent = ((Number)formattedTextField.getValue()).intValue();
        formattedTextField.setBounds(127, 321, 28, 27);
        labelPane.add(formattedTextField);
        formattedTextField.setValue(new Integer(exponent));
        formattedTextField.setColumns(2);
        
        JLabel lblPointA = new JLabel("Point A");
        lblPointA.setBounds(55, 321, 60, 27);
        labelPane.add(lblPointA);
        
        JLabel lblPointB = new JLabel("Point B");
        lblPointB.setBounds(268, 321, 60, 27);
        labelPane.add(lblPointB);
        
        JLabel lblEnterTheCoordinates = new JLabel("Enter the Coordinates of Points where power source is to be connected");
        lblEnterTheCoordinates.setBounds(36, 271, 421, 27);
        labelPane.add(lblEnterTheCoordinates);
        
        formattedTextField_2 = new JFormattedTextField();
        formattedTextField_2.setValue(3);
        exponent = ((Number)formattedTextField_2.getValue()).intValue();
        formattedTextField_2.setBounds(181, 321, 28, 27);
        labelPane.add(formattedTextField_2);
        formattedTextField_2.setValue(new Integer(exponent));
        formattedTextField_2.setColumns(2);
        
        formattedTextField_1 = new JFormattedTextField();
        formattedTextField_1.setValue(3);
        exponent = ((Number)formattedTextField_1.getValue()).intValue();
        formattedTextField_1.setBounds(340, 321, 28, 27);
        labelPane.add(formattedTextField_1);
        formattedTextField_1.setValue(new Integer(exponent));
        formattedTextField_1.setColumns(2);
        
        formattedTextField_3 = new JFormattedTextField();
        formattedTextField_3.setValue(8);
        exponent = ((Number)formattedTextField_3.getValue()).intValue();
        formattedTextField_3.setBounds(396, 321, 28, 27);
        labelPane.add(formattedTextField_3);
        formattedTextField_3.setValue(new Integer(exponent));
        formattedTextField_3.setColumns(3);
        
        JLabel lblX = new JLabel("X");
        lblX.setBounds(110, 321, 46, 27);
        labelPane.add(lblX);
        
        JLabel lblY = new JLabel("Y");
        lblY.setBounds(167, 321, 18, 27);
        labelPane.add(lblY);
        
        JLabel label = new JLabel("X");
        label.setBounds(320, 321, 46, 27);
        labelPane.add(label);
        
        JLabel label_2 = new JLabel("Y");
        label_2.setBounds(380, 321, 18, 27);
        labelPane.add(label_2);
                                
        getContentPane().add(fieldPane, BorderLayout.LINE_END);
    }
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("FormattedTextFieldDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Add contents to the window.
        frame.getContentPane().add(new FormattedTextFieldDemo());
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}

