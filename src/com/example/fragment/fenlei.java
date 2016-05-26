package com.example.fragment;

import java.io.Serializable;
import java.util.List;

public class fenlei  implements Serializable{

	private List<Cate> category;

	@Override
	public String toString() {
		return "fenlei [category=" + category + "]";
	}

	public fenlei(List<Cate> category) {
		super();
		this.category = category;
	}

	public fenlei() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Cate> getCategory() {
		return category;
	}

	public void setCategory(List<Cate> category) {
		this.category = category;
	}
}
