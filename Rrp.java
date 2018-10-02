import java.util.*;
class Rrp 
{
public static class Sched implements Comparable<Sched>
{
public int id,arrt,brstt,priority,wat,tat,compt;
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
int i,n,a,min,k=1,j,m;
float x,y;


System.out.println("Enter the no of process");
 n= sc.nextInt();
 System.out.println("Enter the time quantum");
 m=sc.nextInt();
  Queue<Sched> q = new LinkedList<Sched>();
 int comp[]=new int[n];
  int rem[]=new int[n];
  int tt[]=new int[n];
  int wt[]=new int[n];
  int b[]=new int[n+1];
Sched proc[]=new Sched[n];
Sched z=new Sched();
for(i=0;i<n;i++)
{
  proc[i]=new Sched();
}
Sched s=new Sched();
System.out.println("Enter PID ARRIVAL BURST PRIORITY");
for(i=0;i<n;i++)
{System.out.println("Enter for "+(i+1)+" process");
proc[i].id=sc.nextInt();
proc[i].arrt=sc.nextInt();
proc[i].brstt=sc.nextInt();
b[i]=proc[i].brstt;
proc[i].priority=sc.nextInt();
// ab[i]=proc[i].priority;
//proc[i]=new Sched(process_ID,arr_time,burst_time,pri);
}
Arrays.sort(proc);
for(i=0;i<n;i++)
{
  rem[i]=proc[i].brstt;
}
int t=0;
q.add(proc[0]);
while(true)
{
	z=q.peek();
	boolean done =true;
	for (i=0;i<n;i++ ) 
	{
		
		if (rem[i]>0) 
		{
			done=false;
		
			if (rem[i]!=0) 
			{
				t+=m;
				System.out.println(z.id);
			}
				for(i=0;i<n;i++)
{
if (t>=proc[i].arrt && !q.contains(proc[i]) && proc[i].brstt!=0)
q.add(proc[i]);
}
q.remove();
if (rem[i]>0) 
{
		rem[i]-=m;
		q.add(z);
}
				
			
			}
		else
		{
			t=t+rem[i];

			wt[i]=t-proc[i].brstt;
// proc[i].compt=t;
			rem[i]=0;
			 for(i=0;i<n;i++)
  {
    if(z.id==proc[i].id)
    {
    proc[i].brstt=0;
    proc[i].compt=t;
    }
  }
  System.out.println(z.id);
		}
		}

	}
if(done==true)
	break;
}
}



// System.out.println("The queue is");
// q.add(obj[0]);

// while(!q.isEmpty())
// {
// pro=q.peek();
// if(pro.bt<=m && pro.bt!=0)
// {
//   btime=btime+pro.bt;
//   pro.bt=0;
//   for(i=0;i<n;i++)
//   {
//     if(pro.pid==obj[i].pid)
//     {
//     obj[i].bt=0;
//     obj[i].ct=btime;
//     }
//   }
//   System.out.println(pro.pid);
// }

// else
// {
//   if(pro.bt!=0)
//   System.out.println(pro.pid);
// btime=btime+m;
// }
// for(i=0;i<n;i++)
// {
// if (btime>=obj[i].at && !q.contains(obj[i]) && obj[i].bt!=0)
// q.add(obj[i]);
// }
// q.remove();
// if(pro.bt>0)
// {
// pro.bt=pro.bt-m;
// q.add(pro);
// }
// }

x=0;
y=0;
for( i=0;i<n;i++)
{
tt[i]=proc[i].brstt+wt[i];
proc[i].tat=tt[i];
y=y+tt[i];
}


for(i=0;i<n;i++)
{
proc[i].wat=wt[i];
 x=x+wt[i]; 
}
 x=x/n;
 y=y/n;





   System.out.println(String.format("%-10s%-10s%-10s%-10s%-10s%-10s", "pid", "arrival", "burst", "priority", "waiting", "turnaround"));
for( i=0;i<n;i++)
            System.out.println(String.format("%-10s%-10s%-10s%-10s%-10s%-10s", proc[i].id, proc[i].arrt, b[i], proc[i].priority, proc[i].wat, proc[i].tat));

System.out.println("Average waiting time is\t"+x);
System.out.println("Average turnaround time is\t"+y);



}
}