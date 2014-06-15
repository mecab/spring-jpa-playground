package ru.misosi.mecab;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public User getByUsername(String username) {
		return userRepository.getByUsername(username);
	}
}
