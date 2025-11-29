package com.springboot.springboothousemarket.Mapper;

import com.springboot.springboothousemarket.Entitiy.House;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HouseMapper {

    int insert(House house);

    House selectById(Long id);

    int update(House house);

    int deleteById(Long id);

    List<House> selectAll();

    List<House> selectByLandlordId(Long landlordId);
}