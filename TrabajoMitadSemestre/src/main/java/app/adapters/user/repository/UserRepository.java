package app.adapters.user.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.adapters.user.entity.UserEntity;
import app.adapters.persons.entity.PersonEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	public boolean existsByUserName(String userName);

	public UserEntity findByPersonId(PersonEntity personEntity);

	public UserEntity findByUserName(String userName);

}

