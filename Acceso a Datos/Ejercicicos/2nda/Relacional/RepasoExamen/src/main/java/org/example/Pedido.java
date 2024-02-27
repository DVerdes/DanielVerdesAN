package org.example;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class Pedido implements Serializable {


    private int pedidoId;
    private int clienteId;

    private Date fechaPedido;

    private java.math.BigDecimal total;

    private String estado;

    private Cliente cliente;

    public Pedido() {
    }

    public Pedido(int clienteId, Date fechaPedido, BigDecimal total, String estado) {
        this.clienteId = clienteId;
        this.fechaPedido = fechaPedido;
        this.total = total;
        this.estado = estado;
    }

    public Pedido(int clienteId, Date fechaPedido, BigDecimal total, String estado, Cliente cliente) {
        this.clienteId = clienteId;
        this.fechaPedido = fechaPedido;
        this.total = total;
        this.estado = estado;
        this.cliente = cliente;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

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
                ", clienteId=" + clienteId +
                ", fechaPedido=" + fechaPedido +
                ", total=" + total +
                ", estado='" + estado + '\'' +
                ", cliente=" + cliente +
                '}';
    }
}
