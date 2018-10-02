import java.util.*;
 
public class PRIO {
	public static void main (String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println ("enter no of process:");
		int n= sc.nextInt();
		int pid[] = new int[n]; 
		int arrt[] = new int[n]; 
		int brst[] = new int[n]; 
		int compt[] = new int[n]; 
		int tat[] = new int[n];
		int wat[] = new int[n];  
		int flag[] = new int[n];  
		int bt[]= new int[n];
		int priority[]=new int[n];   
	    int i, ts=0, total=0;
	    float avgwt=0, avgta=0;
 
	    for (i=0;i<n;i++)
	    {
	    	pid[i]= i+1;
	    	System.out.println ("enter process " +(i+1)+ " arrival time:");
	    	arrt[i]= sc.nextInt();
	    	System.out.println("enter process " +(i+1)+ " burst time:");
	    	brst[i]= sc.nextInt();
	    	bt[i]= brst[i];
	    	System.out.println("enter process " +(i+1)+ " priority:");
	    	priority[i]= sc.nextInt();
	    	flag[i]= 0;
	    }
	    System.out.println("Sequence :");
	    while(true)
	    {
	    	int min=99,a=n;
	    	if (total==n)
	    		break;
	    	
	    	for ( i=0;i<n;i++)
	    	{
	    		if ((arrt[i]<=ts) && (flag[i]==0) && (priority[i]<min))
	    		{	
	    			min=priority[i];
	    			a=i;
	    			
	    		}
	    	
	    	}
	    	
	    	if (a==n)
	    		{
	    			ts++;
	    			//System.out.print("P"+c);
	    		}
	    	
	    	else
	    	{   System.out.print("P"+(a+1)+" ");
	    		brst[a]--;
	    		ts++;
	    		if (brst[a]==0)
	    		{
	    			//System.out.print("\tP"+c);
	    			compt[a]= ts;
	    			flag[a]=1;
	    			total++;
	    		}
	    	//System.out.println("P"+c);
	    	}
	    
	    }
	    
	    for(i=0;i<n;i++)
	    {
	    	tat[i] = compt[i] - arrt[i];
	    	wat[i] = tat[i] - bt[i];
	    	avgwt+= wat[i];
	    	avgta+= tat[i];
	    }
	    
	    System.out.println("\n \n \tpid  arrival  burst  priority complete turn waiting");
	    for(i=0;i<n;i++)
	    {
	    	System.out.println("\t"+pid[i] +"\t"+ arrt[i]+"\t"+ bt[i] +"\t"+priority[i]+"\t"+ compt[i] +"\t"+ tat[i] +"\t"+ wat[i]);
	    }
	    
	    System.out.println("\nAverage TurnAroundtime is "+ (float)(avgta/n));
	    System.out.println("Average Waiting time is "+ (float)(avgwt/n));
	    
	}
}