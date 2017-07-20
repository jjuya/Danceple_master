package dandb;

public class ApplyVO {

	private String memberId;
	private String teamId;
	private String genre1;
	private String genre2;
	private String genre3;
	private int seasonId;
	private String others;
	private String membername;
	private String phone;
	
	
	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getTeamId() {
		return teamId;
	}


	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}


	public String getGenre1() {
		return genre1;
	}


	public void setGenre1(String genre1) {
		this.genre1 = genre1;
	}


	public String getGenre2() {
		return genre2;
	}


	public void setGenre2(String genre2) {
		this.genre2 = genre2;
	}


	public String getGenre3() {
		return genre3;
	}


	public void setGenre3(String genre3) {
		this.genre3 = genre3;
	}


	public int getSeasonId() {
		return seasonId;
	}


	public void setSeasonId(int seasonId) {
		this.seasonId = seasonId;
	}


	public String getOthers() {
		return others;
	}


	public void setOthers(String others) {
		this.others = others;
	}


	public String getMembername() {
		return membername;
	}


	public void setMembername(String membername) {
		this.membername = membername;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "ApplyVO [memberId=" + memberId + ", teamId=" + teamId + ", genre1=" + genre1 + ", genre2=" + genre2
				+ ", genre3=" + genre3 + ", seasonId=" + seasonId + ", others=" + others + ", membername=" + membername
				+ ", phone=" + phone + "]";
	}
	
	
} //end class
