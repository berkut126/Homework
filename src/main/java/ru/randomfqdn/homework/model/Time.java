package ru.randomfqdn.homework.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TIMETABLE")
public class Time implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "DAY")
    private String day;

    @Column(name = "TIME")
    @Temporal(TemporalType.TIME)
    private Date time;

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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
