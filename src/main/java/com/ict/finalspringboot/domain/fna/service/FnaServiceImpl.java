package com.ict.finalspringboot.domain.fna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.finalspringboot.domain.fna.mapper.FnaMapper;
import com.ict.finalspringboot.domain.fna.vo.FnaVO;

@Service
public class FnaServiceImpl implements FnaService {
   @Autowired
   private FnaMapper fnaMapper;

   @Override
   public List<FnaVO> getFnaList() {
      return fnaMapper.getFnaList();
   }

}
