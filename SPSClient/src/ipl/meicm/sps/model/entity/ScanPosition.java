package ipl.meicm.sps.model.entity;

import java.util.List;

/**
 * <p> This class represents a wifi scan </p>
 * @author jonibatista
 *
 */
public class ScanPosition {
	private Device device;
	private List<AccessPoint> aps;

	public ScanPosition(Device device) {
		this.device = device;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public List<AccessPoint> getAps() {
		return aps;
	}

	public void setAps(List<AccessPoint> aps) {
		this.aps = aps;
	}
}
