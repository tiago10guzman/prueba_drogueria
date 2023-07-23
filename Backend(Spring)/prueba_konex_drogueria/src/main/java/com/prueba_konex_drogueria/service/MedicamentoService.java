// Importaciones de paquetes y clases necesarias
package com.prueba_konex_drogueria.service;

import com.prueba_konex_drogueria.dto.MedicamentoDTO;

import java.io.IOException;
import java.util.List;

// Interfaz que define los servicios relacionados con la entidad "Medicamento"
public interface MedicamentoService {

    // Método para guardar un medicamento en la base de datos
    MedicamentoDTO saveMedicamento(MedicamentoDTO medicamento) throws IOException;

    // Método para obtener un medicamento por su ID
    MedicamentoDTO getMedicamento(Long id) throws IOException;

    // Método para obtener un medicamento por su nombre y laboratorio
    MedicamentoDTO getMedicamento(String name, String laboratory) throws IOException;

    // Método para obtener una lista de todos los medicamentos
    List<MedicamentoDTO> getMedicamentos();

    // Método para eliminar un medicamento por su nombre y laboratorio
    String deleteMedicamento(String name, String laboratory) throws IOException;

    // Método para actualizar un medicamento en la base de datos
    MedicamentoDTO updateMedicamento(MedicamentoDTO medicamentoDTO) throws IOException;

}
