package com.shar.sharingspring.mapper;

import com.shar.sharingspring.javabean.Menu;
import com.shar.sharingspring.javabean.Menurela;
import com.shar.sharingspring.javabean.TreeResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    public List<Menu> findMenus(Menu menu);
    public List<TreeResult> findAllFMenu();
    public List<TreeResult> findAllRMenu(int roleid);
    public int deleteMenuRela(int roleid);
    public int addMenurela(List<Menurela> mlist);
}
