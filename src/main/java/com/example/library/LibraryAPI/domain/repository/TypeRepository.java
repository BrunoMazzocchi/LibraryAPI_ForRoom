package com.example.library.LibraryAPI.domain.repository;

import com.example.library.LibraryAPI.persistence.entity.*;
import org.springframework.stereotype.*;

import java.util.*;
@Repository
public interface TypeRepository {
    List<Type> getAll();
}
