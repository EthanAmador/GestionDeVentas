package com.gerenciaProyecto.Entites;

import com.gerenciaProyecto.Entites.Control;
import com.gerenciaProyecto.Entites.Producto;
import com.gerenciaProyecto.Entites.Productoventa;
import com.gerenciaProyecto.Entites.Venta;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-20T19:19:04")
@StaticMetamodel(Tienda.class)
public class Tienda_ { 

    public static volatile SingularAttribute<Tienda, Character> estado;
    public static volatile CollectionAttribute<Tienda, Productoventa> productoventaCollection;
    public static volatile CollectionAttribute<Tienda, Venta> ventaCollection;
    public static volatile SingularAttribute<Tienda, Control> idControl;
    public static volatile SingularAttribute<Tienda, String> nit;
    public static volatile SingularAttribute<Tienda, String> direccion;
    public static volatile SingularAttribute<Tienda, Integer> id;
    public static volatile CollectionAttribute<Tienda, Producto> productoCollection;
    public static volatile SingularAttribute<Tienda, String> telefono;
    public static volatile SingularAttribute<Tienda, String> nombres;

}