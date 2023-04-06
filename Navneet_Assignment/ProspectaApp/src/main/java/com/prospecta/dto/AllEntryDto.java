package com.prospecta.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.prospecta.entity.Entry;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import  java.util.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllEntryDto {

	@JsonProperty("count")
	private Integer count;

	@JsonProperty("entries")
	private List<Entry> entries;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<Entry> getEntries() {
		return entries;
	}

	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}
}
