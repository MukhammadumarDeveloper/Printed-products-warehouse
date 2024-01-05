package org.itpu.entity.properties;

import java.io.OutputStream;

public interface Printable {
    default public void print(){
        print(System.out);
    }
    public void print(OutputStream out);
}
