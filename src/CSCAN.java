import java.util.ArrayList;
import java.util.Collections;

public class CSCAN extends Algorithm {
	private ArrayList<Integer> queue=new ArrayList<Integer>();
	private int diskSize;
	private int head;
	private ArrayList<Integer> left=new ArrayList<Integer>();
	private ArrayList<Integer> right=new ArrayList<Integer>();
	CSCAN(ArrayList<Integer> queue,int diskSize,int head)
	{
		this.queue=queue;
		this.diskSize=diskSize;
		this.head=head;
	}
	public void excuteAlgorithm()
	{
		left.add(0);
        right.add(diskSize - 1);
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
		for (int i = 0; i < right.size(); i++)
		{
			currTrack=right.get(i);
			System.out.println(right.get(i));
			seekSequence.add(currTrack);
			distance = Math.abs(currTrack - head);
			seekCount += distance;
            head = currTrack;
		}
		head=0;
		seekCount += (diskSize - 1);
		for (int i = 0; i < left.size(); i++)
		{
			currTrack=left.get(i);
			seekSequence.add(currTrack);
			distance = Math.abs(currTrack - head);
			seekCount += distance;
            head = currTrack;
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
