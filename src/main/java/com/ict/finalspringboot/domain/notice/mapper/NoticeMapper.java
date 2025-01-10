package com.ict.finalspringboot.domain.notice.mapper;

import java.util.List;

import com.ict.finalspringboot.domain.notice.vo.NoticeVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeMapper {
   // 공지 리스트
   List<NoticeVO> getNoticeList();
}
