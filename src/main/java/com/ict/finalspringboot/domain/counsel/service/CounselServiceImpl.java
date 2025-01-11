package com.ict.finalspringboot.domain.counsel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.finalspringboot.domain.counsel.mapper.CounselMapper;
import com.ict.finalspringboot.domain.counsel.vo.CounselVO;

@Service
public class CounselServiceImpl implements CounselService {
   @Autowired
   private CounselMapper counselMapper; 

   @Override
   public List<CounselVO> getCounselList() {
      return counselMapper.getCounselList();
   }

   @Override
   public CounselVO getCounselDetail(String counsel_idx) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getCounselDetail'");
   }

   @Override
   public int postCounselJoin(CounselVO counvo) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'postCounselJoin'");
   }

   @Override
   public int putCounselUpdate(CounselVO counvo) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'putCounselUpdate'");
   }

   @Override
   public int putCounselDelete(CounselVO counvo) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'putCounselDelete'");
   }

   @Override
   public int putCounselCommentJoin(CounselVO counvo) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'putCounselCommentJoin'");
   }
   
}
