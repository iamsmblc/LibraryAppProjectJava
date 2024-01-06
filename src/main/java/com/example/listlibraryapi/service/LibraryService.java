package com.example.listlibraryapi.service;

import com.example.listlibraryapi.exception.LibraryServiceException;
import com.example.listlibraryapi.repository.ListLibraryApiRepository;
import com.example.listlibraryapi.entity.Library;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    private final ListLibraryApiRepository libraryRepository;

    @Autowired
    public LibraryService(ListLibraryApiRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }
    public List<Library> getAllBooks() {
        try{
            List<Library> result = libraryRepository.findAll();
            return result;
        } catch (Exception e) {
            throw new LibraryServiceException("Error occurred during load books : "+e +e.getStackTrace().toString());
        }
    }
    public Library getBookById(@PathVariable Long id) {
        try{
        Optional<Library> library = libraryRepository.findById(id);

        if (library.isPresent() ){
            return library.get();
        } else {
            return null;
        }
        } catch (Exception e) {
            throw new LibraryServiceException("Error occurred during load book : "+e +e.getStackTrace().toString());
        }

    }
    public Library addBook(@RequestBody Library library) {
        try{
        Library newLibrary = libraryRepository.save(library);
        return newLibrary;
        } catch (Exception e) {
            throw new LibraryServiceException("Error occurred during add book : "+e +e.getStackTrace().toString());
        }
    }
    public Library updateBook(Library library) {
        try{
        Library libraryToUpdate = libraryRepository.findById(library.getId()).orElse(null);

        if (libraryToUpdate != null) {
            libraryToUpdate.setBookName(library.getBookName());
            libraryToUpdate.setAuthorsName(library.getAuthorsName());
            libraryToUpdate.setIsBorrowed(library.getIsBorrowed());
            libraryToUpdate.setBorrowerUser(library.getBorrowerUser());

            return libraryRepository.save(libraryToUpdate);
        } else {

            return null;
        }
        } catch (Exception e) {
            throw new LibraryServiceException("Error occurred during update book : "+e +e.getStackTrace().toString());
        }
    }

    public Library deleteBook(Library library) {
        try{
        Library bookToDelete = libraryRepository.findById(library.getId()).orElse(null);

        if (bookToDelete != null) {
            bookToDelete.setIsActive(false);
            return libraryRepository.save(bookToDelete);
        } else {

            return null;
        }
        } catch (Exception e) {
            throw new LibraryServiceException("Error occurred during delete book : "+e +e.getStackTrace().toString());
        }
    }


}
