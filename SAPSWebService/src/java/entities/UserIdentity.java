/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cesar
 */
@Entity
@Table(name = "user_identity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserIdentity.findAll", query = "SELECT u FROM UserIdentity u"),
    @NamedQuery(name = "UserIdentity.findById", query = "SELECT u FROM UserIdentity u WHERE u.id = :id"),
    @NamedQuery(name = "UserIdentity.findByUserId", query = "SELECT u FROM UserIdentity u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserIdentity.findByProvider", query = "SELECT u FROM UserIdentity u WHERE u.provider = :provider"),
    @NamedQuery(name = "UserIdentity.findByIdentity", query = "SELECT u FROM UserIdentity u WHERE u.identity = :identity")})
public class UserIdentity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "provider")
    private String provider;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "identity")
    private String identity;

    public UserIdentity() {
    }

    public UserIdentity(Integer id) {
        this.id = id;
    }

    public UserIdentity(Integer id, int userId, String provider, String identity) {
        this.id = id;
        this.userId = userId;
        this.provider = provider;
        this.identity = identity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserIdentity)) {
            return false;
        }
        UserIdentity other = (UserIdentity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserIdentity[ id=" + id + " ]";
    }
    
}
