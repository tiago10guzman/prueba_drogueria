// Importaciones de paquetes y clases necesarias
package com.prueba_konex_drogueria.service;

import com.prueba_konex_drogueria.dto.VentaDTO;
import com.prueba_konex_drogueria.entity.Medicamento;
import com.prueba_konex_drogueria.entity.Venta;
import com.prueba_konex_drogueria.exceptions.medicamento.MedicamentoNotFoundNameAndLaboratoryException;
import com.prueba_konex_drogueria.mapper.VentaMapper;
import com.prueba_konex_drogueria.repository.MedicamentoRepository;
import com.prueba_konex_drogueria.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

// Anotación para indicar que esta clase es un "Service" (servicio de negocio)
@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    // Método para guardar una venta en la base de datos
    @Override
    public VentaDTO saveVenta(VentaDTO ventaDTO) throws IOException {
        // Buscar el medicamento asociado a la venta por su nombre y laboratorio
        Optional<Medicamento> medicamento = medicamentoRepository.findByNombreAndLaboratorio(
                ventaDTO.getMedicamento().getNombre(), ventaDTO.getMedicamento().getLaboratorio());

        if (!medicamento.isPresent()) {
            throw new MedicamentoNotFoundNameAndLaboratoryException(
                    ventaDTO.getMedicamento().getNombre(), ventaDTO.getMedicamento().getLaboratorio());
        }

        // Reducir la cantidad de stock del medicamento según la cantidad vendida
        medicamento.get().setCantidadStock(medicamento.get().getCantidadStock() - ventaDTO.getCantidad());
        medicamentoRepository.save(medicamento.get());

        // Crear una nueva venta y asignarle el medicamento asociado
        Venta venta = VentaMapper.INSTANCE.DtoToEntity(ventaDTO);
        venta.setMedicamento(medicamento.get());
        ventaRepository.save(venta);

        return ventaDTO;
    }

    // Método para obtener una lista de todas las ventas almacenadas en la base de datos
    @Override
    public List<VentaDTO> getVentas() {
        return VentaMapper.INSTANCE.mapToDto(ventaRepository.findAll());
    }
}
