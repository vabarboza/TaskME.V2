package com.tavernainfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tavernainfo.model.Status;

public interface StatusRepository extends JpaRepository<Status, Integer>{

}
