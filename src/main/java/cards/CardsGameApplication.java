package cards;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cards.data.TestCustomRepository;
import cards.data.TestUserRepository;
import cards.data.collections.TestUser;

@SpringBootApplication
public class CardsGameApplication implements CommandLineRunner {

	@Autowired
	TestUserRepository repository;
	
	@Autowired
	TestCustomRepository customRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(CardsGameApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		deleteAll();
		addData();
		listAll();
		findFirst();
		findRegexAddress();
		
	}

	public void deleteAll() {
		System.out.println("Deleting records.");
		repository.deleteAll();
	}
	
	public void addData() {
		System.out.println("Adding data.");
		repository.save(new TestUser("Jack Bauer", "New York", 11111d));
		repository.save(new TestUser("Harvey Spectre", "London", 22222d));
		repository.save(new TestUser("Mike Ross", "New Jersey", 333333d));
		repository.save(new TestUser("Louise Litt", "Kathmandu", 44444d));
	}
	
	public void listAll() {
		System.out.println("List all:");
		repository.findAll()
				  .forEach(user -> System.out.println(user));
	}
	
	public void findFirst() {
		System.out.println("Find first id:");
		
		Optional<TestUser> optionalUser = repository.findFirstById("1");
		TestUser user = optionalUser.isPresent() ?
				optionalUser.get() : null;
				
		if (user != null)
			System.out.println(user);
		else
			System.out.println("Brak.");
	}
	
	public void findRegexAddress() {
		System.out.println("Find all addresses starting with New:");
		repository.findByRegexAddress("^New")
				  .forEach(user -> System.out.println(user));
	}
	
}
