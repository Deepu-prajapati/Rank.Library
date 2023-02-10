package com.example.library.Library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Library {

    private int rank;
    private String libraryName;
    private String libraryAddress;
    private long libraryNumber;
    private String libraryFacilities;
    private String libraryOpeningTime;
    private String libraryClosingTime;


}
