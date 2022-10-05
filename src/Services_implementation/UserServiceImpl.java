package Services_implementation;

import Services.UserService;
import dao.UserDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.User;

public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDao();
    }
    
    @Override
    public int login(User user) {
        if(user.getUsername().trim().isEmpty() || user.getPassword().trim().isEmpty()) {
            return 0;
        }
        try {
            return userDao.signup(user);
        } catch (SQLException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int signUp(User user) {
        if(user.getUsername().trim().isEmpty() || user.getPassword().trim().isEmpty() || 
                user.getPhone().trim().isEmpty() || user.getAddress().trim().isEmpty()){
            return 2;
        }
        if(user.getUsername().length() < 5){
            return 3;
        }
        if(user.getPassword().length() < 7){
            return 4;
        }
        if(user.getPhone().length() < 11 || user.getPhone().length() > 11){
            return 5;
        }
        try {
            Integer.parseInt(user.getPhone());
        } catch (Exception e) {
            return 6;
        }
        try {
            return userDao.register(user);
        } catch (SQLException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }

    @Override
    public int getUserByFirstDigits(User user) {
        try {
            return userDao.getUserByFirstDigits(user);
        } catch (SQLException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int getUserByLastDigits(User user) {
        try {
            return userDao.getUserByLastDigits(user);
        } catch (SQLException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int editUserPassword(User user)  {
        try {
            return userDao.editUserPassword(user);
        } catch (SQLException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
