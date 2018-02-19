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
import javax.persistence.Table;

/**
 *
 * @author toshiba
 */
@Entity
@Table(name = "impuesto_descuento")
public class ImpuestoDescuento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "SEC_IMP_DESC", nullable = false)
    private Integer secImpDesc;
    
    @Column(name = "TIPO", nullable = false, length = 3)
    private String tipo;
   
    @Column(name = "COD_DESC_IMP", nullable = false, length=10)
    private String codDescImp;
    
    @Column(name = "DESCRIPCION", nullable = false, length=20)
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
        @Column(name = "PORCENTAJE", nullable = false, precision = 4, scale = 2)
    private BigDecimal porcentaje;
    
    @Column(name = "VALOR", nullable = false, precision = 9, scale = 2)
    private BigDecimal valor;
    
    @JoinColumn(name = "COD_FACTURA", referencedColumnName = "COD_FACTURA", insertable = false, updatable = false)
    @ManyToOne
    private Factura codigo;

    public ImpuestoDescuento() {
    }

    public ImpuestoDescuento(Integer secImpDesc) {
        this.secImpDesc = secImpDesc;
    }

    public Integer getSecImpDesc() {
        return secImpDesc;
    }

    public void setSecImpDesc(Integer secImpDesc) {
        this.secImpDesc = secImpDesc;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodDescImp() {
        return codDescImp;
    }

    public void setCodDescImp(String codDescImp) {
        this.codDescImp = codDescImp;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
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
        hash += (secImpDesc != null ? secImpDesc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImpuestoDescuento)) {
            return false;
        }
        ImpuestoDescuento other = (ImpuestoDescuento) object;
        if ((this.secImpDesc == null && other.secImpDesc != null) || (this.secImpDesc != null && !this.secImpDesc.equals(other.secImpDesc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ImpuestoDescuento{" + "secImpDesc=" + secImpDesc + ", tipo=" + tipo + ", codDescImp=" + codDescImp + ", descripcion=" + descripcion + ", porcentaje=" + porcentaje + ", valor=" + valor + ", codigo=" + codigo + '}';
    }

}
