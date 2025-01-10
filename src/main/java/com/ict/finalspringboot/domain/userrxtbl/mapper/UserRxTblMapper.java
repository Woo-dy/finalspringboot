package com.ict.finalspringboot.domain.userrxtbl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ict.finalspringboot.domain.userrxtbl.vo.UserRxTblVO;

@Mapper
public interface UserRxTblMapper {
   List<UserRxTblVO> getUserRxTblList();
   List<UserRxTblVO> getUserRxTblById(String post_num);
   int getUserRxTblUpdate(UserRxTblVO urvo);
   int getUserRxTblDelete(String post_num);   
   int getUserRxTblWrite(UserRxTblVO urvo);
}
