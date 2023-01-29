package com.microservicedemo.filter.service;

import com.microservicedemo.filter.models.Inventory;
import com.microservicedemo.filter.repositories.FilterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FilterServiceImpl implements FilterService {

    private FilterRepository filterRepository;

    @Override
    public void add(Inventory inventory) {
        this.filterRepository.save(inventory);
    }
}
