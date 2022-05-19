package com.example.library.LibraryAPI.persistence.crud;

import com.example.library.LibraryAPI.persistence.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;

import java.util.*;

public interface TypeCrudRepository extends CrudRepository<Type, Integer> {

    @Query(value = "Select * from types", nativeQuery = true)
    List<Type> getAll();
}
