package com.wellsfargo.wimt.machine.model;

import org.springframework.data.annotation.Transient;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "MachineDetails")
public class MachineDetails {

	@Transient
	public static final String SEQUENCE_NAME = "machine_sequence";

	@Id
	private long id;

	public SystemInformation systemInformation;
    public MemoryCPUUsage memory_CPUUsage;
    public ArrayList<DiskUsage> diskUsage;
    public String wwnDetails;
    public String oracleDBInstances;
    public PackageUpdates packageUpdates;
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



