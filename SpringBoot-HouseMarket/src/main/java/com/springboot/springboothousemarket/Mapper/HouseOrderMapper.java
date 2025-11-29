package com.springboot.springboothousemarket.Mapper;

import com.springboot.springboothousemarket.Entitiy.HouseOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HouseOrderMapper {

    int insert(HouseOrder houseOrder);

    HouseOrder selectById(Long id);

    int update(HouseOrder houseOrder);

    int deleteById(Long id);

    List<HouseOrder> selectAll();

    List<HouseOrder> selectByUserId(Long userId);
}