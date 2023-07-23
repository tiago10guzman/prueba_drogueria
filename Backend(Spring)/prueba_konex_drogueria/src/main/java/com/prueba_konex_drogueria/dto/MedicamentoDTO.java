package com.prueba_konex_drogueria.dto;

// Importaciones de clases necesarias
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Objects;

// Anotaciones de Lombok para generar constructores, getters, setters, equals y hashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicamentoDTO {

    // Atributo con anotaciones de validación
    @NotBlank(message = "Nombre cannot be null")
    @Pattern(regexp = "^[a-zA-Z\\s-]*$", message = "Nombre cannot be null")
    private String nombre;

    // Atributo con anotaciones de validación
    @NotBlank(message = "Laboratorio cannot be null")
    private String laboratorio;

    // Atributo con anotaciones de validación
    @NotBlank(message = "Fecha Fabricacion cannot be null")
    @DateTimeFormat(pattern ="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private LocalDateTime fechaFabricacion;

    // Atributo con anotaciones de validación
    @NotBlank(message = "Fecha Vencimiento cannot be null")
    @DateTimeFormat(pattern ="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private LocalDateTime fechaVencimiento;

    // Atributo con anotaciones de validación
    @Min(value = 1, message = "La cantidad mínima permitida es 1")
    private Integer cantidadStock;

    // Atributo con anotaciones de validación
    @PositiveOrZero(message = "El valor debe ser positivo o cero")
    private Double valorUnitario;

    // Atributo con anotaciones de validación
    @NotBlank(message = "Laboratorio cannot be null")
    private Integer estado;



    // Método equals para comparar objetos
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicamentoDTO that = (MedicamentoDTO) o;
        return nombre.equals(that.nombre) && laboratorio.equals(that.laboratorio) && fechaFabricacion.equals(that.fechaFabricacion) && fechaVencimiento.equals(that.fechaVencimiento) && cantidadStock.equals(that.cantidadStock) && valorUnitario.equals(that.valorUnitario) && estado.equals(that.estado);
    }

    // Método hashCode para generar un código hash del objeto
    @Override
    public int hashCode() {
        return Objects.hash(nombre, laboratorio, fechaFabricacion, fechaVencimiento, cantidadStock, valorUnitario, estado);
    }

    // Getters y Setters para los atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public LocalDateTime getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(LocalDateTime fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public LocalDateTime getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDateTime fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
