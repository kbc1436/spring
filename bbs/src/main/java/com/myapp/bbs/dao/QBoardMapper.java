package com.myapp.bbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myapp.bbs.model.BoardVO;
import com.myapp.bbs.model.Criteria;
import com.myapp.bbs.model.QBoardVO;

@Mapper
public interface QBoardMapper {
	
	/* 게시판 등록 */
	public void enroll(QBoardVO qboard);
	
	/* 게시판 목록 */
	public List<QBoardVO> getList();
	
	/* 게시판 목록(페이징 적용): pageNum , amount를 입력받아 객체 cri생성 없으면 기본(1,10), keyword추가됨 */
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
