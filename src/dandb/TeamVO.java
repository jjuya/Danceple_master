
package dandb;

public class TeamVO {

	private String teamId;
	private String teamName;
	private String teamDay;
	private String location;
	private String mainTime;
	private String preTime;
	private String teamUrl;
	
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamDay() {
		return teamDay;
	}
	public void setTeamDay(String teamDay) {
		this.teamDay = teamDay;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMainTime() {
		return mainTime;
	}
	public void setMainTime(String mainTime) {
		this.mainTime = mainTime;
	}
	public String getPreTime() {
		return preTime;
	}
	public void setPreTime(String preTime) {
		this.preTime = preTime;
	}
	public String getTeamUrl() {
		return teamUrl;
	}
	public void setTeamUrl(String teamUrl) {
		this.teamUrl = teamUrl;
	}
	
	@Override
	public String toString() {
		return "TeamVO [teamId=" + teamId + ", teamName=" + teamName + ", teamDay=" + teamDay + ", location=" + location
				+ ", mainTime=" + mainTime + ", preTime=" + preTime + ", teamUrl=" + teamUrl + "]";
	}
	
} //end class
