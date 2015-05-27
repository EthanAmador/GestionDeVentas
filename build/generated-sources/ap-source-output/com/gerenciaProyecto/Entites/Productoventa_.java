package com.gerenciaProyecto.Entites;

import com.gerenciaProyecto.Entites.Producto;
import com.gerenciaProyecto.Entites.Tienda;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-20T19:19:04")
@StaticMetamodel(Productoventa.class)
public class Productoventa_ { 

    public static volatile SingularAttribute<Productoventa, Character> estado;
    public static volatile SingularAttribute<Productoventa, Integer> id;
    public static volatile SingularAttribute<Productoventa, Producto> idProducto;
    public static volatile SingularAttribute<Productoventa, Tienda> idTienda;

}