import java.util.*;
class Ab
{
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
     if (this.brstt > process.brstt)
    return 1;
 else if (this.brstt < process.brstt)
    return -1;
  else if(this.brstt==process.brstt)
       {
       	if ( this.arrt < process.arrt) 
return -1;
        else if ( this.arrt == process.arrt ) 
return 0;
        else 
return 1;
}
return 0;
      
}
/*public String toString()
{

return"id, arrt, brstt, priority, wait, turn,compt";
}*/
}
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
int i,j,k,a,b,n,time,min;
float avgtat=0,avgwt=0;

System.out.println("Enter the no of process");
 n= sc.nextInt();
 int comp[]=new int[n];
  int ab[]=new int[100];
  int tat[]=new int[n];
  int waitt[]=new int[n];
int abc[] = new int[100];
Sched proc[]=new Sched[n];
Sched z=new Sched();
PriorityQueue<Sched> q = new PriorityQueue(n-1,new Sched());
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
abc[i]=proc[i].brstt;
proc[i].priority=sc.nextInt();
ab[i]=proc[i].priority;
//proc[i]=new Sched(process_ID,arr_time,burst_time,pri);
}
Arrays.sort(proc);
k=1;
time=0;
q.add(proc[0]);
z=q.peek();
while(!q.isEmpty())
{

time=time+z.brstt;
System.out.println(z.id);
for(i=0;i<n;i++)
{
  if(z.id==proc[i].id)
  {
    proc[i].brstt=0;
    proc[i].compt=time;
  }
}
q.remove();
for(i=0;i<n;i++)
{
if(time>=proc[i].arrt && !q.contains(proc[i]) && proc[i].brstt!=0)
{
  q.add(proc[i]);
}
z=q.peek();
}
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
System.out.println(String.format("%-5s%-10s%-10s%-10s%-15s%-15s%-15s", "PID", "ARRIVAL", "BURST", "PRIORITY", "WAITING", "TURNARAOUND", "COMPLETION"));
for( i=0;i<n;i++)
            System.out.println(String.format("%-5s%-10s%-10s%-10s%-15s%-15s%-15s", proc[i].id, proc[i].arrt, proc[i].brstt, proc[i].priority, proc[i].wait, proc[i].turn,proc[i].compt));
//Arrays.toString(proc[i]);
System.out.println("Average waiting time :\t"+avgwt);
System.out.println("Average turnaround time:\t"+avgtat);

}
}
