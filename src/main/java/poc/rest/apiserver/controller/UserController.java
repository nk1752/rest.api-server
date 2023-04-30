package poc.rest.apiserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import poc.rest.apiserver.entity.User;
import poc.rest.apiserver.service.UserService;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/health")
    public String sayHello() {
        return "Resource Server up and running";
    }

    @RequestMapping(
        value="/api/add",
        params = {"num1", "num2"},
        method = RequestMethod.GET)
    public String add(@RequestParam Integer num1, @RequestParam Integer num2) {

        String str = "total: " + Integer.toString(num1 + num2);

        System.out.println(str);
        return str;
    }

    @RequestMapping(
        value = "/api/user",
        method = RequestMethod.GET,
        params = {"id"})
    public User getUserById(@RequestParam Long id) {

        String str = "Testing..." + Long.toString(id);
        System.out.println(str);
  
        return userService.getUserById(id);
    }

    @RequestMapping(
        value = "/api/user",
        method = RequestMethod.GET,
        params = {"id1", "id2"})
    public List<User> getUserByIdBetween(@RequestParam Long id1, @RequestParam Long id2) {

        
        String str = "Test ids => " + Long.toString(id1) + " " + Long.toString(id2);
        System.out.println(str);
  
        return userService.getUserByIdBetween(id1, id2);
    }

    @RequestMapping(
        value = "/api/user",
        method = RequestMethod.GET,
        params = {"lastName"})
    public List<User> getUserByLastName(@RequestParam String lastName) {

        String str = "Testing => last name = " + lastName;
        System.out.println(str);
  
        return userService.getUserByLastName(lastName);
    }

    @RequestMapping(
        value = "/api/user",
        method = RequestMethod.GET,
        params = {"firstName"})
    public List<User> getUserByFirstName(@RequestParam String firstName) {

        String str = "Testing => first name = " + firstName;
        System.out.println(str);
  
        return userService.getUserByFirstName(firstName);
    }

    @RequestMapping(
        value = "/api/user",
        method = RequestMethod.GET,
        params = {"lastName", "firstName"})
    public List<User> getUserByLastNameAndFirstName(@RequestParam String lastName, @RequestParam String firstName) {

        String str = "Testing => full name = " + firstName + " " + lastName;
        System.out.println(str);
  
        return userService.getUserByLastNameAndFirstName(lastName, firstName);
    }

    @RequestMapping(method=RequestMethod.POST, value="/api/user")
    public User addUser(@RequestBody User user) {

        //Customer customer = new Customer(id, firstName, lastName, accountId);

        String str = "Testing...  full name";
        System.out.println(str);

        userService.addUser(user);

        return user;

    }
    
}

