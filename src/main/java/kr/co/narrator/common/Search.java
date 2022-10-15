package kr.co.narrator.common;

// Search 클래스가 Pagination 클래스를 상속 받았으므로, 기존 Pagination 의 특성을 그대로 사용할 수 있음.
// DAO, Service, Controller 에서 Pagination 객체 생성하는 코드를 모두 Search로 변경해야 함.
public class Search extends Pagination {
	
	private String searchType;
	private String keyword;
	
	public String getSearchType() {
		return searchType;
	}
	
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	
	public String getKeyword() {
		return keyword;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
