import java.util.ArrayList;
import java.util.Collections;

public class SSTF extends Algorithm{
	
	private int initialHead ;
	private ArrayList<Integer> left=new ArrayList<Integer>();
	private ArrayList<Integer> right=new ArrayList<Integer>();
	
	SSTF(ArrayList<Integer> queue,int diskSize,int head)
	{
		this.queue=queue;
		this.diskSize=diskSize;
		this.head=head;
		this.initialHead = head;
	}
	
	@Override
	public void excuteAlgorithm() {
		
		for(int i=0;i<queue.size();i++) {
			if(queue.get(i)<head) {
				left.add(queue.get(i));
			}
			else {
				right.add(queue.get(i));
			}
		}
	
		queue.clear();
		Collections.sort(right);
		Collections.sort(left,Collections.reverseOrder());
		
		while (right.size()>0 && left.size()>0) {
			int l = left.get(0) ;
			int r = right.get(0);
			int differenceLeft = Math.abs(l - head);
			int differenceRight = Math.abs(r - head);
			if(differenceLeft < differenceRight) {
				queue.add(l);
				head = l ;
				left.remove(0);
			}
			else {
				queue.add(r);
				head = r;
				right.remove(0);
			}
		}
		while (right.size()>0) {
			queue.add(right.get(0));
			right.remove(0);
		}
		while (left.size()>0) {
			queue.add(left.get(0));
			left.remove(0);
		}
		
		traverseQueue();
	}

	@Override
	public void traverseQueue() {
		
		ArrayList<Integer> seekSequence=new ArrayList<Integer>();
		int distance=0,currTrack,seekCount = 0;
		
		for(int i = 0 ; i < queue.size() ; i++) {
			currTrack = queue.get(i) ;
			seekSequence.add(currTrack);
		}
		
		for(int i : seekSequence) {
			distance = Math.abs(i - initialHead);
			initialHead = i ;
			seekCount += distance;
		}
		
		print(seekCount,seekSequence);
	}
	
	@Override
	public void print(int seekCount, ArrayList<Integer> seekSequence) {
		
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
