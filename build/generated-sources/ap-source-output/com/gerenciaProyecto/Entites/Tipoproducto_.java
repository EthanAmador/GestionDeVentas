package com.gerenciaProyecto.Entites;

import com.gerenciaProyecto.Entites.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-20T19:19:04")
@StaticMetamodel(Tipoproducto.class)
public class Tipoproducto_ { 

    public static volatile SingularAttribute<Tipoproducto, Character> estado;
    public static volatile SingularAttribute<Tipoproducto, Integer> id;
    public static volatile CollectionAttribute<Tipoproducto, Producto> productoCollection;
    public static volatile SingularAttribute<Tipoproducto, String> nombre;

}