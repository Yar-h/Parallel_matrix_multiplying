package par_3;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MultiplierFox extends Thread{
	
	public static int numberOfThreads=1;
	public static ExecutorService executor;
	private static Set<Thread> threadSet;
	public static long row_count;
	public static long col_count;
	private static ArrayList<Point> start_elements;;
	public static Matrix Result;
	public static Matrix arr1;
	public static Matrix arr2;
	public static CountDownLatch lock;
	//public static CountDownLatch lock2;
	private static int step;
	public static JTable table;
	
	private Point startPoint;
	
	public MultiplierFox(Point p){
		startPoint=p;
	}
	
	public static void multiply() {
		threadSet = new HashSet<Thread>();
		executor = Executors.newFixedThreadPool(numberOfThreads);
		start_elements = new ArrayList<Point>(numberOfThreads);
		lock = new CountDownLatch(numberOfThreads);
		//lock2= new CountDownLatch(numberOfThreads);
		for (int o=0;o<numberOfThreads;o++)
			start_elements.add(new Point());
		step = (int)(col_count/Math.sqrt(Double.parseDouble(numberOfThreads+"")));
		for (int i = 0; i < numberOfThreads ; i++) {
			start_elements.get(i).setLocation((int) Math.floor(i*step/col_count)*step, (i%(col_count/step))*step);
		}

		for (int i = 0; i < numberOfThreads; i++) {
			Thread worker = new MultiplierFox(start_elements.get(i));
			executor.execute(worker);
			threadSet.add(worker);
		}
		
	}
	
	public void run(){
		for (int b=0; b< col_count/step;b++){ //	Multiplying blocks
				    for (int i = startPoint.x; i < startPoint.x+step; i++) {
			            for (int j = startPoint.y; j < startPoint.y+step; j++) {
			                for (int k = 0; k < step; k++) {
			                	Result.set(i, j, Result.get(i, j)+ arr1.get(i, k+(step*b)) * arr2.get(k+(step*b), j)); 
			                }
			            }
			        }
				}


		lock.countDown();
		System.out.println("ended");		
	}

}
