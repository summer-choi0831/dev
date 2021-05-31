package com.summer.dev.domain.wedding;

import lombok.Data;

@Data
public class RecordRequest {
    String start;
    String end;
    String name;
    String cur_answer;
    int question_num;
    String mode;
    String duration;
}
