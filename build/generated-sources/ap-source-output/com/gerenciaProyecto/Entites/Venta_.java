package com.gerenciaProyecto.Entites;

import com.gerenciaProyecto.Entites.Control;
import com.gerenciaProyecto.Entites.Tienda;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-20T19:19:04")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, String> numVenta;
    public static volatile SingularAttribute<Venta, String> horaVenta;
    public static volatile SingularAttribute<Venta, Character> estado;
    public static volatile SingularAttribute<Venta, Integer> cantidadproductos;
    public static volatile SingularAttribute<Venta, Control> idControl;
    public static volatile SingularAttribute<Venta, Integer> id;
    public static volatile SingularAttribute<Venta, Tienda> idTienda;
    public static volatile SingularAttribute<Venta, String> fechaVenta;

}