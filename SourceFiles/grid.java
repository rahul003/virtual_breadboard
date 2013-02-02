import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;


public class grid {
	int i;
	int j;
	String comp;
	int id;
	int pot;
	int terminal;
	double value;
	
	grid(int l,int m)
	{
		value=0;
		i=l;
		j=m;
		if(i==0)
		{
			
			pot=j/6;
			if(j%6==5)
			{
				pot=64+j/6;
			}
		}
		if(i==1)
		{
			pot=4+(j-5)/6;
			if(j%6==5)
			{
				pot=67+j/6;
			}
		}
		if(i>1 && i<7)
		{
			pot=8+j;
		}
		if(i>6 && i<12)
		{
			pot=31+j;
		}
		if(i==12)
		{
			pot=54+j/5;
			if(j%6==5)
			{
				pot=70+j/6;
			}
		}
		if(i==13)
		{
			pot=59+j/5;
			if(j%6==5)
			{
				pot=73+j/6;
			}
		}
		
	}
	
	void putpot(int l, int m)
	{value=0;
	i=l;
	j=m;
	if(i==0)
	{
		
		pot=j/6;
		if(j%6==5)
		{
			pot=64+j/6;
		}
	}
	if(i==1)
	{
		pot=4+(j-5)/6;
		if(j%6==5)
		{
			pot=67+j/6;
		}
	}
	if(i>1 && i<7)
	{
		pot=8+j;
	}
	if(i>6 && i<12)
	{
		pot=31+j;
	}
	if(i==12)
	{
		pot=54+j/5;
		if(j%6==5)
		{
			pot=70+j/6;
		}
	}
	if(i==13)
	{
		pot=59+j/5;
		if(j%6==5)
		{
			pot=73+j/6;
		}
	}
}
	
	void putdata(int a,int b,String str)
	{
		id=a;
		terminal=b;
		comp=str;
		System.out.println("assigned "+comp);
	}
	
	void resetdata()
	{
		comp=null;
		id=0;
		terminal=0;
		value=0;
	}
	
	void printdata()
	{
		System.out.print(i+ " "+j+" "+pot+" "+comp+id+" "+terminal+" val="+value+"\t\t");
	}
/*
	void printtofile()
	{
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));
			out.write(i+ " "+j+" "+pot+" "+comp+id+" "+terminal+" val="+value+"\t\t");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
/*
	public static void  main(String[] args)
	{
		grid obj[][]=new grid[14][23];
		for(int i=0;i<14;i++)
		{
			for(int j=0;j<23;j++)
			{
				obj[i][j]=new grid(i,j);
//				obj[i][j].putpot(i,j);
				//obj[i][j].printdata();
				if(i==0 || i==1 || i==12 || i==13)
				{
					if(j%5==4)
					{
						System.out.print("   ");
					}
					if(j==19)
						break;
				}
			}
			System.out.println();
		}
		//System.out.println(obj);
	}*/

}