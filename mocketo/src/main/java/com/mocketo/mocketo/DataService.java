package com.mocketo.mocketo;

import java.util.ArrayList;
import java.util.List;

public abstract class DataService {

	public abstract int[] retreiveAllData();
	List<Integer> list = new ArrayList<>();
	
	public void addItem(int item) {
		list.add(item);
	}
	
	
	
}
