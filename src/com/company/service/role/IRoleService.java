package com.company.service.role;

import com.company.model.Role;
import com.company.model.RoleName;
import com.company.service.IService;

public interface IRoleService extends IService<Role> {
    Role findByName(RoleName name);
}
