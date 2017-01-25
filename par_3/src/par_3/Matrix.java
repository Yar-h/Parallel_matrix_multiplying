package par_3;

import java.util.Random;

public class Matrix {
	private int[][] matrix;
	private int rows;
	private int cols;
	
	public Matrix(){
		rows=0;
		cols=0;
		matrix= new int[rows][cols];
	}
	public Matrix(int n, int m, boolean random){
		rows=n;
		cols=m;
		matrix= new int[rows][cols];
		if (random) {
			Random r = new Random();
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					matrix[i][j]=r.nextInt(5)+5;
				}
				
			}
		}
	}
	
	public void reset(){
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				matrix[i][j]=0;
			}
			
		}
	}
	
	public int[][] getMatrix() {
		return matrix;
	}
	public int get(int i, int j){
		return matrix[i][j];
	}
	
	public void set(int i, int j, int val){
		matrix[i][j]=(int)val;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getCols() {
		return cols;
	}
	public void setCols(int cols) {
		this.cols = cols;
	}
	
	
}
