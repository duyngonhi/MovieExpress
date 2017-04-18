package vn.framgia.bean;

import vn.framgia.model.Film;

import javax.persistence.Column;

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
