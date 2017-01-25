package par_3;

public class Counter {
	private int value=0;
	
	public void increment(int val){
		value+=val;
	}
	
	public void decrement(int val){
		value-=val;
	}
	public void increment(){
		value++;
	}
	
	public void decrement(){
		value--;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
