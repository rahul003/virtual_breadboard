import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;

public class mice extends JPanel implements MouseListener,MouseMotionListener{


    private Point p1 = new Point(100, 100);


    private int clicX = 0;
    private int clicY = 0;
    private Rectangle clicR;


    int count[]=new int[27];    //no. of copies of that comp.
    int adjust[][]=new int [27][2];
    JLabel label_all[][]=new JLabel[27][30];
    Rectangle bnds[]=new Rectangle[27];
    String paths[]=new String[27];
    int limit[]=new int[27];   //limit for no. of copies of that comp.
    static public grid obj[][]=new grid[14][23];
    JLabel trash;
    
    static void dispbread()
    {
		for(int i=0;i<14;i++)
		{
			for(int j=0;j<23;j++)
			{
				//obj[i][j]=new grid();
				//obj[i][j].putpot(i,j);
				obj[i][j].printdata();
				if(i==0 || i==1 || i==12 || i==13)
				{
					if(j%5==4)
					{
						System.out.print("   ");
					}
					//if(j==19)
						//break;
				}
			}
			System.out.println();
		}
    }
    
	public mice() {
		
		
		for(int i=0;i<14;i++)
		{
			for(int j=0;j<23;j++)
			{
				obj[i][j]=new grid(i,j);
				//obj[i][j].putpot(i,j);
				obj[i][j].printdata();
				if(i==0 || i==1 || i==12 || i==13)
				{
					if(j%5==4)
					{
						System.out.print("   ");
					}
					//if(j==19)
						//break;
				}
			}
			System.out.println();
		}

		
		setLayout(null);
		setPreferredSize(new Dimension(1366, 786));

		for(int i=0;i<27;i++)
		{
			limit[i]=20;
		}

		limit[5]=30;
		limit[6]=30;
		limit[8]=10;
		limit[9]=10;
		limit[25]=30;
		limit[26]=30;

		label_all[0][1] = new JLabel("");
		label_all[0][1].setIcon(new ImageIcon(mice.class.getResource(paths[0]="/images/capacitor.png")));
		label_all[0][1].setBounds(905, 26, 75, 73);
		bnds[0]=label_all[0][1].getBounds();
		count[0]++;
		add(label_all[0][1]);
		label_all[0][1].addMouseMotionListener(this);
		label_all[0][1].addMouseListener((MouseListener)this);

		label_all[1][1] = new JLabel("");
		label_all[1][1].setIcon(new ImageIcon(mice.class.getResource(paths[1]="/images/capacitor2.png")));
		label_all[1][1].setBounds(1016, 26, 75, 73);
		bnds[1]=label_all[1][1].getBounds();
		count[1]++;
		add(label_all[1][1]);
		label_all[1][1].addMouseMotionListener(this);
		label_all[1][1].addMouseListener((MouseListener)this);

		label_all[2][1] = new JLabel("");
		label_all[2][1].setIcon(new ImageIcon(mice.class.getResource(paths[2]="/images/transistor.png")));
		label_all[2][1].setBounds(1114, 26, 82, 82);
		bnds[2]=label_all[2][1].getBounds();
		count[2]++;
		add(label_all[2][1]);
		label_all[2][1].addMouseMotionListener(this);
		label_all[2][1].addMouseListener((MouseListener)this);

		label_all[3][1] = new JLabel("");
		label_all[3][1].setIcon(new ImageIcon(mice.class.getResource(paths[3]="/images/transistor2.png")));
		label_all[3][1].setBounds(1216, 26, 82, 82);
		bnds[3]=label_all[3][1].getBounds();
		count[3]++;
		add(label_all[3][1]);
		label_all[3][1].addMouseMotionListener(this);
		label_all[3][1].addMouseListener((MouseListener)this);

		 label_all[4][1] = new JLabel("");
		 label_all[4][1].setIcon(new ImageIcon(mice.class.getResource(paths[4]="/images/diode.png")));
		 label_all[4][1].setBounds(905, 169, 75, 20);
		 bnds[4]=label_all[4][1].getBounds();
		 count[4]++;
		add( label_all[4][1]);
		label_all[4][1].addMouseMotionListener(this);
		label_all[4][1].addMouseListener((MouseListener)this);

		  label_all[5][1] = new JLabel("");
		  label_all[5][1].setIcon(new ImageIcon(mice.class.getResource(paths[5]="/images/dioderev.png")));
		  label_all[5][1].setBounds(905, 126, 75, 20);
		  bnds[5]=label_all[5][1].getBounds();
		add( label_all[5][1]);
		count[5]++;
		label_all[5][1].addMouseMotionListener(this);
		label_all[5][1].addMouseListener((MouseListener)this);

		 label_all[6][1] = new JLabel("");
		 label_all[6][1].setIcon(new ImageIcon(mice.class.getResource(paths[6]="/images/blueconn.png")));
		 label_all[6][1].setBounds(925, 540, 145, 6);
		 bnds[6]=label_all[6][1].getBounds();
		add(label_all[6][1]);
		count[6]++;
		 label_all[6][1].addMouseMotionListener(this);
		 label_all[6][1].addMouseListener((MouseListener)this);

		 label_all[7][1] = new JLabel("");
		 label_all[7][1].setIcon(new ImageIcon(mice.class.getResource(paths[7]="/images/blueconnector.png")));
		 label_all[7][1].setBounds(906, 555, 6, 110);
		 bnds[7]=label_all[7][1].getBounds();
		 count[7]++;
		add( label_all[7][1]);
		label_all[7][1].addMouseMotionListener(this);
		label_all[7][1].addMouseListener((MouseListener)this);

		label_all[8][1] = new JLabel("");
		label_all[8][1].setIcon(new ImageIcon(mice.class.getResource(paths[8]="/images/opamp.png")));
		label_all[8][1].setBounds(905, 245, 138, 110);
		bnds[8]=label_all[8][1].getBounds();
		count[8]++;
		add(label_all[8][1]);
		label_all[8][1].addMouseMotionListener(this);
		label_all[8][1].addMouseListener((MouseListener)this);

		 label_all[9][1] = new JLabel("");
		 label_all[9][1].setIcon(new ImageIcon(mice.class.getResource(paths[9]="/images/opamprev.png")));
		 label_all[9][1].setBounds(1208, 245, 136, 110);
		 bnds[9]=label_all[9][1].getBounds();
		add(label_all[9][1]);
		count[9]++;
		label_all[9][1].addMouseMotionListener(this);
		label_all[9][1].addMouseListener((MouseListener)this);

		 label_all[10][1] = new JLabel("");
		 label_all[10][1].setIcon(new ImageIcon(mice.class.getResource(paths[10]="/images/resistor.png")));
		 label_all[10][1].setBounds(905, 492, 80, 19);
		 bnds[10]=label_all[10][1].getBounds();
		add( label_all[10][1]);
		count[10]++;
		 label_all[10][1].addMouseMotionListener(this);
		 label_all[10][1].addMouseListener((MouseListener)this);

		 label_all[11][1] = new JLabel("");
		 label_all[11][1].setIcon(new ImageIcon(mice.class.getResource(paths[11]="/images/resistor.png")));
		 label_all[11][1].setBounds(1016, 492, 136, 19);
		 bnds[11]=label_all[11][1].getBounds();
		add(label_all[11][1]);
		count[11]++;
		label_all[11][1].addMouseMotionListener(this);
		label_all[11][1].addMouseListener((MouseListener)this);

		 label_all[12][1] = new JLabel("");
		 label_all[12][1].setIcon(new ImageIcon(mice.class.getResource(paths[12]="/images/resistor.png")));
		 label_all[12][1].setBounds(1162, 492, 182, 19);
		 bnds[12]=label_all[12][1].getBounds();
		add( label_all[12][1]);
		count[12]++;
		label_all[12][1].addMouseMotionListener(this);
		label_all[12][1].addMouseListener((MouseListener)this);

		 label_all[13][1] = new JLabel("");
		 label_all[13][1].setIcon(new ImageIcon(mice.class.getResource(paths[13]="/images/diode.png")));
		 label_all[13][1].setBounds(1016, 169, 136, 20);
		 bnds[13]=label_all[13][1].getBounds();
		add( label_all[13][1]);
		count[13]++;
		label_all[13][1].addMouseMotionListener(this);
		label_all[13][1].addMouseListener((MouseListener)this);

		 label_all[14][1] = new JLabel("");
		 label_all[14][1].setIcon(new ImageIcon(mice.class.getResource(paths[14]="/images/diode.png")));
		 label_all[14][1].setBounds(1162, 169, 182, 20);
		 bnds[14]=label_all[14][1].getBounds();
		add(label_all[14][1]);
		count[14]++;
		label_all[14][1].addMouseMotionListener(this);
		label_all[14][1].addMouseListener((MouseListener)this);

		 label_all[15][1] = new JLabel("");
		 label_all[15][1].setIcon(new ImageIcon(mice.class.getResource(paths[15]="/images/led.png")));
		 label_all[15][1].setBounds(1055, 265, 68, 72);
		 bnds[15]=label_all[15][1].getBounds();
		add(label_all[15][1]);
		count[15]++;
		label_all[15][1].addMouseMotionListener(this);
		label_all[15][1].addMouseListener((MouseListener)this);

		 label_all[16][1] = new JLabel("");
		 label_all[16][1].setIcon(new ImageIcon(mice.class.getResource(paths[16]="/images/led2.png")));
		 label_all[16][1].setBounds(1126, 265, 68, 72);
		 bnds[16]=label_all[16][1].getBounds();
		add( label_all[16][1]);
		count[16]++;
		label_all[16][1].addMouseMotionListener(this);
		label_all[16][1].addMouseListener((MouseListener)this);


		 label_all[17][1] = new JLabel("");
		 label_all[17][1].setIcon(new ImageIcon(mice.class.getResource(paths[17]="/images/dioderev.png")));
		 label_all[17][1].setBounds(1016, 126, 136, 20);
		 bnds[17]=label_all[17][1].getBounds();
		add( label_all[17][1]);
		count[17]++;
		label_all[17][1].addMouseMotionListener(this);
		label_all[17][1].addMouseListener((MouseListener)this);

		 label_all[18][1] = new JLabel("");
		 label_all[18][1] .setIcon(new ImageIcon(mice.class.getResource(paths[18]="/images/dioderev.png")));
		label_all[18][1] .setBounds(1162, 126, 182, 20);
		bnds[18]=label_all[18][1].getBounds();
		add(label_all[18][1] );
		count[18]++;
		label_all[18][1].addMouseMotionListener(this);
		label_all[18][1].addMouseListener((MouseListener)this);


		 label_all[19][1] = new JLabel("");
		 label_all[19][1].setIcon(new ImageIcon(mice.class.getResource(paths[19]="/images/zener.png")));
		 label_all[19][1].setBounds(1016, 400,136, 20);
		 bnds[19]=label_all[19][1].getBounds();
		add( label_all[19][1]);
		count[19]++;
		 label_all[19][1].addMouseMotionListener(this);
		 label_all[19][1].addMouseListener((MouseListener)this);

		 label_all[20][1] = new JLabel("");
		 label_all[20][1].setBounds(1162, 400, 182, 20);
		 bnds[20]=label_all[20][1].getBounds();
		 label_all[20][1].setIcon(new ImageIcon(mice.class.getResource(paths[20]="/images/zener.png")));
		add(label_all[20][1]);
		count[20]++;
		label_all[20][1].addMouseMotionListener(this);
		label_all[20][1].addMouseListener((MouseListener)this);

		 label_all[21][1] = new JLabel("");
		 label_all[21][1].setIcon(new ImageIcon(mice.class.getResource(paths[21]="/images/zener.png")));
		 label_all[21][1].setBounds(905, 400, 75, 20);
		 bnds[21]=label_all[21][1].getBounds();
		add(label_all[21][1]);
		count[21]++;
		label_all[21][1].addMouseMotionListener(this);
		label_all[21][1].addMouseListener((MouseListener)this);


		 label_all[22][1] = new JLabel("");
		 label_all[22][1].setBounds(905, 443, 75, 20);
		 bnds[22]=label_all[22][1].getBounds();
		 label_all[22][1].setIcon(new ImageIcon(mice.class.getResource(paths[22]="/images/zenerrev.png")));
		add( label_all[22][1]);
		count[22]++;
		label_all[22][1].addMouseMotionListener(this);
		label_all[22][1].addMouseListener((MouseListener)this);

		 label_all[23][1] = new JLabel("");
		 label_all[23][1].setBounds(1016, 443, 136, 20);
		 bnds[23]=label_all[23][1].getBounds();
		 label_all[23][1].setIcon(new ImageIcon(mice.class.getResource(paths[23]="/images/zenerrev.png")));
		add(label_all[23][1]);
		count[23]++;
		 label_all[23][1].addMouseMotionListener(this);
		 label_all[23][1].addMouseListener((MouseListener)this);


		 label_all[24][1] = new JLabel("");
		 label_all[24][1].setBounds(1162, 443, 182, 20);
		 bnds[24]=label_all[24][1].getBounds();
		 label_all[24][1].setIcon(new ImageIcon(mice.class.getResource(paths[24]="/images/zenerrev.png")));
		add( label_all[24][1]);
		count[24]++;
		label_all[24][1].addMouseMotionListener(this);
		label_all[24][1].addMouseListener((MouseListener)this);

		 label_all[25][1] = new JLabel("");
		 label_all[25][1].setBounds(925, 555, 250, 6);
		 bnds[25]=label_all[25][1].getBounds();
		 label_all[25][1].setIcon(new ImageIcon(mice.class.getResource(paths[25]="/images/redconnector.png")));
		add(label_all[25][1]);
		count[25]++;
		label_all[25][1].addMouseMotionListener(this);
		label_all[25][1].addMouseListener((MouseListener)this);

		 label_all[26][1] = new JLabel("");
		 label_all[26][1].setBounds(886, 451, 6, 215);
		 bnds[26]=label_all[26][1].getBounds();
		 label_all[26][1].setIcon(new ImageIcon(mice.class.getResource(paths[26]="/images/redconnector.png")));
		add(label_all[26][1]);
		count[26]++;
		label_all[26][1].addMouseMotionListener(this);
		label_all[26][1].addMouseListener((MouseListener)this);

		JLabel lblBreadboardSimulator = new JLabel("BreadBoard Simulator");
		lblBreadboardSimulator.setBounds(344, 26, 134, 29);
		add(lblBreadboardSimulator);
		
		trash = new JLabel("");
		trash.setIcon(new ImageIcon(mice.class.getResource("/images/trash.png")));
		trash.setBounds(1182, 459, 241, 291);
		//trash.set
		//trash.setComponentZOrder(lblBreadboardSimulator, 1);
		add(trash);
		
		JButton label= new JButton("");
		label.setIcon(new ImageIcon(mice.class.getResource("/images/save1.png")));
		label.setBounds(938, 623, 193, 65);
		add(label);
		label.addMouseListener((MouseListener)this);


	}

