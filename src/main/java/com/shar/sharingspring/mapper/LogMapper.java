package com.shar.sharingspring.mapper;

import com.shar.sharingspring.javabean.SystemLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper {
    public int addLog(SystemLog systemLog);
}
