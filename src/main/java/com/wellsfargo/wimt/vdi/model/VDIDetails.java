package com.wellsfargo.wimt.vdi.model;

import org.springframework.data.annotation.Transient;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "VDIDetails")
public class VDIDetails {

	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";
	
	@Id
	private long id;
	
	public SystemInformation systemInformation;
	public MemoryCPUUsage memory_CPUUsage;
	public ArrayList<DiskUsage> diskUsage;
	public String wwnDetails;
	public String systemDate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public SystemInformation getSystemInformation() {
		return systemInformation;
	}
	public void setSystemInformation(SystemInformation systemInformation) {
		this.systemInformation = systemInformation;
	}
	public MemoryCPUUsage getMemory_CPUUsage() {
		return memory_CPUUsage;
	}
	public void setMemory_CPUUsage(MemoryCPUUsage memory_CPUUsage) {
		this.memory_CPUUsage = memory_CPUUsage;
	}
	public ArrayList<DiskUsage> getDiskUsage() {
		return diskUsage;
	}
	public void setDiskUsage(ArrayList<DiskUsage> diskUsage) {
		this.diskUsage = diskUsage;
	}
	public String getWwnDetails() {
		return wwnDetails;
	}
	public void setWwnDetails(String wwnDetails) {
		this.wwnDetails = wwnDetails;
	}
	public String getSystemDate() {
		return systemDate;
	}
	public void setSystemDate(String systemDate) {
		this.systemDate = systemDate;
	}
	
	
	
	
}

class SystemInformation {
	public String hostname;
	public String uptime;
	public String manufacturer;
	public String productName;
	public String version;
	public String serialNumber;
	public String machineType;
	public String systemDetails;
	public String availableRAM;
	public String usageRAM;
	public String operatingSystem;
	public String osVersion;
	public String osFamily;
	public String kernel;
	public String architecture;
	public String processorName;
	public String activeUser;
	public String systemMainIP;
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getUptime() {
		return uptime;
	}
	public void setUptime(String uptime) {
		this.uptime = uptime;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getMachineType() {
		return machineType;
	}
	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}
	public String getSystemDetails() {
		return systemDetails;
	}
	public void setSystemDetails(String systemDetails) {
		this.systemDetails = systemDetails;
	}
	public String getAvailableRAM() {
		return availableRAM;
	}
	public void setAvailableRAM(String availableRAM) {
		this.availableRAM = availableRAM;
	}
	public String getUsageRAM() {
		return usageRAM;
	}
	public void setUsageRAM(String usageRAM) {
		this.usageRAM = usageRAM;
	}
	public String getOperatingSystem() {
		return operatingSystem;
	}
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	public String getOsVersion() {
		return osVersion;
	}
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
	public String getOsFamily() {
		return osFamily;
	}
	public void setOsFamily(String osFamily) {
		this.osFamily = osFamily;
	}
	public String getKernel() {
		return kernel;
	}
	public void setKernel(String kernel) {
		this.kernel = kernel;
	}
	public String getArchitecture() {
		return architecture;
	}
	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}
	public String getProcessorName() {
		return processorName;
	}
	public void setProcessorName(String processorName) {
		this.processorName = processorName;
	}
	public String getActiveUser() {
		return activeUser;
	}
	public void setActiveUser(String activeUser) {
		this.activeUser = activeUser;
	}
	public String getSystemMainIP() {
		return systemMainIP;
	}
	public void setSystemMainIP(String systemMainIP) {
		this.systemMainIP = systemMainIP;
	}
	
	
}

class MemoryCPUUsage {
	public String memoryUsage;
	public String swapUsage;
	public String cpuUsage;
	public String getMemoryUsage() {
		return memoryUsage;
	}
	public void setMemoryUsage(String memoryUsage) {
		this.memoryUsage = memoryUsage;
	}
	public String getSwapUsage() {
		return swapUsage;
	}
	public void setSwapUsage(String swapUsage) {
		this.swapUsage = swapUsage;
	}
	public String getCpuUsage() {
		return cpuUsage;
	}
	public void setCpuUsage(String cpuUsage) {
		this.cpuUsage = cpuUsage;
	}
	
	
}

class DiskUsage {
	public String usage;
	public String filesystem;
	public String size;
	public String used;
	public String avail;
	public String use;
	public String mountedOn;
	public String getUsage() {
		return usage;
	}
	public void setUsage(String usage) {
		this.usage = usage;
	}
	public String getFilesystem() {
		return filesystem;
	}
	public void setFilesystem(String filesystem) {
		this.filesystem = filesystem;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getUsed() {
		return used;
	}
	public void setUsed(String used) {
		this.used = used;
	}
	public String getAvail() {
		return avail;
	}
	public void setAvail(String avail) {
		this.avail = avail;
	}
	public String getUse() {
		return use;
	}
	public void setUse(String use) {
		this.use = use;
	}
	public String getMountedOn() {
		return mountedOn;
	}
	public void setMountedOn(String mountedOn) {
		this.mountedOn = mountedOn;
	}
	
	
}
