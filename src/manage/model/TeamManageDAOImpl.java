package manage.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import basic.model.ConnectDAOImpl;
import dandb.TeamVO;

public class TeamManageDAOImpl implements TeamManageDAO {
	
	private static TeamManageDAOImpl teamManageDAO = null;
	private ConnectDAOImpl connectDAOImpl = null;
	
	private TeamManageDAOImpl() {
		connectDAOImpl = ConnectDAOImpl.getInstance();	
	} //end constructor

	public static TeamManageDAOImpl getInstance() {
		
		if (teamManageDAO == null) {
			teamManageDAO = new TeamManageDAOImpl();
		}
		
		return teamManageDAO;
	} //end getInstance()

	@Override
	public void insertTeam(TeamVO teamVO) throws Exception {
		
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO tb_Team (teamid, teamname, teamday, location, maintime, pretime, teamurl)");
		sql.append(" VALUES (?, ?, ?, ?, ?, ?, ?)");
		
		Connection cn = null;
		PreparedStatement ps = null;
		
		try {
			cn = connectDAOImpl.getConnection();
			ps = cn.prepareStatement(sql.toString());

			ps.setString(1, teamVO.getTeamId());
			ps.setString(2, teamVO.getTeamName());
			ps.setString(3, teamVO.getTeamDay());
			ps.setString(4, teamVO.getLocation());
			ps.setString(5, teamVO.getMainTime());
			ps.setString(6, teamVO.getPreTime());
			ps.setString(7, teamVO.getTeamUrl());
			
			ps.executeUpdate();
		} finally {
			connectDAOImpl.dbClose(ps, cn);
		}
		
	} //end insertArticle()
	
	@Override
	public void deleteTeam(TeamVO teamVO) throws Exception {
		
		StringBuffer sql = new StringBuffer();
		sql.append(" DELETE FROM tb_Team");
		sql.append(" WHERE  teamid=?");
		
		Connection cn = null;
		PreparedStatement ps = null;
		
		try {
			cn = connectDAOImpl.getConnection();
			ps = cn.prepareStatement(sql.toString());

			ps.setString(1, teamVO.getTeamId());
			if (ps.executeUpdate() == 0){
				throw new RuntimeException("팀 ID 가 틀립니다.");
			}
		} finally {
			connectDAOImpl.dbClose(ps, cn);
		}
		
	} //end deleteTeam()
	
	@Override
	public void updateTeam(TeamVO teamVO) throws Exception {
		
		StringBuffer sql = new StringBuffer();

		sql.append(" UPDATE tb_Team SET");
		sql.append("       	teamname=?");
		sql.append("       	teamday=?");
		sql.append("       	location=?");
		sql.append("       	maintime=?");
		sql.append("       	pretime=?");
		sql.append("       	teamurl=?");
		sql.append(" WHERE  teamid=?");
		
		Connection cn = null;
		PreparedStatement ps = null;
		
		try {
			cn = connectDAOImpl.getConnection();
			ps = cn.prepareStatement(sql.toString());

			ps.setString(1, teamVO.getTeamName());
			ps.setString(2, teamVO.getTeamDay());
			ps.setString(3, teamVO.getLocation());
			ps.setString(4, teamVO.getMainTime());
			ps.setString(5, teamVO.getPreTime());
			ps.setString(6, teamVO.getTeamUrl());
			ps.setString(7, teamVO.getTeamId());
			
			if (ps.executeUpdate() == 0){
				throw new RuntimeException("팀 ID가 틀립니다.");
			}
		} finally {
			connectDAOImpl.dbClose(ps, cn);
		}
		
	} //end updateTeam()

} //end class
