package com.example.library.LibraryAPI.domain.service;

import com.example.library.LibraryAPI.domain.repository.*;
import com.example.library.LibraryAPI.persistence.TypeRepository;
import com.example.library.LibraryAPI.persistence.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class TypeService {
    @Autowired
    private TypeRepository typeRepository;

    public List<Type> getAll(){
        return typeRepository.getAll();
    }


}
