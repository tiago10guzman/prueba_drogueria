// Importaciones de paquetes y clases necesarias
package com.prueba_konex_drogueria.mapper;

import com.prueba_konex_drogueria.dto.MedicamentoDTO;
import com.prueba_konex_drogueria.entity.Medicamento;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

// Anotación para indicar que esta interfaz es un "Mapper"
@Mapper
public interface MedicamentoMapper {

    // Creación de una instancia del Mapper utilizando el método estático de la clase Mappers.getMapper
    MedicamentoMapper INSTANCE = Mappers.getMapper(MedicamentoMapper.class);

    // Método para convertir un objeto MedicamentoDTO en un objeto Medicamento
    Medicamento DtoToEntity(MedicamentoDTO medicamentoDTO);

    // Método para convertir un objeto Medicamento en un objeto MedicamentoDTO
    MedicamentoDTO mapToDto(Medicamento medicamento);

    // Método para convertir una lista de objetos Medicamento en una lista de objetos MedicamentoDTO
    List<MedicamentoDTO> mapToDto(List<Medicamento> medicamentos);
}
