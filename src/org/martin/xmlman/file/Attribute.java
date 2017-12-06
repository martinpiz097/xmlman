/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.martin.xmlman.file;

import static org.martin.xmlman.file.Symbols.EQUAL;

/**
 *
 * @author martin
 */
public class Attribute {
    private String key;
    private String value;

    public Attribute(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return new StringBuilder(key).append(EQUAL).append(value)
                .toString();
    }
    
}
