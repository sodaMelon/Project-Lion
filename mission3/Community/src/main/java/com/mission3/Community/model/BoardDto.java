package com.mission3.Community.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.SecondaryTable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    private Long id;
    private String name;
}
