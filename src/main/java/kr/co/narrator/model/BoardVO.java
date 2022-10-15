package kr.co.narrator.model;

public class BoardVO {

	public int seq;					// 번호
	public String name;			// 작성자
	public String email;			// 이메일
	public String homepage;	// 홈페이지
	public String title;				// 제목
	public String content;		// 내용
	public String password;		// 비밀번호
	public int count;				// 조회수
	public String ip;				// 등록IP
	public String regdate;		// 등록일
	public int pos;					// 댓글
	public int depth;				// 댓글
	public int view_cnt;			// 조회수
	
	public String original_file_name;	// 파일 이름
	public String stored_file_name;	// 파일 이름
	public int file_size;					// 파일 용량

	public String getOriginal_file_name() { return original_file_name; }
	public void setOriginal_file_name(String original_file_name) { this.original_file_name = original_file_name; }

	public String getStored_file_name() { return stored_file_name; }
	public void setStored_file_name(String stored_file_name) { this.stored_file_name = stored_file_name; }

	public int getFile_size() { return file_size; }
	public void setFile_size(int file_size) { this.file_size = file_size; }

	public int getSeq() { return seq; }
	public void setSeq(int seq) { this.seq = seq; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public String getHomepage() { return homepage; }
	public void setHomepage(String homepage) { this.homepage = homepage; }

	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }

	public String getContent() { return content; }
	public void setContent(String content) { this.content = content; }

	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }

	public int getCount() { return count; }
	public void setCount(int count) { this.count = count; }

	public String getIp() { return ip; }
	public void setIp(String ip) { this.ip = ip; }

	public String getRegdate() { return regdate; }
	public void setRegdate(String regdate) { this.regdate = regdate; }

	public int getPos() { return pos; }
	public void setPos(int pos) { this.pos = pos; }

	public int getDepth() { return depth; }
	public void setDepth(int depth) { this.depth = depth; }

	public int getView_cnt() {
		return view_cnt;
	}
	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}


}
