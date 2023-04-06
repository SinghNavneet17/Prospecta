package com.prospecta.service;

import com.prospecta.entity.Entry;
import com.prospecta.dto.EntryDto;
import java.util.*;

public interface EntryService {

   public List<EntryDto> getEntriesByCategory(String category);

   public Entry saveEntries();

   
}
