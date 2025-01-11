package com.ict.finalspringboot.domain.fna.service;

import java.util.List;

import com.ict.finalspringboot.domain.fna.vo.FnaVO;

public interface FnaService {
   // 자주 묻는 질문 리스트
   List<FnaVO> getFnaList();
}
