package basic.controllers;

import java.util.HashMap;
import java.util.Map;

public class ModelAndView {

	private String viewName;
	private Map<String, Object> model = new HashMap<String, Object>();
	
	//Constructor
	//기본 생성자
	public ModelAndView(){}
	//form 이동
	public ModelAndView(String viewName) {
		this.viewName = viewName;
	}
	//데이터가 있는 이동
	public ModelAndView(String viewName, String key, Object obj) {
		this.viewName = viewName;
		model.put(key, obj);
	}
	
	//Getter and Setter
	public Map<String, Object> getModel() {
		return model;
	}
	public void addObject(String key, Object obj) {
		model.put(key, obj);
	}
	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	
	@Override
	public String toString() {
		return "ModelAndView [model=" + model + ", viewName=" + viewName + "]";
	}
	
	
} //end class
