package entities;

import entities.Advertisments;
import entities.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-12-11T18:54:47")
@StaticMetamodel(Stores.class)
public class Stores_ { 

    public static volatile SingularAttribute<Stores, String> address;
    public static volatile CollectionAttribute<Stores, Advertisments> advertismentsCollection;
    public static volatile SingularAttribute<Stores, Integer> ids;
    public static volatile CollectionAttribute<Stores, Users> usersCollection;
    public static volatile SingularAttribute<Stores, String> imagec;
    public static volatile SingularAttribute<Stores, String> namest;
    public static volatile SingularAttribute<Stores, byte[]> image;
    public static volatile SingularAttribute<Stores, String> info;

}