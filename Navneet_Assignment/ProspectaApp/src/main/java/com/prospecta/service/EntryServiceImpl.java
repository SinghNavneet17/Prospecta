package com.prospecta.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prospecta.dto.AllEntryDto;
import com.prospecta.dto.EntryDto;
import com.prospecta.entity.Entry;
import com.prospecta.exception.EntryException;
import com.prospecta.repository.EntryRepo;
@Service
public class EntryServiceImpl implements EntryService{
	
    @Autowired
    private EntryRepo entryRepo;

    @Autowired
    private RestTemplate  rTemplate;
    
    @Override
    public List<EntryDto> getEntriesByCategory(String category) {
    	
        String ResourceUrl = "https://api.publicapis.org/entries";
        ResponseEntity<AllEntryDto> responseEntity = rTemplate.getForEntity(ResourceUrl, AllEntryDto.class);
        

        
        List<EntryDto> list = new ArrayList<>();

        for(Entry e: responseEntity.getBody().getEntries()){
            if(category.equals(e.getCategory())){
                list.add(new EntryDto(e.getTitle(),e.getDescription()));
            }
        }

        if(list.size()==0)
        	
            throw new EntryException("No Such category found with : "+category);

        return list;

    }

    @Override
    public Entry saveEntries() {
        String ResourceUrl = "https://api.publicapis.org/random";
        ResponseEntity<AllEntryDto> responseEntity = rTemplate.getForEntity(ResourceUrl, AllEntryDto.class);

        Entry entry = responseEntity.getBody().getEntries().get(0);

        return entryRepo.save(entry);
    }


    
}

