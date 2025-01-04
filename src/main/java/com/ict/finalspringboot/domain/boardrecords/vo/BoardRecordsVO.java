package com.ict.finalspringboot.domain.boardrecords.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardRecordsVO {
   private String rx_idx, user_idx, rx_date, rx_phar_name, drug_idx, phar_idx, rx_photo;
   private MultipartFile file;
}