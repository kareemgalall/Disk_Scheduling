import java.util.ArrayList;
import java.util.Collections;

public class newlyOptimized extends Algorithm{
	
	newlyOptimized(ArrayList<Integer> queue,int diskSize,int head)
	{
		this.queue=queue;
		this.diskSize=diskSize;
		this.head=head;
	}
	
	@Override
	public void excuteAlgorithm() {
		queue.add(0);
		Collections.sort(queue);
		traverseQueue();
	}

	@Override
	public void traverseQueue() {
		ArrayList<Integer> seekSequence=new ArrayList<Integer>();
		int distance=0,currTrack,seekCount = 0;
		for(int i = 0 ; i < queue.size() ; i++) {
			currTrack = queue.get(i) ;
			seekSequence.add(currTrack);
			distance = Math.abs(currTrack - head) ;
			seekCount += distance ;
			head = currTrack ;
		}
		print(seekCount,seekSequence);
	}
	
	@Override
	public void print(int seekCount, ArrayList<Integer> seekSequence) {
		
		System.out.println("Total number of seek operations = " + seekCount );
		System.out.print("Seek Sequence is: ");

        for (int i = 0; i < seekSequence.size(); i++) {
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
