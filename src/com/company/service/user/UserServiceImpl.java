package com.company.service.user;

import com.company.config.ConfigReadAndWriteFile;
import com.company.file.Path;
import com.company.model.User;

import java.io.IOException;
import java.util.List;

public class UserServiceImpl implements IUserService {
    ConfigReadAndWriteFile<User> configReadAndWriteFile = new ConfigReadAndWriteFile<>();
    public String PATH_USER = Path.PATH + "user.txt";
    List<User> userList = configReadAndWriteFile.readFromFile(PATH_USER);

    @Override
    public List<User> findAll() throws IOException {
        configReadAndWriteFile.writeFile(PATH_USER, userList);
        return userList;
    }

    @Override
    public void save(User user) {
        userList.add(user);
    }

    @Override
    public User findById(int id) {
        for (int i = 0; i < userList.size(); i++) {
            if(userList.get(i).getId()==id){
                return userList.get(i);
            }
        }
        return null;
    }
}
