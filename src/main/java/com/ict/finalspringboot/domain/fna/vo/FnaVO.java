package com.ict.finalspringboot.domain.fna.vo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FnaVO {
   private String fna_idx = "";
   private String admin_idx = "";
   private String fna_question = "";
   private String fna_answer = "";
   private LocalDate fna_reg_date = LocalDate.now();
   private LocalDate fna_up_date = null;
   private int fna_delete = 0;
   private LocalDate fna_out_date = null;
}
