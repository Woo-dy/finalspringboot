package com.ict.finalspringboot.domain.counsel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ict.finalspringboot.domain.counsel.service.CounselService;
import com.ict.finalspringboot.domain.counsel.vo.CounselVO;
import com.ict.finalspringboot.domain.userrxtbl.vo.DataVO;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/counseltbl")
public class CounselController {
   @Autowired
   private CounselService counselService;

   @GetMapping("/list")
   // 공지 리스트
   public DataVO getFnaList(){
      DataVO dataVO = new DataVO();
   
      try {
         log.info("Controller: getFnaList 호출");
         List<CounselVO> list = counselService.getCounselList();
         log.info("Controller: list : " + list);
         dataVO.setSuccess(true);
         dataVO.setMessage("기록 조회 성공");
         dataVO.setData(list);
      } catch (Exception e) {
         dataVO.setSuccess(false);
         dataVO.setMessage("기록 조회 실패: " + e.getMessage());
         dataVO.setData(null);
         e.printStackTrace();
      }
   
   
      return dataVO;
   }
}