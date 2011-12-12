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
@Table(name = "aps")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aps.findAll", query = "SELECT a FROM Aps a"),
    @NamedQuery(name = "Aps.findByBssid", query = "SELECT a FROM Aps a WHERE a.bssid = :bssid"),
    @NamedQuery(name = "Aps.findByApmac", query = "SELECT a FROM Aps a WHERE a.apmac = :apmac"),
    @NamedQuery(name = "Aps.findByPosition", query = "SELECT a FROM Aps a WHERE a.position = :position")})
public class Aps implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "bssid")
    private String bssid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apmac")
    private String apmac;
    @Size(max = 255)
    @Column(name = "position")
    private String position;

    public Aps() {
    }

    public Aps(String bssid) {
        this.bssid = bssid;
    }

    public Aps(String idbssida, String apmac) {
        this.bssid = bssid;
        this.apmac = apmac;
    }

    public String getBssid() {
        return bssid;
    }

    public void setBssid(String bssid) {
        this.bssid = bssid;
    }

    public String getApmac() {
        return apmac;
    }

    public void setApmac(String apmac) {
        this.apmac = apmac;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bssid != null ? bssid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aps)) {
            return false;
        }
        Aps other = (Aps) object;
        if ((this.bssid == null && other.bssid != null) || (this.bssid != null && !this.bssid.equals(other.bssid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Aps[ ida=" + bssid + " ]";
    }
    
}
