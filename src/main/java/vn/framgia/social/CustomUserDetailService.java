package vn.framgia.social;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import vn.framgia.dao.IUserDAO;
import vn.framgia.dao.impl.UserDAOImpl;
import vn.framgia.model.User;


@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private IUserDAO iUserDAO;

    @Override
    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRES_NEW)
    public UserDetail loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = iUserDAO.getUser(userId);
        if (user == null) {
            return null;
        }
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = buildSimpleGrantedAuthorities(user);
        return new UserDetail(user.getUserId(), user.getFullName(), user.getPassword(), true, true
                , true, true, simpleGrantedAuthorities);
    }

    private List<SimpleGrantedAuthority> buildSimpleGrantedAuthorities(User user) {
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<SimpleGrantedAuthority>();
        simpleGrantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));
        return simpleGrantedAuthorities;
    }
}
