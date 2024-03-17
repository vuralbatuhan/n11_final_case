package com.example.n11_final_case.dto;

/*
 * @author batuhanvural
 */

import com.example.n11_final_case.entity.enums.Score;
import lombok.Data;

@Data
public class CommentDto {
    private int id;
    private Score score;
    private String description;
}
