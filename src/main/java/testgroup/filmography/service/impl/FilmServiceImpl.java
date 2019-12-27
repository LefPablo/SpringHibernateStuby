package testgroup.filmography.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testgroup.filmography.dao.FilmDao;
import testgroup.filmography.model.Film;
import testgroup.filmography.service.FilmService;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {
    private FilmDao filmDao;

    public FilmServiceImpl() {
    }

    @Autowired
    public FilmServiceImpl(FilmDao filmDao) {
        this.filmDao = filmDao;
    }

    @Transactional
    @Override
    public List<Film> allFilms() {
        return filmDao.allFilms();
    }

    @Override
    public void add(Film film) {
        filmDao.add(film);
    }

    @Override
    public void delete(Film film) {
        filmDao.delete(film);
    }

    @Override
    public void edit(Film film) {
        filmDao.edit(film);
    }

    @Override
    public Film getById(int id) {
        return filmDao.getById(id);
    }
}
