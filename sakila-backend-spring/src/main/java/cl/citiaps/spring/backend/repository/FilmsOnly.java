package cl.citiaps.spring.backend.repository;

import java.util.Set;

import cl.citiaps.spring.backend.entities.Actor;
import cl.citiaps.spring.backend.entities.Film;

public interface FilmsOnly {
	Film getFilm();
}
