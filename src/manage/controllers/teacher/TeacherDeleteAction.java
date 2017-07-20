package manage.controllers.teacher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import basic.controllers.AbstractController;
import basic.controllers.DispatcherServlet;
import basic.controllers.ModelAndView;
import dandb.TeacherVO;
import manage.model.TeacherManageDAO;
import manage.model.TeacherManageDAOImpl;

public class TeacherDeleteAction extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		
		long teacherId = Long.parseLong(request.getParameter("teacherId"));
		//String teacherName = request.getParameter("teacherName");
		
		Logger logger
		= LoggerFactory.getLogger(TeacherDeleteAction.class);
		
		logger.info(request.getParameter("teacherId"));
		
		TeacherVO teacherVO = new TeacherVO();
		teacherVO.setTeacherId(teacherId);
		//teacherVO.setTeacherName(teacherName);
		
		TeacherManageDAO teacherManageDAO = TeacherManageDAOImpl.getInstance();
		ModelAndView mav = new ModelAndView("/WEB-INF/views/result.jsp");
		
		try {
			teacherManageDAO.deleteTeacher(teacherVO);
			mav.addObject("msg", "강사 삭제 성공");
			mav.addObject("url", "list");
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("msg", "강사 삭제 실패");
			mav.addObject("url", "javascript:history.back();");
		}
		
		return null;
	}
	
}
