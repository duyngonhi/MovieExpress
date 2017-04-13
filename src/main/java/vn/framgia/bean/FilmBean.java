package vn.framgia.bean;

import vn.framgia.model.Film;
import vn.framgia.model.Schedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by FRAMGIA\duong.van.tien on 10/04/2017.
 */
public class FilmBean {

    private Integer id;
    private String filmName;
    private String image;
    private Integer ratting;
    private String cinemaName;
    private String cityName;
    private String day;
    private String time;
    private List<String> schedules = new ArrayList<String>();

    public FilmBean() {
    }

    public FilmBean(Integer id, String filmName, String image, Integer ratting,
                    String cinemaName, String cityName) {
        this.id = id;
        this.filmName = filmName;
        this.image = image;
        this.ratting = ratting;
        this.cinemaName = cinemaName;
        this.cityName = cityName;
    }

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

    public List<String> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<String> schedules) {
        this.schedules = schedules;
    }

    public void addSchedule(String schedule) {
        this.schedules.add(schedule);
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

    public Film convertToFilm(FilmBean filmBean) {
        Film film = new Film();
        film.setFilmName(filmBean.getFilmName());
        film.setImage(filmBean.getImage());
        film.setRatting(filmBean.getRatting());
        film.setCinemaName(filmBean.getCinemaName());
        film.setCityName(filmBean.getCityName());
        return film;
    }
}
