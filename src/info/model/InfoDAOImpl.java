package info.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import basic.model.ConnectDAOImpl;
import dandb.ApplyVO;
import dandb.GenreVO;
import dandb.MemberVO;
import dandb.SeasonVO;
import dandb.TeamVO;

public class InfoDAOImpl implements InfoDAO{

	private static InfoDAOImpl infoDAO = null;
	private ConnectDAOImpl cnA = null;
		
	private InfoDAOImpl() {
		cnA = ConnectDAOImpl.getInstance();
	} //end constructor

	public static InfoDAOImpl getInstance() {
		
		if (infoDAO == null) {
			infoDAO = new InfoDAOImpl();
		}
		
		return infoDAO;
	} //end getInstance()
	
	
	@Override
	public List<TeamVO> getTeamList() throws Exception {
		
		List<TeamVO> list = new ArrayList<TeamVO>();
		
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT *");
		sql.append(" FROM tb_Team");
		
		Connection cn =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			cn = cnA.getConnection();
			ps = cn.prepareStatement(sql.toString());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				TeamVO teamVO = new TeamVO();
				teamVO.setTeamId(rs.getString("teamid"));
				teamVO.setTeamName(rs.getString("teamname"));
				teamVO.setTeamDay(rs.getString("teamday"));
				teamVO.setLocation(rs.getString("location"));
				teamVO.setMainTime(rs.getString("maintime"));
				teamVO.setPreTime(rs.getString("pretime"));
				teamVO.setTeamUrl(rs.getString("teamurl"));
				
				list.add(teamVO);
			}
			
		} finally {
			cnA.dbClose(rs, ps, cn);
		}
		
		return list;
	} //end getTeamList
	
	@Override
	public List<GenreVO> getGenreList() throws Exception {
		
		List<GenreVO> list = new ArrayList<GenreVO>();
		
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT *");
		sql.append(" FROM tb_Genre");
		
		Connection cn =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			cn = cnA.getConnection();
			ps = cn.prepareStatement(sql.toString());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				GenreVO genreVO = new GenreVO();
				genreVO.setGenreId(rs.getString("genreid"));
				genreVO.setGenreName(rs.getString("genrename"));
				genreVO.setGenreUrl(rs.getString("genreUrl"));
				
				list.add(genreVO);
			}
			
		} finally {
			cnA.dbClose(rs, ps, cn);
		}
		
		return list;
	} //end getGenreList
	
	@Override
	public List<SeasonVO> getSeasonList() throws Exception {
		
		List<SeasonVO> list = new ArrayList<SeasonVO>();
		
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT *");
		sql.append(" FROM tb_Season");
		
		Connection cn =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			cn = cnA.getConnection();
			ps = cn.prepareStatement(sql.toString());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				SeasonVO seasonVO = new SeasonVO();
				seasonVO.setSeasonId(rs.getLong("seasonid"));
				seasonVO.setSnMonth(rs.getString("snmonth"));
				seasonVO.setStartDate(rs.getString("startdate"));
				seasonVO.setEndDate(rs.getString("enddate"));
				seasonVO.setProjectDate(rs.getString("projectdate"));
				seasonVO.setProjectDesc(rs.getString("projectdesc"));
				
				list.add(seasonVO);
			}
			
		} finally {
			cnA.dbClose(rs, ps, cn);
		}
		
		return list;
	}
	@Override
	public List<ApplyVO> getApplyList() throws Exception {
		Connection cn =null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<ApplyVO> list = new ArrayList<ApplyVO>();
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT * from apply ");


        try {
            cn = cnA.getConnection();
            ps = cn.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            
            while(rs.next()) {
                ApplyVO appVO = new ApplyVO();
                appVO.setTeamId(rs.getString("teamid"));
                appVO.setMemberId(rs.getString("userid"));
                appVO.setGenre1(rs.getString("genre1"));
                appVO.setGenre2(rs.getString("genre2"));
                appVO.setGenre3(rs.getString("genre3"));
                appVO.setSeasonId(rs.getInt("seasonid"));
                
                list.add(appVO);
            }
        } finally {
            cnA.dbClose(rs, ps, cn);
        }
        return list;
	}
	@Override
	public List<MemberVO> getMemberList() throws Exception {
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<MemberVO> list = new ArrayList<MemberVO>();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * from tb_member ");

		try {
			cn = cnA.getConnection();
			ps = cn.prepareStatement(sql.toString());
			rs = ps.executeQuery();

			while (rs.next()) {
				MemberVO memVO = new MemberVO();
				memVO.setEmail(rs.getString("email"));
				memVO.setGender(rs.getString("gender"));
				memVO.setGradeId(rs.getString("gradeId"));
				memVO.setUserName(rs.getString("Name"));
				memVO.setPhone(rs.getString("phone"));
				memVO.setUserId(rs.getString("userid"));

				list.add(memVO);
			}
		} finally {
			cnA.dbClose(rs, ps, cn);
		}
		return list;
	}
} //end class
