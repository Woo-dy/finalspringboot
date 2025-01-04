package com.ict.finalspringboot.domain.boardrecords.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.finalspringboot.domain.boardrecords.mapper.BoardRecordsMapper;
import com.ict.finalspringboot.domain.boardrecords.vo.BoardRecordsVO;

@Service
public class BoardRecordsServiceImpl implements BoardRecordsService {
   @Autowired
   private BoardRecordsMapper boardRecordsMapper;

   @Override
   public List<BoardRecordsVO> getBoardRecordsList() {
      return boardRecordsMapper.getBoardRecordsList();
   }

   @Override
   public BoardRecordsVO getBoardRecordsById(String rx_idx) {
      return boardRecordsMapper.getBoardRecordsById(rx_idx);
   }

   @Override
   public int getBoardRecordsUpdate(BoardRecordsVO grvo) {
      return boardRecordsMapper.getBoardRecordsUpdate(grvo);
   }

   @Override
   public int getBoardRecordsDelete(String rx_idx) {
      return boardRecordsMapper.getBoardRecordsDelete(rx_idx);
   }

   @Override
   public int getBoardRecordsWrite(BoardRecordsVO grvo) {
      return boardRecordsMapper.getBoardRecordsWrite(grvo);
   }

}
