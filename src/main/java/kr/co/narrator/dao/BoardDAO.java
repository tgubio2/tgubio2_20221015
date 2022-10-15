package kr.co.narrator.dao;

import java.util.List;

import kr.co.narrator.common.Search;
import kr.co.narrator.model.BoardVO;
import kr.co.narrator.model.ReplyVO;

public interface BoardDAO {

	public List<BoardVO> getBoardList(Search search) throws Exception;
	// 총 게시글 갯수 확인
	public int getBoardListCnt(Search search) throws Exception;
	public BoardVO getBoardContent(int seq) throws Exception;
	public int insertBoard(BoardVO boardVO) throws Exception;
	public int updateBoard(BoardVO boardVO) throws Exception;
	public int deleteBoard(int seq) throws Exception;
	public int updateViewCnt(int seq) throws Exception;
	
	// 댓글 리스트 추가
	public List<ReplyVO> getReplyList(int seq) throws Exception;
	public int saveReply(ReplyVO replyVO) throws Exception;
	public int updateReply(ReplyVO replyVO) throws Exception;
	public int deleteReply(int rid) throws Exception;
	
}
