import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

import java.text.*;

/**
 * FormattedTextFieldDemo.java requires no other files.
 *
 * It implements a mortgage calculator that uses four
 * JFormattedTextFields.
 */
public class alertcap extends JDialog
                                    implements PropertyChangeListener {
    //Values for the fields
    private double amount = 100000;
    private double value = 7.5;  //7.5%
    private int exponent = 3;
    private JLabel valueLabel;
    private JLabel exponentLabel;
    private JLabel actvalueLabel;

    //Strings for the labels
    private JFormattedTextField valueField;
    private JFormattedTextField exponentField;
    private JFormattedTextField actvalueField;

    //Formats to format and parse numbers
    private NumberFormat amountFormat;
    private NumberFormat percentFormat;
    private NumberFormat actvalueFormat;
    private JButton button;
    private JButton button_1;
    
   
    public alertcap() {
    	
    	JPanel labelPane = new JPanel();
    		
    	JOptionPane.showMessageDialog(labelPane,
    			"The two terminals of the capacitor can't be at the same potential",
    			"Error",
    			JOptionPane.WARNING_MESSAGE);

          
  
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}
   
}







