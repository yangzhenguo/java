package com.hiyzg.proto;

import lombok.Cleanup;

import java.io.*;

/**
 * Created by Sam on 2019/8/23.
 */
public class Main {
    public static void main(String[] args) {
        Person person = new Person();

        try {
            @Cleanup
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            @Cleanup
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(person);

            @Cleanup
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
            Object obj = ois.readObject();
            person.getNums().add(4);
            System.out.println(person);
            System.out.println(obj);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
