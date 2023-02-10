package com.example.library.Library.controller;


import com.example.library.Library.model.Library;
import com.example.library.Library.service.LibraryServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/library-info")
public class LibraryController {
    private LibraryServices libraryServices;

    public LibraryController(LibraryServices libraryServices) {
        this.libraryServices = libraryServices;
    }
    @GetMapping("allUser")
    public List<Library> findAll(){
        return libraryServices.findAll();
    }
    @GetMapping("/getLibrary/rank")
    public Library findByRank(@RequestParam int rank){
        return libraryServices.findByRank(rank);
    }
    @PostMapping("add-libraries")
    public void addLibraries(@RequestBody Library libraryInfo){
        libraryServices.addLibraries(libraryInfo);
    }
    @PutMapping("update-libraries/rank")
    public void updateLibrary(@RequestParam int rank,@RequestBody Library libraryInfo){
        libraryServices.updateLibrary(rank,libraryInfo);
    }
    @DeleteMapping("delete-library/rank")
    public void deleteLibrary(@RequestParam int rank){
        libraryServices.deleteLibrary(rank);
    }
}
