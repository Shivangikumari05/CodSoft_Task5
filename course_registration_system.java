import java.util.ArrayList;
import java.util.List;

class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private List<Student> registeredStudents;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.registeredStudents = new ArrayList<>();
    }

    public boolean registerStudent(Student student) {
        if (registeredStudents.size() < capacity) {
            registeredStudents.add(student);
            student.registerCourse(this);
            return true;
        }
        return false;
    }

    public boolean dropStudent(Student student) {
        if (registeredStudents.contains(student)) {
            registeredStudents.remove(student);
            student.dropCourse(this);
            return true;
        }
        return false;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getNumRegisteredStudents() {
        return registeredStudents.size();
    }

    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", title='" + title + '\'' +
                ", capacity=" + capacity +
                ", numRegisteredStudents=" + registeredStudents.size() +
                '}';
    }
}

class Student {
    private String studentId;
    private String name;
    private List<Course> registeredCourses;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public boolean registerCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            registeredCourses.add(course);
            course.registerStudent(this);
            return true;
        }
        return false;
    }

    public boolean dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.dropStudent(this);
            return true;
        }
        return false;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

  
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", registeredCourses=" + registeredCourses +
                '}';
    }
}
public class course_registration_system {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// creating courses
        Course course1 = new Course("CS101", "Introduction to Computer Science", "Learn the basics of computer science", 40, "MW 9:00-10:30");
        Course course2 = new Course("MATH101", "Calculus I", "Learn single-variable calculus", 80, "TR 11:00-12:30");
        Course course3 = new Course("HINDI101", "Hindi Composition II", "Learn to write college-level essays", 45, "T 1:00-2:30");

        // display the course list
        System.out.println("Available Courses:");
        System.out.println(course1);
        System.out.println(course2);
        System.out.println(course3);

	}

}
