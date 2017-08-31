package org.primefaces.avalon.view;

import java.io.File;
import java.net.URL;

public class Demo {
    public static void main(String[] args) {

        ClassLoader classLoader = Demo.class.getClassLoader();
        URL lResource = classLoader.getResource("messages.properties");
        File file = new File(lResource.getFile());
        System.out.println();
    }
}
