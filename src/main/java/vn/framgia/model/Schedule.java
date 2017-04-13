package vn.framgia.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by FRAMGIA\duong.van.tien on 10/04/2017.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "tblSchedule")
public class Schedule implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "day")
    private String day;

    @Column(name = "time")
    private String time;

    @ManyToOne()
    @JoinColumn(name = "filmId")
    private Film film;

    public Schedule() {
    }

    public Schedule(String day, String time, Film film) {
        this.day = day;
        this.time = time;
        this.film = film;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
