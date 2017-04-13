package vn.framgia.social;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class SocialUser extends org.springframework.social.security.SocialUser {

    private String userId;

    public SocialUser(String userId, String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
