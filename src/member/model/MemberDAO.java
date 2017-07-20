package member.model;


import dandb.MemberVO;

public interface MemberDAO {
	
	void insertMember(MemberVO memberVO) throws Exception;

	boolean duplicateIdCheck(String id) throws Exception;


	
	



	

}
