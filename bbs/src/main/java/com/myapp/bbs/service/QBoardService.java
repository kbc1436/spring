package com.myapp.bbs.service;

import java.util.List;

import com.myapp.bbs.model.BoardVO;
import com.myapp.bbs.model.Criteria;
import com.myapp.bbs.model.QBoardVO;

public interface QBoardService {
	
    /* 게시판 등록 */
    public void enroll(QBoardVO qboard);
    
	/* 게시판 목록 */
	public List<QBoardVO> getList();
	
    /* 게시판 목록(페이징 적용) */
    public List<QBoardVO> getListPaging(Criteria cri);
	
	 /* 게시판 조회 */
    public QBoardVO getPage(int qbno);
    
    /* 게시판 수정 */
    public int modify(QBoardVO qboard);
    
    /* 게시판 삭제 */
    public int delete(int qbno);
    
    /* 게시판 총 갯수 */
    public int getTotal(Criteria cri);
 
}
