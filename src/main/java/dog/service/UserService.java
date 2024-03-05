package dog.service;

import java.util.List;
import dog.entity.User;

public interface UserService {
    public static final int CORRECT_LOGIN = 0;
    public static final int WRONG_PASSWORD = 1;
    public static final int USER_NOT_EXIST = 2;
    public static final int COUNT_PER_PAGE = 10;

    User getUserByUid(String uId);
   
    List<User> getUserList(int page);
   
    int getUserCount();
   
    void registerUser(User user);
    
    void updateUser(User user);
   
    void deleteUser(String uId);

    int login(String uId, String pwd);
    
}
