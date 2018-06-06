package com.dhruv.mdbmt.util;

public class TenantContext {

	private static final String DEFAULT_KEYSPACE_NAME = "mobiadz";
	private static ThreadLocal<String> currentTenant = new ThreadLocal<>();

	public static void setCurrentTenant(String tenantId) {
		currentTenant.set(tenantId);
	}

	public static String getCurrentTenant() {
		String tenantId = currentTenant.get( );
		return ( tenantId != null && tenantId.trim( ).length( ) > 0 ) ? tenantId.trim( ) : DEFAULT_KEYSPACE_NAME;
	}

}
