package how.to.spring.controller;

import how.to.spring.dto.UserDto;
import how.to.spring.entity.User;
import how.to.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setBirthday(userDto.getBirthday());
        userRepository.save(user);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User getById(@RequestParam("id") Long id) {
        return userRepository.findOne(id);
    }

    @RequestMapping(value = "/removeUser/{id}", method = RequestMethod.DELETE)
    public void remove(@PathVariable("id") Long id) {
        userRepository.delete(id);
    }

    @RequestMapping(value = "/updateBirthday", method = RequestMethod.PUT)
    public void updateBirthday(@RequestBody UserDto userDto) {
        User user = userRepository.findByFirstNameAndLastName(userDto.getFirstName(), userDto.getLastName());
        user.setBirthday(userDto.getBirthday());
        userRepository.save(user);
    }

}