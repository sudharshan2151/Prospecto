package com.prospecta.PublicAPIsAPI.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.prospecta.PublicAPIsAPI.model.Entry;

@Repository
public interface PubilcAPIRepository extends ListCrudRepository<Entry, Integer>{

}
