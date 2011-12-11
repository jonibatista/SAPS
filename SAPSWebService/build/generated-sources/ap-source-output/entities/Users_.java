package entities;

import entities.Roles;
import entities.Stores;
import entities.UserTokens;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-12-11T18:54:47")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> status;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, Integer> logins;
    public static volatile SingularAttribute<Users, Integer> failedLoginCount;
    public static volatile CollectionAttribute<Users, Roles> rolesCollection;
    public static volatile SingularAttribute<Users, Date> modified;
    public static volatile SingularAttribute<Users, Integer> id;
    public static volatile SingularAttribute<Users, String> username;
    public static volatile SingularAttribute<Users, Integer> lastLogin;
    public static volatile SingularAttribute<Users, String> resetToken;
    public static volatile CollectionAttribute<Users, Stores> storesCollection;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile SingularAttribute<Users, Date> created;
    public static volatile SingularAttribute<Users, Integer> idStore;
    public static volatile CollectionAttribute<Users, UserTokens> userTokensCollection;
    public static volatile SingularAttribute<Users, Date> lastFailedLogin;

}