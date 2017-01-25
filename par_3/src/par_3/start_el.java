package par_3;

import java.util.HashMap;
import java.util.Map;

public class start_el {
	private Map cell_list = new HashMap <Integer, Integer>(); 
	
	public void addCell(int y, int x){
		cell_list.put(y, x);
	}
	
	public Map getCell_list() {
		return cell_list;
	}

	public void setCell_list(Map cell_list) {
		this.cell_list = cell_list;
	}

}
