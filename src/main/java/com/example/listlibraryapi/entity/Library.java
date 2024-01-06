package com.example.listlibraryapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Library") // Tablo adını belirtiyoruz
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "BookName")
    private String bookName;

    @Column(name = "AuthorsName")
    private String authorsName;

    @Column(name = "IsBorrowed")
    private Boolean isBorrowed;

   @Column(name = "BorrowerUser")
    private String borrowerUser;

   @Column(name = "IsActive")
    private boolean isActive;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorsName() {
        return authorsName;
    }

    public void setAuthorsName(String authorsName) {
        this.authorsName = authorsName;
    }

    public Boolean getIsBorrowed() {
        return isBorrowed;
    }

    public void setIsBorrowed(Boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }
    public String getBorrowerUser() {
        return borrowerUser;
    }

    public void setBorrowerUser(String borrowerUser) {
        this.borrowerUser = borrowerUser;
    }
   public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

}
