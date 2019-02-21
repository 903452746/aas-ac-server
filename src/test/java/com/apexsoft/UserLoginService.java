package com.apexsoft;

import com.apexsoft.aas.authentication.simple.LoginService;
import com.apexsoft.aas.common.exception.AuthException;
import com.apexsoft.aas.modules.index.model.AuthData;
import com.apexsoft.aas.modules.index.model.AuthUser;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/9/6.
 */
@Service
@Primary
public class UserLoginService implements LoginService {
    private static Map<String,DDUser> userMap = new HashMap<>();
    static {
        userMap.put("admin",new DDUser("admin","用户admin"));
        userMap.put("10001",new DDUser("10001","用户10001"));
        userMap.put("10002",new DDUser("10002","用户10002"));
        userMap.put("10003",new DDUser("10003","用户10003"));
        userMap.put("10004",new DDUser("10004","用户10004"));
        userMap.put("10005",new DDUser("10005","用户10005"));
        userMap.put("10006",new DDUser("10006","用户10006"));
        userMap.put("10007",new DDUser("10007","用户10007"));
        userMap.put("10008",new DDUser("10008","用户10008"));
        userMap.put("10009",new DDUser("10009","用户10009"));
        userMap.put("10010",new DDUser("10010","用户10010"));
    }

    /**
     * 通过userId和密码获取用户
     * @param userId
     * @param password
     * @return
     */
    private DDUser getUser(String userId,String password){
        //这里简单用Map存放用户信息，真实场景应该是从DAO层获取数据
        DDUser user = userMap.get(userId);
        //校验密码，此处省略
        return user;
    }

    /**
     * 通过userId取用户
     * @param userId
     * @return
     */
    private DDUser getUser(String userId){
        //这里简单用Map存放用户信息，真实场景应该是从DAO层获取数据
        DDUser user = userMap.get(userId);
        return user;
    }

    private AuthUser createAuthUser(DDUser user){
        if(null==user){
            return null;
        }
        AuthUser authUser = new AuthUser();
        authUser.setUserId(user.getUserId());
        authUser.setUserName(user.getUserName());
        authUser.setUser(user);
        return authUser;
    }

    @Override
    public AuthUser login(AuthData authData) throws AuthException {
        //验证参数，如有其它参数需要验证，请求时将参数放到AuthData的ext中，这里取出来进行验证
        //如果需要用到HttpServletRequest对象，可以通过 UserSession.getRequestHolder() 获取
        if(null!=authData && StringUtils.hasText(authData.getUser())  && StringUtils.hasText(authData.getPassword())){
            DDUser user = getUser(authData.getUser(),authData.getPassword());
            return createAuthUser(user);
        }else{
            DDUser user = getUser("admin",null);
            return createAuthUser(user);
        }
    }

    @Override
    public AuthUser createAuthUser(String userId) throws AuthException {
        DDUser user = getUser("admin",null);
        return createAuthUser(user);
    }

    public static class DDUser{
        private String userId;
        private String userName;

        public DDUser(String userId, String userName) {
            this.userId = userId;
            this.userName = userName;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}

