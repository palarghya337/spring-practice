package com.spring.practice.bean;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionPojo {

	private List<String> listOfString;
	private Set<String> setOfString;
	private Map<Integer, String> mapOfIntegerString;
	
	public List<String> getListOfString() {
		return listOfString;
	}
	public void setListOfString(List<String> listOfString) {
		this.listOfString = listOfString;
	}
	public Set<String> getSetOfString() {
		return setOfString;
	}
	public void setSetOfString(Set<String> setOfString) {
		this.setOfString = setOfString;
	}
	public Map<Integer, String> getMapOfIntegerString() {
		return mapOfIntegerString;
	}
	public void setMapOfIntegerString(Map<Integer, String> mapOfIntegerString) {
		this.mapOfIntegerString = mapOfIntegerString;
	}
}
