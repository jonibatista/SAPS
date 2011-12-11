package entities;

import entities.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-12-11T18:54:47")
@StaticMetamodel(Roles.class)
public class Roles_ { 

    public static volatile SingularAttribute<Roles, Integer> id;
    public static volatile SingularAttribute<Roles, String> description;
    public static volatile SingularAttribute<Roles, String> name;
    public static volatile CollectionAttribute<Roles, Users> usersCollection;

}