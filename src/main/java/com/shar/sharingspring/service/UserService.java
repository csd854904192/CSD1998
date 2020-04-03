package com.shar.sharingspring.service;

import com.shar.sharingspring.mapper.DeptMapper;
import com.shar.sharingspring.mapper.FileMapper;
import com.shar.sharingspring.mapper.LogMapper;
import com.shar.sharingspring.mapper.MenuMapper;
import com.shar.sharingspring.javabean.User;
import com.shar.sharingspring.javabean.*;
import com.shar.sharingspring.javabean.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.print.Doc;
import java.util.*;

@Service
public class UserService {
    @Resource
    private DeptMapper deptMapper;
    @Resource
    private MenuMapper menuMapper;
    @Resource
    private FileMapper fileMapper;
    @Resource
    private LogMapper logMapper;

    /**
     * 用户登录
     * @param map
     * @return
     */
    @Transactional
    public User userLogin(Map map){
        User user = deptMapper.UserLogin(map);
        return user;
    }
    /**
    *用户查询数据
     **/
    @Transactional
    public Map datagrid(HashMap map){
        Integer count= deptMapper.findAllusers(map);
        List<User> users = deptMapper.findusers(map);
        Map map1 = new HashMap();
        map1.put("users",users);
        map1.put("count",count);
        return map1;
    }

    /**
     * 新增用户
     * @param list
     * @return
     */
    @Transactional
    public int form(List list){
        int i = deptMapper.addUser(list);
        return i;
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    @Transactional
    public int regUser(User user){
        int i = deptMapper.regUser(user);
        return i;
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @Transactional
    public int updateForm(User user){
        int i = deptMapper.updateInfo(user);
        return i;
    }

    /**
     * 删除用户
     * @param userid
     * @return
     */
    @Transactional
    public int deleteUser(int userid){
        int i = deptMapper.deleteUser(userid);
        return i;
    }

    /**
     * 查询菜单
     * @param menu
     * @return
     */
    @Transactional
    public Map<String,List<Menu>> findMenus(Menu menu){
        Map<String,List<Menu>> map = new LinkedHashMap<>();
        List<Menu> menuList1 = menuMapper.findMenus(menu);
        for (int i =0;i<menuList1.size();i++){
            Menu menu1 = menuList1.get(i);
            menu1.setMenufid(menu1.getMenuid());
            menu1.setRoleid(menu.getRoleid());
            List<Menu> menuList2 = menuMapper.findMenus(menu1);
            map.put(menu1.getMenuname(),menuList2);
        }
        return map;
    }

    /**
     * 查找用户角色
     * @return
     */
    @Transactional
    public List<Role> findRole(){
        return deptMapper.findRole();
    }

    /**
     * 树形结构，权限管理
     * @param roleid
     * @return
     */
    @Transactional
    public Map findTree(int roleid){
        List<TreeResult> tlist1 = menuMapper.findAllFMenu();
        List<TreeResult> tlist2 = menuMapper.findAllRMenu(roleid);
        Map map = new HashMap();
        map.put("menuname",tlist1);
        map.put("roleid",tlist2);
        return map;
    }

    /**
     * 权限管理，修改菜单
     * @param map
     * @return
     */
    @Transactional
    public boolean subUpdateMenu(Map map){
        boolean flag = false;
        int a = menuMapper.deleteMenuRela((Integer) map.get("roleid"));
        if (a>0) {
            int b = menuMapper.addMenurela((List) map.get("mlist"));
            if (b>0){
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 查找文件记录
     * @param map
     * @return
     */
    @Transactional
    public Map findFiles(HashMap map){
        Integer count= fileMapper.findAllFiles(map);
        List<Files> files = fileMapper.findFiles(map);
        Map map1 = new HashMap();
        map1.put("files",files);
        map1.put("count",count);
        return map1;
    }

    /**
     * 文档审核
     * @param map
     * @return
     */
    public Map findManagerFiles(HashMap map){
        Integer count= fileMapper.findManagerAllFile(map);
        List<Files> files = fileMapper.findManagerFile(map);
        Map map1 = new HashMap();
        map1.put("files",files);
        map1.put("count",count);
        return map1;
    }
    /**
     * 添加日志
     * @param systemLog
     * @return
     */
    @Transactional
    public int addLog(SystemLog systemLog){
        return logMapper.addLog(systemLog);
    }


    public User findUser(String username){
       User user = fileMapper.findUserName(username);
       return user;
    }

    /**
     * 搜索文档
     */
    public Map findConFiles(HashMap map){
        Integer count = fileMapper.findConAllFiles(map);
        List<Files> files = fileMapper.findConFiles(map);
        Map map2 = new HashMap();
        map2.put("files",files);
        map2.put("count",count);
        return map2;
    }

    /**
     * 上传文档
     * @param files
     * @return
     */
    @Transactional
    public int UpLoadFiles(Files files){
        return fileMapper.UpLoadFiles(files);
    }
    /**
     * 搜索文件格式
     */
    public List<DocType> findDocType(){
        return fileMapper.findDocType();
    }

    /**
     * 修改文档审核状态
     * @param map
     * @return
     */
    @Transactional
    public int changeDocState(Map map){
        return fileMapper.changeDocState(map);
    }

    /**
     * 查找文档配置
     * @param map
     * @return
     */
    public Map findTypes(HashMap map){
        Integer count= fileMapper.findTypeCount(map);
        List<DocType> docTypes = fileMapper.findType(map);
        Map map1 = new HashMap();
        map1.put("docTypes",docTypes);
        map1.put("count",count);
        return map1;
    }

    /**
     * 删除文档配置内容
     * @param typeid
     * @return
     */
    @Transactional
    public int deleteType(int typeid){
        return fileMapper.deleteType(typeid);
    }

    /**
     * 修改文档配置
     * @param docType
     * @return
     */
    @Transactional
    public int updateType(DocType docType){
        return fileMapper.updateType(docType);
    }

    /**
     * 增加文档配置
     * @param docType
     * @return
     */
    @Transactional
    public int addType(DocType docType){
        return fileMapper.addType(docType);
    }

    /**
     * 查询下载文件
     * @param docid
     * @return
     */
    public Files findDowFiles(int docid){
        return fileMapper.findDowFiles(docid);
    }

    /**
     * 修改下载次数
     * @param docid
     * @return
     */
    @Transactional
    public int updateDowCount(int docid){
        return fileMapper.updateDowCount(docid);
    }

    /**
     * 获取全部权限
     * @return
     */
    public List<TreeResult> findAllFMenu(){
        return menuMapper.findAllFMenu();
    }

    /**
     * 获取角色权限
     * @param rid
     * @return
     */
    @Transactional
    public List<TreeResult>findAllRMenu(Integer rid){
        return menuMapper.findAllRMenu(rid);
    }
}
