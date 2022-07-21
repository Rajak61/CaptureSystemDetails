package com.wellsfargo.wimt.vdi.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.wimt.vdi.exception.ResourceNotFoundException;
import com.wellsfargo.wimt.vdi.model.VDIDetails;
import com.wellsfargo.wimt.vdi.repository.VDIRepository;
import com.wellsfargo.wimt.vdi.service.SequenceGeneratorService;

@RestController
@RequestMapping("/api/v1")
public class VDIDetailsController {

	
	@Autowired
	private VDIRepository vdiRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	 Logger logger = LoggerFactory.getLogger(VDIDetailsController.class);
	 
	@GetMapping("/vdidetails")
	public List<VDIDetails> getAllVDIDetails() {
		return vdiRepository.findAll();
	}

	@GetMapping("/vdidetails/{id}")
	public ResponseEntity<VDIDetails> getVDiDetailsById(@PathVariable(value = "id") Long VDIId)
			throws ResourceNotFoundException {
		logger.info("Entering the getVDiDetailsById #######");
		VDIDetails vdiDetails = vdiRepository.findById(VDIId)
				.orElseThrow(() -> new ResourceNotFoundException("Vdi not found for this id :: " + VDIId));
		
		logger.info("Exiting the getVDiDetailsById #######");
		return ResponseEntity.ok().body(vdiDetails);
	}

	@PostMapping("/vdidetails")
	public VDIDetails createVDIDetails(@Valid @RequestBody VDIDetails vdiDetails) {
		logger.info("Entering the createVDIDetails #######");
		vdiDetails.setId(sequenceGeneratorService.generateSequence(VDIDetails.SEQUENCE_NAME));
		vdiDetails.setSystemDate(LocalDateTime.now().toString());
		logger.info("Exiting the createVDIDetails #######");
		return vdiRepository.save(vdiDetails);
	}
	
	@PostMapping("/batchvdidetails")
	public List<VDIDetails> createVdiDetailsBatch(@Valid @RequestBody List<VDIDetails> vdiDetails) {
		logger.info("Entering the createVdiDetailsBatch #######");
		
		for (VDIDetails vdiDetail : vdiDetails) {
			
			vdiDetail.setId(sequenceGeneratorService.generateSequence(VDIDetails.SEQUENCE_NAME));
			vdiDetail.setSystemDate(LocalDateTime.now().toString());
		}
		logger.info("Exiting the createVdiDetailsBatch #######");
		return vdiRepository.saveAll(vdiDetails);
	}
	
	@PutMapping("/vdidetails/{id}")
	public ResponseEntity<VDIDetails> updateVdiDetails(@PathVariable(value = "id") Long vdiId,
			@Valid @RequestBody VDIDetails vdiDetails) throws ResourceNotFoundException {
		logger.info("Entering the updateVdiDetails #######");
		VDIDetails vdiDetail = vdiRepository.findById(vdiId)
				.orElseThrow(() -> new ResourceNotFoundException("Vdi not found for this id :: " + vdiId));

		vdiDetail.setWwnDetails(vdiDetails.getWwnDetails());
		final VDIDetails updatedVDIDetails = vdiRepository.save(vdiDetail);
		logger.info("Exiting the updateVdiDetails #######");
		return ResponseEntity.ok(updatedVDIDetails);
	}
}
