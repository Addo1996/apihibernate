
package com.krakedev.apihibernate.peliculas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krakedev.apihibernate.peliculas.entidades.Pelicula;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

    List<Pelicula> findByGenero(String genero);

    List<Pelicula> findByDisponible(boolean disponible);

}
