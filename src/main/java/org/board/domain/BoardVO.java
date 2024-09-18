package org.board.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;


@AllArgsConstructor
@Getter
public class BoardVO {
    private int seq;
    private String title;
    private String content;
    private String writer;
    private int password;
    private Timestamp regDate;
    private int cnt;

    public BoardVO(){

    }

    public BoardVO(String title, String content, String writer, int password){
        super();
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.password = password;
        this.cnt = 0;
    }


    // get/set 메서드 생략

}
