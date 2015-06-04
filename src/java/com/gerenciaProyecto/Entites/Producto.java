/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciaProyecto.Entites;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Agandio
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findById", query = "SELECT p FROM Producto p WHERE p.id = :id"),
    @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Producto.findByCantidadproductos", query = "SELECT p FROM Producto p WHERE p.cantidadproductos = :cantidadproductos"),
    @NamedQuery(name = "Producto.findByPreciosCompra", query = "SELECT p FROM Producto p WHERE p.preciosCompra = :preciosCompra"),
    @NamedQuery(name = "Producto.findByPreciosVenta", query = "SELECT p FROM Producto p WHERE p.preciosVenta = :preciosVenta"),
    @NamedQuery(name = "Producto.findByIva", query = "SELECT p FROM Producto p WHERE p.iva = :iva"),
    @NamedQuery(name = "Producto.findByEstado", query = "SELECT p FROM Producto p WHERE p.estado = :estado")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "cantidadproductos")
    private int cantidadproductos;
    @Basic(optional = false)
    @Column(name = "precios_compra")
    private BigInteger preciosCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precios_venta")
    private BigInteger preciosVenta;
    @Basic(optional = false)
    @Column(name = "iva")
    private int iva;
    @Basic(optional = false)
    @Column(name = "estado")
    private Character estado;
//    @OneToMany(mappedBy = "idProducto")
//    private Collection<Productoventa> productoventaCollection;
    @JoinColumn(name = "id_control", referencedColumnName = "id")
    @ManyToOne
    private Control idControl;
    @JoinColumn(name = "id_tienda", referencedColumnName = "id")
    @ManyToOne
    private Tienda idTienda;
    @JoinColumn(name = "id_tipoproducto", referencedColumnName = "id")
    @ManyToOne
    private Tipoproducto idTipoproducto;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;

    public enum ESTADOS {

        ACTIVO('A'), INACTIVO('I');
        public final Character estado;

        ESTADOS(Character estado) {
            this.estado = estado;
        }

        public Character getEstado() {
            return estado;
        }
    }

    public Producto() {
    }

    public Producto(Integer id) {
        this.id = id;
    }

    public Producto(Integer id, String nombre, int cantidadproductos, BigInteger preciosCompra, BigInteger preciosVenta, int iva, Character estado) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadproductos = cantidadproductos;
        this.preciosCompra = preciosCompra;
        this.preciosVenta = preciosVenta;
        this.iva = iva;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadproductos() {
        return cantidadproductos;
    }

    public void setCantidadproductos(int cantidadproductos) {
        this.cantidadproductos = cantidadproductos;
    }

    public BigInteger getPreciosCompra() {
        return preciosCompra;
    }

    public void setPreciosCompra(BigInteger preciosCompra) {
        this.preciosCompra = preciosCompra;
    }

    public BigInteger getPreciosVenta() {
        return preciosVenta;
    }

    public void setPreciosVenta(BigInteger preciosVenta) {
        this.preciosVenta = preciosVenta;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

//    @XmlTransient
//    public Collection<Productoventa> getProductoventaCollection() {
//        return productoventaCollection;
//    }
//
//    public void setProductoventaCollection(Collection<Productoventa> productoventaCollection) {
//        this.productoventaCollection = productoventaCollection;
//    }

    public Control getIdControl() {
        return idControl;
    }

    public void setIdControl(Control idControl) {
        this.idControl = idControl;
    }

    public Tienda getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(Tienda idTienda) {
        this.idTienda = idTienda;
    }

    public Tipoproducto getIdTipoproducto() {
        return idTipoproducto;
    }

    public void setIdTipoproducto(Tipoproducto idTipoproducto) {
        this.idTipoproducto = idTipoproducto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Gerencia_Proyecto.Entites.Producto[ id=" + id + " ]";
    }

}
