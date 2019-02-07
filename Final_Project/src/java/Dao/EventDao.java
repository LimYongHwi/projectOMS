package Dao;

import java.util.ArrayList;
import java.util.HashMap;

import VO.EventVO;
import VO.FAQVO;
import VO.Service_CenterVO;

public interface EventDao {
	//�����.
	public int insertEvent(EventVO event);
	//������Ʈ
	public int updateEvent(EventVO event);
	//����
	public int deleteEvent(EventVO event);
	
	//�ϳ��̱�
	public EventVO selectOneEvent(EventVO event);
	
	//����Ʈ�̱�
	public ArrayList<HashMap<String, Object>> getEventList(HashMap<String, Object> params);
	
	//�������� ������ȣ ������
	public int getEventSeqNum();
	
	// ��ü �Խù� �˻����ǿ� �´� �� ī��Ʈ
	public int getCountEvent(HashMap<String, Object> params);
	
}
