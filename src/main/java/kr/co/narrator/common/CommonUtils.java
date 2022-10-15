package kr.co.narrator.common;

import java.util.UUID;
import java.util.Map;
import java.util.List;

public class CommonUtils {
	
	// getRandomString() 메서드는 32글자의 랜덤한 문자열(숫자포함)을 만들어서 반환
	public static String getRandomString() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	// 공백 또는 null 체크
	// if(CommonUtils.isEmpty(체크 할 변수)) {
	// null 이거나 공백일 경우 실행
	// } else {
	// null 이거나 공백이 아닐때 실행
	// }
	public static boolean isEmpty(Object obj) {
		if(obj == null) return true;
		if((obj instanceof String) && (((String)obj).trim().length() == 0)) { return true; }
		if(obj instanceof Map) { return ((Map<?,?>) obj).isEmpty(); }
		if(obj instanceof Map) { return ((Map<?,?>)obj).isEmpty(); }
		if(obj instanceof List) { return ((List<?>)obj).isEmpty(); }
		if(obj instanceof Object[]) { return (((Object[])obj).length == 0); }
		
		return false;
	}
}
