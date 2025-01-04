package com.ict.finalspringboot.domain.boardrecords.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ict.finalspringboot.domain.boardrecords.vo.BoardRecordsVO;

@Mapper
public interface BoardRecordsMapper {
   List<BoardRecordsVO> getBoardRecordsList();
   BoardRecordsVO getBoardRecordsById(String rx_idx);
   int getBoardRecordsUpdate(BoardRecordsVO grvo);
   int getBoardRecordsDelete(String rx_idx);   
   int getBoardRecordsWrite(BoardRecordsVO grvo);
}
