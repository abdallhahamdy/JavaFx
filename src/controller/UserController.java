package controller;

import Services_implementation.UserServiceImpl;
import model.User;

public class UserController {
    private UserServiceImpl userServiceImpl;

    public UserController() {
        userServiceImpl = new UserServiceImpl();
    }
    
    public int login(User user){
        return userServiceImpl.login(user);
    }
    
    public int register(User user){
        return userServiceImpl.signUp(user);
    }
    
    public int getUserByFirstDigits(User user) {
        return userServiceImpl.getUserByFirstDigits(user);
    }
    
    public int getUserByLastDigits(User user) {
        return userServiceImpl.getUserByLastDigits(user);
    }
    
    public int editUserPassword(User user){
        return userServiceImpl.editUserPassword(user);
    }
}
