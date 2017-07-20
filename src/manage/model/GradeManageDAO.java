package manage.model;

import dandb.GradeVO;

public interface GradeManageDAO {

	void insertGrade(GradeVO gradeVO) throws Exception;
	void deleteGrade(GradeVO gradeVO) throws Exception;
	void updateGrade(GradeVO gradeVO)throws Exception;
}
