
package com.krakedev.apihibernate.peliculas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.krakedev.apihibernate.peliculas.entidades.Pelicula;
import com.krakedev.apihibernate.peliculas.repository.PeliculaRepository;

@Service
public class ServicioPelicula {

    private final PeliculaRepository repository;

    public ServicioPelicula(PeliculaRepository repository) {
        this.repository = repository;
    }

    // Metodo crear PAelicula con repository
    public Pelicula crear(Pelicula pelicula) {
        return repository.save(pelicula);
    }

    // Metodo listar con repository
    public List<Pelicula> listar() {
        return repository.findAll();
    }

    // Metodo buscar por id de pelicula con repository
    public Pelicula buscarPorId(Long id) {
        Optional<Pelicula> resultado = repository.findById(id);
        return resultado.orElse(null);
    }

    // Metodo actualizar Pelicula con repository
    public Pelicula actualizar(Long id, Pelicula peliculaActualizada) {

        Pelicula pelicula = buscarPorId(id);

        if (pelicula == null) {
            return null;
        }

        pelicula.setNombre(peliculaActualizada.getNombre());
        pelicula.setDirector(peliculaActualizada.getDirector());
        pelicula.setGenero(peliculaActualizada.getGenero());
        pelicula.setDuracion(peliculaActualizada.getDuracion());
        pelicula.setDisponible(peliculaActualizada.isDisponible());

        return repository.save(pelicula);
    }

    // Metodo eliminar con repository
    public boolean eliminar(Long id) {

        Pelicula pelicula = buscarPorId(id);

        if (pelicula == null) {
            return false;
        }

        repository.deleteById(id);
        return true;
    }

    // Metodo buscar por genero con repository
    public List<Pelicula> buscarPorGenero(String genero) {
        return repository.findByGenero(genero);
    }

    // Metodo buscar por disponibilidad con repository
    public List<Pelicula> buscarPorDisponible(boolean disponible) {
        return repository.findByDisponible(disponible);
    }
}
