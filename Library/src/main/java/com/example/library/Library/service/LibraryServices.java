package com.example.library.Library.service;


import com.example.library.Library.model.Library;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service

public class LibraryServices {

    static final List<Library> libraryInfo = new ArrayList<>();
    private static int rank = 0;

    static{
        libraryInfo.add(new Library(++rank,"Swami Vivekananda" , "Vijay Nagar Indore" , 7021458735L,
                "Free WiFi","7:00 AM", "11:00 PM"));
        libraryInfo.add(new Library(++rank,"Maharaja" , "Palasia Indore" , 6024458735L,
                "Open 24*7","00:00 AM", "00:00 AM"));
        libraryInfo.add(new Library(++rank,"Eklavya" , "Sudama Nagar Indore" , 9998458735L,
                "Noise cancellation Separate cabins","4:00 AM", "11:00 PM"));
        libraryInfo.add(new Library(++rank,"Dronacharya" , "Navlakha Indore" , 8080458735L,
                "Tea and Snakes is Available","6:00 AM", "11:00 PM"));
        libraryInfo.add(new Library(++rank,"AryaBhatt" , "Super Plaza Indore" , 9876543210L,
                "Free Wifi+Free Books for Learning","5:00 AM", "11:00 PM"));

    }

    // find all libraries
    public List<Library> findAll(){
        return libraryInfo;
    }
    // find libraries by rank
    public Library findByRank(int rank){
        Predicate<? super Library> predict = todo->todo.getRank() == rank;
        Library library = libraryInfo.stream().filter(predict).findFirst().get();
        return library;
    }

    // adding new libraries
    public void addLibraries(Library library){
        libraryInfo.add(library);
    }

    // update the libraries information
    public void updateLibrary(int rank,Library newLibrary){

        Library library = findByRank(rank);

        library.setRank(newLibrary.getRank());
        library.setLibraryName(newLibrary.getLibraryName());
        library.setLibraryAddress(newLibrary.getLibraryAddress());
        library.setLibraryNumber(newLibrary.getLibraryNumber());
        library.setLibraryFacilities(newLibrary.getLibraryFacilities());
        library.setLibraryOpeningTime(newLibrary.getLibraryOpeningTime());
        library.setLibraryClosingTime(newLibrary.getLibraryClosingTime());
    }
    public void deleteLibrary(int rank){
        Predicate<? super Library> predicate = manages -> manages.getRank() == rank;
        libraryInfo.removeIf(predicate);
    }
}
