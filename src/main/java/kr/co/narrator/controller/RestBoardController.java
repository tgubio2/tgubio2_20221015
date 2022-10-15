package kr.co.narrator.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.narrator.model.ReplyVO;
import kr.co.narrator.service.BoardService;

@RestController
@RequestMapping(value = "/restBoard")
public class RestBoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	private BoardService boardService;

	@RequestMapping(value = "/getReqlyList", method = RequestMethod.POST)
	public List<ReplyVO> getReplyList(@RequestParam("seq") int seq) throws Exception {
		return boardService.getReplyList(seq);
	}
	
	// 댓글 쓰기 추가
	@RequestMapping(value = "/saveReply", method = {RequestMethod.POST, RequestMethod.GET} )
	public Map<String, Object> saveReply(@RequestBody ReplyVO replyVO) throws Exception {
		Map<String, Object> result = new HashMap<>();

		try {
			boardService.saveReply(replyVO);
			result.put("status", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status",  "False");
		}
		return result;
	}

	// 댓글 수정
	@RequestMapping(value = "/updateReply", method = RequestMethod.POST)
	public Map<String, Object> updateReply(@RequestBody ReplyVO replyVO) throws Exception {
		Map<String, Object> result = new HashMap<>();
		
		try {
			boardService.updateReply(replyVO);
			result.put("status",  "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status",  "False");
		}
		return result;
	}

	// 댓글 삭제
	@RequestMapping(value = "/deleteReply", method = RequestMethod.POST)
	public Map<String, Object> deleteReply(@RequestParam("rid") int rid) throws Exception {
		Map<String, Object> result = new HashMap<>();
		try {
			boardService.deleteReply(rid);
			result.put("status", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status",  "False");
		}
		return result;

	}
}
