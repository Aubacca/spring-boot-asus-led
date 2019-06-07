package ch.rohner.asusLed.security;

import ch.rohner.asusLed.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsServiceImpl userService;

    @Autowired
    public AppSecurityConfig(UserDetailsServiceImpl userService) {
        super();
        this.userService = userService;
    }

    @Bean
    public AuthenticationProvider authProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userService);
        daoAuthenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

        return daoAuthenticationProvider;
    }

/*
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        List<UserDetails> users = getAppUsers();

        return new InMemoryUserDetailsManager(users);
    }
*/

/*
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }
*/

    private List<UserDetails> getAppUsers() {
        List<UserDetails> users = new ArrayList<>();
        users.add(User.withDefaultPasswordEncoder()
                .username("Aubacca").password("1234")
                .roles("USER")
                .build());
        return users;
    }
}
