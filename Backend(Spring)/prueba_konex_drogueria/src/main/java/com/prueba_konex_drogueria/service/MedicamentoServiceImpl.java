// Importaciones de paquetes y clases necesarias
package com.prueba_konex_drogueria.service;

import com.prueba_konex_drogueria.dto.MedicamentoDTO;
import com.prueba_konex_drogueria.entity.Medicamento;
import com.prueba_konex_drogueria.exceptions.global.GlobalDataRequiredException;
import com.prueba_konex_drogueria.exceptions.medicamento.MedicamentoNotFoundNameAndLaboratoryException;
import com.prueba_konex_drogueria.exceptions.medicamento.MedicamentoNotFoundException;
import com.prueba_konex_drogueria.mapper.MedicamentoMapper;
import com.prueba_konex_drogueria.repository.MedicamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

// Anotación para indicar que esta clase es un "Service" (servicio de negocio)
@Service
@AllArgsConstructor
public class MedicamentoServiceImpl implements MedicamentoService {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    // Método para guardar un medicamento en la base de datos
    @Override
    @Transactional
    public MedicamentoDTO saveMedicamento(MedicamentoDTO medicamentoDTO) throws IOException {
        if (Objects.isNull(medicamentoDTO)) {
            throw new GlobalDataRequiredException();
        }
        return MedicamentoMapper.INSTANCE.mapToDto(medicamentoRepository.save(MedicamentoMapper.INSTANCE.DtoToEntity(medicamentoDTO)));
    }

    // Método para obtener un medicamento por su ID
    @Override
    public MedicamentoDTO getMedicamento(Long id) throws IOException {
        Optional<Medicamento> medicamento = medicamentoRepository.findById(id);
        if (!medicamento.isPresent()) {
            throw new MedicamentoNotFoundException(id);
        }
        return MedicamentoMapper.INSTANCE.mapToDto(medicamento.get());
    }

    // Método para obtener un medicamento por su nombre y laboratorio
    @Override
    public MedicamentoDTO getMedicamento(String nombre, String laboratory) throws IOException {
        Optional<Medicamento> medicamento = medicamentoRepository.findByNombreAndLaboratorio(nombre, laboratory);
        if (!medicamento.isPresent()) {
            throw new MedicamentoNotFoundNameAndLaboratoryException(nombre, laboratory);
        }
        return MedicamentoMapper.INSTANCE.mapToDto(medicamento.get());
    }

    // Método para obtener una lista de todos los medicamentos
    @Override
    public List<MedicamentoDTO> getMedicamentos() {
        return MedicamentoMapper.INSTANCE.mapToDto(medicamentoRepository.findAll());
    }

    // Método para eliminar un medicamento por su nombre y laboratorio
    @Override
    @Transactional
    public String deleteMedicamento(String nombre, String laboratory) {
        Optional<Medicamento> medicamento = medicamentoRepository.findByNombreAndLaboratorio(nombre, laboratory);
        if (!medicamento.isPresent()) {
            throw new MedicamentoNotFoundNameAndLaboratoryException(nombre, laboratory);
        }
        medicamento.get().setEstado(medicamento.get().getEstado() == 0 ? 1 : 0);
        medicamentoRepository.save(medicamento.get());
        return "Medicamento eliminado";
    }

    // Método para actualizar un medicamento en la base de datos
    @Override
    @Transactional
    public MedicamentoDTO updateMedicamento(MedicamentoDTO medicamentoDTO) throws IOException {
        Optional<Medicamento> medicamentoExistente = medicamentoRepository.findByNombreAndLaboratorio(medicamentoDTO.getNombre(), medicamentoDTO.getLaboratorio());

        if (!medicamentoExistente.isPresent()) {
            throw new MedicamentoNotFoundNameAndLaboratoryException(medicamentoDTO.getNombre(), medicamentoDTO.getLaboratorio());
        }

        // Actualizar los atributos del medicamento existente con los valores del MedicamentoDTO actualizado
        Medicamento medicamentoActualizado = MedicamentoMapper.INSTANCE.DtoToEntity(medicamentoDTO);
        medicamentoActualizado.setId(medicamentoExistente.get().getId());

        // Guardar los cambios en la base de datos
        return MedicamentoMapper.INSTANCE.mapToDto(medicamentoRepository.save(medicamentoActualizado));
    }
}
