package com.prospecta.repository;

import com.prospecta.entity.Entry;
import java.util.*;

import com.prospecta.dto.EntryDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepo extends JpaRepository<Entry,Integer> {
	

    public List<EntryDto> findByCategory(String category);


}
