package member.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basic.controllers.AbstractController;
import basic.controllers.ModelAndView;
import dandb.MemberVO;
import member.model.MemberDAO;
import member.model.MemberDAOImpl;

public class MemberInsertAction extends AbstractController{

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		String memberId=request.getParameter("memberId");
		String memberPwd=request.getParameter("memberPwd");
		String memberName=request.getParameter("memberName");
		String phone=request.getParameter("phone");
		String birthday = request.getParameter("birthday");
		String email =request.getParameter("email");
		String gender =request.getParameter("gender");
		String gradeId =request.getParameter("gradeId");
		
		
		MemberVO memberVO= new MemberVO();
		memberVO.setUserId(memberId);
		memberVO.setUserPwd(memberPwd);
		memberVO.setUserName(memberName);
		memberVO.setPhone(phone);
		memberVO.setBirthday(birthday);
		memberVO.setEmail(email);
		memberVO.setGender(gender);
		memberVO.setGradeId(gradeId);
		
		
		MemberDAO memberDAO = MemberDAOImpl.getInstance();
		
		ModelAndView mav= new ModelAndView("/WEB-INF/member/result.jsp");
		
		try{
			memberDAO.insertMember(memberVO);
			mav.addObject("msg","회원가입 성공.");
			mav.addObject("url","login");
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject("msg","회원가입 실패");
			mav.addObject("url", "javascript:history.back();");
			}
		return mav;//new ModelAndView("/WEB-INF");
		
	}

}
