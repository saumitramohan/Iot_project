package sample.data.jpa.domain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import sample.data.jpa.service.UserRepository;

import java.util.ArrayList;
import java.util.List;


@Component
public class DetailsService implements UserDetailsService {

    @Autowired
    UserRepository users;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List list = new ArrayList();

        User user = users.findAllByUsername(username);
        if (user.getUsername() == null){
            throw new UsernameNotFoundException(username + " was not found");
        }


        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                list
        );
    }
}
