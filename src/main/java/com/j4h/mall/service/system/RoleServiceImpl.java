package com.j4h.mall.service.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j4h.mall.mapper.system.RoleMapper;
import com.j4h.mall.model.system.Role;
import com.j4h.mall.model.system.RoleList;
import com.j4h.mall.model.system.RoleVo;
import com.j4h.mall.model.system.StorageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/3 17:31
 */
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleMapper roleMapper;

    @Override
    public RoleList queryRole(StorageQuery storageQuery) {
        int start = storageQuery.getPage();
        int limit = storageQuery.getLimit();
        String sort = storageQuery.getSort();
        String order = storageQuery.getOrder();
        PageHelper.startPage(start,limit,sort + " " + order);
        String name = storageQuery.getName();
        if(name == null){
            name = "";
        }
        name = "%" + name + "%";
        List<Role> roles = roleMapper.queryRole(name);
        PageInfo<Role> rolePageInfo = new PageInfo<>(roles);
        long total = rolePageInfo.getTotal();
        RoleList roleList = new RoleList();
        roleList.setItems(roles);
        roleList.setTotal(total);
        return roleList;
    }

    /**
     * 输入name和desc，再查询返回完整数据
     * @param role
     * @return
     */
    @Override
    public Role addRole(Role role) {
        roleMapper.insertRole(role);
        int id = role.getId();
        return roleMapper.queryRoleById(id);
    }

    @Override
    public void deleteRole(Role role) {
        roleMapper.deleteRole(role);
    }

    @Override
    public List<RoleVo> getAllRole() {
        List<RoleVo> allRole = roleMapper.getAllRole();
        return allRole;
    }
}
