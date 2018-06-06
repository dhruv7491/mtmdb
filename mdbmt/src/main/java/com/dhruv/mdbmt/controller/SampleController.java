package com.dhruv.mdbmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dhruv.mdbmt.config.MultiTenantMongoDbFactory;
import com.dhruv.mdbmt.documents.UserDetails;
import com.dhruv.mdbmt.repository.UserRepository;
import com.dhruv.mdbmt.util.RestResponse;
import com.dhruv.mdbmt.util.RestUtils;
import com.dhruv.mdbmt.util.TenantContext;

@RestController
public class SampleController {
	
	@Autowired
	UserRepository userRepo;
	@RequestMapping(method = RequestMethod.GET, value = "")
	public ResponseEntity<RestResponse<String>> findMyTransactions(
			@RequestHeader(value = "X-TenantId") String tenantId) {
		TenantContext.setCurrentTenant(tenantId);
		MultiTenantMongoDbFactory.setDatabaseNameForCurrentThread(tenantId);
		userRepo.save(new UserDetails());
		return RestUtils.successResponse(TenantContext.getCurrentTenant());
	}
}
