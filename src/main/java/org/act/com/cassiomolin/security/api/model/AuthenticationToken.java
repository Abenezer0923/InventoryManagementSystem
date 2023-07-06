package org.act.com.cassiomolin.security.api.model;

/**
 * API model for the authentication token.
 *
 * @author cassiomolin
 */
public class AuthenticationToken {

    private int token;

    public AuthenticationToken() {

    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }
}