package com.wellsfargo.wimt.vdi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.wimt.vdi.model.VDIDetails;

@Repository
public interface VDIRepository extends MongoRepository<VDIDetails, Long>{

}
