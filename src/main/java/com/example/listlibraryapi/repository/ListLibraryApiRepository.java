package com.example.listlibraryapi.repository;

import com.example.listlibraryapi.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListLibraryApiRepository extends JpaRepository<Library, Long> {



}
