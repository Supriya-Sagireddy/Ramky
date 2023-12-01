package org.OneToMany;

import javax.persistence.*;
import java.util.List;
@Entity
@Table
public class Teacher {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private int teacher_id;
    private String teacher_name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "sid")
    @OrderColumn(name = "type")
    private List<Student>students;

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    public Teacher(){

    }

}

