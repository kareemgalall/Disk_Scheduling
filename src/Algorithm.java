import java.util.ArrayList;

abstract class Algorithm {
	
	protected ArrayList<Integer> queue=new ArrayList<Integer>();
	protected int diskSize;
	protected int head;
	
	public abstract void excuteAlgorithm() ;
	public abstract void traverseQueue();
	public abstract void print(int seekCount, ArrayList<Integer> seekSequence);
	
}