	@Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    	//System.out.println("entered");

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(   //makes line edges smooth
            	RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setStroke(new BasicStroke(3,
                BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
		        	for(int j=3;j<=20;j=j+1)
		           	{
		           		for(int i=2;i<=24;i=i+1)
		           		{
		   			        p1.x=35*i-25;
		   			        p1.y=35*j-25;
		   			        if(j!=5 && j!=11 && j!=12 && j!=18)
		   			        {
		   			        	if(j==3 && i==2)
		   			        	{
		   			        		//super.paintComponent(g);
		   			        		//Color aColor = new Color(0xF1F1F1);
		   			        		Color aColor = new Color(0xFFFFFF);   		
		   			        		g.setColor(Color.white);
		   			        		
		   			        		//System.out.println(this.getWidth()/2);
		   			        		g.fillRect(0,0,860,this.getHeight());
		   			        		aColor = new Color(0xF1F1F1);
		   			        		g.setColor(aColor);
		   			        		g.fillRect(this.getWidth()/2,this.getHeight(),this.getWidth(),this.getHeight());
		   			        		g.setColor(Color.black);
		   			        		g.drawLine(861, 0,861, this.getHeight() );
		   			        	}
		   			        	if((j==3 || j==4 || j==19 || j==20) && (i==7 || i==13 || i==19))
		   			        	{
		   			        		
		   			        	}	
		   			        	
		   			        	else
			   			        {
			   			        	g2d.setColor(Color.black);
			   			        	g.fillOval(p1.x, p1.y, 11, 11);
			   			        	g2d.setColor(Color.white);
			   			        	g.fillOval((p1.x)+3, (p1.y)+3,7, 7);
		   			        	}
		   			        }
		           		}
		           	}
           }


public static void main(String[] args) {
	 mice obj =new mice();
	 obj.display();
      EventQueue.invokeLater(new Runnable() {
           public void run() {
          }
      });
}


void display(){

	JFrame frame=new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setTitle("Bread Board Simulator");
	frame.setSize(1366, 766);
	frame.setResizable(true);
	frame.getContentPane().add(this);

}


@Override
public void mousePressed(MouseEvent e) {
	System.out.println("mouse pressed");
	clicR=((JComponent)e.getSource()).getBounds();
	clicX = e.getX();
    clicY = e.getY();
    
    int flag=0;
    //System.out.println(((JComponent)e.getSource()));
    for(int i=0;i<27;i++)
	    if(((JComponent)e.getSource()).getBounds().x==bnds[i].x && ((JComponent)e.getSource()).getBounds().y==bnds[i].y && ((JComponent)e.getSource()).getBounds().width==bnds[i].width && ((JComponent)e.getSource()).getBounds().height==bnds[i].height)
	    {
	    	flag=1;
		    if(count[i]<limit[i]-1)
		    {
			    count[i]++;

			    label_all[i][count[i]]=new JLabel();
				label_all[i][count[i]].setIcon(new ImageIcon(mice.class.getResource(paths[i])));
				label_all[i][count[i]].setBounds(bnds[i].x,bnds[i].y, bnds[i].width, bnds[i].height);
				label_all[i][count[i]].addMouseMotionListener(this);
				label_all[i][count[i]].addMouseListener((MouseListener)this);
				//label_all[i][count[i]].set
			    this.add(label_all[i][count[i]]);
			}
		    return;
	    }
    int i,j,X,Y,finalX,finalY;
    if(flag==0)
    {
    	for(int z=0;z<27;z++)
    	{
    		for(int w=1;w<count[z];w++)
    		if(((JComponent) e.getSource())==label_all[z][w])
    		{
		    	X=((JComponent) e.getSource()).getX()-adjust[z][0];
		    	Y=((JComponent) e.getSource()).getY()-adjust[z][1];
		    	System.out.println(X+" "+Y);
				j=(X-25)/35;
				i=((Y-25)/35);
				System.out.println(i);
				i=i-2;
				
				
				if(z==0 || z==1 ||  z==15 || z==16 )
				{
					i=i+1;
				}
				if(z==2 || z==3)
				{
					i=i+2;
				}
				if(z==8 || z==9 )
					i=6;
				
				if(z==7 || z==26 )
				{
					j=j-1;
					System.out.println(i);
					if(i>1)
						i=i-1;
				}
				if(z==6 || z==25 )
				{
					j=j-1;
					System.out.println(i);
					if(i>1)
						i=i-1;
				}
				if(i>6)
					i=i-2;
				if(i>12)
					i=i-1;
				System.out.println(i+" "+j);
				obj[i][j].resetdata();
				//obj[i][j+1].resetdata();
				if(z==0 || z==1 || z==15 || z==16 )
				{
					obj[i][j+1].resetdata();
				}
				if(z==4 || z==5 || z==10 || z==21 || z==22)
				{
					obj[i][j+2].resetdata();
				}
				if(z==13 || z==17 || z==11 || z==19 || z==23)
				{
					obj[i][j+4].resetdata();
				}
				if(z==14 || z==18 || z==12 || z==20 || z==24)
				{
					obj[i][j+5].resetdata();
				}
				if(z==2 || z==3)
				{
					obj[i][j+1].resetdata();
					obj[i][j+2].resetdata();
				}
				if(z==8 || z==9)
				{
					for(int q=0;q<4;q++)
					{
						obj[i][j+q].resetdata();
					}
					for(int q=0;q<4;q++)
					{
						obj[i+1][j+q].resetdata();
					}
				}
				int epot;
				if(z==6 )
				{
					epot=obj[i][j].pot;
					if(i==0 || i==1 || i==12 ||i==13)
						obj[i][j+4].resetdata();
					else
						obj[i][j+4].resetdata();
					
					potcal();
				}
				if(z==25 )
				{
					if(i==0 || i==1 || i==12 ||i==13)
						obj[i][j+7].resetdata();
					else
						obj[i][j+7].resetdata();
					potcal();
				}
				if(z==7 )
				{
					if(i==0 || i==1 || i==10 ||i==11)
						obj[i+2][j].resetdata();
					else
						obj[i+1][j].resetdata();
					potcal();
				}
				if(z==26 )
				{
					if(i==0 || i==1 || i==7 ||i==8)
						obj[i+5][j].resetdata();
					else
						obj[i+4][j].resetdata();
					potcal();
				}
    		}
    	}
    	
    }

    }

public void potcal()
{
	for(int q=0;q<14;q++)
	{
		for(int s=0;s<23;s++)
		{
			if(q==0 || q==1 || q==12 || q==13)
			{
				if(s==20)
					break;
			}
			obj[q][s].putpot(q, s);
		}
	}
	
	int ppot;
	for(int q=0;q<14;q++)
	{
		for(int s=0;s<23;s++)
		{
			
			if(q==0 || q==1 || q==12 || q==13)
			{
				if(s==20)
					break;
			}
			ppot=obj[q][s].pot;
			if(obj[q][s].comp=="conn" && (obj[q][s].terminal)%10==2)
			{
				for(int e=0;e<14;e++)
				{
					for(int r=0;r<23;r++)
					{
						if(e==0 || e==1 || e==12 || e==13)
						{
							if(r==20)
								break;
						}
						if(obj[e][r].comp=="conn" && obj[e][r].id==obj[q][s].id && (obj[e][r].terminal)==obj[q][s].terminal-1)
						{
							for(int t=0;t<14;t++)
							{
								for(int y=0;y<23;y++)
								{
									if(t==0 || t==1 || t==12 || t==13)
									{
										if(y==20)
											break;
									}
									if(obj[t][y].pot==ppot)
									{
										obj[t][y].pot=obj[e][r].pot;
									}
								}
							}
						}
					}
				}
				
			}
		}
	}
	
}

@Override
public void mouseReleased(MouseEvent e) {
	int flag=0;
	int comp = 100;
	int finalX,finalY;
	int X,Y;
	Rectangle p=new Rectangle();
	p=trash.getBounds();
	System.out.println("mouse rel");

    X=((JComponent) e.getSource()).getX()+ e.getX();
	Y=((JComponent) e.getSource()).getY()+ e.getY();

	if(p.contains(X, Y))
	{
		((JComponent) e.getSource()).setVisible(false);
		this.remove(((JComponent) e.getSource()));
		dispbread();
		return;
	}
	dialogcap cap=new dialogcap(0,0);
	dialogres a= new dialogres(0,0,0);
    for(int i=0;i<27;i++)
    {
    	flag=0;
	    if(clicR.x==bnds[i].x && clicR.y==bnds[i].y && clicR.width==bnds[i].width && clicR.height==bnds[i].height)
	    {
	    	flag=1;
	    	break;/*
	    	if(i==10 || i==11 || i==12)
	    	{
	    		 a = new FormattedTextFieldDemo();
	    		a.setVisible(true);
		    	break;
	    	}
	    	if(i==0 || i==1)
	    	{
	    		 cap=new dialogcap();
	    		cap.setVisible(true);
	    		//while(cap.flag==0)
	    		{
	    			
	    		}
		    	break;
	    	}*/
	    }
    }

    for(int i=0;i<27;i++)
    {
    	for(int j=0;j<count[i];j++)
    	if((JComponent) e.getSource()==label_all[i][j])
    	{
    		comp=i;
    		break;
    	}
    }


    int i,j;
    
    switch(comp)
    {

    case 0:
	case 1:
		
		X=((JComponent) e.getSource()).getX()+ e.getX();
		Y=((JComponent) e.getSource()).getY()+ e.getY();
		//System.out.println(e.getX());
		if((X-25)%35<21)
			finalX=((X-25)/35)*35-10;
		else
			finalX=((X-25)/35)*35+25;
		
		if((Y-25)%10<21)
			finalY=((Y-25)/35)*35+25;
		else
			finalY=((Y-25)/35)*35+60;

		if(finalX<0)
		finalX=25;

		if(finalY<130)
			finalY=130;

		if(finalX>760)
			finalX=760;
		
		if(finalY>515)
			finalY=515;

		if(finalY==95||finalY==340 )
			finalY=finalY+35;
		System.out.println(finalX);
		System.out.println(finalY);
		if(finalY==305 || finalY==550)
			finalY=finalY-35;

		((JComponent) e.getSource()).setLocation(finalX+(adjust[comp][0]=6),finalY+(adjust[comp][1]=-7));
		
		j=(finalX-25)/35;
		i=(2+(finalY-130)/35);
		if(i>6)
			i=i-2;
		System.out.println("terminals are at "+i+" "+j);
		
		if(comp==0)
		{
			obj[i][j].putdata(count[0]+count[1]-2, 1, "cap");
			obj[i][j+1].putdata(count[0]+count[1]-2, -1, "cap");
			if(flag==1)
			{
				cap=new dialogcap(i,j);
    		cap.setVisible(true);
			}
			
			
			//System.out.println("result="+obj[i][j].value);
		}
		else
		{
			obj[i][j].putdata(count[0]+count[1]-2, -1, "cap");
			obj[i][j+1].putdata(count[0]+count[1]-2, 1, "cap");
			if(flag==1)
			{
				cap=new dialogcap(i,j);
    		cap.setVisible(true);
			}
		}
		dispbread();
		break;
	case 3:
	case 2:

		{
			X=((JComponent) e.getSource()).getX()+ e.getX();
			Y=((JComponent) e.getSource()).getY()+ e.getY();

			if((X-25)%35<21)
				finalX=((X-25)/35)*35+5;
			else
				finalX=((X-25)/35)*35+40;
			if((Y-25)%35<21)
				finalY=((Y-25)/35)*35+10;
			else
				finalY=((Y-25)/35)*35+45;


			if(finalX>775)
				finalX=740;

			if(finalX<40)
			finalX=40;

			if(finalY<115)
				finalY=115;
			if(finalY>500)
				finalY=500;
			System.out.println(finalX);
			if(finalY==80||finalY==325 )
				finalY=finalY+35;
			System.out.println(finalY);
			if(finalY==290|| finalY==535)
				finalY=finalY-35;

			((JComponent) e.getSource()).setLocation(finalX+6,finalY-3);
			j=(finalX-25)/35;
			i=((finalY-25)/35);
			if(i>6)
				i=i-2;
			System.out.println("terminals are at "+i+" "+j);
			
			if(comp==2)
			{
				obj[i][j].putdata(count[comp]+count[comp+1]-2, 1, "trans");
				obj[i][j+1].putdata(count[comp]+count[comp+1]-2, 2, "trans");
				obj[i][j+2].putdata(count[comp]+count[comp+1]-2, 3, "trans");
				
			}
			else
			{
				obj[i][j].putdata(count[comp]+count[comp-1]-2, 1, "trans");
				obj[i][j+1].putdata(count[comp]+count[comp-1]-2, 3, "trans");
				obj[i][j+2].putdata(count[comp]+count[comp-1]-2, 2, "trans");
			}
			dispbread();
			}

	break;
	 case 8:


		X=((JComponent) e.getSource()).getX()+ e.getX();
		Y=((JComponent) e.getSource()).getY()+ e.getY();

		if((X-25)%35<21)
			finalX=((X-25)/35)*35;
		else
			finalX=((X-25)/35)*35+35;
		if((Y-25)%35<21)
			finalY=((Y-25)/35)*35+15;
		else
			finalY=((Y-25)/35)*35+50;

		if(finalX<35)
		finalX=35;
		finalY=330;
		if(finalX>700)
			finalX=700;
		System.out.println(finalX);

		i=6;
		j=(finalX-25)/35;
		
		if(count[comp]>1 || count[comp+1]>1)
		{
			if(obj[i][j].comp=="opamp" || obj[i][j+1].comp=="opamp" || obj[i][j+2].comp=="opamp" || obj[i][j+3].comp=="opamp"  )
			{
				((JComponent) e.getSource()).setLocation(bnds[comp].x,bnds[comp].y);
				count[comp]--;
				alert warn=new alert();
				break;
			}
			
		}
		
		((JComponent) e.getSource()).setLocation(finalX+(adjust[comp][0]=-3),finalY+(adjust[comp][1]=-1));
		
		System.out.println("terminals are at "+i+" "+j);
		for(int k=0;k<4;k++)
		obj[i][j+k].putdata(count[i], 8-k, "opamp");
		i=7;
		for(int k=0;k<4;k++)
			obj[i][j+k].putdata(count[i], 1+k, "opamp");
		dispbread();

	break;

	case 9:

		X=((JComponent) e.getSource()).getX()+ e.getX();
		Y=((JComponent) e.getSource()).getY()+ e.getY();

		if((X-25)%35<21)
			finalX=((X-25)/35)*35;
		else
			finalX=((X-25)/35)*35+35;
		if((Y-25)%35<21)
			finalY=((Y-25)/35)*35+15;
		else
			finalY=((Y-25)/35)*35+50;

		if(finalX<35)
		finalX=35;
		finalY=330;
		if(finalX>700)
			finalX=700;
		System.out.println(finalX);

		

		i=6;
		j=(finalX-25)/35;
		
		if(count[comp]>1 || count[comp-1]>1)
		{
			if(obj[i][j].comp=="opamp" || obj[i][j+1].comp=="opamp" || obj[i][j+2].comp=="opamp" || obj[i][j+3].comp=="opamp"  )
			{
				((JComponent) e.getSource()).setLocation(bnds[comp].x,bnds[comp].y);
				count[comp]--;
				alert warn=new alert();
				break;
			}
			
		}
		
		((JComponent) e.getSource()).setLocation(finalX+(adjust[comp][0]=2),finalY+(adjust[comp][1]=-1));
		System.out.println("terminals are at "+i+" "+j);
		for(int k=0;k<4;k++)
		obj[i][j+k].putdata(count[i]+count[i-1], 4-k, "opamp");
		i=7;
		for(int k=0;k<4;k++)
			obj[i][j+k].putdata(count[i]+count[i-1], 5+k, "opamp");
		dispbread();
		break;

	 case 4:
	 case 5:
	 case 21:
	 case 22:
	 case 10:

			X=((JComponent) e.getSource()).getX()+ e.getX();
			Y=((JComponent) e.getSource()).getY()+ e.getY();

			if((X-25)%35<21)
				finalX=((X-25)/35)*35+5;
			else
				finalX=((X-25)/35)*35+40;
			if((Y-25)%35<21)
				finalY=((Y-25)/35)*35+10;
			else
				finalY=((Y-25)/35)*35+45;


			if(finalX>740)
				finalX=740;

			if(finalX<40)
			finalX=40;

			if(finalY<=185)
				finalY=185;
			if(finalY>=570)
				finalY=570;

			System.out.println(finalX);
			if(finalY==150||finalY==395 )
				finalY=finalY+35;

			System.out.println(finalY);
			if(finalY==360|| finalY==605)
				finalY=finalY-35;

			((JComponent) e.getSource()).setLocation(finalX+(adjust[comp][0]=8),finalY+(adjust[comp][1]=-4));
			j=(finalX-25)/35;
			
			i=(1+(finalY-130)/35);
			if(i>6)
				i=i-2;
			System.out.println("terminals are at "+i+" "+j);
			
			if(comp==4)
			{
				obj[i][j].putdata(count[4]+count[5]+count[13]+count[14]+count[17]+count[18]-6, -1, "diode");
				obj[i][j+2].putdata(count[4]+count[5]+count[13]+count[14]+count[17]+count[18]-6, 1, "diode");
			}
			if(comp==5)
			{
				obj[i][j].putdata(count[4]+count[5]+count[13]+count[14]+count[17]+count[18]-6, 1, "diode");
				obj[i][j+2].putdata(count[4]+count[5]+count[13]+count[14]+count[17]+count[18]-6, -1, "diode");
			}
			if(comp==10)
			{
				if(flag==1)
				{
				obj[i][j].putdata(count[comp]+count[comp+1]+count[comp+2]-3, 1, "res");
				obj[i][j+2].putdata(count[comp]+count[comp+1]+count[comp+2]-3, 1, "res");
				a = new dialogres(i,j,2);
		    	a.setVisible(true);
				}
			}
			if(comp==21)
			{
				obj[i][j].putdata(count[19]+count[20]+count[21]+count[22]+count[23]+count[24]-6, 1, "zdiode");
				obj[i][j+2].putdata(count[19]+count[20]+count[21]+count[22]+count[23]+count[24]-6, -1, "zdiode");
			}
			if(comp==22)
			{
				obj[i][j].putdata(count[19]+count[20]+count[21]+count[22]+count[23]+count[24]-6, -1, "zdiode");
				obj[i][j+2].putdata(count[19]+count[20]+count[21]+count[22]+count[23]+count[24]-6, 1, "zdiode");
			}
			dispbread();
			break;

	 case 6:
		 X=((JComponent) e.getSource()).getX()/*+ e.getX()*/;
			Y=((JComponent) e.getSource()).getY()/*+ e.getY()*/;

			if((X-25)%35<21)
				finalX=((X-25)/35)*35+25;
			else
				finalX=((X-25)/35)*35+60;
			if((Y-25)%35<21)
				finalY=((Y-25)/35)*35+25;
			else
				finalY=((Y-25)/35)*35+60;


			if(finalX>690)
				finalX=690;

			if(finalX<60)
			finalX=60;

			if(finalY<=95)
				finalY=95;
			if(finalY>=690)
				finalY=690;

			if((finalX==95||finalX==305 || finalX==515 ) && (finalY==95 || finalY==130 || finalY==655 || finalY==690))
				finalX=finalX+35;
			
			if((finalX==60||finalX==270 || finalX==480 ) && (finalY==95 || finalY==130 || finalY==655 || finalY==690))
				finalX=finalX+70;
			if((finalX==235||finalX==445 || finalX==655 ) && (finalY==95 || finalY==130 || finalY==655 || finalY==690))
				finalX=finalX-35;
			if((finalX==690 ) && (finalY==95 || finalY==130 || finalY==655 || finalY==690))
				finalX=finalX-70;
			System.out.println(finalX);
			if(finalY==165||finalY==410 )
				finalY=finalY+35;

			
			if(finalY==375|| finalY==620)
				finalY=finalY-35;
			
			System.out.println(finalY);
			((JComponent) e.getSource()).setLocation(finalX+(adjust[comp][0]=-8),finalY+(adjust[comp][1]=-12));
			
			j=(finalX-25)/35-1;
			i=(1+(finalY-130)/35);
			
			if(i<3)
			{
				
			}
			if(i>2)
			{
				i=i-1;
			}
			if(i>6)
			{
				i=i-2;
			}
			if(i>11)
			{
				i=i-1;
			}
			System.out.println("terminals are at "+i+" "+j);
			

			obj[i][j].putdata(count[6]+count[7]+count[25]+count[26]-4, comp*10+1, "conn");
			if(i==0 || i==1 || i==12 ||i==13)
				obj[i][j+4].putdata(count[6]+count[7]+count[25]+count[26]-4, comp*10+2, "conn");
			else
				obj[i][j+4].putdata(count[6]+count[7]+count[25]+count[26]-4, comp*10+2, "conn");
			
			int lpot=obj[i][j].pot;
			int rpot;
			if(i==0 || i==1 || i==12 ||i==13)
				rpot=obj[i][j+3].pot;
			else
				rpot=obj[i][j+4].pot;
			//System.out.println(lpot+" "+rpot);
			for(int r=0;r<14;r++)
			{
				for(int t=0;t<23;t++)
				{
					if((r==0 || r==1 || r==12 || r==13) && t==19)
						break;
						
					if(obj[r][t].pot==rpot)
					{
						obj[r][t].pot=lpot;
						//System.out.println(r+" "+t);
						
					}
				}
			}
			


			dispbread();
			
			break;

	 case 25:
			X=((JComponent) e.getSource()).getX()/*+ e.getX()*/;
			Y=((JComponent) e.getSource()).getY()/*+ e.getY()*/;

			if((X-25)%35<21)
				finalX=((X-25)/35)*35+25;
			else
				finalX=((X-25)/35)*35+60;
			if((Y-25)%35<21)
				finalY=((Y-25)/35)*35+25;
			else
				finalY=((Y-25)/35)*35+60;


			if(finalX>585)
				finalX=585;

			if(finalX<60)
			finalX=60;

			if(finalY<=95)
				finalY=95;
			if(finalY>=690)
				finalY=690;
			if((finalX==200 || finalX==410 ) && (finalY==95 || finalY==130 || finalY==655 || finalY==690))
				finalX=finalX-35;

			System.out.println(finalX);
			if(finalY==165||finalY==410 )
				finalY=finalY+35;

			System.out.println(finalY);
			if(finalY==375|| finalY==620)
				finalY=finalY-35;

			((JComponent) e.getSource()).setLocation(finalX+(adjust[comp][0]=-8),finalY+(adjust[comp][1]=-12));
			
			j=(finalX-25)/35-1;
			i=(1+(finalY-130)/35);
			
			if(i<3)
			{
				
			}
			if(i>2)
			{
				i=i-1;
			}
			if(i>6)
			{
				i=i-2;
			}
			if(i>11)
			{
				i=i-1;
			}
			System.out.println("terminals are at "+i+" "+j);
			
			
			obj[i][j].putdata(count[6]+count[7]+count[25]+count[26]-4, comp*10+1, "conn");
			
			if(i==0 || i==1 || i==12 ||i==13)
				obj[i][j+7].putdata(count[6]+count[7]+count[25]+count[26]-4, comp*10+2, "conn");
			else
				obj[i][j+7].putdata(count[6]+count[7]+count[25]+count[26]-4, comp*10+2, "conn");
			
			 lpot=obj[i][j].pot;
			
			if(i==0 || i==1 || i==12 ||i==13)
				rpot=obj[i][j+6].pot;
			else
				rpot=obj[i][j+7].pot;
			
			/*
			obj[i][j].putdata(1, 1, "conn");
			obj[i][j+7].putdata(1, 1, "conn");
			
			
			lpot=obj[i][j].pot;
			rpot=obj[i][j+7].pot;*/
			//System.out.println(lpot+" "+rpot);
			for(int r=0;r<14;r++)
			{
				for(int t=0;t<23;t++)
				{
					if((r==0 || r==1 || r==12 || r==13) && t==19)
						break;
						
					if(obj[r][t].pot==rpot)
					{
						obj[r][t].pot=lpot;
						//System.out.println(r+" "+t);
						
					}
				}
			}
			dispbread();
			break;


	case 17:
	case 13:
	case 19:
	case 23:
	case 11:
			X=((JComponent) e.getSource()).getX()+ e.getX();
			Y=((JComponent) e.getSource()).getY()+ e.getY();

			if((X-25)%35<21)
				finalX=((X-25)/35)*35+10;
			else
				finalX=((X-25)/35)*35+45;
			if((Y-25)%35<21)
				finalY=((Y-25)/35)*35+10;
			else
				finalY=((Y-25)/35)*35+45;


			if(finalX>673)
				finalX=673;

			if(finalX<40)
			finalX=40;

			if(finalY<=185)
				finalY=185;

			System.out.println(finalX);
			if(finalY>=570)
				finalY=570;

			if(finalY==150||finalY==395 )
				finalY=finalY+35;

			System.out.println(finalY);
			if(finalY==360|| finalY==605)
				finalY=finalY-35;
			j=(finalX-25)/35;
			
			i=(1+(finalY-130)/35);
			if(i>6)
				i=i-2;
			System.out.println("terminals are at "+i+" "+j);
			
			if(comp==13)
			{
				obj[i][j].putdata(count[4]+count[5]+count[13]+count[14]+count[17]+count[18]-6, -1, "diode");
				obj[i][j+4].putdata(count[4]+count[5]+count[13]+count[14]+count[17]+count[18]-6, 1, "diode");
			}
			if(comp==17)
			{
				obj[i][j].putdata(count[4]+count[5]+count[13]+count[14]+count[17]+count[18]-6, 1, "diode");
				obj[i][j+4].putdata(count[4]+count[5]+count[13]+count[14]+count[17]+count[18]-6, -1, "diode");
			}
			if(comp==11)
			{
				obj[i][j].putdata(count[comp]+count[comp+1]+count[comp+2]-3, 1, "res");
				obj[i][j+4].putdata(count[comp]+count[comp+1]+count[comp+2]-3, 1, "res");
				obj[i][j].putdata(count[comp]+count[comp+1]+count[comp+2]-3, 1, "res");
				obj[i][j+2].putdata(count[comp]+count[comp+1]+count[comp+2]-3, 1, "res");
				if(flag==1)
				{
				a = new dialogres(i,j,4);
		    	a.setVisible(true);
				}
			}
			if(comp==19)
			{
				obj[i][j].putdata(count[19]+count[20]+count[21]+count[22]+count[23]+count[24]-6, 1, "zdiode");
				obj[i][j+4].putdata(count[19]+count[20]+count[21]+count[22]+count[23]+count[24]-6, -1, "zdiode");
			}
			if(comp==23)
			{
				obj[i][j].putdata(count[19]+count[20]+count[21]+count[22]+count[23]+count[24]-6, -1, "zdiode");
				obj[i][j+4].putdata(count[19]+count[20]+count[21]+count[22]+count[23]+count[24]-6, 1, "zdiode");
			}
			dispbread();
			((JComponent) e.getSource()).setLocation(finalX+(adjust[comp][0]=8),finalY+(adjust[comp][1]=-4));
	break;

	 case 14:
	 case 18:
	 case 20:
	 case 24:
	 case 12:
					X=((JComponent) e.getSource()).getX()+ e.getX();
			Y=((JComponent) e.getSource()).getY()+ e.getY();

			if((X-25)%35<21)
				finalX=((X-25)/35)*35+10;
			else
				finalX=((X-25)/35)*35+45;
			if((Y-25)%35<21)
				finalY=((Y-25)/35)*35+10;
			else
				finalY=((Y-25)/35)*35+45;


			if(finalX>636)
				finalX=636;

			if(finalX<40)
			finalX=40;

			if(finalY<=185)
				finalY=185;

			System.out.println(finalX);
			if(finalY>=570)
				finalY=570;

			if(finalY==150||finalY==395 )
				finalY=finalY+35;

			System.out.println(finalY);
			if(finalY==360|| finalY==605)
				finalY=finalY-35;

			((JComponent) e.getSource()).setLocation(finalX+(adjust[comp][0]=5),finalY+(adjust[comp][1]=-3));
j=(finalX-25)/35;
			
			i=(1+(finalY-130)/35);
			if(i>6)
				i=i-2;
			System.out.println("terminals are at "+i+" "+j);
			
			if(comp==14)
			{
				obj[i][j].putdata(count[4]+count[5]+count[13]+count[14]+count[17]+count[18]-6, -1, "diode");
				obj[i][j+5].putdata(count[4]+count[5]+count[13]+count[14]+count[17]+count[18]-6, 1, "diode");
			}
			if(comp==18)
			{
				obj[i][j].putdata(count[4]+count[5]+count[13]+count[14]+count[17]+count[18]-6, 1, "diode");
				obj[i][j+5].putdata(count[4]+count[5]+count[13]+count[14]+count[17]+count[18]-6, -1, "diode");
			}
			if(comp==12)
			{
				obj[i][j].putdata(count[comp]+count[comp+1]+count[comp+2]-3, 1, "res");
				obj[i][j+5].putdata(count[comp]+count[comp+1]+count[comp+2]-3, 1, "res");
				obj[i][j].putdata(count[comp]+count[comp+1]+count[comp+2]-3, 1, "res");
				obj[i][j+2].putdata(count[comp]+count[comp+1]+count[comp+2]-3, 1, "res");
				if(flag==1)
				{
				a = new dialogres(i,j,5);
		    	a.setVisible(true);
				}
			}
			if(comp==20)
			{
				obj[i][j].putdata(count[19]+count[20]+count[21]+count[22]+count[23]+count[24]-6, 1, "zdiode");
				obj[i][j+5].putdata(count[19]+count[20]+count[21]+count[22]+count[23]+count[24]-6, -1, "zdiode");
			}
			if(comp==24)
			{
				obj[i][j].putdata(count[19]+count[20]+count[21]+count[22]+count[23]+count[24]-6, -1, "zdiode");
				obj[i][j+5].putdata(count[19]+count[20]+count[21]+count[22]+count[23]+count[24]-6, 1, "zdiode");
			}
			dispbread();

			break;


			case 7:
				
				X=((JComponent) e.getSource()).getX()/*+ e.getX()*/;
			Y=((JComponent) e.getSource()).getY()/*+ e.getY()*/;

			if((X-25)%35<21)
				finalX=((X-25)/35)*35+25;
			else
				finalX=((X-25)/35)*35+60;
			if((Y-25)%35<21)
				finalY=((Y-25)/35)*35+25;
			else
				finalY=((Y-25)/35)*35+60;


			if(finalX>830)
				finalX=830;

			if(finalX<60)
			finalX=60;

			if(finalY<=95)
				finalY=95;

			if(finalY>130 && finalY<=255)
				finalY=130;
			
			//if(finalX==235||finalX==445||finalX==655)
				 // finalX=finalX-35;
			System.out.println(finalX);
			if(finalY>=585)
				finalY=585;
			if(finalY>255 && finalY<=515)
				finalY=340;

			System.out.println(finalY);
			if(finalY==360|| finalY==605)
				finalY=finalY-35;

			((JComponent) e.getSource()).setLocation(finalX+(adjust[comp][0]=-11),finalY+(adjust[comp][1]=-9));
			
			j=(finalX-25)/35-1;
			i=(1+(finalY-130)/35);
			
			if(i>2)
			{
				i=i-1;
			}
			if(i>6)
			{
				i=i-2;
			}
			if(i>11)
			{
				i=i-1;
			}
			System.out.println("terminals are at "+i+" "+j);
			
			obj[i][j].putdata(count[6]+count[7]+count[25]+count[26]-4, comp*10+1, "conn");
			
			if(i==0 || i==1 || i==10 ||i==11)
			{
				obj[i+2][j].putdata(count[6]+count[7]+count[25]+count[26]-4, comp*10+2, "conn");
				rpot=obj[i+2][j].pot;
			}
			else
			{
				obj[i+1][j].putdata(count[6]+count[7]+count[25]+count[26]-4, comp*10+2, "conn");
				rpot=obj[i+1][j].pot;
			}
			
			
			lpot=obj[i][j].pot;
			System.out.println(lpot+" "+rpot);
			for(int r=0;r<14;r++)
			{
				for(int t=0;t<23;t++)
				{
					//if((r==0 || r==1 || r==12 || r==13) && t==19)
						//break;
						
					if(obj[r][t].pot==rpot)
					{
						obj[r][t].pot=lpot;
						System.out.println(r+" "+t);
						
					}
				}
			}
			dispbread();
			
			break;
				
			case 26:

				X=((JComponent) e.getSource()).getX()/*+ e.getX()*/;
			Y=((JComponent) e.getSource()).getY()/*+ e.getY()*/;

			if((X-25)%35<21)
				finalX=((X-25)/35)*35+25;
			else
				finalX=((X-25)/35)*35+60;
			if((Y-25)%35<21)
				finalY=((Y-25)/35)*35+25;
			else
				finalY=((Y-25)/35)*35+60;


			if(finalX>830)
				finalX=830;

			if(finalX<60)
			finalX=60;

			if(finalY<=95)
				finalY=95;

			System.out.println(finalX);
			if(finalY>=480)
				finalY=480;
			//if(finalX==235||finalX==445||finalX==655)
			  //finalX=finalX-35;
			
			if(finalY>130 && finalY<235)
				finalY=235;

			if(finalY>340 && finalY<445)
				finalY=340;

			System.out.println(finalY);

			((JComponent) e.getSource()).setLocation(finalX+(adjust[comp][0]=-11),finalY+(adjust[comp][1]=-9));
			
			j=(finalX-25)/35-1;
			i=(1+(finalY-130)/35);
			//j=j-j%5;
			if(i<3)
			{
				
			}
			if(i>2)
			{
				i=i-1;
			}
			if(i>6)
			{
				i=i-2;
			}
			if(i>11)
			{
				i=i-1;
			}
			System.out.println("terminals are at "+i+" "+j);
			obj[i][j].putdata(count[6]+count[7]+count[25]+count[26]-4, comp*10+1, "conn");
			
			if(i==0 || i==1 || i==7 ||i==8)
			{
				obj[i+5][j].putdata(count[6]+count[7]+count[25]+count[26]-4, comp*10+2, "conn");
				rpot=obj[i+5][j].pot;
			}
			else
			{
				obj[i+4][j].putdata(count[6]+count[7]+count[25]+count[26]-4,comp*10+2, "conn");
				rpot=obj[i+4][j].pot;
			}
			
			
			lpot=obj[i][j].pot;
			System.out.println(lpot+" "+rpot);
			for(int r=0;r<14;r++)
			{
				for(int t=0;t<23;t++)
				{
					//if((r==0 || r==1 || r==12 || r==13) && t==19)
						//break;
						
					if(obj[r][t].pot==rpot)
					{
						obj[r][t].pot=lpot;
						System.out.println(r+" "+t);
						
					}
				}
			}
			dispbread();
			
			break;

			
	 case 15:
	 case 16:
	X=((JComponent) e.getSource()).getX()+ e.getX();
	Y=((JComponent) e.getSource()).getY()+ e.getY();

	if((X-25)%35<21)
		finalX=((X-25)/35)*35+5;
	else
		finalX=((X-25)/35)*35+40;
	if((Y-25)%35<21)
		finalY=((Y-25)/35)*35+13;
	else
		finalY=((Y-25)/35)*35+48;


	if(finalX>776)
		finalX=776;

	if(finalX<40)
	finalX=40;

	if(finalY<=118)
		finalY=118;
	/*if(finalY>53 && finalY<117)
		finalY=115;*/

	System.out.println(finalX);
	if(finalY>=538)
		finalY=538;
	//if(finalY>255 && finalY<430)
		//finalY=430;

	if(finalY==83||finalY==328)
		finalY=finalY+35;

	System.out.println(finalY);
	if(finalY==293|| finalY==538)
		finalY=finalY-35;

	((JComponent) e.getSource()).setLocation(finalX+(adjust[comp][0]=-5),finalY+(adjust[comp][1]=0));
	j=(finalX-25)/35;
	i=((finalY-25)/35);
	if(i>6)
		i=i-2;
	System.out.println("terminals are at "+i+" "+j);
	
	if(comp==15)
	{
		obj[i][j].putdata(count[15]+count[16]-2, -1, "led");
		obj[i][j+1].putdata(count[15]+count[16]-2, 1, "led");
	}
	else
	{
		obj[i][j].putdata(count[15]+count[16]-2, 1, "led");
		obj[i][j+1].putdata(count[15]+count[16]-2, -1, "led");
	}
	dispbread();
	break;
	
	
	
	 default:
		 boolean flag1=false;	
		 boolean flag2=false;
		 boolean flag3=false;
		 int first = 0;
		 alertop b;
			potcal();
		 //do
		 {
			for(int q=0;q<14;q++)
			{
				for(int s=0;s<22;s++)
				{
				
					if(q==0 || q==1 || q==12 || q==13)
					{
						//if(s==20)
							//break;
					}
					
					if(q==6)
					{
						if(obj[q][s].comp=="opamp")
						{
							if(obj[q][s].comp!="opamp" || (obj[q][s].id!=obj[q][s-1].id))
							{
								first=s;
							}
							
							for(int k=s+1;k<first+4;k++)
							{
								if(obj[q][k].pot==obj[q][s].pot)
									{
									  b=new alertop();
									  flag2= true;
									  break;
									  
									}
								
								if(obj[q+1][k].pot==obj[q][s].pot)
									{b= new alertop();
									 flag2=true;
									 break;
									
									}
							}	
							
						}
						
						
					}
					
					if(flag2==true)
						break;
					
					
					if(obj[q][s].comp=="cap" && (obj[q][s].pot==obj[q][s+1].pot))
					{
						System.out.println("enter");
						flag1=true;
						alertcap al=new alertcap();
						break;			
					}
					
					if((q==0 || q==1 || q==12 || q==13) && (s==5 || s==11 || s==17))
					{
						
			    		if(obj[q][s].comp=="conn")
			    		{
			    			flag3=true;
							JPanel p1 = new JPanel();
				    	JOptionPane.showMessageDialog(p1,
				    			"Your connecting wires are not in valid positions",
				    			"Error",
				    			JOptionPane.WARNING_MESSAGE);
				    	break;
			    		}
					}

				}
				
				if(flag1 || flag2 || flag3)
					break;
			}
		 }//while(flag1);
		 //
		 input saving = new input();	
		 if(!flag1 && !flag2 && !flag3)
		 {
			 BufferedWriter out = null;
			 try {
					out = new BufferedWriter(new FileWriter("output.txt"));
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
			saving.setVisible(true);
			 {
				
				for(int i1=0;i1<14;i1++)
				{
					for(int j1=0;j1<23;j1++)
					{
						
						
						try {
							out.write(obj[i1][j1].i+ " "+obj[i1][j1].j+" "+obj[i1][j1].pot+" "+obj[i1][j1].comp+obj[i1][j1].id+" "+obj[i1][j1].terminal+" val="+obj[i1][j1].value+"\t\t");
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						if(i1==0 || i1==1 || i1==12 || i1==13)
						{
						/*	if(j1%5==4)
							{
								try {
									out.write("   ");
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}*/
							//if(j1==19)
								//break;
						}
					}
					try {
						out.newLine();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				
			} 
			 try {
				 out.newLine();/*
				 if(saving.rdbtnAcsquareWave.isSelected())
				 {
					 System.out.println("rdbtnAcsquareWave");
				 }
				 if(saving.rdbtnDc.isSelected())
				 {
					 System.out.println("rdbtnDc");
				 }
				 if(saving.rdbtnNewRadioButton.isSelected())
				 {
					 System.out.println("rdbtnNewRadioButton");
				 }*/
				 out.close();
				 System.out.println("written to output.txt");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 }
    }
    
    
   // dispbread();
}


@Override
public void mouseDragged(MouseEvent e) {

	//System.out.println("mouse drag");
	{
    ( (JComponent) e.getSource() ).setLocation(  ((JComponent) e.getSource()).getX() + e.getX() -clicX   , ( (JComponent) e.getSource() ).getY()+e.getY()-clicY);
	}
}

@Override
public void mouseMoved(MouseEvent arg0) {
}

@Override
public void mouseClicked(MouseEvent e) {
}

@Override
public void mouseEntered(MouseEvent arg0) {
}

@Override
public void mouseExited(MouseEvent arg0) {
}
}

