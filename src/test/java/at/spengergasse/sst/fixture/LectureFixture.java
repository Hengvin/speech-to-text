package at.spengergasse.sst.fixture;


import at.spengergasse.sst.domain.Lecture;

public class LectureFixture {
    public static final String STUDENT_ID = "student-Id";
    public static final String TEACHER = "Schrutek";
    public static final String SUBJECT = "C#";

    public static Lecture createLecture() {

        return new Lecture (STUDENT_ID, TEACHER, SUBJECT);
    }
}