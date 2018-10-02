import java.util.*;
class rd
{
	public static class Sched implements Comparable<Sched>
{
	public int id,arrt,brstt,priority,wait,turn;
	public int compareTo(Sched process)
	{
		if ( this.arrt < process.arrt ) return -1;
        else if ( this.arrt == process.arrt ) return 0;
        else return 1;
	}
}
public static void main(String args[])
{
	Scanner sc=new Scanner(System.in);
	int a,b,c,i,n,j,k;
	float avgwt=0,avgtat=0;
	System.out.println("Enter the number of processes");
	n=sc.nextInt();
	System.out.println("Enter process details:");
	int compl[]=new int[n];
	int x[]=new int[n];
	int waitt[]=new int[n];
int tat[]=new int[n];
Sched proc =new Sched[n];
for(i=0;i<n;i++)
{
	proc[i]=new Sched();
}
System.out.println("PID Arrival Burst Priority");
for (i=0;i<n;i++) 
{
	proc[i].id=sc.nextInt();
proc[i].arrt=sc.nextInt();
proc[i].brstt=sc.nextInt();
proc[i].priority=sc.nextInt();
}
Arrays.sort(proc);

//Calculating completion time
comp[0]=proc[0].arrt+proc[0].brstt;
for(i=1;i<n;i++)
{
	comp[i]=proc[i].brstt+comp[i-1];
}
//turnaround time
for( i=0;i<n;i++)
{
tat[i]=comp[i]-proc[i].arrt;
proc[i].turn=t[i];
avgtat=avgtat+tat[i];
}
//waiting time
for( i=0;i<n;i++)
{
waitt[i]=tat[i]-proc[i].brstt;
proc[i].wait=waitt[i];
avgwt=avgwt+waitt[i];
}
avgwt=avgwt/n;
avgtat=avgtat/n;
System.out.println(String.format("%-10s%-10s%-10s%-10s%-10s%-10s", "pid", "arrival", "burst", "priority", "waiting", "turnaround"));
for( i=0;i<n;i++)
            System.out.println(String.format("%-10s%-10s%-10s%-10s%-10s%-10s", proc[i].id, proc[i].arrt, proc[i].brstt, proc[i].priority, proc[i].wait, proc[i].turn));

System.out.println("Average waiting time is\t"+avgwt);
System.out.println("Average turnaround time is\t"+avgtat);
}
}