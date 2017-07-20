package manage.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import basic.model.ConnectDAOImpl;
import dandb.GradeVO;
import dandb.TeacherVO;

public class TeacherManageDAOImpl implements TeacherManageDAO {

	private static TeacherManageDAOImpl teacherManageDAO = null;
	private ConnectDAOImpl connectDAOImpl = null;

	private TeacherManageDAOImpl() {
		connectDAOImpl = ConnectDAOImpl.getInstance();
	} //end constructor

	public static TeacherManageDAOImpl getInstance() {

		if (teacherManageDAO == null) {
			teacherManageDAO = new TeacherManageDAOImpl();
		}

		return teacherManageDAO;
	} //end getInstance()

	@Override
	public void insertTeacher(TeacherVO teacherVO) throws Exception {

		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO tb_Teacher (teacherid, teachername, genreid, teamid, seasonid)");
		sql.append(" VALUES (seq_teacher.nextval ,?, ?, ?, ?)");

		Connection cn = null;
		PreparedStatement ps = null;

		try {
			cn = connectDAOImpl.getConnection();
			ps = cn.prepareStatement(sql.toString());

			ps.setString(1, teacherVO.getTeacherName());
			ps.setString(2, teacherVO.getGenreId());
			ps.setString(3, teacherVO.getTeamId());
			ps.setString(4, teacherVO.getSeasonId());
			ps.executeUpdate();
		} finally {
			connectDAOImpl.dbClose(ps, cn);
		}

	} //end insertArticle()

	@Override
	public void updateTeacher(TeacherVO teacherVO) throws Exception {

		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE tb_Teacher SET");
		sql.append(" 		teachername=?,");
		sql.append(" 		genreid=?,");
		sql.append(" 		teamid=?,");
		sql.append("		seasonid=?");
		sql.append(" WHERE 	teacherid=?");
		Connection cn = null;
		PreparedStatement ps = null;

		try {
			cn = connectDAOImpl.getConnection();
			ps = cn.prepareStatement(sql.toString());

			ps.setString(1, teacherVO.getTeacherName());
			ps.setString(2, teacherVO.getGenreId());
			ps.setString(3, teacherVO.getTeamId());
			ps.setString(4, teacherVO.getSeasonId());
			ps.setLong(5, teacherVO.getTeacherId());
			ps.executeUpdate();
		} finally {
			connectDAOImpl.dbClose(ps, cn);
		}

	} //end updateTeacher()

	@Override
	public void deleteTeacher(TeacherVO teacherVO) throws Exception {
		
		StringBuffer sql = new StringBuffer();
		sql.append(" DELETE FROM tb_Teacher");
		sql.append(" WHERE 	teacherid=?");
		
		Connection cn = null;
		PreparedStatement ps = null;
		
		try {
			cn = connectDAOImpl.getConnection();
			ps = cn.prepareStatement(sql.toString());

			ps.setLong(1, teacherVO.getTeacherId());
			
			if (ps.executeUpdate() == 0){
				throw new RuntimeException("강사 ID 가 틀립니다.");
			}
		} finally {
			connectDAOImpl.dbClose(ps, cn);
		}

	}

} //end class
