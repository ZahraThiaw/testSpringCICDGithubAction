package sn.zahra.thiaw.testspringcicdgithubaction.Services.Impl;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sn.zahra.thiaw.testspringcicdgithubaction.Datas.Repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository compteRepository;

    public CustomUserDetailsService(UserRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Retourner directement l'entité User qui implémente déjà UserDetails
        return compteRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
