package com.example.library.LibraryAPI.persistence;

import com.example.library.LibraryAPI.persistence.crud.*;
import com.example.library.LibraryAPI.persistence.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import java.util.*;


@EnableAutoConfiguration
@Repository
public class TypeRepository implements  com.example.library.LibraryAPI.domain.repository.TypeRepository{

    @Autowired
    private TypeCrudRepository typeCrudRepository;
    @Override
    public List<Type> getAll() {
        List<Type> types = (List<Type>) typeCrudRepository.getAll();
        return types;
    }
}
