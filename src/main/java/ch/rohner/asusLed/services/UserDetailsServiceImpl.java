package ch.rohner.asusLed.services;

import ch.rohner.asusLed.daos.User;
import ch.rohner.asusLed.daos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
        final User user = userRepository.findByUserid(userid);
//        when no user found raise exception.
        if (user == null) {
            throw new UsernameNotFoundException("User with ID " + userid + " not found!");
        }
        return new UserDetailsImpl(user);
    }
}
