package Service;

import java.util.HashMap;

public interface Board_Service {
	
	
	public int getStart(int num);	
	public int getEnd(int num);
	public int getLast(HashMap<String, Object> params); 
	public int getSkip(int page);
	
	/*
	@Override//페이지를 받아서 페이징...을 뱉어주는것들 시작번호~마지막애까지
	public int getStart(int num) { // 시작페이지
		// TODO Auto-generated method stub
		return (num-1)/10*10+1;
	}
	
	
	@Override
	public int getEnd(int num) {	// 마지막페이지
		// TODO Auto-generated method stub
		int a= (num/10+1);
		if(num%10==0)
			a=num/10;
		return a*10;
	}

	@Override
	public int getLast(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		return (BDao.getCount(params)-1)/10+1;
	}

	@Override//
	public int getSkip(int page) {
		// TODO Auto-generated method stub
		return (page-1)*10;
	}
*/

}
