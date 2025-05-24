package com.university.securityservice.dto;

public  class TokenRefreshRequest {
    private String refreshToken;

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

    
}