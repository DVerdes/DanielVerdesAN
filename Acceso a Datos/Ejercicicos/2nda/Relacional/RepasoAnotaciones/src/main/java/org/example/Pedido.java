package org.example;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "Pedidos")
public class Pedido implements Serializable {


    private int pedidoId;

    private Date fechaPedido;

    private BigDecimal total;

    private String estado;

    private Cliente cliente;

    public Pedido() {
    }

    public Pedido( Date fechaPedido, BigDecimal total, String estado) {
        this.fechaPedido = fechaPedido;
        this.total = total;
        this.estado = estado;
    }

    public Pedido(Date fechaPedido, BigDecimal total, String estado, Cliente cliente) {

        this.fechaPedido = fechaPedido;
        this.total = total;
        this.estado = estado;
        this.cliente = cliente;
    }

    @Id
    @Column(name = "PedidoID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }



    @Column(name = "FechaPedido")
    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    @Column(name = "Total")
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Column(name = "Estado")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @ManyToOne
    @JoinColumn(name = "ClienteID", insertable = false, updatable = false)
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "pedidoId=" + pedidoId +

                ", fechaPedido=" + fechaPedido +
                ", total=" + total +
                ", estado='" + estado + '\'' +
                ", cliente=" + cliente +
                '}';
    }
}
