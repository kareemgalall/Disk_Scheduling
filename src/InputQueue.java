import java.util.*;

public class InputQueue {
	private Algorithm algorithm;
	public ArrayList<Integer>arr=new ArrayList<Integer>();
	InputQueue(ArrayList<Integer>arr)
	{
		this.arr=arr;
	}
	public void setAlgorithm(Algorithm algorithm)
	{
		this.algorithm=algorithm;
		algorithm.excuteAlgorithm();
	}
}
