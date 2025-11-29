package com.springboot.springboothousemarket.Mapper;

import com.springboot.springboothousemarket.Entitiy.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserMapper {

    int insert(SysUser sysUser);

    SysUser selectById(Long id);

    int update(SysUser sysUser);

    int deleteById(Long id);

    List<SysUser> selectAll();

    SysUser selectByUsername(String username);
}