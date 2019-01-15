package com.example.demo.mapper;
import java.util.List;

import com.example.demo.pojo.SysUser;

public interface SysUserMapperCustom {
	
	List<SysUser> queryUserSimplyInfoById(String id);
}