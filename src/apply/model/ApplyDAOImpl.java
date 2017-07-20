package apply.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import basic.model.ConnectDAOImpl;
import dandb.ApplyVO;

public class ApplyDAOImpl implements ApplyDAO{
	private static ApplyDAOImpl applyDAO = null;
	private ConnectDAOImpl cnA = null;
		
	private ApplyDAOImpl() {
		cnA = ConnectDAOImpl.getInstance();
	} //end constructor

	public static ApplyDAOImpl getInstance() {
		
		if (applyDAO == null) {
			applyDAO = new ApplyDAOImpl();
		}
		
		return applyDAO;
	} //end getInstance()

	@Override
	public void insertApply(ApplyVO applyVO) throws Exception {
		
		PreparedStatement ps = null;
		Connection cn = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO danceple(memberid, teamid, others, genreid1, genreid2, genreid3)");
		sql.append(" VALUES(memberid, ?, ?, ?, ? ,?)");
		sql.append(" WHERE membername=? AND phone=?");
		
		try {
			cn = cnA.getConnection();
			ps = cn.prepareStatement(sql.toString());
			ps.setString(1, applyVO.getTeamId());
			ps.setString(2, applyVO.getOthers());
			ps.setString(3, applyVO.getGenre1());
			ps.setString(4, applyVO.getGenre2());
			ps.setString(5, applyVO.getGenre3());
			ps.setString(6, applyVO.getMembername());
			ps.setString(7, applyVO.getPhone());
			ps.executeUpdate();
		
		
		} finally {
			cnA.dbClose(ps, cn);
		}
	}
	
	

}
