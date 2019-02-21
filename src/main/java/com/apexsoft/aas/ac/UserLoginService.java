package com.apexsoft.aas.ac;

import com.alibaba.fastjson.JSON;
import com.apexsoft.aas.authentication.simple.LoginService;
import com.apexsoft.aas.common.exception.AuthException;
import com.apexsoft.aas.modules.index.model.AuthData;
import com.apexsoft.aas.modules.index.model.AuthUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserLoginService implements LoginService {
    private static final Logger log = LoggerFactory.getLogger(UserLoginService.class);
    @Override
    public AuthUser login(AuthData authData) throws AuthException {
        log.info(JSON.toJSONString(authData));
        AuthUser<AuthData> auth =new AuthUser<>();
        auth.setUser(authData);
        auth.setUserName(authData.getUser());
        auth.setUserId(authData.getUser());
        return auth;
    }

    @Override
    public AuthUser createAuthUser(String uid) throws AuthException {
        AuthUser<AuthData> auth =new AuthUser<>();
        AuthData authData  = new AuthData();
        auth.setUser(authData);
        return auth;
    }
}
