package org.example;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "student")
public class Student {
    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", courses=" + courses +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String name ;
@OneToMany(mappedBy = "student",cascade = CascadeType.ALL,orphanRemoval = true)
    private Collection <Courses> courses = new ArrayList<Courses>();

    public Collection<Courses> getCourses() {
        return courses;
    }

    public void setCourses(Collection<Courses> courses) {
        this.courses = courses;
    }

    public void addCourse(Courses c){
        courses.add(c);
        c.setStudent(this);

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
