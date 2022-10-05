package Services;

import model.User;

public interface UserService {
    public int login(User user);
    public int signUp(User user);
    public int getUserByFirstDigits(User user);
    public int getUserByLastDigits(User user);
    public int editUserPassword(User user);
}
