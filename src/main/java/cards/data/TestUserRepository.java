package cards.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import cards.data.collections.TestUser;

public interface TestUserRepository extends MongoRepository<TestUser, String>{
	Optional<TestUser> findFirstById(String id);
	
	@Query("{name:'?0'")
	List<TestUser> findByName(String name);
	
	@Query("{address : { $regex: ?0 } }")
	List<TestUser> findByRegexAddress(String address);
	//Optional<TestUser> findById(String id);
	//Optional<TestUser> findByName(String name);
	
	
}
