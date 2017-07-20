package dandb;

public class SeasonVO {
	
	private long seasonId;
	private String snMonth;
	private String startDate;
	private String endDate;
	private String projectDate;
	private String projectDesc;
	
	public long getSeasonId() {
		return seasonId;
	}
	public void setSeasonId(long seasonId) {
		this.seasonId = seasonId;
	}
	public String getSnMonth() {
		return snMonth;
	}
	public void setSnMonth(String snMonth) {
		this.snMonth = snMonth;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getProjectDate() {
		return projectDate;
	}
	public void setProjectDate(String projectDate) {
		this.projectDate = projectDate;
	}
	public String getProjectDesc() {
		return projectDesc;
	}
	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}
	
	@Override
	public String toString() {
		return "SeasonVO [seasonId=" + seasonId + ", snmonth=" + snMonth + ", startDate=" + startDate + ", endDate="
				+ endDate + ", projectDate=" + projectDate + ", projectDesc=" + projectDesc + "]";
	}

} //end class
