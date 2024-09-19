package org.board.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.board.domain.BoardDao;
import org.board.domain.BoardVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

    @Resource
    private BoardDao boardDao;

    public BoardDao getBoardDao(){
        return boardDao;
    }

    public void setBoardDao(BoardDao boardDao){
        this.boardDao = boardDao;
    }

    @Override
    public List<BoardVO> list(){
        return boardDao.list();
    }

    @Override
    public int delete(BoardVO boardVO){
        return boardDao.delete(boardVO);
    }

    @Override
    public int edit(BoardVO boardVO, int seq){
        log.info(String.valueOf(seq));
        return boardDao.update(new BoardVO(boardVO, seq));
    }

    @Override
    public void write(BoardVO boardVO){
        boardDao.insert(boardVO);
    }

    @Override
    public BoardVO read(int seq){
        boardDao.updateReadCount(seq);
        return boardDao.select(seq);
    }

}
