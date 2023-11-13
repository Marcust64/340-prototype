package com.pickandgo.demo.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.AuthorityUtils;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marcus Thompson
 */

@Service
public class UserService {
    
    @Autowired
    UserRepository repo;

   // @Autowired
    //PasswordEncoder passwordEncoder;

//    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
//         User user = repo.findByEmail(email);

//         List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(user.getTag());
        
//         return new org.springframework.security.core.userdetails.User(
//                 user.getEmail(), user.getPassword(), authorities);
//     }

//     public void saveUser(User user) {
//         System.out.println("@@@@@");
//         user.setPassword(passwordEncoder.encode(user.getPassword()));
//         repo.save(user);
//     }

    public User findByEmail(String email) {
        return repo.findByEmail(email);
    }
}
