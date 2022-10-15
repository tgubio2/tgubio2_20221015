package kr.co.narrator.dao;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.narrator.common.Search;
import kr.co.narrator.model.BoardVO;
import kr.co.narrator.model.ReplyVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	//private final String NS = "kr.co.narrator.boardMapper";

	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<BoardVO> getBoardList(Search search) throws Exception {
		return sqlSession.selectList("kr.co.narrator.boardMapper.getBoardList", search);
	}
	
	// 총 개시글 갯수 확인
	@Override
	public int getBoardListCnt(Search search) throws Exception {
		return sqlSession.selectOne("kr.co.narrator.boardMapper.getBoardListCnt", search);
	}
	
	@Override
	public BoardVO getBoardContent(int seq) throws Exception {
		return sqlSession.selectOne("kr.co.narrator.boardMapper.getBoardContent", seq);
	}

	@Override
	public int insertBoard(BoardVO boardVO) throws Exception {
		return sqlSession.insert("kr.co.narrator.boardMapper.insertBoard", boardVO);
	}

	@Override
	public int updateBoard(BoardVO boardVO) throws Exception {
		return sqlSession.update("kr.co.narrator.boardMapper.updateBoard", boardVO);
	}

	@Override
	public int deleteBoard(int seq) throws Exception {
		return sqlSession.delete("kr.co.narrator.boardMapper.deleteBoard", seq);
	}

	@Override
	public int updateViewCnt(int seq) throws Exception {
		return sqlSession.update("kr.co.narrator.boardMapper.updateViewCnt", seq);
	}

	// 댓글 리스트
	@Override
	public List<ReplyVO> getReplyList(int seq) throws Exception {
		return sqlSession.selectList("kr.co.narrator.replyMapper.getReplyList", seq);
	}
	@Override
	public int saveReply(ReplyVO replyVO) throws Exception {
		return sqlSession.insert("kr.co.narrator.replyMapper.saveReply", replyVO);
	}
	@Override
	public int updateReply(ReplyVO replyVO) throws Exception {
		return sqlSession.update("kr.co.narrator.replyMapper.updateReply", replyVO);
	}
	@Override
	public int deleteReply(int rid) throws Exception {
		return sqlSession.delete("kr.co.narrator.replyMapper.deleteReply", rid);
	}

}
