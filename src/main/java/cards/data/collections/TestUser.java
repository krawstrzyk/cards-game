package cards.data.collections;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class TestUser {

	@Id
	private String id;
	
	private String name;
	private String address;
	private Double salary;
	
	public TestUser(String name, String address, Double salary) {
		 this.name = name;
		 this.address = address;
		 this.salary = salary;
	}	
	
	@Override
	public String toString() {
		return String.format(
				"Customer[id=%s, firstName='%s', address='%s', " +
				"salary='%s]", 
				id, name, address, salary);
  }

}