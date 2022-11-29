package ru.ezuykow.stringlist.exceptions;

public class IndexIsNotValidException extends RuntimeException{

    public IndexIsNotValidException() {
        super("Index out of bounds!");
    }
}
