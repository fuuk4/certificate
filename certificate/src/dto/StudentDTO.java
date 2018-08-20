package dto;

public class StudentDTO {
	private int id;
	private String name;
	private int grade;
	private String className;
	public StudentDTO(int id, String name, int grade, String className) {
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.className = className;
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
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}


}
