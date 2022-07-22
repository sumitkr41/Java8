package interview;

import java.util.List;

public class Emp {
	private String name;
	private int salary;
	private String city;
	private List <String> skills;
	
	
	
	public Emp(String name, int salary, String city, List<String> skills) {
		super();
		this.name = name;
		this.salary = salary;
		this.city = city;
		this.skills = skills;
	}
	public Emp(String name, int salary, String city) {
		this.name = name;
		this.salary = salary;
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	
	
	
}
