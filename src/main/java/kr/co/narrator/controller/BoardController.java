package kr.co.narrator.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.narrator.common.Search;
import kr.co.narrator.model.BoardVO;
import kr.co.narrator.model.ReplyVO;
import kr.co.narrator.service.BoardService;

@Controller
//@RequestMapping(value = "/board")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	private BoardService boardService;
	
	// 예외처리, DB에서 발생하는 에러처리
	@ExceptionHandler(RuntimeException.class)
	public String exceptionHandler(Model model, Exception e) {
		logger.info("exception : " + e.getMessage());
		model.addAttribute("exception", e);
		return "error/exception";
	}

	// 게시판 리스트
	@RequestMapping(value = "/getBoardList.do", method = RequestMethod.GET)
	public String getBoardList(Model model
			, @RequestParam(required = false, defaultValue = "1") int page
			, @RequestParam(required = false, defaultValue = "1") int range
			, @RequestParam(required = false, defaultValue = "title") String searchType
			, @RequestParam(required = false) String keyword
			) throws Exception {

		// 검색 추가
		Search search = new Search();
		search.setSearchType(searchType);
		search.setKeyword(keyword);

		// 전체 게시물 갯수, 검색을 위해 search 추가
		int listCnt = boardService.getBoardListCnt(search);
		// Pagination 객체 생성
		//Pagination pagination = new Pagination();

		// 검색을 위해 pagination 을 search 로 변경
		search.pageInfo(page, range, listCnt);
		model.addAttribute("pagination", search);
		model.addAttribute("boardList", boardService.getBoardList(search));
		return "/";
	}
	
	// 게시판 글쓰기
	@RequestMapping("/boardForm")
	//public String boardForm() {
	public String boardForm(@ModelAttribute("boardVO") BoardVO vo, Model model) {
		return "board/boardForm";
	}
	
	@RequestMapping(value = "/saveBoard", method=RequestMethod.POST, headers = ("content-type=multipart/*") )
	public String saveBoard(@ModelAttribute("BoardVO") BoardVO boardVO
			, Model model
			, @RequestParam("mode") String mode
			//, @RequestParam(value = "file", required = false) MultipartFile multipartFile	// 단일파일
			//, @RequestParam(required = false) List<MultipartFile> files // 또는 MultipartFile[]
			, MultipartHttpServletRequest multi
			, RedirectAttributes rttr) throws Exception {

		// BoardController 에서 바로 적용 테스트
		String filePath = "C:\\egovframework\\upload\\";
		String fileName = "";
		String fileNameDB = "";

		// 파일 중복문제는 UUID 로 해결 가능
		// FileUtils.java 를 이용한 방법, 단일파일
		/*
		if(multipartFile.isEmpty() == false) {
			System.out.println("================= file start ==============");
			System.out.println("name : " + multipartFile.getName());
			System.out.println("filename : " + multipartFile.getOriginalFilename());
			System.out.println("size : " + multipartFile.getSize());
			System.out.println("================= file end ===============");
			
			String originalFileName = multipartFile.getOriginalFilename();	// 파일명
			long fileSize = multipartFile.getSize();	// 파일 사이즈
			
			String safeFile = filePath + System.currentTimeMillis() + "_" + originalFileName;
			try {
				multipartFile.transferTo(new File(safeFile));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		*/
		//List<MultipartFile> fileList = mtfRequest.getFiles("file");
		/*
		//for(MultipartFile mf : files) {
			String original_file_name = mf.getOriginalFilename();
			long file_size = mf.getSize();		// 파일 사이즈

			System.out.println("원본파일명 : " + original_file_name);
			System.out.println("파일사이즈 : " + file_size);
			String stored_file_name = filePath + System.currentTimeMillis() + "_" + original_file_name;
			try{
				mf.transferTo(new File(stored_file_name));
			} catch(IllegalStateException e) {
				e.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		*/

		if(mode.equals("edit")) {
			boardService.updateBoard(boardVO);
		} else {

			// 다중파일 업로드
			Iterator<String> files = multi.getFileNames();
			while(files.hasNext()) {
				String uploadFile = files.next();
				MultipartFile mFile = multi.getFile(uploadFile);
				fileName = mFile.getOriginalFilename();
				fileNameDB += mFile.getOriginalFilename() + ",";
				System.out.println("실제 파일 이름 : " + fileName);
				//model.addAttribute("original_file_name", fileName);
				boardVO.setOriginal_file_name(fileNameDB);
				try {
					mFile.transferTo(new File(filePath+fileName));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			boardService.insertBoard(boardVO);
		}
		return "redirect:/board/getBoardList";
	}

	// 게시판 내용
	@RequestMapping(value = "/getBoardContent", method = RequestMethod.GET)
	public String getBoardContent(Model model, @RequestParam("seq") int seq) throws Exception {
		model.addAttribute("boardContent", boardService.getBoardContent(seq));
		// 게시글 조회 시 댓글을 입력할 수 있는 폼이 생성되어야 함.
		model.addAttribute("replyVO", new ReplyVO());
		return "board/boardContent";
	}
	
	// 게시물 수정
	@RequestMapping(value = "/editForm", method = RequestMethod.GET)
	public String editForm(@RequestParam("seq") int seq, @RequestParam("mode") String mode, Model model) throws Exception {
		model.addAttribute("boardContent", boardService.getBoardContent(seq));
		model.addAttribute("mode", mode);
		model.addAttribute("boardVO", new BoardVO());
		return "board/boardForm";
	}
	
	// 게시물 삭제
	@RequestMapping(value = "/deleteBoard", method = RequestMethod.GET)
	public String deleteBoard(@RequestParam("seq") int seq, RedirectAttributes rttr) throws Exception {
		boardService.deleteBoard(seq);
		return "redirect:/board/getBoardList";
	}
}
