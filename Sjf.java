import java.util.*;
class Sjf
{int i,j,k,a,b,n,time,min;
float avgtat=0,avgwt=0;

public static class Sched implements Comparable<Sched>
{
  
public int id,wait,turn,compt,brstt,arrt,priority;
  
 /*Sched(int process_ID,int burst_time,int arr_time,int pri)
{
    this.id=process_ID;
    this.brstt=burst_time;
    this.arrt = arr_time;
    this.priority=pri;

}*/
public int compareTo(Sched process) 
{
       if ( this.arrt < process.arrt) 
return -1;
        else if ( this.arrt == process.arrt ) 
return 0;
        else 
return 1;
      
}
}
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
//int i,j,k,a,b,n,time,min;
//float avgtat=0,avgwt=0;

System.out.println("Enter the no of process");
 n= sc.nextInt();
 int comp[]=new int[n];
  int sjf[]=new int[100];
  int tat[]=new int[n];
  int waitt[]=new int[n];
//int rq[] = new int[n];
Sched proc[]=new Sched[n];
Sched z=new Sched();
for(i=0;i<n;i++)
{
	proc[i]=new Sched();
}
System.out.println("Enter PID ARRIVAL BURST PRIORITY");
for(i=0;i<n;i++)
{System.out.println("Enter for "+(i+1)+" process");
proc[i].id=sc.nextInt();
proc[i].arrt=sc.nextInt();
proc[i].brstt=sc.nextInt();
sjf[i]=proc[i].brstt;
proc[i].priority=sc.nextInt();
//proc[i]=new Sched(process_ID,arr_time,burst_time,pri);
}
Arrays.sort(proc);
sjff(proc,z,n);

System.out.println(String.format("%-5s%-10s%-10s%-10s%-15s%-15s", "PID", "ARRIVAL", "BURST", "PRIORITY", "WAITING", "TURNARAOUND", "Completion"));
for( i=0;i<n;i++)
            System.out.println(String.format("%-5s%-10s%-10s%-10s%-15s%-15s%-15s", proc[i].id, proc[i].arrt, proc[i].brstt, proc[i].priority, proc[i].wait, proc[i].turn,proc[i].compt));

System.out.println("Average waiting time :\t"+avgwt);
System.out.println("Average turnaround time : \t"+avgtat);

}
public static void sjff(Sched proc[],Sched z,int n)
{
k=1;
time=0;
for(j=0;j<n;j++)
{
time=time+sjf[j];
min=sjf[k];
for(i=k;i<n;i++)
{
if (time>=proc[i].arrt && proc[i].brstt<min)
{
z=proc[k];
proc[k]=proc[i];
proc[i]=z;
}
}
k++;
}

proc[0].compt=proc[0].arrt+proc[0].brstt;
for(i=1;i<n;i++)
{
  if(proc[i].arrt>proc[i-1].compt)
  proc[i].compt=proc[i].arrt+proc[i].brstt;
  else
  proc[i].compt=proc[i].brstt+proc[i-1].compt;
}

//Calculating turnaroundtime
for( i=0;i<n;i++)
{
tat[i]=proc[i].compt-proc[i].arrt;
proc[i].turn=tat[i];
avgtat=avgtat+tat[i];
}
//Calculating waiting time
proc[0].wait=0;
for(i=1;i<n;i++)
{
  if(proc[i].arrt>proc[i-1].compt)
  {
    proc[i].wait=0;
  }
  else
  {
    proc[i].wait=proc[i-1].compt-proc[i].arrt;
    avgwt=avgwt+proc[i].wait;
  }
}
avgwt=avgwt/n;
avgtat=avgtat/n;

}
}
