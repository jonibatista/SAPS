package ipl.meicm.sps.model;

import ipl.meicm.sps.model.entity.AccessPoint;

import java.util.List;

public class CalculatePosition {
	private static final int RSSI_RANGE_ERROR = 5;

	/**
	 * <p>
	 * Allow us to know if the device is moving.
	 * </p>
	 * 
	 * @param current
	 *            the access point list of the last WiFi scan
	 * @param previous
	 *            the access point list of the previous WiFi scan
	 * @return true if the device's moving, false if not
	 */
	public boolean isMoving(List<AccessPoint> current,
			List<AccessPoint> previous) {

		for (AccessPoint last : current) {
			for (AccessPoint prev : previous) {
				if (last.equals(prev)) {
					// ap's matches
					// let's see if the rssi increase or decrease
					if ((last.getRssi() < prev.getRssi() - RSSI_RANGE_ERROR)
							|| (last.getRssi() > prev.getRssi()
									+ RSSI_RANGE_ERROR))
						return true;
				}
			}
		}

		return false;
	}
}
