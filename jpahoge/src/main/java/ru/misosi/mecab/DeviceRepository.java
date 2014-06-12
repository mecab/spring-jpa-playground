package ru.misosi.mecab;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends CrudRepository<Device, Integer> {
	List<Device> findAll();
	Device findOne(Integer id);
}
