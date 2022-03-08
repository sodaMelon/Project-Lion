package com.mission3.Community.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Area {
    @Id
    @GeneratedValue
    private Long id;
    private String head; //도, 광역시
    private String body; //시, 군, 구
    private String tail; //동, 면, 읍
    private int latitude; //위도
    private int longitude; //경도


}
