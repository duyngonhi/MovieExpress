package vn.framgia.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;
import vn.framgia.bean.FilmBean;
import vn.framgia.service.ICityService;
import vn.framgia.service.IFilmService;
import vn.framgia.ulti.Constant;
import vn.framgia.ulti.Helpers;
import java.util.Date;
import java.util.List;

/**
 * Created by FRAMGIA\duong.van.tien on 12/04/2017.
 */
@Controller
public class FilmController {
    private static final Logger logger = Logger.getLogger(CloneDataController.class);

    @Autowired
    private IFilmService iFilmService;

    @Autowired
    MessageSource messageSource;

    @Autowired
    LocaleResolver localeResolver;


    @RequestMapping(value= Constant.URI_FILMS)
    public String listFilms(Model model, Integer offset, Integer maxResult) {
        try {
            List<FilmBean> listFilmBeans = iFilmService.list(offset, maxResult, "", Helpers.convertDatetoString(new Date()));
            if (listFilmBeans == null) {
                return "index";
            }
            model.addAttribute("listFilmBeans", listFilmBeans);
            model.addAttribute("count", iFilmService.count());
            model.addAttribute("offset", offset);
            return "films";
        } catch (Exception e) {
            logger.error(messageSource.getMessage("controller.error_message", null, null), e);
        }
        return null;
    }

    @RequestMapping(value= Constant.URI_FILMS+"/{cityName}")
    public String findFilmByName(Model model, Integer offset, Integer maxResult,
        @PathVariable(value = "cityName") String cityName) {
        try {
            List<FilmBean> listFilmBeans = iFilmService.list(offset, maxResult, cityName, Helpers.convertDatetoString(new Date()));
            model.addAttribute("listFilmBeans", listFilmBeans);
            model.addAttribute("message", "List film of "+cityName+" city");
            return "film";
        } catch (Exception e) {
            logger.error(messageSource.getMessage("controller.error_message", null, null), e);
        }
        return null;
    }
}
