import java.util.ArrayList;
import java.util.Scanner;
public class Test {
	Test()
	{
		ArrayList<Integer>arr=new ArrayList<>();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the queue size");
		int size=input.nextInt();
		System.out.println("Enter the queue");
		
		for(int i=0;i<size;i++)
		{
			int m=input.nextInt();
			arr.add(m);
		}
		
		System.out.println("Enter the disk size");
		int diskSize=input.nextInt();
		System.out.println("Enter the head position");
		int head=input.nextInt();
		System.out.println("Enter the direction");
		input.nextLine();
		String direction=input.nextLine();
		
		InputQueue q=new InputQueue(arr);
		System.out.println("--------SCAN Algorithm----------");
		q.setAlgorithm(new Scan(arr,diskSize,head,"left"));
		System.out.println("--------CSAN Algorithm----------");
		q.setAlgorithm(new CSCAN(arr,diskSize,head));
	}
}
