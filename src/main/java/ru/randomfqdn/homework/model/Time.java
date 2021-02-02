package ru.randomfqdn.homework.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Table(name = "TIMETABLE")
public class Time implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "DAY")
    private String day;

    @Column(name = "TIME", columnDefinition = "TIME")
    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "LESSON")
    private Lesson lesson;

    public Time() {
        // Required by the JPA
    }

    @Override
    public String toString() {
        return "Time{" +
                "id=" + id +
                ", day='" + day + '\'' +
                ", time=" + time +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
