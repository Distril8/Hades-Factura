/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.hades.factura.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author toshiba
 */
@Entity
@Table(name = "factura_detalle")
@NamedQueries({
    @NamedQuery(name = "FacturaDetalle.findAll", query = "SELECT f FROM FacturaDetalle f")})
public class FacturaDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "SEC_DETALLE", nullable = false)
    private Integer secDetalle;
    
    @Column(name = "COD_PRODUCTO", nullable = false,length = 20)
    private String codProducto;
    
    @Column(name = "DESCRIPCION", nullable = false,length = 80)
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  
    @Column(name = "VALOR_UNITARIO", nullable = false, precision = 9, scale = 2 )
    private BigDecimal valorUnitario;
    
    @Column(name = "CANTIDAD", nullable = false)
    private Integer cantidad;
    
    @Column(name = "DESCUENTO",  precision = 9, scale = 2)
    private BigDecimal descuento;
    
    @Column(name = "VALOR_FINAL", nullable = false, precision = 9, scale = 2)
    private BigDecimal valorFinal;
    
    @JoinColumn(name = "COD_FACTURA", referencedColumnName = "COD_FACTURA",insertable = false, updatable = false)
    @ManyToOne
    private Factura codigo;

    public FacturaDetalle() {
    }

    public FacturaDetalle(Integer secDetalle) {
        this.secDetalle = secDetalle;
    }

    public Integer getSecDetalle() {
        return secDetalle;
    }

    public void setSecDetalle(Integer secDetalle) {
        this.secDetalle = secDetalle;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(BigDecimal valorFinal) {
        this.valorFinal = valorFinal;
    }

    public Factura getCodigo() {
        return codigo;
    }

    public void setCodigo(Factura codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secDetalle != null ? secDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaDetalle)) {
            return false;
        }
        FacturaDetalle other = (FacturaDetalle) object;
        if ((this.secDetalle == null && other.secDetalle != null) || (this.secDetalle != null && !this.secDetalle.equals(other.secDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FacturaDetalle{" + "secDetalle=" + secDetalle + ", codProducto=" + codProducto + ", descripcion=" + descripcion + ", valorUnitario=" + valorUnitario + ", cantidad=" + cantidad + ", descuento=" + descuento + ", valorFinal=" + valorFinal + ", codigo=" + codigo + '}';
    }

}
