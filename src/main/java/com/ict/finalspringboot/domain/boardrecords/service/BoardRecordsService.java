package com.ict.finalspringboot.domain.boardrecords.service;

import java.util.List;

import com.ict.finalspringboot.domain.boardrecords.vo.BoardRecordsVO;

public interface BoardRecordsService {
   List<BoardRecordsVO> getBoardRecordsList();
   BoardRecordsVO getBoardRecordsById(String rx_idx);
   int getBoardRecordsUpdate(BoardRecordsVO grvo);
   int getBoardRecordsDelete(String rx_idx);   
   int getBoardRecordsWrite(BoardRecordsVO grvo);
}
