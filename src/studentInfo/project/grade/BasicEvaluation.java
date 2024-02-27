package studentInfo.project.grade;

public class BasicEvaluation implements GradeEvaluation {

    // 일반 과목 학점 산출
    @Override
    public String getGrade(int point) { // 점수를 입력받는다.
        String grade; // 등급 저장

        if (point >= 90) {
            grade = "A";
        } else if (point >= 80) {
            grade = "B";
        } else if (point >= 70) {
            grade = "c";
        } else if (point >= 55) {
            grade = "D";
        } else {
            grade = "F";
        }

        return grade;
    }
}