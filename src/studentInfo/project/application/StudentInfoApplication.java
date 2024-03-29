package studentInfo.project.application;

import studentInfo.project.school.School;
import studentInfo.project.school.Score;
import studentInfo.project.school.Student;
import studentInfo.project.school.Subject;
import studentInfo.project.school.report.GenerateGradeReport;
import studentInfo.project.utils.Define;

public class StudentInfoApplication {

    School goodSchool = School.getInstance(); // 학교 생성
    Subject korean; // 국어 과목
    Subject math;   // 수학 과목

    GenerateGradeReport gradeReport = new GenerateGradeReport();

    public static void main(String[] args) {

        StudentInfoApplication app = new StudentInfoApplication();

        app.createSubject(); // 과목 개설, 학교에 과목 등록
        app.createStudent();
        
        // 성적 결과 생성해서 출력
        String report = app.gradeReport.getReport();
        System.out.println(report);
    }

    // 과목을 생성하는 메소드
    public void createSubject() {
        korean = new Subject("국어", Define.KOREA);
        math = new Subject("수학", Define.MATH);

        // 학교에 과목 개설
        goodSchool.addSubject(korean);
        goodSchool.addSubject(math);
    }

    // 학생을 생성하는 메소드
    public void createStudent() {
        Student student1 = new Student(181213, "이지은", korean);
        Student student2 = new Student(181518, "장원영", math);
        Student student3 = new Student(171230, "원빈", korean);
        Student student4 = new Student(171255, "하니", korean);
        Student student5 = new Student(171590, "정성찬", math);

        // 학교에 학생 등록
        goodSchool.addStudent(student1);
        goodSchool.addStudent(student2);
        goodSchool.addStudent(student3);
        goodSchool.addStudent(student4);
        goodSchool.addStudent(student5);

        // 수강 신청
        // 국어
        korean.register(student1);
        korean.register(student2);
        korean.register(student3);
        korean.register(student4);
        korean.register(student5);
        // 수학
        math.register(student1);
        math.register(student2);
        math.register(student3);
        math.register(student4);
        math.register(student5);

        // 학생의 과목별 점수 추가
        // 이지은
        addScoreForStudent(student1, korean, 95);
        addScoreForStudent(student1, math, 56);
        // 장원영
        addScoreForStudent(student2, korean, 95);
        addScoreForStudent(student2, math, 98);
        // 원빈
        addScoreForStudent(student3, korean, 100);
        addScoreForStudent(student3, math, 88);
        // 하니
        addScoreForStudent(student4, korean, 89);
        addScoreForStudent(student4, math, 95);
        // 정성찬
        addScoreForStudent(student5, korean, 83);
        addScoreForStudent(student5, math, 56);
    }

    // 학생별로 과목별(국어, 수학) 점수 추가
    public void addScoreForStudent(Student student, Subject subject, int point) {
        Score score = new Score(student.getStudentID(), subject, point);
        student.addSubjectScore(score);
    }
}
