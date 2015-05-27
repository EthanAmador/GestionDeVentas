package com.gerenciaProyecto.Entites;

import com.gerenciaProyecto.Entites.Producto;
import com.gerenciaProyecto.Entites.Tienda;
import com.gerenciaProyecto.Entites.Usuario;
import com.gerenciaProyecto.Entites.Venta;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-20T19:19:04")
@StaticMetamodel(Control.class)
public class Control_ { 

    public static volatile SingularAttribute<Control, String> fechaIngreso;
    public static volatile CollectionAttribute<Control, Tienda> tiendaCollection;
    public static volatile SingularAttribute<Control, Character> estado;
    public static volatile CollectionAttribute<Control, Venta> ventaCollection;
    public static volatile SingularAttribute<Control, Integer> id;
    public static volatile CollectionAttribute<Control, Producto> productoCollection;
    public static volatile CollectionAttribute<Control, Usuario> usuarioCollection;
    public static volatile SingularAttribute<Control, String> fechaFin;
    public static volatile SingularAttribute<Control, String> nombres;

}