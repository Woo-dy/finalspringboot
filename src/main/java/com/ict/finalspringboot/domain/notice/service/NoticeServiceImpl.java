package com.ict.finalspringboot.domain.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.finalspringboot.domain.notice.mapper.NoticeMapper;
import com.ict.finalspringboot.domain.notice.vo.NoticeVO;

@Service
public class NoticeServiceImpl implements NoticeService {
   @Autowired
   private NoticeMapper noticeMapper;

   @Override
   public List<NoticeVO> getNoticeList() {
      return noticeMapper.getNoticeList();
   }

   @Override
   public NoticeVO getNoticeDetail(String notice_idx) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getNoticeDetail'");
   }

   @Override
   public int postNoticeJoin(NoticeVO nvo) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'postNoticeJoin'");
   }

   @Override
   public int putNoticeDelete(NoticeVO nvo) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'putNoticeDelete'");
   }

}