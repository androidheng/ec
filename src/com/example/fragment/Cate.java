package com.example.fragment;

import java.io.Serializable;

public class Cate implements Serializable{

	private int id;
	private Boolean isleafnode;
	private String name;
	private int parent_id;
	private String pic;
	private String tag;
	@Override
	public String toString() {
		return "Cate [id=" + id + ", isleafnode=" + isleafnode + ", name="
				+ name + ", parent_id=" + parent_id + ", pic=" + pic + ", tag="
				+ tag + "]";
	}
	public Cate(int id, Boolean isleafnode, String name, int parent_id,
			String pic, String tag) {
		super();
		this.id = id;
		this.isleafnode = isleafnode;
		this.name = name;
		this.parent_id = parent_id;
		this.pic = pic;
		this.tag = tag;
	}
	public Cate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Boolean getIsleafnode() {
		return isleafnode;
	}
	public void setIsleafnode(Boolean isleafnode) {
		this.isleafnode = isleafnode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
}
