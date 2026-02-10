package scbt.rbs.arms;

import com.vaadin.flow.server.VaadinSession;
import jakarta.security.auth.message.AuthException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Objects;

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