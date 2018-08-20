package dto;

public class TeacherDTO {
	private int id;
	private String name;
	private boolean maneger;
	public TeacherDTO(int id, String name, boolean maneger) {
		this.id = id;
		this.name = name;
		this.maneger = maneger;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isManeger() {
		return maneger;
	}
	public void setManeger(boolean maneger) {
		this.maneger = maneger;
	}

}
