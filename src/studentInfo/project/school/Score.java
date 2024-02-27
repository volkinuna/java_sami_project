package studentInfo.project.school;

public class Score {
    // 어느 학생의 어느 과목의 점수가 몇점인지 표현되어야 한다.
    
    // 필드
    public int studentId; // 학번
    private Subject subject; // 과목
    private int point; // 점수

    // 생성자
    public Score(int studentId, Subject subject, int point) {
        this.studentId = studentId;
        this.subject = subject;
        this.point = point;
    }

    @Override
    public String toString() {
        return "학번 : " + this.studentId + ", " + subject.getSubjectName() + " : " + point + "점";
    }

    // getter, setter
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
