package com.example.n11_final_case.entity;

/*
 * @author batuhanvural
 */

import com.example.n11_final_case.entity.enums.Score;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "COMMENT")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "score", nullable = false)
    private Score score;

    @Column(name = "description", nullable = false, length = 200)
    private String description;
}
