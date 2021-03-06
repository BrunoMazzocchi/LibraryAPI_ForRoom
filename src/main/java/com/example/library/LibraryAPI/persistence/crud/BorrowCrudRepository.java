package com.example.library.LibraryAPI.persistence.crud;

import com.example.library.LibraryAPI.persistence.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

public interface BorrowCrudRepository extends CrudRepository<Borrow, Integer> {

    @Query(value = "SELECT * FROM borrows WHERE student_id = ?", nativeQuery = true)
    List<Borrow > findBorrowByStudentId(int studentId);

    @Query(value = "SELECT * FROM borrows WHERE book_id = ?", nativeQuery = true)
    List<Borrow> findBorrowByBookId(int bookId);

    @Transactional
    void deleteBorrowByBookId(int bookId);

    @Query(value = "Select * from borrows", nativeQuery = true)
    List<Borrow> getAll();
}
