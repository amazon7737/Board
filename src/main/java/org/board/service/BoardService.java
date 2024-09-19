package org.board.service;

import org.board.domain.BoardVO;

import java.util.List;

public interface BoardService {
    public abstract List<BoardVO> list();

    public abstract int delete(BoardVO boardVO);

    public abstract int edit(BoardVO boardVO, int seq);

    public abstract void write(BoardVO boardVO);

    public abstract BoardVO read(int seq);

}
