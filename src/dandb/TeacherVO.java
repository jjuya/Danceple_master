package dandb;

public class TeacherVO {
	
	private Long teacherId;
	private String teacherName;
	private String genreId;
	private String teamId;
	private String seasonId;
	
	public Long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getGenreId() {
		return genreId;
	}
	public void setGenreId(String genreId) {
		this.genreId = genreId;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getSeasonId() {
		return seasonId;
	}
	public void setSeasonId(String seasonId) {
		this.seasonId = seasonId;
	}
	
	@Override
	public String toString() {
		return "TeacherVO [teacherId=" + teacherId + ", teacherName=" + teacherName + ", genreId=" + genreId
				+ ", teamId=" + teamId + ", seasonId=" + seasonId + "]";
	}
	
} //end class
