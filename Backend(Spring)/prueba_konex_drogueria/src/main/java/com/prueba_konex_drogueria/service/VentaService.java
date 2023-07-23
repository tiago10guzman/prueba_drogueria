// Importaciones de paquetes y clases necesarias
package com.prueba_konex_drogueria.service;

import com.prueba_konex_drogueria.dto.VentaDTO;
import java.io.IOException;
import java.util.List;

// Interfaz que define los servicios relacionados con la entidad "Venta"
public interface VentaService {

     // Método para guardar una venta en la base de datos
     VentaDTO saveVenta(VentaDTO ventaDTO) throws IOException;

     // Método para obtener una lista de todas las ventas almacenadas en la base de datos
     List<VentaDTO> getVentas();
}
