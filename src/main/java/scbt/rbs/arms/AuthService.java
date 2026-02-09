package scbt.rbs.arms;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
public class AuthService implements UserDetailsService {
   // private final UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) {

/*
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Not found"));
*/
        return
                User.withUsername("user")
                        .password("{noop}user")
                        .roles("USER", "ADMIN")
                        .build();

/*
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream().map(SimpleGrantedAuthority::new).toList()
                */


    }
}