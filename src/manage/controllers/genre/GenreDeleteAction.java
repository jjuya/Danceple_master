package manage.controllers.genre;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basic.controllers.AbstractController;
import basic.controllers.ModelAndView;
import dandb.GenreVO;
import manage.model.GenreManageDAO;
import manage.model.GenreManageDAOImpl;

public class GenreDeleteAction extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {

		String genreName = request.getParameter("genreName");
		String genreId = request.getParameter("genreId");
		
		GenreVO genreVO = new GenreVO();
		genreVO.setGenreId(genreId);
		genreVO.setGenreName(genreName);
		
		GenreManageDAO genreManageDAO = GenreManageDAOImpl.getInstance();
		ModelAndView mav = new ModelAndView("/WEB-INF/views/result.jsp");
		
		try {
			genreManageDAO .deleteGenre(genreVO);
			mav.addObject("msg", "장르 등록 성공");
			mav.addObject("url", "genreList");
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("msg", "장르 등록 실패");
			mav.addObject("url", "javascript:history.back();");
		}
		
		return mav;
		
		
	}
} //end class