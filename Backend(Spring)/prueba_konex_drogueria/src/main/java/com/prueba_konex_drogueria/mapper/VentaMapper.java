// Importaciones de paquetes y clases necesarias
package com.prueba_konex_drogueria.mapper;

import com.prueba_konex_drogueria.dto.VentaDTO;
import com.prueba_konex_drogueria.entity.Venta;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

// Anotación para indicar que esta interfaz es un "Mapper"
@Mapper
public interface VentaMapper {

    // Creación de una instancia del Mapper utilizando el método estático de la clase Mappers.getMapper
    VentaMapper INSTANCE = Mappers.getMapper(VentaMapper.class);

    // Método para convertir un objeto VentaDTO en un objeto Venta
    Venta DtoToEntity(VentaDTO ventaDTO);

    // Método para convertir un objeto Venta en un objeto VentaDTO
    VentaDTO mapToDto(Venta venta);

    // Método para convertir una lista de objetos Venta en una lista de objetos VentaDTO
    List<VentaDTO> mapToDto(List<Venta> ventas);
}
