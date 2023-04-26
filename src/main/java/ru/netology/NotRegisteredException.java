package ru.netology;
public class NotRegisteredException extends RuntimeException{
    public NotRegisteredException (String name) {

        super("Player" + name + "not found");
    }
}
