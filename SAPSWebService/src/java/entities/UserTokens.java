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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "user_tokens")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserTokens.findAll", query = "SELECT u FROM UserTokens u"),
    @NamedQuery(name = "UserTokens.findById", query = "SELECT u FROM UserTokens u WHERE u.id = :id"),
    @NamedQuery(name = "UserTokens.findByUserAgent", query = "SELECT u FROM UserTokens u WHERE u.userAgent = :userAgent"),
    @NamedQuery(name = "UserTokens.findByToken", query = "SELECT u FROM UserTokens u WHERE u.token = :token"),
    @NamedQuery(name = "UserTokens.findByCreated", query = "SELECT u FROM UserTokens u WHERE u.created = :created"),
    @NamedQuery(name = "UserTokens.findByExpires", query = "SELECT u FROM UserTokens u WHERE u.expires = :expires")})
public class UserTokens implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "user_agent")
    private String userAgent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "token")
    private String token;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created")
    private int created;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expires")
    private int expires;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users userId;

    public UserTokens() {
    }

    public UserTokens(Integer id) {
        this.id = id;
    }

    public UserTokens(Integer id, String userAgent, String token, int created, int expires) {
        this.id = id;
        this.userAgent = userAgent;
        this.token = token;
        this.created = created;
        this.expires = expires;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public int getExpires() {
        return expires;
    }

    public void setExpires(int expires) {
        this.expires = expires;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
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
        if (!(object instanceof UserTokens)) {
            return false;
        }
        UserTokens other = (UserTokens) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserTokens[ id=" + id + " ]";
    }
    
}
