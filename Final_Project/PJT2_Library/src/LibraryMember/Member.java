package LibraryMember;

import java.util.*;

public interface Member {
	public boolean IdCheck(String idCheck); // 아이디 중복 확인할 추상메소드
	public void IdInput(String idInput); // 아이디 입력 받을 추상메소드
	public void print();
	
	public List<String> list();
	public void read(List<String> list);
	
}
