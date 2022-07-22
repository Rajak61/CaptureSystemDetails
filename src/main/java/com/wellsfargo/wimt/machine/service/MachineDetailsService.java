package com.wellsfargo.wimt.machine.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.wimt.machine.model.MachineDetails;
import com.wellsfargo.wimt.machine.repository.MachineDetailsRepository;

@Service
public class MachineDetailsService {
	Logger logger = LoggerFactory.getLogger(MachineDetailsService.class);
	MachineDetailsRepository machineDetailsRepository;
	
	@Autowired
	public MachineDetailsService(MachineDetailsRepository machineDetailsRepository) {
		this.machineDetailsRepository = machineDetailsRepository;
	}
	
	public List<MachineDetails>  getMachineDetailsByOSName(String osName) {
		logger.info("Entering the getMachineDetailsByOsName in service#### ");
        List<MachineDetails> machineDetails = machineDetailsRepository.findAll();
        List<MachineDetails> machineDetail = machineDetails.stream().filter(machine->machine.getSystemInformation().getOperatingSystem().equalsIgnoreCase(osName)).collect(Collectors.toList());
        logger.info("Exiting the getMachineDetailsByOsName in service #### " +machineDetail.size());
        return machineDetail;

	}
}
