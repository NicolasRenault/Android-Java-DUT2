package com.example.myapplication.model.interfaces;

public interface SerializableObject {

    void writeObject(Object o);

    Object readObject();
}
