package ipl.meicm.sps.model.entity;

/**
 * <p> This class represents a user device </p>
 * @author jonibatista
 *
 */
public class Device {
	private String brand;
	private String model;
	private String manufacturer;
	private String mac;
	
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
	 * @param brand The brand (e.g., google) the software is customized for, if any.
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
	 * @param model The brand (e.g., google) the software is customized for, if any.
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
	 * @param manufacturer The manufacturer of the product/hardware.
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
	 * @param mac The MacAddresse of the device
	 */
	public void setMac(String mac) {
		this.mac = mac;
	}
}
