package com.company.service.role;

import com.company.config.ConfigReadAndWriteFile;
import com.company.file.Path;
import com.company.model.Role;
import com.company.model.RoleName;

import java.io.IOException;
import java.util.List;

public class RoleServiceImpl implements IRoleService {
    ConfigReadAndWriteFile<Role> configReadAndWriteFile = new ConfigReadAndWriteFile<>();
    public String PATH_ROLE = Path.PATH + "role.txt";
    List<Role> roleList = configReadAndWriteFile.readFromFile(PATH_ROLE);

    @Override
    public List<Role> findAll() throws IOException {
        configReadAndWriteFile.writeFile(PATH_ROLE, roleList);
        return roleList;
    }

    @Override
    public void save(Role role) {
        roleList.add(role);
    }

    @Override
    public Role findById(int id) {
        for (int i = 0; i < roleList.size(); i++) {
            if (id == roleList.get(i).getId()) {
                return roleList.get(i);
            }
        }
        return null;
    }

    @Override
    public Role findByName(RoleName name) {

        switch (name) {
            case ADMIN:
                return findById(3);
            case PM:
                return findById(2);
            default:
                return findById(1);
        }
    }
}
