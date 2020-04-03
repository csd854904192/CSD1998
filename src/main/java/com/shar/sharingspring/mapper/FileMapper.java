package com.shar.sharingspring.mapper;

import com.shar.sharingspring.javabean.DocType;
import com.shar.sharingspring.javabean.User;
import com.shar.sharingspring.javabean.Files;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FileMapper {
    public List<Files> findFiles(Map map);//搜索文件记录
    public int findAllFiles(Map map);//文件记录数
    public List<Files> findConFiles(Map map);//带条件搜索文件记录
    public int findConAllFiles(Map map);//带条件搜索文件记录数
    public User findUserName(String username);//上传用户
    public List<Files>findManagerFile(Map map);//文档审核
    public int findManagerAllFile(Map map);//文档审核总数
    public int UpLoadFiles(Files files);//文件上传
    public List<DocType> findDocType();//搜索文件格式
    public int changeDocState(Map map);//更改文件审核状态
    public List<DocType> findType(Map map);//查询配置后文档格式
    public int findTypeCount(Map map);//查询配置后文档格式总数
    public int deleteType(int typeid);//删除配置的格式
    public int updateType(DocType docType);//修改配置的格式
    public int addType(DocType docType);//增加配置格式
    public Files findDowFiles(int docid);//查询下载文件
    public int updateDowCount(int docid);//修改下载次数

}
