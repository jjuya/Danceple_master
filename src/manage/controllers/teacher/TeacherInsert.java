package manage.controllers.teacher;

import dandb.GenreVO;
import dandb.SeasonVO;
import dandb.TeamVO;
import info.model.InfoDAO;
import info.model.InfoDAOImpl;
import manage.model.TeacherManageDAO;
import manage.model.TeacherManageDAOImpl;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basic.controllers.AbstractController;
import basic.controllers.ModelAndView;

public class TeacherInsert extends AbstractController{

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		InfoDAO infoDAO = InfoDAOImpl.getInstance();

		ModelAndView mav = new ModelAndView();
		
		try {
			List<TeamVO> teamList = infoDAO.getTeamList(); 
			List<GenreVO> genreList = infoDAO.getGenreList();
			List<SeasonVO> seasonList = infoDAO.getSeasonList();
			
			mav.setViewName("/WEB-INF/manage/teacher/TeacherInsert.jsp");
			mav.addObject("teamList", teamList);
			mav.addObject("genreList", genreList);
			mav.addObject("seasonList", seasonList);
			
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("/WEB-INF/manage/teacher/TeacherInsert.jsp");
			mav.addObject("msg", "리스트 출력에러\n관리자에게 문의하세요");
			mav.addObject("url", "test");
		}
		
		return mav;
	}

	
}
