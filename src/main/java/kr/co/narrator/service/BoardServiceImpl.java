package kr.co.narrator.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.narrator.common.Search;
import kr.co.narrator.dao.BoardDAO;
import kr.co.narrator.model.BoardVO;
import kr.co.narrator.model.ReplyVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO boardDAO;
	
	// 게시판 리스트
	@Override
	public List<BoardVO> getBoardList(Search search) throws Exception {
		return boardDAO.getBoardList(search);
	}
	
	// 총 개시글 갯수 확인
	@Override
	public int getBoardListCnt(Search search) throws Exception {
		return boardDAO.getBoardListCnt(search);
	}
	
	// 게시판 글쓰기
	@Override
	public void insertBoard(BoardVO boardVO) throws Exception {
		boardDAO.insertBoard(boardVO);
	}

	// 게시판 내용
	@Transactional
	@Override
	public BoardVO getBoardContent(int seq) throws Exception {
		
		BoardVO boardVO = new BoardVO();

		boardDAO.updateViewCnt(seq);
		boardVO = boardDAO.getBoardContent(seq);
		return boardVO;
		//return boardDAO.getBoardContent(seq);
	}

	// 게시판 수정
	@Override
	public void updateBoard(BoardVO boardVO) throws Exception {
		boardDAO.updateBoard(boardVO);
	}

	// 게시물 삭제
	@Override
	public void deleteBoard(int seq) throws Exception {
		boardDAO.deleteBoard(seq);
	}

	// 댓글 리스트
	@Override
	public List<ReplyVO> getReplyList(int seq) throws Exception {
		return boardDAO.getReplyList(seq);
	}
	@Override
	public int saveReply(ReplyVO replyVO) throws Exception {
		return boardDAO.saveReply(replyVO);
	}
	@Override
	public int updateReply(ReplyVO replyVO) throws Exception {
		return boardDAO.updateReply(replyVO);
	}
	@Override
	public int deleteReply(int rid) throws Exception {
		return boardDAO.deleteReply(rid);
	}

}
