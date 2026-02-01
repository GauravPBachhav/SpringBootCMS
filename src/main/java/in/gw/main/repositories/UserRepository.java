package in.gw.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.gw.main.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User , Long> 
{

	
	
}
