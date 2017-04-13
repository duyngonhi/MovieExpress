package vn.framgia.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by FRAMGIA\duong.van.tien on 10/04/2017.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "tblFilm")
public class Film implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "filmName")
    private String filmName;

    @Column(name = "image")
    private String image;

    @Column(name = "ratting")
    private Integer ratting;

    @Column(name = "cinemaName")
    private String cinemaName;

    @Column(name = "cityName")
    private String cityName;

    @OneToMany
    private Set<Schedule> schedule;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getRatting() {
        return ratting;
    }

    public void setRatting(Integer ratting) {
        this.ratting = ratting;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Set<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(Set<Schedule> schedule) {
        this.schedule = schedule;
    }
}
