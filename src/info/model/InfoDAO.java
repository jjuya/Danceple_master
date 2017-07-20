package info.model;

import java.util.List;

import dandb.ApplyVO;
import dandb.GenreVO;
import dandb.MemberVO;
import dandb.SeasonVO;
import dandb.TeamVO;

public interface InfoDAO {

	List<TeamVO> getTeamList() throws Exception;

	List<GenreVO> getGenreList() throws Exception;

	List<SeasonVO> getSeasonList() throws Exception;

	List<MemberVO> getMemberList() throws Exception;

	List<ApplyVO> getApplyList() throws Exception;

}
