package ipl.meicm.sapsclient.model.entity;


/**
 * <p>
 * This class represents a traced access point
 * </p>
 * 
 * @author jonibatista
 * 
 */
public class AccessPoint {
	private String bssid;
	private int rssi;
	private String ssid;
	private int scanNumber;
	
	public AccessPoint(){
		this.scanNumber = 0;
	}

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
		this.scanNumber = 1;
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
		this.scanNumber = ap.getScanNumber();
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

	public int getScanNumber() {
		return scanNumber;
	}

	public void setScanNumber(int scanNumber) {
		this.scanNumber = scanNumber;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof AccessPoint))
			return false;
		if (((AccessPoint) obj).getBssid().equals(bssid))
			return true;

		return false;
	}
}
