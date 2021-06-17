package co.edu.icesi.back.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.edu.icesi.back.model.Userr;
import co.edu.icesi.back.repository.UserrRepository;

@Service
public class MyCustomUserDetailsService implements UserDetailsService{
	
	private UserrRepository userrRepository;
	
	@Autowired
	public MyCustomUserDetailsService(UserrRepository userrRepository){
		this.userrRepository = userrRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Userr userr = userrRepository.findByUserName(userName);
		if (userr != null) {
			User.UserBuilder builder = User.withUsername(userName).password(userr.getUserPassword()).roles(userr.getType().toString());
			return builder.build();
		} else {
			throw new UsernameNotFoundException("User not found.");
		}
	}

}
