package ru.misosi.mecab;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeviceService {
	@Autowired
	private DeviceRepository deviceRepository;
	
	@Transactional
	public Device findOne(Integer id) {
		return deviceRepository.findOne(id);
	}
	
	@Transactional
	public List<Device> findAll() {
		return deviceRepository.findAll();
	}
}
