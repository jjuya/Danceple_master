package manage.controllers.teacher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basic.controllers.AbstractController;
import basic.controllers.ModelAndView;

public class TeacherDelete extends AbstractController{

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		
		return new ModelAndView("/WEB-INF/manage/teacher/TeacherDelete.jsp");
	}
} //end class
