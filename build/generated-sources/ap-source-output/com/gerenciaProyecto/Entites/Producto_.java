package com.gerenciaProyecto.Entites;

import com.gerenciaProyecto.Entites.Control;
import com.gerenciaProyecto.Entites.Productoventa;
import com.gerenciaProyecto.Entites.Tienda;
import com.gerenciaProyecto.Entites.Tipoproducto;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-20T19:19:04")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, Character> estado;
    public static volatile CollectionAttribute<Producto, Productoventa> productoventaCollection;
    public static volatile SingularAttribute<Producto, Integer> cantidadproductos;
    public static volatile SingularAttribute<Producto, Integer> iva;
    public static volatile SingularAttribute<Producto, Control> idControl;
    public static volatile SingularAttribute<Producto, BigInteger> preciosVenta;
    public static volatile SingularAttribute<Producto, Tipoproducto> idTipoproducto;
    public static volatile SingularAttribute<Producto, Integer> id;
    public static volatile SingularAttribute<Producto, String> nombre;
    public static volatile SingularAttribute<Producto, Tienda> idTienda;
    public static volatile SingularAttribute<Producto, BigInteger> preciosCompra;

}