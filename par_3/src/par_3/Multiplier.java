package par_3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Multiplier extends Thread {
	public static int numberOfThreads=1;
	public static ExecutorService executor;
	private static Set<Thread> threadSet;
	public static long row_count;
	public static long col_count;
	private static ArrayList<start_el> start_elements;;
	public static Matrix Result;
	public static Matrix arr1;
	public static Matrix arr2;
	public static CountDownLatch lock;
	
	private start_el start_el_list;

	public Multiplier(start_el list) {
		start_el_list=list;
	}

	public static void multiply(){
		threadSet = new HashSet<Thread>();
		executor = Executors.newFixedThreadPool(numberOfThreads);
		start_elements = new ArrayList<start_el>(numberOfThreads);
		lock = new CountDownLatch(numberOfThreads);
		for (int o=0;o<numberOfThreads;o++)
			start_elements.add(new start_el());
		int y=1;
		for (int i = 0; i < row_count; i++) {
			y--;
			if (y<0) y=(int)(row_count-1);
			start_elements.get(i%numberOfThreads).addCell(y,0);	//[0] row; [y] column
		}
		
		for (int i = 0; i < numberOfThreads; i++) {
			Thread worker = new Multiplier(start_elements.get(i));
			executor.execute(worker);
			threadSet.add(worker);
		}
		
	}
	
	public void run() {
		int x=0;
		int y=0;
		for (Object temp : start_el_list.getCell_list().keySet()) {
			x=0;
			y=Integer.parseInt(temp.toString());
			for (int t=0;t<arr1.getCols();t++){
				int res = 0;
				for (int i = 0; i < arr1.getCols(); i++) {
					res+=arr1.get(x, i)*arr2.get(i, y);
		        }
					Result.set(x, y, res);
				x++;
				y++;
				if (x==row_count) x=0;if (y==row_count) y=0;
			}

		}

		lock.countDown();
		System.out.println("ended");
	}

}
