import java.util.ArrayList;
import java.util.Collections;

public class CSCAN extends Algorithm {

	private int initialHead ;
	private String direction;
	private ArrayList<Integer> left=new ArrayList<Integer>();
	private ArrayList<Integer> right=new ArrayList<Integer>();
	
	CSCAN(ArrayList<Integer> queue,int diskSize,int head,String direction)
	{
		this.queue=queue;
		this.diskSize=diskSize;
		this.head=head;
		this.direction=direction;
		this.initialHead=head;
	}
	
	public void excuteAlgorithm()
	{
		left.add(0);
        right.add(diskSize - 1);
        
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
		
		for (int i = 0; i < right.size(); i++) {
			currTrack=right.get(i);
			seekSequence.add(currTrack);
		}
		for (int i = 0; i < left.size(); i++) {
			currTrack=left.get(i);
			seekSequence.add(currTrack);
		}
		
		if(direction.equals("left")) {
			Collections.reverse(seekSequence);
		}
		
		for(int i : seekSequence) {
			distance = Math.abs(i - head);
			head = i ;
			seekCount += distance;
		}
			
		print(seekCount,seekSequence);
	}
	
	@Override
	public void print( int seekCount, ArrayList<Integer> seekSequence)
	{
		System.out.println("Total number of seek operations = " + seekCount );
		System.out.print("Seek Sequence is: " + this.initialHead + " -> ");

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
