package manage.controllers.teacher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basic.controllers.AbstractController;
import basic.controllers.ModelAndView;
import dandb.TeacherVO;
import manage.model.TeacherManageDAO;
import manage.model.TeacherManageDAOImpl;

public class TeacherUpdateAction extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		
		Long teacherId = Long.parseLong(request.getParameter("teacherId"));
		String teacherName = request.getParameter("teacherName");
		String teamId = request.getParameter("teamId");
		String genreId = request.getParameter("genreId");
		String seasonId = request.getParameter("seasonId");
		
		TeacherVO teacherVO = new TeacherVO();
		teacherVO.setTeacherId(teacherId);
		teacherVO.setTeacherName(teacherName);
		teacherVO.setTeamId(teamId);
		teacherVO.setGenreId(genreId);
		teacherVO.setSeasonId(seasonId);
		
		TeacherManageDAO teacherManageDAO = TeacherManageDAOImpl.getInstance();
		ModelAndView mav = new ModelAndView("/WEB-INF/views/result.jsp");
		
		try {
			teacherManageDAO.updateTeacher(teacherVO);
			mav.addObject("msg", "강사 수정 성공");
			mav.addObject("url", "list");
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("msg", "강사 수정 실패");
			mav.addObject("url", "javascript:history.back();");
		}
		
		return null;
	}
	
}
