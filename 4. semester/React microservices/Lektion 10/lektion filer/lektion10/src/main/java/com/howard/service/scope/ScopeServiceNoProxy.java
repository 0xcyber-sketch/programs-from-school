package com.howard.service.scope;

import javax.enterprise.context.Dependent;

@Dependent
public class ScopeServiceNoProxy {
    public String getScope() {
        return this.toString();
    }
}
