package kr.co.narrator.service;

import java.util.List;
import java.util.Map;

import kr.co.narrator.common.Search;
import kr.co.narrator.model.BoardVO;
import kr.co.narrator.model.ReplyVO;

public interface BoardService {

	// 게시판 리스트
	public List<BoardVO> getBoardList(Search search) throws Exception;
	
	// 총 개시글 갯수 확인
	public int getBoardListCnt(Search search) throws Exception;
	
	// 게시판 내용
	public BoardVO getBoardContent(int seq) throws Exception;

	// 게시판 글쓰기
	//public Map<String, Object> insertBoard(BoardVO boardVO) throws Exception;
	public void insertBoard(BoardVO boardVO) throws Exception;

	// 게시판 수정
	public void updateBoard(BoardVO boardVO) throws Exception;
	
	// 게시물 삭제
	public void deleteBoard(int seq) throws Exception;

	// 댓글 리스트
	public List<ReplyVO> getReplyList(int seq) throws Exception;
	public int saveReply(ReplyVO replyVO) throws Exception;
	public int updateReply(ReplyVO replyVO) throws Exception;
	public int deleteReply(int rid) throws Exception;

}
