package manage.model;

import dandb.TeacherVO;

public interface TeacherManageDAO {

	void insertTeacher(TeacherVO teacherVO) throws Exception;

	void updateTeacher(TeacherVO teacherVO) throws Exception;

	void deleteTeacher(TeacherVO teacherVO) throws Exception;


}
