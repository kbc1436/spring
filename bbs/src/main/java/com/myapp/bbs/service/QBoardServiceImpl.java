package com.myapp.bbs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myapp.bbs.dao.BoardMapper;
import com.myapp.bbs.dao.QBoardMapper;
import com.myapp.bbs.model.BoardVO;
import com.myapp.bbs.model.Criteria;
import com.myapp.bbs.model.QBoardVO;

@Service
public class QBoardServiceImpl implements QBoardService {

	private QBoardMapper qboardMapper;
	
	public QBoardServiceImpl(QBoardMapper qboardMapper) {
		this.qboardMapper = qboardMapper;
	}
	
	@Override
	public void enroll(QBoardVO qboard) {
		qboardMapper.enroll(qboard);	
	}

	@Override
	public List<QBoardVO> getList() {		
		return qboardMapper.getList();
	}

	@Override
	public QBoardVO getPage(int qbno) {
		return qboardMapper.getPage(qbno);
	}

	@Override
	public int modify(QBoardVO qboard) {
		return qboardMapper.modify(qboard);
	}

	@Override
	public int delete(int qbno) {
		return qboardMapper.delete(qbno);
	}

	@Override
	public List<QBoardVO> getListPaging(Criteria cri) {
		return qboardMapper.getListPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		return qboardMapper.getTotal(cri);
	}

}
