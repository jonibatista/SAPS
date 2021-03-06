package entities;

import java.io.Serializable;


/**
 * <p>
 * This class represents a traced access point
 * </p>
 * 
 * @author jonibatista
 * 
 */
public class AccessPoint implements Serializable {

    private static final long serialVersionUID = 1L;
    private String bssid;
    private int rssi;
    private String ssid;

    /**
     * 
     * @param bssid
     *            device mac address
     * @param rssi
     *            signal strength (dBm)
     * @param ssid
     *            network identifier
     */
    public AccessPoint(String bssid, int rssi, String ssid) {
        super();
        this.bssid = bssid;
        this.rssi = rssi;
        this.ssid = ssid;
    }

    /**
     * <p>
     * Like a clone() method
     * </p>
     * 
     * @param ap
     *            AccessPoint object that will be cloned
     */
    public AccessPoint(AccessPoint ap) {
        super();
        this.bssid = ap.getBssid();
        this.rssi = ap.getRssi();
        this.ssid = ap.getSsid();
    }

    public String getBssid() {
        return bssid;
    }

    public void setBssid(String bssid) {
        this.bssid = bssid;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public int getRssi() {
        return rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessPoint)) {
            return false;
        }
        if (((AccessPoint) obj).getBssid().equals(bssid)) {
            return true;
        }

        return false;
    }
}