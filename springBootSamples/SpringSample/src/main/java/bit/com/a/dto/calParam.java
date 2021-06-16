package bit.com.a.dto;

import java.io.Serializable;

public class calParam implements Serializable{
	private String choice;
	private String search;
	public calParam() {
		super();
	}
	public calParam(String choice, String search) {
		super();
		this.choice = choice;
		this.search = search;
	}
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	@Override
	public String toString() {
		return "calParam [choice=" + choice + ", search=" + search + "]";
	}
	
	
}
