package dog.service;


import org.mindrot.jbcrypt.BCrypt;

import dog.dao.UserDao;
import dog.entity.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDao() ;

    @Override
    public User getUserByUid(String uId) {
        User user = userDao.getUserByUid(uId);
        return user;
    }

    @Override
    public List<User> getUserList(int page) {
        int offset = (page - 1) * COUNT_PER_PAGE;
        List<User> list = userDao.getUserList(COUNT_PER_PAGE, offset);
        return list;
    }

    @Override
    public int getUserCount() {
        return 0;
    }

    @Override
    public void registerUser(User user) {
    User u = userDao.getUserByUid(user.getuId());
        if (u != null)
            return;

        String hashedPwd = BCrypt.hashpw(user.getPwd(), BCrypt.gensalt());
        user.setPwd(hashedPwd);
        userDao.insertUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(String uId) {
        userDao.deleteUser(uId);
    }

    @Override
    public int login(String uId, String pwd) {
       User user = userDao.getUserByUid(uId);
        if (user == null)
            return USER_NOT_EXIST;
        if (BCrypt.checkpw(pwd, user.getPwd()))
            return CORRECT_LOGIN;
        return WRONG_PASSWORD;
    }
}
