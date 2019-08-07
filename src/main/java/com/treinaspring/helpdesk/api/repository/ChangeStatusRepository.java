package com.treinaspring.helpdesk.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.treinaspring.helpdesk.api.entity.ChangeStatus;

public interface ChangeStatusRepository extends MongoRepository<ChangeStatus, String>{
	
	Iterable<ChangeStatus> findByticketIdOrderByDateChangeStatus(String tickedId);

}
