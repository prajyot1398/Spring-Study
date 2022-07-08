package study.springmvcdemo.forms;

public class NameListForm {

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NameListForm() {
		this.name = new String("No Name Provided");
	}
	
}
