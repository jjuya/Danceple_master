package dandb;

public class GradeVO {

	private String gradeId;
	private String gradeName;
	
	public String getGradeId() {
		return gradeId;
	}
	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	
	@Override
	public String toString() {
		return "GradeVO [gradeId=" + gradeId + ", gradeName=" + gradeName + "]";
	}

} //end class
