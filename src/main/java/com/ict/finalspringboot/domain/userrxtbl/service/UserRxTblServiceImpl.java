package com.ict.finalspringboot.domain.userrxtbl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.finalspringboot.domain.userrxtbl.mapper.UserRxTblMapper;
import com.ict.finalspringboot.domain.userrxtbl.vo.UserRxTblVO;

@Service
public class UserRxTblServiceImpl implements UserRxTblService {
   @Autowired
   private UserRxTblMapper UserRxTblMapper;

   @Override
   public List<UserRxTblVO> getUserRxTblList() {
      return UserRxTblMapper.getUserRxTblList();
   }

   @Override
   public List<UserRxTblVO> getUserRxTblById(String post_num) {
      // post_num 값 확인
      System.out.println("Received post_num2: " + post_num);
      return UserRxTblMapper.getUserRxTblById(post_num);
   }

   @Override
   public int getUserRxTblUpdate(UserRxTblVO urvo) {
      return UserRxTblMapper.getUserRxTblUpdate(urvo);
   }

   @Override
   public int getUserRxTblDelete(String post_num) {
      return UserRxTblMapper.getUserRxTblDelete(post_num);
   }

   @Override
   public int getUserRxTblWrite(UserRxTblVO urvo) {
      return UserRxTblMapper.getUserRxTblWrite(urvo);
   }

}
