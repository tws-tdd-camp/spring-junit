package demo;

import demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private List<Student> students;

    {
        students.add(new Student("WuYifan", 20));
        students.add(new Student("LiuXing", 19));
    }

    public List<Student> getAll() {
        return students;
    }
}
