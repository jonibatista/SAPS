package entities;

import entities.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-12-11T18:54:47")
@StaticMetamodel(UserTokens.class)
public class UserTokens_ { 

    public static volatile SingularAttribute<UserTokens, Integer> id;
    public static volatile SingularAttribute<UserTokens, Integer> expires;
    public static volatile SingularAttribute<UserTokens, String> userAgent;
    public static volatile SingularAttribute<UserTokens, String> token;
    public static volatile SingularAttribute<UserTokens, Integer> created;
    public static volatile SingularAttribute<UserTokens, Users> userId;

}