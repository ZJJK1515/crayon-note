package com.crayon.gateway.auth;

import lombok.Data;

@Data
public class PublicKey {
    private String publicKey;
    private boolean mockServer;

    public PublicKey() {
        this.mockServer = false;
    }

    public PublicKey(String publicKey) {
        this.publicKey = publicKey;
        this.mockServer = false;
    }
}
