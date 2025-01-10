package com.ict.finalspringboot.domain.notice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ict.finalspringboot.domain.notice.service.NoticeService;
import com.ict.finalspringboot.domain.notice.vo.NoticeVO;
import com.ict.finalspringboot.domain.userrxtbl.vo.DataVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/noticetbl")
public class NoticeController {
   @Autowired
   private NoticeService noticeTblService;

   @GetMapping("/list")
   // 공지 리스트
   public DataVO getNoticeList(){
      DataVO dataVO = new DataVO();
   
      try {
         log.info("Controller: getNoticeList 호출");
         List<NoticeVO> list = noticeTblService.getNoticeList();
         log.info("Controller: list : " + list);
         dataVO.setSuccess(true);
         dataVO.setMessage("진료 기록 조회 성공");
         dataVO.setData(list);
      } catch (Exception e) {
         dataVO.setSuccess(false);
         dataVO.setMessage("진료 기록 조회 실패: " + e.getMessage());
         dataVO.setData(null);
         e.printStackTrace();
      }
   
      return dataVO;
   }
}