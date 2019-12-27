package testgroup.filmography.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import testgroup.filmography.dao.impl.FilmDaoImpl;
import testgroup.filmography.model.Film;
import testgroup.filmography.service.FilmService;
import testgroup.filmography.service.impl.FilmServiceImpl;

import java.util.List;

@Controller
public class FilmController {
    private FilmService filmService;

    @Autowired
    public void setFilmService(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/")
    public String allFilms(Model model) {
        List<Film> films = new FilmServiceImpl(new FilmDaoImpl()).allFilms();
        model.addAttribute("filmsList", films);
        return "films";
    }

    @GetMapping("/edit")
    public String editPage(Model model) {
        return "editPate";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable("id") int id, Model model) {
        Film film = filmService.getById(id);
        model.addAttribute("film", film);
        return "editPage";
    }

    @PostMapping("/edit")
    public String editFilm(@ModelAttribute("film") Film film) {
        filmService.edit(film);
        return "redirect:/";
    }

    @GetMapping("/add")
    public String addPage(Model model) {
        return "editPage";
    }

    @PostMapping("/add")
    public String addFilm(@ModelAttribute("film") Film film) {
        filmService.add(film);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletePage(@PathVariable("id") int id, Model model) {
        Film film = filmService.getById(id);
        filmService.delete(film);
        return "redirect:/";
    }
}
