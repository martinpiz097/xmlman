/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.martin.xmlman.file.ex;

/**
 *
 * @author martin
 */
public class BadFormatException extends Exception {

    /**
     * Creates a new instance of <code>BadFormatException</code> without detail
     * message.
     */
    public BadFormatException() {
    }

    /**
     * Constructs an instance of <code>BadFormatException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public BadFormatException(String msg) {
        super(msg);
    }
}
