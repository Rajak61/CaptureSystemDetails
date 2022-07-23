package com.wellsfargo.wimt.machine.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.wimt.machine.exception.ResourceNotFoundException;
import com.wellsfargo.wimt.machine.model.MachineDetails;
import com.wellsfargo.wimt.machine.repository.MachineDetailsRepository;
import com.wellsfargo.wimt.machine.service.MachineDetailsService;
import com.wellsfargo.wimt.machine.service.SequenceGeneratorService;

@RestController
@RequestMapping("/api/v1")
public class MachineDetailsController {

	@Autowired
	private MachineDetailsRepository machineRepository;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@Autowired
	MachineDetailsService machineDetailsService;

	Logger logger = LoggerFactory.getLogger(MachineDetailsController.class);

	@GetMapping("/machinedetails")
	public List<MachineDetails> getAllMachineDetails() {
		logger.info("Entering the getAllMachineDetails #######");
		List<MachineDetails> machineDetails = machineRepository.findAll();
		logger.info("Exiting the getAllMachineDetails ####### " + machineDetails.size());
		return machineDetails;
	}

	@GetMapping("/machinedetails/{id}")
	public ResponseEntity<MachineDetails> getMachineDetailsById(@PathVariable(value = "id") Long machineId)
			throws ResourceNotFoundException {
		logger.info("Entering the getMachineDetailsById #######");
		MachineDetails machineDetails = machineRepository.findById(machineId)
				.orElseThrow(() -> new ResourceNotFoundException("machine not found for this id :: " + machineId));

		ResponseEntity<MachineDetails> response = ResponseEntity.ok().body(machineDetails);
		logger.info("Exiting the getMachineDetailsById #######");
		return response;
	}

	@PostMapping("/machinedetails")
	public MachineDetails createMachineDetails(@Valid @RequestBody MachineDetails machineDetails) {
		logger.info("Entering the createMachineDetails #######");
		machineDetails.setId(sequenceGeneratorService.generateSequence(MachineDetails.SEQUENCE_NAME));
		machineDetails.setSystemDate(LocalDateTime.now().toString());
		MachineDetails machineDetail = machineRepository.save(machineDetails);
		logger.info("Exiting the createMachineDetails #######");
		return machineDetail;
	}

	@PostMapping("/batchmachinedetails")
	public List<MachineDetails> createMachineDetailsBatch(@Valid @RequestBody List<MachineDetails> machineDetails) {
		logger.info("Entering the createMachineDetailsBatch #######");

		for (MachineDetails machineDetail : machineDetails) {

			machineDetail.setId(sequenceGeneratorService.generateSequence(MachineDetails.SEQUENCE_NAME));
			machineDetail.setSystemDate(LocalDateTime.now().toString());
		}
		List<MachineDetails> machineDet = machineRepository.saveAll(machineDetails);
		logger.info("Exiting the createMachineDetailsBatch ####### " + machineDet.size());
		return machineDet;
	}

	@PutMapping("/machinedetails/{id}")
	public ResponseEntity<MachineDetails> updateMachineDetails(@PathVariable(value = "id") Long machineId,
			@Valid @RequestBody MachineDetails machineDetails) throws ResourceNotFoundException {
		logger.info("Entering the updateMachineDetails #######");
		MachineDetails machineDetail = machineRepository.findById(machineId)
				.orElseThrow(() -> new ResourceNotFoundException("machine not found for this id :: " + machineId));

		machineDetail.setWwnDetails(machineDetails.getWwnDetails());
		final MachineDetails updatedMachineDetails = machineRepository.save(machineDetail);
		logger.info("Exiting the updateMachineDetails #######");
		return ResponseEntity.ok(updatedMachineDetails);
	}

	@GetMapping("/machinedetails/getbyos")
	public List<MachineDetails> getMachineDetailsByOSName(@RequestParam(value = "osName") String osName) {
		logger.info("Entering the getMachineDetailsByOsName #### ");
		List<MachineDetails> machineDetails=null;
		if(osName!=null && !osName.isEmpty()){
		machineDetails = machineDetailsService.getMachineDetailsByOSName(osName.trim());
		logger.info("Exiting the getMachineDetailsByOsName #### " + machineDetails.size());
		}
		return machineDetails;
	}
	
	@GetMapping("/machinedetails/proceesorname")
	public List<MachineDetails> getMachineDetailsByProcessorName(@RequestParam(value = "processorName") String processorName) {
		logger.info("Entering the getMachineDetailsByProcessorName #### ");
		List<MachineDetails> machineDetails=null;
		if(processorName!=null && !processorName.isEmpty()){
		machineDetails = machineDetailsService.getMachineDetailsByProcessorName(processorName.trim());
		logger.info("Exiting the getMachineDetailsByProcessorName #### " + machineDetails.size());
		}
		return machineDetails;
	}

	@GetMapping("/machinedetails/memory")
	public List<MachineDetails> getMachineDetailsByMemoryUsage(@RequestParam(value = "memoryUsage") String memoryUsage) {
		logger.info("Entering the getMachineDetailsByMemoryUsage #### ");
		List<MachineDetails> machineDetails=null;
		if(memoryUsage!=null && !memoryUsage.isEmpty()){
		machineDetails = machineDetailsService.getMachineDetailsByMemoryUsage(memoryUsage.trim());
		logger.info("Exiting the getMachineDetailsByMemoryUsage #### " + machineDetails.size());
		}
		return machineDetails;
	}

}
