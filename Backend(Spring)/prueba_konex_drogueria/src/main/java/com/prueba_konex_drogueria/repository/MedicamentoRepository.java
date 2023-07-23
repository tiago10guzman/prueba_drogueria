// Importaciones de paquetes y clases necesarias
package com.prueba_konex_drogueria.repository;

import com.prueba_konex_drogueria.entity.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Anotación para indicar que esta interfaz es un "Repository" (repositorio de acceso a datos)
@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

    // Método para buscar un medicamento por nombre y laboratorio
    // La implementación de este método será proporcionada automáticamente por Spring Data JPA
    Optional<Medicamento> findByNombreAndLaboratorio(String name, String laboratory);
}
