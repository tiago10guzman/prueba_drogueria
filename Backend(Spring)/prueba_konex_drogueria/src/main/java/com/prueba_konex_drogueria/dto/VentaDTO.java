package com.prueba_konex_drogueria.dto;

// Importaciones de clases necesarias

import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

// Anotaciones de Lombok para generar constructores, getters, setters, equals y hashCode
@Builder
public class VentaDTO {

    // Atributo con anotación para especificar el formato de la fecha
    @DateTimeFormat(pattern ="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private LocalDateTime fecha;

    // Atributo que representa el medicamento vendido (un objeto MedicamentoDTO)
    private MedicamentoDTO medicamento;

    // Atributo para la cantidad de medicamentos vendidos
    private Integer cantidad;

    // Atributo para el valor unitario de un medicamento en la venta
    private BigDecimal valorUnitario;

    // Atributo para el valor total de la venta (cantidad * valorUnitario)
    private BigDecimal valorTotal;

    // Constructor con argumentos para inicializar todos los atributos
    public VentaDTO(LocalDateTime fecha, MedicamentoDTO medicamento, Integer cantidad, BigDecimal valorUnitario, BigDecimal valorTotal) {
        this.fecha = fecha;
        this.medicamento = medicamento;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
    }

    // Constructor sin argumentos
    public VentaDTO() {
    }

    // Método equals para comparar objetos
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VentaDTO ventaDTO = (VentaDTO) o;
        return fecha.equals(ventaDTO.fecha) && medicamento.equals(ventaDTO.medicamento) && cantidad.equals(ventaDTO.cantidad) && valorUnitario.equals(ventaDTO.valorUnitario) && valorTotal.equals(ventaDTO.valorTotal);
    }

    // Método hashCode para generar un código hash del objeto
    @Override
    public int hashCode() {
        return Objects.hash(fecha, medicamento, cantidad, valorUnitario, valorTotal);
    }

    // Getters y Setters para los atributos
    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public MedicamentoDTO getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(MedicamentoDTO medicamento) {
        this.medicamento = medicamento;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
