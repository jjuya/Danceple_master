package member.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basic.controllers.AbstractController;
import basic.controllers.ModelAndView;
import member.model.MemberDAO;
import member.model.MemberDAOImpl;

public class MemberIdCheckAction extends AbstractController  {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("tb_memberId");
        MemberDAO dao = MemberDAOImpl.getInstance();
        
        boolean result;
		try {
			result = dao.duplicateIdCheck(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
       /* if(result)    out.println("0"); // 아이디 중복
        else        out.println("1");
        
        out.close();
       */
		return null;
	}

}
