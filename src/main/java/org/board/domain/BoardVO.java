package org.board.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public class BoardVO {

    private int seq;

    @Length(min=2, max=5, message = "제목은 2자 이상, 5자 미만 입력하세요.")
    private String title;

    @NotEmpty(message = "내용을 입력하세요.")
    private String content;

    @NotEmpty(message = "작성자를 입력하세요.")
    private String writer;

    private int password;
    private Timestamp regDate;
    private int cnt;

    public BoardVO(BoardVO boardVO,  int seq){
        super();
        this.title = boardVO.getTitle();
        this.content = boardVO.getContent();
        this.writer = boardVO.getWriter();
        this.password = boardVO.getPassword();
        this.seq = seq;
    }

    public BoardVO(String title, String content, String writer, int password){
        super();
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.password = password;
        this.cnt = 0;
    }

    public BoardVO() {

    }


    // get/set 메서드 생략

    public void setSeq(int seq){
        this.seq = seq;
    }

    public void setPassword(int password){
        this.password = password;
    }

}
