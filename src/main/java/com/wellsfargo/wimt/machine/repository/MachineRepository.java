package com.wellsfargo.wimt.machine.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.wimt.machine.model.MachineDetails;

@Repository
public interface MachineRepository extends MongoRepository<MachineDetails, Long>{

}
