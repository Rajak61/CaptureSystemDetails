package com.wellsfargo.wimt.machine.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.wellsfargo.wimt.machine.model.MachineDetails;

@Repository
public interface MachineDetailsRepository extends MongoRepository<MachineDetails, Long>{
	
	@Query("{osName:'?0'}")
	List<MachineDetails> findByOperatingSystem(String osName);

}
