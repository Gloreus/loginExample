package scbt.rbs.arms;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.server.auth.NavigationAccessControl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService implements UserDetailsService {
    private static final String USER_ATTRIBUTE = "AuthService.User";

    public UserDetails loadUserByUsername(String username) {

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

    public void logOut() {
        VaadinSession.getCurrent().close();
        VaadinSession.getCurrent().getSession().invalidate();
        UI.getCurrent().navigate("login");
    }
}