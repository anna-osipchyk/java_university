package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class Contact implements //испрользование интерфейса, т е возможностей другого класса
        Comparable<Contact>,
        Iterable<String>, Iterator<String>
{
    ///////////////////////////////////////////////////
    // argument exception

    public static class ArgException extends Exception {//создание на базе существующего
        // класса новый с расширением родитльских методов
        private static final long serialVersionUID = 1L;//final - константа
        // final означает, что после присвоения ссылки на объект, уже нельзя
        // ее изменить, но можно изменять состояние объекта.


        ArgException( String arg ) {
            super( "Invalid argument: " + arg );
        }//конструктор, который
        //наследуется от родителя
    }

    ///////////////////////////////////////////////////
    // area names
    // final означает, что после присвоения ссылки на объект, уже нельзя
    // ее изменить, но можно изменять состояние объекта.
    public static final String[] names =//
            {
                    "*Contact",
                    "*Mobile",
                    "Work",
                    "Home",
                    "E-mail",
                    "WWW-page",
                    "Address"
            };

    //format strings for area printout
    public static String[] formatStr =  {//определенные форматы
            "%-9s",   //
            "%-9s",   //
            "%-9s",   //
            "%-9s",   //
            "%-17s",  //
            "%-17s",  //s - Любой тип, который будет приведен к строке
            "%-9s"    //цифра - колво символов в строке
    };

    ///////////////////////////////////////////////////
    // sort
    public static String getSortByName(int sortBy) {
        return Contact.names[sortBy];
    }
    //позиция в нэймс, (поле), по которой будет происходить сортировка

    public static Comparator<Contact> getComparator(int sortBy) {//создание коллабл объекта компаратора
        if ( sortBy >= names.length || sortBy < 0 ) {
            throw new IndexOutOfBoundsException();//создаем объект класса исключений и выбрасываем  его
        }
        return new Comparator<Contact> () {
            @Override //переопредление родительского метода
            public int compare(Contact c0, Contact c1) {
                return c0.areas[sortBy].compareTo( c1.areas[sortBy]);//лексиграфиеское сравнение строк
            }
        };
    }

    ///////////////////////////////////////////////////
    //  checkers (stubs)
    protected boolean validName(String str) {
        return str != null && str.length() > 0;
    }

    protected boolean validMobile(String str) {
        return str != null && str.length() > 0;
    }

    protected boolean validPhone(String str) {
        return str != null;
    }

    protected boolean validAddress(String str) {
        return str != null;
    }

    protected boolean validEMail(String str) {
        return str != null;
    }

    protected boolean validWWWPage(String str) {
        return str != null;
    }

    /////////////////////////////////////////
    // areas container
    private String[] areas = null;

    // indexator:
    public int length() {
        return areas.length;
    }
    public String getArea( int idx ) {
        if ( idx >= length() || idx < 0 ) {
            throw new IndexOutOfBoundsException();
        }
        return areas[idx];
    }
    public void setArea( int idx, String value ) throws ArgException {
        if ( idx >= length() || idx < 0 ) {
            throw new IndexOutOfBoundsException();
        }
        if (( idx == 0 && validName( value )== false ) 				||
                ( idx == 1 && validMobile( value )== false ) 			||
                ( idx > 1 && idx < 4 && validPhone( value )== false ) 	||
                ( idx == 4 && validEMail( value )== false ) 			||
                ( idx == 5 && validWWWPage( value )== false ) 			||
                ( idx == 6 && validAddress( value )== false )			) {
            throw new ArgException( value );
        }
        areas[idx] = value;
    }

    //Iterable<String>, Iterator<String>
    public Iterator<String> iterator() {
        reset();//обнуление итератора, перемещение на 0 элемент
        return this;//
    }

    private int iterator_idx = 0;
    public void reset() {
        iterator_idx = 0;
    }
    public boolean hasNext() {
        return iterator_idx >= areas.length ? false: true;
    }
    public void remove() {
        //
    }
    public String next() {
        if ( iterator_idx < areas.length ) {
            return areas[iterator_idx++];
        }
        reset();
        return null;
    }
    //Comparable<Contact>
    public int compareTo( Contact cy ) {
        return areas[0].compareTo( cy.areas[0] );
    }
    // toString
    public String toString() {
        if ( areas == null ) {
            return " | | | | | | ";
        }
        String res = areas[0];
        for ( int i = 1; i < areas.length; i++ ) {
            res += "|" + areas[i];
        }
        return res;
    }
    // constructors:
    //public Contact() {}
    private void setup( String[] args ) throws ArgException {
        if ( args == null ) {
            throw new ArgException( "null pointer passed for args" );
        }
        if ( args.length < 2 || args.length > names.length ) {
            throw new ArgException( Arrays.toString( args ));
        }
        areas = new String[names.length];
        int i = 0;
        for (; i < args.length; i++ ) {
            setArea( i, args[i] );
        }
        while ( i < names.length ) {
            areas[i++] = "";
        }
    }
    public Contact( String str ) throws ArgException {
        if ( str == null ) {
            throw new ArgException( "null pointer passed for str" );
        }
        // count tokens:
        int num = 1, idx = 0, idxFrom = 0;
        while (( idx = str.indexOf( '|', idxFrom ))!= -1 )
        {
            idxFrom = idx + 1;
            num++;
        }
        // allocate array
        String[] args = new String[num];
        // put all tokens to array
        idx = 0; idxFrom = 0; num = 0;
        while (( idx = str.indexOf( '|', idxFrom ))!= -1 )
        {
            args[num++] = str.substring( idxFrom, idx );
            idxFrom = idx + 1;
        }
        args[num] = str.substring( idxFrom );
        setup( args );
    }

    public Contact( String...args ) throws ArgException {
        setup( args );
    }

    private static String format( Iterable<String> what ) {
        String result = "";
        int idx = 0;
        for( String str : what ) {
            result += String.format( formatStr[idx++], str );
        }
        return result;
    }

    public static String format() {
        return Contact.format( Arrays.asList(Contact.names ));
    }

    public static String format( Contact cn ) {
        return Contact.format(((Iterable<String>) cn ));
    }
}

