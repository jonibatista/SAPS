# Description

This is a android aplication that uses wireless signal triangulation of a local network to calculate the position of a mobile device.

# Requirements

* Android 2.2 froyo at least;
* wi-fi connection on;

# How it works
 
The application will execute a Wi-Fi Scan, on a android service, every X seconds to get the available access point information, such as the signal strength. Then the service will check if the device is moving or not. For this, the system compares the last sacn result with the previous. Finally, if the device is moving the service will sent the  traced Access Points information to the Web Service and will receive the current position.
**(descrive the interface...)**

# Setup

## Android Application
* Set the network SSID to yours in the attribute SSID on the *ipl.meicm.sps.controller.ScanService* class;
