package com.company;

import java.util.Arrays;
import com.company.Contact;

class Main
{
    static void sortAndPrint(Contact[] pl, int sortBy )  {
        // printout in table
        System.out.println( "----- Sorted by: " + Contact.getSortByName(sortBy));
        Arrays.sort( pl, Contact.getComparator(sortBy));
        System.out.printf( Contact.format() );
        System.out.println();
        for( Contact cnt : pl ) {
            System.out.println( Contact.format( cnt ) );
        }
    }
    public static void main(String[] args) {
        try {
            Contact[] pl = new Contact[4];
            pl[0] = new Contact( "Joahn|1234567|9876543||joahn@gmail.com||" );
            pl[1] = new Contact( "Ann|2345678|8765432||nann@gmail.com||" );
            pl[2] = new Contact( "Mary", "3456789", "7654321", "", "mary@gmail.com" );
            pl[3] = new Contact( "Empty|0000000|||||" );
            sortAndPrint( pl, 0 );
            sortAndPrint( pl, 1 );
            sortAndPrint( pl, 2 );
            sortAndPrint( pl, 4 );
            // exception test:
            new Contact("Test exception object");
        }
        catch ( Exception e ) {
            System.out.println( "Exception: " + e );
        }
    }
}
