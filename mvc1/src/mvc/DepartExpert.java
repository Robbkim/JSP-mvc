package mvc;

import java.util.ArrayList;
import java.util.List;

public class DepartExpert {
	public List<String> getAdvice(String depart){
		List<String> list = new ArrayList<>();
		
		switch(depart) { //byte, short, char, int, String 자바는 이 5가지만 지원
		case "kor" :
			list.add("국문학을 공부하는 과입니다.");
			list.add("국어를 매우 잘해야 합니다.");
			break;
		case "eng" :
			list.add("영문학을 공부하는 과입니다.");
			list.add("영어를 매우 잘해야 합니다.");
			break;
		case "com" :
			list.add("컴공학을 공부하는 과입니다.");
			list.add("컴를 매우 잘해야 합니다.");
			break;
		case "game" :
			list.add("게임학을 공부하는 과입니다.");
			list.add("게임를 매우 잘해야 합니다.");
			break;
		default :
			list.add("아직 준비 못함");
		}
		return list;
		
	}

}
