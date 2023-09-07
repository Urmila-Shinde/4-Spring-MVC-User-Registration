package in.urmilait.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.urmilait.binding.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	
	@Query("select count(*) from User where uname = :uname and password =:password ")
	public Integer checkUser(String uname, String password);

}  