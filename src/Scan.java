import java.util.*;
import java.util.Scanner;

public class Scan extends Algorithm {
	private ArrayList<Integer> queue=new ArrayList<Integer>();
	private int diskSize;
	private int head;
	private String direction;
	private ArrayList<Integer> left=new ArrayList<Integer>();
	private ArrayList<Integer> right=new ArrayList<Integer>();
	
	Scan(ArrayList<Integer> queue,int diskSize,int head,String direction)
	{
		System.out.println("-----------"+direction+"---------");
		this.queue=queue;
		this.diskSize=diskSize;
		this.head=head;
		this.direction=direction;
	}
	
	@Override
	public void excuteAlgorithm()
	{
		if(direction=="left")
		{
			left.add(0);
		}
		else if(direction == "right")
		{
			right.add(diskSize-1);
		}
		for(int i=0;i<queue.size();i++)
		{
			if(queue.get(i)<head)
			{
				left.add(queue.get(i));
			}
			else
			{
				right.add(queue.get(i));
			}
		}
		Collections.sort(right);
		Collections.sort(left);
		traverseQueue();
	}
	
	public void traverseQueue()
	{
		ArrayList<Integer> seekSequence=new ArrayList<Integer>();
		int distance=0,currTrack,seekCount = 0;
		int cnt=0;
		while(cnt<2)
		{
			if(this.direction=="left")
			{
				for (int i = 0; i < left.size(); i++)
				{
					currTrack=left.get(i);
					seekSequence.add(currTrack);
					distance = Math.abs(currTrack - head);
					seekCount += distance;
                    head = currTrack;
				}
				
				this.direction = "right";
			}
			else if(this.direction=="right")
			{
				for (int i = 0; i < right.size(); i++)
				{
					currTrack=right.get(i);
					seekSequence.add(currTrack);
					distance = Math.abs(currTrack - head);
					seekCount += distance;
                    head = currTrack;
				}
				
				this.direction="left";
			}
		cnt++;
		}
		print(seekCount,seekSequence);
	}
	
	public void print( int seekCount, ArrayList<Integer> seekSequence)
	{
		System.out.println("Total number of seek operations = " + seekCount );
		System.out.println("Seek Sequence is: ");

        for (int i = 0; i < seekSequence.size(); i++)
        {
            System.out.println(seekSequence.get(i));
        }
	}
	
}
