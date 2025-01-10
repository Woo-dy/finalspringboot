package com.ict.finalspringboot.domain.notice.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeVO {
   private String notice_idx, admin_idx, notice_titlem, notice_content, notice_reg_date, notice_file, notice_file_name, notice_delete, notice_out_date;
}
