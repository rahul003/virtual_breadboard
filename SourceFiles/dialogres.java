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
public class dialogres extends JDialog
                                    implements PropertyChangeListener {
    //Values for the fields
	static int unit=1;
	//int unit;
    private double amount = 100000;
    private double value = 7.5;  //7.5%
    private int exponent = 3;
    private JLabel valueLabel;
    private JLabel exponentLabel;
    private JLabel actvalueLabel;

    //Strings for the labels
    private JFormattedTextField valueField;
    private JFormattedTextField exponentField;
    JFormattedTextField actvalueField;

    //Formats to format and parse numbers
    private NumberFormat amountFormat;
    private NumberFormat percentFormat;
    private NumberFormat actvalueFormat;
    private JButton button;
    private JButton button_1;
    public void puttxt(int a)
    {
    	this.unit=a;
    }
    double result;
    int flag;
   /* 
    public dialogcap(int x,int y)
    {
    	    
    }*/
    public dialogres(final int x,final int y,final int l) {
    	System.out.println("x="+x+" y="+y);
    	if(x!=0 || y!=0 )
    	{
    		mice.obj[x][y].value=7500;
    		mice.obj[x][y+l].value=7500;
    	}
    	setTitle("Enter the value");
    	setAlwaysOnTop(true);
        //super(new BorderLayout());
        setUpFormats();
        //setVisible(true);
        setSize(389,309);
        double actvalue = computeactvalue(amount,
                                        value,
                                        exponent);
        valueLabel = new JLabel("Mantissa:");
        valueLabel.setBounds(113, 80, 60, 35);
        exponentLabel = new JLabel("Exponent of 10:");
        exponentLabel.setBounds(83, 124, 90, 35);
        actvalueLabel = new JLabel("Value:");
        actvalueLabel.setBounds(136, 172, 37, 27);

        //Lay out the labels in a panel.
        JPanel labelPane = new JPanel();
        labelPane.setLayout(null);
        labelPane.add(valueLabel);
        labelPane.add(exponentLabel);
        labelPane.add(actvalueLabel);

        //Layout the text fields in a panel.
        JPanel fieldPane = new JPanel(new GridLayout(0,1));

        //Put the panels in this panel, labels on left,
        //text fields on right.
        //setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        getContentPane().add(labelPane, BorderLayout.CENTER);
        
                valueField = new JFormattedTextField(percentFormat);
                valueField.setBounds(185, 84, 74, 27);
                labelPane.add(valueField);
                valueField.setValue(new Double(value));
                valueField.setColumns(10);
                valueField.addPropertyChangeListener("value", this);
                valueLabel.setLabelFor(valueField);
                
                exponentField = new JFormattedTextField();
                exponentField.setBounds(185, 128, 74, 27);
                labelPane.add(exponentField);
                exponentField.setValue(new Integer(exponent));
                exponentField.setColumns(10);
                exponentField.addPropertyChangeListener("value", this);
                exponentLabel.setLabelFor(exponentField);
                
                actvalueField =new JFormattedTextField(new DecimalFormat("#####.####"));
                actvalueField.setBounds(185, 172, 74, 27);
                labelPane.add(actvalueField);
                actvalueField.setValue(new Double(actvalue));
                actvalueField.setColumns(10);
                actvalueField.setEditable(false);
                actvalueField.setForeground(Color.red);
                actvalueLabel.setLabelFor(actvalueField);
                                
                                button = new JButton("OK");
                                button.addMouseListener(new MouseAdapter() {
                                	
                                	@Override
                                	public void mouseClicked(MouseEvent arg0) {
                                		flag=1;
                                		mice.obj[x][y].value=(Double)actvalueField.getValue();
                                		mice.obj[x][y+l].value=(Double)actvalueField.getValue();
                                		result=computeactvalue(amount, value, exponent);
                                		System.out.println("act="+result);
                                		mice.dispbread();
                                		setVisible(false);
                                	}
                                });
                                button.setActionCommand("OK");
                                button.setBounds(165, 226, 60, 23);
                                labelPane.add(button);
                                
                                button_1 = new JButton("Cancel");
                                button_1.addMouseListener(new MouseAdapter() {
                                	@Override
                                	public void mouseClicked(MouseEvent arg0) {
                                		flag=1;
                                		result=7500;
                                		System.out.println("act="+result);
                                		setVisible(false);
                                	}
                                });
                                button_1.setActionCommand("Cancel");
                                button_1.setBounds(160, 168, 74, 23);
                                //labelPane.add(button_1);
                                String comp;
                                if(unit==1)
                                {
                                	comp="resistor";
                                }
                                else 
                                {
                                	comp="capacitor";
                                }
                                JLabel lblEnterTheValue = new JLabel("Enter the value of resistor you want to create");
                                lblEnterTheValue.setBounds(48, 13, 283, 14);
                                labelPane.add(lblEnterTheValue);
                                
                                JLabel lblIfYouPress = new JLabel("If you directly exit, default values\r\n");
                                lblIfYouPress.setBounds(76, 40, 221, 14);
                                labelPane.add(lblIfYouPress);
                                
                                JLabel lblWillBeSet = new JLabel("will be set to the resistor");
                                lblWillBeSet.setBounds(106, 56, 157, 14);
                                labelPane.add(lblWillBeSet);
                                
                                JLabel lblNewLabel = new JLabel("Kohms");
                                
                                lblNewLabel.setBounds(271, 178, 46, 14);
                                labelPane.add(lblNewLabel);
        getContentPane().add(fieldPane, BorderLayout.LINE_END);
    }

    /** Called when a field's "value" property changes. */
    public void propertyChange(PropertyChangeEvent e) {
        Object source = e.getSource();
        if (source == valueField) {
            value = ((Number)valueField.getValue()).doubleValue();
        } else if (source == exponentField) {
            exponent = ((Number)exponentField.getValue()).intValue();
        }

        double actvalue = computeactvalue(amount, value, exponent);
        result=actvalue;
        System.out.println("act="+result);
        actvalueField.setValue(new Double(actvalue));
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

    /*public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
	        UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }*/

    //Compute the monthly actvalue based on the loan amount,
    //APR, and length of loan.
    double computeactvalue(double loanAmt, double value, int exponent) {
        double  power,  answer;
/*
        exponent *= 12;        //get number of months
        if (value > 0.01) {
            I = value / 100.0 / 12.0;         //get monthly value from annual
            partial1 = Math.pow((1 + I), (0.0 - exponent));
            denominator = (1 - partial1) / I;
        } else { //value ~= 0
            denominator = exponent;
        }

        answer = (-1 * loanAmt) / denominator;*/
        power=Math.pow(10, exponent);
        answer=value*power;
        return answer;
    }

    //Create and set up number formats. These objects also
    //parse numbers input by user.
    private void setUpFormats() {
        amountFormat = NumberFormat.getNumberInstance();
        amountFormat.setMinimumFractionDigits(4);
        percentFormat = NumberFormat.getNumberInstance();
        percentFormat.setMinimumFractionDigits(4);

        actvalueFormat = NumberFormat.getCurrencyInstance();
    }
}

