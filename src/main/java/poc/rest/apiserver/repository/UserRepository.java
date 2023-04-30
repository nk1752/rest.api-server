package poc.rest.apiserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import poc.rest.apiserver.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

    User findById(Long id);

    List<User> findByLastName(String lastName);
    List<User> findByFirstName(String firstName);
    List<User> findByLastNameAndFirstName(String lastName, String firstName);
    List<User> findByAccountId(Integer id);

    List<User> findByIdBetween(Long id1, Long id2);

    
    
}
