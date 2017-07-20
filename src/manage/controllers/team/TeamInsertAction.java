package manage.controllers.team;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basic.controllers.AbstractController;
import basic.controllers.ModelAndView;
import dandb.TeamVO;
import manage.model.TeamManageDAO;
import manage.model.TeamManageDAOImpl;

public class TeamInsertAction extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {

		String teamId = request.getParameter("teamId");
		String teamName = request.getParameter("teamName");
		String teamDay	= request.getParameter("teamDay");
		String location	= request.getParameter("location");
		String mainTime	= request.getParameter("mainTime");
		String preTime	= request.getParameter("preTime");
		String teamUrl	= request.getParameter("teamUrl");
		
		TeamVO teamVO = new TeamVO();
		teamVO.setTeamId(teamId);
		teamVO.setTeamName(teamName);
		teamVO.setTeamDay(teamDay);
		teamVO.setLocation(location);
		teamVO.setMainTime(mainTime);
		teamVO.setPreTime(preTime);
		teamVO.setTeamUrl(teamUrl);
		
		TeamManageDAO teamManageDAO = TeamManageDAOImpl.getInstance();
		ModelAndView mav = new ModelAndView("/WEB-INF/views/result.jsp");
		
		try {
			teamManageDAO .insertTeam(teamVO);
			mav.addObject("msg", "팀 등록");
			mav.addObject("url", "teamList");
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("msg", "팀 등록 실패");
			mav.addObject("url", "javascript:history.back();");
		}
		
		return mav;
		
		
	}
} //end class