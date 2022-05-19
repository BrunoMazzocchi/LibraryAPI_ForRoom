package com.example.library.LibraryAPI.persistence.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;

@Entity
@Table(name = "borrows")
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer borrowId;
    private Integer studentId;
    private Integer bookId;
    private Date takenDate;
    private Date broughtDate;

    @ManyToOne
    @JoinColumn(name = "bookId", insertable = false, updatable = false) //Mediante esto, no se actualizan ni
    private Book book;

    @ManyToOne
    @JoinColumn(name = "studentId", insertable = false, updatable = false) //Mediante esto, no se actualizan ni
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Date getTakenDate() {
        return takenDate;
    }

    public void setTakenDate(Date takeDate) {
        this.takenDate = takeDate;
    }

    public Date getBroughtDate() {
        return broughtDate;
    }

    public void setBroughtDate(Date broughtDate) {
        this.broughtDate = broughtDate;
    }
}
