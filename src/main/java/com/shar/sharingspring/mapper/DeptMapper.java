package com.shar.sharingspring.mapper;

import com.shar.sharingspring.javabean.Role;
import com.shar.sharingspring.javabean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DeptMapper {
    public User UserLogin(Map map);
    public int addUser(List list);
    public int regUser(User user);
    public int findAllusers(Map map);
    public List<User> findusers(Map map);
    public int updateInfo(User user);
    public int deleteUser(int userid);
    public List<Role> findRole();
}
