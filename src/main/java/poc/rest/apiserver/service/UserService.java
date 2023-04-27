package poc.rest.apiserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poc.rest.apiserver.entity.User;
import poc.rest.apiserver.repository.UserRepository;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public List<User> getUserByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    public List<User> getUserByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    public List<User> getUserByLastNameAndFirstName(String lastName, String firstName) {
        return userRepository.findByLastNameAndFirstName(lastName, firstName);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> getUserByAccountId(Integer id) {
        return userRepository.findByAccountId(id);
    }

    public List<User> getUserByIdBetween(Long id1, Long id2) {

        return userRepository.findByIdBetween(id1, id2);

    }
}
