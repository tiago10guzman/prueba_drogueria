// Importaciones de paquetes y clases necesarias
package com.prueba_konex_drogueria.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

// Anotaciones de Lombok para generar automáticamente constructores, métodos getters y setters, y otros métodos útiles
@Builder
@Data
@Entity

// Anotación para especificar el nombre de la tabla en la base de datos a la que se mapeará esta entidad
@Table(name = "ventas")
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;

    // Identificador único de la venta, se generará automáticamente al guardar el objeto en la base de datos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Fecha de la venta en formato LocalDateTime
    @Column(name = "fecha")
    @DateTimeFormat(pattern ="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private LocalDateTime fecha;

    // Relación ManyToOne con la entidad "Medicamento", es decir, una venta pertenece a un medicamento específico
    @ManyToOne
    @JoinColumn(name = "medicamento_id")
    private Medicamento medicamento;

    // Cantidad de medicamentos vendidos en esta venta
    @Column(name = "cantidad")
    private Integer cantidad;

    // Valor unitario del medicamento en esta venta
    @Column(name = "valor_unitario", columnDefinition = "NUMBER")
    private BigDecimal valorUnitario;

    // Valor total de la venta (valor_unitario * cantidad)
    @Column(name = "valor_total", columnDefinition = "NUMBER")
    private BigDecimal valorTotal;

    // Constructor vacío necesario para JPA
    public Venta() {
    }

    // Constructor con todos los campos, excepto el ID, que se generará automáticamente
    public Venta(Long id, LocalDateTime fecha, Medicamento medicamento, Integer cantidad, BigDecimal valorUnitario, BigDecimal valorTotal) {
        this.id = id;
        this.fecha = fecha;
        this.medicamento = medicamento;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
    }

    // Implementación de equals y hashCode para comparar objetos de la clase Venta correctamente

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Venta venta = (Venta) o;
        return id != null && Objects.equals(id, venta.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    // Métodos getters y setters para acceder a los campos de la entidad

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
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
