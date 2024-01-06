package com.example.listlibraryapi.controller;

import com.example.listlibraryapi.entity.Library;
import com.example.listlibraryapi.exception.LibraryServiceException;
import com.example.listlibraryapi.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import com.example.listlibraryapi.repository.ListLibraryApiRepository;
import java.util.List;

@RestController
@RequestMapping("")
public class ListLibraryApiController {

    @Autowired
    private ListLibraryApiRepository listLibraryApiRepository;

    @Autowired
    private LibraryService libraryService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/get-all-books")
    public List<Library> getAllBooks() {
        try{return libraryService.getAllBooks();
        } catch (Exception e) {
            throw new LibraryServiceException("Error occurred during load books : "+ e);
        }

    }

    @GetMapping("/get-book/{id}")
    public Library getBookById(@PathVariable Long id) {
        try{
        return libraryService.getBookById(id);
        } catch (Exception e) {
            throw new LibraryServiceException("Error occurred during load book : "+e +e.getStackTrace().toString());
        }
    }

    @PostMapping("/book-add")
    public Library addBook(@RequestBody Library library) {
        try{
       return libraryService.addBook(library);
        } catch (Exception e) {
            throw new LibraryServiceException("Error occurred during add book : "+e +e.getStackTrace().toString());
        }
    }

    @PostMapping("/update-book")
    public Library updateBook(@RequestBody Library library) {
        try{
        return libraryService.updateBook(library);
        } catch (Exception e) {
            throw new LibraryServiceException("Error occurred during update book : "+e +e.getStackTrace().toString());
        }
    }

    @PostMapping("/delete-book")
    public Library deleteBook(@RequestBody Library library) {
        try{
        return libraryService.deleteBook(library);
        } catch (Exception e) {
            throw new LibraryServiceException("Error occurred during delete book : "+e +e.getStackTrace().toString());
        }
    }
}
