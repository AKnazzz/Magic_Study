package org.workwork.g_spring.homework_g5.hw;

import org.apache.commons.lang3.StringUtils;

/**
 * Hello world!
 *
 */
public class App {
    private static final String MSG = "Hello World!";

    public static void main( String[] args ) {
        System.out.printf( "Original message: %s%n", MSG );
        System.out.printf( "Reversed message: %s%n", StringUtils.reverse(MSG) );
    }
}