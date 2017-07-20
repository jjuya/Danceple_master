package dandb;

public class MemberVO {
	
	private String userId;
	private String userPwd;
	private String userName;
	private String phone;
	private String birthday;
	private String email;
	private String gender;
	private String gradeId;
	private String teamId;
	private int penalty;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGradeId() {
		return gradeId;
	}
	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public int getPenalty() {
		return penalty;
	}
	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}
	@Override
	public String toString() {
		return "MemberVO [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", phone=" + phone
				+ ", birthday=" + birthday + ", email=" + email + ", gender=" + gender + ", gradeId=" + gradeId
				+ ", teamId=" + teamId + ", penalty=" + penalty + "]";
	}
	
} //end class
