package mvc;

import java.util.ArrayList;
import java.util.List;

public class DepartExpert {
	public List<String> getAdvice(String depart){
		List<String> list = new ArrayList<>();
		
		switch(depart) { //byte, short, char, int, String �ڹٴ� �� 5������ ����
		case "kor" :
			list.add("�������� �����ϴ� ���Դϴ�.");
			list.add("��� �ſ� ���ؾ� �մϴ�.");
			break;
		case "eng" :
			list.add("�������� �����ϴ� ���Դϴ�.");
			list.add("��� �ſ� ���ؾ� �մϴ�.");
			break;
		case "com" :
			list.add("�İ����� �����ϴ� ���Դϴ�.");
			list.add("�ĸ� �ſ� ���ؾ� �մϴ�.");
			break;
		case "game" :
			list.add("�������� �����ϴ� ���Դϴ�.");
			list.add("���Ӹ� �ſ� ���ؾ� �մϴ�.");
			break;
		default :
			list.add("���� �غ� ����");
		}
		return list;
		
	}

}
