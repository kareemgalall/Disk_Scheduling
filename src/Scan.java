import java.util.ArrayList;
import java.util.Collections;

public class Scan extends Algorithm {
	
	private String direction;
	private ArrayList<Integer> left=new ArrayList<Integer>();
	private ArrayList<Integer> right=new ArrayList<Integer>();
	
	Scan(ArrayList<Integer> queue,int diskSize,int head,String direction)
	{
		this.queue=queue;
		this.diskSize=diskSize;
		this.head=head;
		this.direction=direction;
	}
	
	@Override
	public void excuteAlgorithm()
	{
		if(direction.equals("left")) {
			left.add(0);
		}
		else if(direction.equals("right")) {
			right.add(diskSize-1);
		}
		
		for(int i=0;i<queue.size();i++) {
			if(queue.get(i)<head) {
				left.add(queue.get(i));
			}
			else {
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
			if(this.direction.equals("left"))
			{
				for (int i = left.size()-1; i >=0 ; i--)
				{
					currTrack=left.get(i);
					seekSequence.add(currTrack);
					distance = Math.abs(currTrack - head);
					seekCount += distance;
                    head = currTrack;
				}
				
				this.direction = "right";
			}
			else if(this.direction.equals("right"))
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
	
	@Override
	public void print( int seekCount, ArrayList<Integer> seekSequence)
	{
		System.out.println("Total number of seek operations = " + seekCount );
		System.out.print("Seek Sequence is: ");

        for (int i = 0; i < seekSequence.size(); i++)
        {
            System.out.print(seekSequence.get(i));
            if(i == seekSequence.size()-1) {
            	System.out.print("\n\n");
            }
            else {
            	System.out.print(" -> ");
            }
        }
	}
	
}
