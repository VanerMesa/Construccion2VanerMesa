package app.ports;

import app.domain.models.User;

public interface UserPort {
	public boolean existsByUserName (String userName);
	void saveUser(User User);
	
	public User findByPersonId(long personId);

}
