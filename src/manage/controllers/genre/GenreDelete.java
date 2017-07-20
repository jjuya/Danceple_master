package manage.controllers.genre;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basic.controllers.AbstractController;
import basic.controllers.ModelAndView;

public class GenreDelete extends AbstractController{

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		
		return new ModelAndView("/WEB-INF/manage/genre/GenreDelete.jsp");
	}

}
