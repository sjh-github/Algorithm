package com.sjh.lombok;

import lombok.Cleanup;
import lombok.NonNull;
import lombok.SneakyThrows;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author sjh
 */
public class PersonInfoPrint {


    private static void printPersonInfo(@NonNull Person person) {
        System.out.println(person.toString());
        System.out.println(person.getName() + "," + person.getGender());
    }

    @SneakyThrows
    private static void fileOperate() {
        @Cleanup FileInputStream fin = new FileInputStream("/Users/sjh/Desktop/1.jpg");
        @Cleanup BufferedInputStream in = new BufferedInputStream(fin);
        @Cleanup FileOutputStream fout = new FileOutputStream("/Users/sjh/Desktop/lombok.jpg");
        @Cleanup BufferedOutputStream out = new BufferedOutputStream(fout);
        byte[] bytes = new byte[2048];
        int length = 0;
        while ((length = in.read(bytes, 0, bytes.length)) != -1) {
            out.write(bytes, 0, length);
        }

    }

    public static void main(String[] args) {
        Person person = new Person("sjh", "男");
        printPersonInfo(person);
        fileOperate();
    }
}
