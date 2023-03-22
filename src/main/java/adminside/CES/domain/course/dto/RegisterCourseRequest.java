package adminside.CES.domain.course.dto;

public class RegisterCourseRequest {
    private int studentId;

    private String courseId;

    public RegisterCourseRequest(int studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }
}
