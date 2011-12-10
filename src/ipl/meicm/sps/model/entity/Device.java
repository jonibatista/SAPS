package ipl.meicm.sps.model.entity;

import java.util.List;

/**
 * <p>
 * This class represents a user device
 * </p>
 * 
 * @author jonibatista
 * 
 */
public class Device {
	private String brand;
	private String model;
	private String manufacturer;
	private String mac;
	private List<AccessPoint> currentScan;
	private int direction;

	public Device() {
		// TODO Auto-generated constructor stub
	}

	public Device(String brand, String model, String manufacturer) {
		super();
		this.brand = brand;
		this.model = model;
		this.manufacturer = manufacturer;
	}

	/**
	 * 
	 * @return The brand (e.g., google) the software is customized for, if any.
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * 
	 * @param brand
	 *            The brand (e.g., google) the software is customized for, if
	 *            any.
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * 
	 * @return The end-user-visible name for the end product.
	 */
	public String getModel() {
		return model;
	}

	/**
	 * 
	 * @param model
	 *            The brand (e.g., google) the software is customized for, if
	 *            any.
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * 
	 * @return The manufacturer of the product/hardware.
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * 
	 * @param manufacturer
	 *            The manufacturer of the product/hardware.
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * 
	 * @return The MacAddresse of the device
	 */
	public String getMac() {
		return mac;
	}

	/**
	 * 
	 * @param mac
	 *            The MacAddresse of the device
	 */
	public void setMac(String mac) {
		this.mac = mac;
	}

	/**
	 * @return the list of access points traced in the last Wi-Fi Device Scan
	 */
	public List<AccessPoint> getCurrentScan() {
		return currentScan;
	}

	/**
	 * 
	 * @param currentScan the list of access points traced in the last Wi-Fi Device Scan
	 */
	public void setCurrentScan(List<AccessPoint> currentScan) {
		this.currentScan = currentScan;
	}

	/**
	 * <p> Let you know if the device is moving in the positive or negative direction </p>
	 * 
	 * @return greater than 0 if the device is moving on the positive direction, less than 0 if not 
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * 
	 * @param direction  greater than 0 if the device is moving on the positive direction, less than 0 if not. </br> Typically you should use 1 or -1.
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}
}
