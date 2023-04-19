package com.howard.service.scope;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class ScopeService {
    public String getScope() {
        return this.toString();
    }
}
