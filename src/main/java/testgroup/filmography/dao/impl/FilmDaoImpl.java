package testgroup.filmography.dao.impl;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import testgroup.filmography.dao.FilmDao;
import testgroup.filmography.model.Film;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class FilmDaoImpl implements FilmDao {
    private SessionFactory sessionFactory;
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer, Film> films = new HashMap<>();

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Film> allFilms() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Film").list();
    }

    @Override
    public void add(Film film) {
//        film.setId(AUTO_ID.getAndIncrement());
        films.put(film.getId(), film);
    }

    @Override
    public void edit(Film film) {
        films.put(film.getId(), film);
    }

    @Override
    public void delete(Film film) {
        films.remove(film.getId());
    }

    @Override
    public Film getById(int id) {
        return films.get(id);
    }
}
