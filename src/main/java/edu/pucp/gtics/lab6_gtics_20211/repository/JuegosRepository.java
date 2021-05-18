package edu.pucp.gtics.lab6_gtics_20211.repository;

import edu.pucp.gtics.lab6_gtics_20211.entity.Juegos;
import edu.pucp.gtics.lab6_gtics_20211.entity.JuegosUserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository

public interface JuegosRepository extends JpaRepository<Juegos,Integer> {
    @Query(value = "Select j.idjuego, j.nombre, j.descripcion, j.image, j.idgenero \n" +
            "from juegos j, juegosxusuario ju \n" +
            "where j.idjuego=ju.idjuego and ju.idusuario= ?",nativeQuery = true)
    List<JuegosUserDto> obtenerJuegosPorUser(int idusuario);
}
