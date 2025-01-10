package com.ict.finalspringboot.domain.userrxtbl.service;

import java.util.List;

import com.ict.finalspringboot.domain.userrxtbl.vo.UserRxTblVO;

public interface UserRxTblService {
   List<UserRxTblVO> getUserRxTblList();
   
   List<UserRxTblVO> getUserRxTblById(String post_num);
   int getUserRxTblUpdate(UserRxTblVO urvo);
   int getUserRxTblDelete(String post_num);   
   int getUserRxTblWrite(UserRxTblVO urvo);
}
