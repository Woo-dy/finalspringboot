package com.ict.finalspringboot.domain.qna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.finalspringboot.domain.qna.mapper.QnaMapper;
import com.ict.finalspringboot.domain.qna.vo.QnaVO;

@Service
public class QnaServiceImpl implements QnaService {
   
   @Autowired
   private QnaMapper qnaMapper;

   @Override
   public List<QnaVO> getQnaList() {
      return qnaMapper.getQnaList();
   }

   @Override
   public QnaVO getQnaDetail(String Qna_idx) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getQnaDetail'");
   }

   @Override
   public int postQnaJoin(QnaVO qvo) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'postQnaJoin'");
   }

   @Override
   public int putQnaUpdate(QnaVO qvo) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'putQnaUpdate'");
   }

   @Override
   public List<QnaVO> getNoAnswerList() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getNoAnswerList'");
   }

   @Override
   public List<QnaVO> getUserQnaList(String user_idx) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getUserQnaList'");
   }
   
}
