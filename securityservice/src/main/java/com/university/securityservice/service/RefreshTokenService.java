package com.university.securityservice.service;


import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.university.securityservice.entity.RefreshToken;
import com.university.securityservice.entity.User;
import com.university.securityservice.repository.RefreshTokenRepository;
import com.university.securityservice.repository.UserRepository;

@Service
public class RefreshTokenService {

    @Value("${jwt.refreshTokenExpirationMs}")
    private Long refreshTokenDurationMs;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private UserRepository userRepository;

    public RefreshToken createRefreshToken(User user) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUser(user);
        refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
        refreshToken.setToken(UUID.randomUUID().toString());
        Optional<RefreshToken> existingTokenOpt = refreshTokenRepository.findByUser(refreshToken.getUser());

        if (existingTokenOpt.isPresent()) {
            // Update existing token details
            RefreshToken existingToken = existingTokenOpt.get();
            existingToken.setToken(refreshToken.getToken());
            existingToken.setExpiryDate(refreshToken.getExpiryDate());
            refreshToken = refreshTokenRepository.save(existingToken);
        } else {
            // Save new token
            refreshToken = refreshTokenRepository.save(refreshToken);
        }

        return refreshToken;

    }

    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(token);
            throw new RuntimeException("Refresh token expired. Please login again.");
        }
        return token;
    }

    public void deleteByUserId(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        refreshTokenRepository.deleteByUser(user);
    }
}

