package networking;

import java.util.Scanner;

public class BellmannFord {
	
	static int[] compute_routingTable(int linkCost[][],int source,int nodes)
	{
		int cost[]=new int[nodes+1];
		for(int i=1;i<cost.length;i++)
		{
			cost[i]=999;
		}
		cost[source]=0;
		for(int k=1;k<=nodes-1;k++)
		{
			for(int i=1;i<=nodes;i++)
			{
				for(int j=1;j<=nodes;j++)
				{
					if(linkCost[i][j]!=999)
					{
						if(cost[j]>cost[i]+linkCost[i][j])
						{
							cost[j]=cost[i]+linkCost[i][j];
						}
					}
				}
			}
		}
		
		return cost;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner (System.in);
		System.out.println("Enter the no.of nodes connected to the router");
		int nodes=sc.nextInt();
		int linkCost[][]=new int[nodes+1][nodes+1];
		System.out.println("Enter the link cost matrix.Enter 999 if there is no direct path.");
		for(int i=1;i<=nodes;i++)
		{
			for(int j=1;j<=nodes;j++)
			{
				linkCost[i][j]=sc.nextInt();
			}
		}
		System.out.println("Enter the source router");
		int source=sc.nextInt();
		int[] finalCost=compute_routingTable(linkCost,source,nodes);
		System.out.println("Final link costs are: ");
		for(int i=1;i<finalCost.length;i++)
		{
			System.out.println("Cost from "+source+ " to "+i+ " is : "+finalCost[i]);
		}
	}

}
