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
    public String healthCheck() {

        String str = ">>>>>>>>> Health Check >>>>>>>>>";
        System.out.println(str);
        
        return "REST API Server is up and running";
    }
    
    @RequestMapping("/status")
    public String statusCheck() {

        String str = ">>>>>>>>> Status Check >>>>>>>>>";
        System.out.println(str);
        
        return "REST API Server is up and running.  This endpoint is not protected.";
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

        String str = ">>>>>>>>> Testing id >>>>>>>>> " + Long.toString(id);
        System.out.println(str);
  
        return userService.getUserById(id);
    }

    @RequestMapping(
        value = "/api/user",
        method = RequestMethod.GET,
        params = {"id1", "id2"})
    public List<User> getUserByIdBetween(@RequestParam Long id1, @RequestParam Long id2) {

        
        String str =  ">>>>>>>>> Testing ids >>>>>>>>> " + Long.toString(id1) + " " + Long.toString(id2);
        System.out.println(str);
  
        return userService.getUserByIdBetween(id1, id2);
    }

    @RequestMapping(
        value = "/api/user",
        method = RequestMethod.GET,
        params = {"lastname"})
    public List<User> getUserByLastName(@RequestParam String lastname) {

        String str = ">>>>>>>>> Testing lastname >>>>>>>>> " + lastname;
        System.out.println(str);
  
        return userService.getUserByLastName(lastname);
    }

    @RequestMapping(
        value = "/api/user",
        method = RequestMethod.GET,
        params = {"firstname"})
    public List<User> getUserByFirstName(@RequestParam String firstname) {

        String str = ">>>>>>>>> Testing firstname >>>>>>>>> " + firstname;
        System.out.println(str);
  
        return userService.getUserByFirstName(firstname);
    }

    @RequestMapping(
        value = "/api/user",
        method = RequestMethod.GET,
        params = {"lastname", "firstname"})
    public List<User> getUserByLastNameAndFirstName(@RequestParam String lastname, @RequestParam String firstname) {

        String str = "Testing => full name = " + firstname + " " + lastname;
        System.out.println(str);
  
        return userService.getUserByLastNameAndFirstName(lastname, firstname);
    }

    @RequestMapping(method=RequestMethod.POST, value="/api/user")
    public User addUser(@RequestBody User user) {

        //Customer customer = new Customer(id, firstName, lastName, accountId);

        String str = ">>>>>>>>> Testing POST >>>>>>>>> " + user.toString();
        System.out.println(str);

        userService.addUser(user);

        return user;

    }
    
}

