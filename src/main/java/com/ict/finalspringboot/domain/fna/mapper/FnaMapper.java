package com.ict.finalspringboot.domain.fna.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ict.finalspringboot.domain.fna.vo.FnaVO;

@Mapper
public interface FnaMapper {
   // 공지 리스트
   List<FnaVO> getFnaList();
}
