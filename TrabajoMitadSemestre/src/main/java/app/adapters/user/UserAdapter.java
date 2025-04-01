package app.adapters.user;

import app.adapters.user.repository.UserRepository;
import app.domain.models.User;
import app.ports.UserPort;

public class UserAdapter implements UserPort {
	private UserRepository userRepository;

	@Override
	public boolean existsByUserName(String userName) {		
		return userRepository.existsByUserName(userName);
	}

	@Override
	public void saveUser(User User) {
		
		
		
	}

	@Override
	public User findByPersonId(long personId) {
		// TODO Auto-generated method stub
		return null;
	}

}
