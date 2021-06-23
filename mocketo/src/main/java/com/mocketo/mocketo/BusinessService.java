package com.mocketo.mocketo;

import java.util.ArrayList;
import java.util.List;

public class BusinessService {

	DataService service;
	
	

	public BusinessService(DataService service) {
		super();
		this.service = service;
	}
	
	public BusinessService() {
		super();
	}

	public void setService(DataService service) {
		this.service = service;
	}

	public int findGreatest() {
		int[] data = service.retreiveAllData();
		int greatest = Integer.MIN_VALUE;
		for (int value : data) {
			if(value > greatest) {
				greatest = value;
			}
		}
		service.addItem(greatest);
		return greatest;
	}
	
}
