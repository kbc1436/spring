package com.myapp.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myapp.bbs.model.BoardVO;
import com.myapp.bbs.model.Criteria;
import com.myapp.bbs.model.PageMakerDTO;
import com.myapp.bbs.model.QBoardVO;
import com.myapp.bbs.service.BoardService;
import com.myapp.bbs.service.QBoardService;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/qboard")
@Log		//콘솔의 로그 출력 (print out 대신 사용)
public class QBoardController {
	
	private QBoardService qboardService;
	
	public QBoardController(QBoardService qboardService) {
		this.qboardService = qboardService;
	}
	
	@GetMapping("/enroll")
	public String boardEnrollGet(Model model) {
		model.addAttribute("qboard", new QBoardVO());
		return "/qboard/enroll";
	}
	
	@PostMapping("/enroll")
	public String boardEnrollPost(QBoardVO qboard, RedirectAttributes attr) {
		//log.info("BoardVO : " + board);
		qboardService.enroll(qboard);
		attr.addFlashAttribute("message", "게시물 등록 성공!");
		return "redirect:/qboard/list"; //포스트 다음에 리다이렉트
	}
	
//	@GetMapping("/list")
//	public String boardListGET(Model model) {
//		//boardList에 모든 게시글을 전달
//		model.addAttribute("boardList", boardService.getList());
//		return "list";
//	}
	
	/* 게시판 목록 페이지(페이징 적용) */
	@GetMapping("/list")
	public String boardListGET(Criteria cri, Model model) {
		//boardList에 페이징된 게시글을 전달
		model.addAttribute("QboardList", qboardService.getListPaging(cri));
		
		int total = qboardService.getTotal(cri);
		PageMakerDTO pmk = new PageMakerDTO(total, cri); //객체 생성시 모든 변수 계산됨
		
		model.addAttribute("pmk", pmk); //페이지네이션을 위한 pmk객체 전달
		
		return "/qboard/list";
	}
	
	/**
	 * 게시판 글을 조회하기
	 * @param bno
	 * @param model
	 * @return
	 */
	@GetMapping("/get")
	public String boardPageGET(@RequestParam("qbno") int qbno, Model model, Criteria cri) {
		model.addAttribute("qboard", qboardService.getPage(qbno));
		model.addAttribute("cri", cri);
		return "/qboard/get";
	}
	
	@GetMapping("/modify")
	public String boardModifyGET(@RequestParam("qbno") int qbno, Model model, Criteria cri) {
		model.addAttribute("qboard", qboardService.getPage(qbno));
		model.addAttribute("cri", cri);
		return "/qboard/modify";
	}
	
	@PostMapping("/modify")
	public String boardModifyPOST(QBoardVO qboard, RedirectAttributes attr) {
		log.info("" + qboard);
		qboardService.modify(qboard); //modify페이지에서 수정된 내용을 업데이트 함
		attr.addFlashAttribute("message", "수정 성공!");
		return "redirect:/qboard/list"; //post - redirect - get
	}
	
	@GetMapping("/delete")
	public String boardDeleteGET(@RequestParam("qbno") int qbno, RedirectAttributes attr) {
		qboardService.delete(qbno); 
		attr.addFlashAttribute("message", "삭제 성공!");
		return "redirect:/qboard/list";
	}
	
	
	
	
}





