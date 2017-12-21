/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.martin.xmlman.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.martin.xmlman.file.ex.BadFormatException;
import org.martin.xmlman.io.StringInputStream;

/**
 *
 * @author martin
 */
public class TagManager {
    public static Tag createTagFrom(String text) throws BadFormatException{
        text = text.trim();
        char[] chars = text.toCharArray();
        if (text.contains("<") && text.contains(">") && text.contains("/")) {
            StringBuilder sbName = new StringBuilder();
            StringBuilder sbAttr = new StringBuilder();
            
        }
        else
            throw new BadFormatException("El formato del archivo es invalido");
    }
    
    public static Tag createTagFrom(File file) throws IOException, BadFormatException{
        String fileLines;
        try (StringInputStream sis = new StringInputStream(new FileInputStream(file))) {
            fileLines = sis.readAll();
        }
        return createTagFrom(fileLines);
    }
    
    private Tag createTagFrom(Tag parent, String tagText){
        StringBuilder sbName = new StringBuilder();
        char[] chars = tagText.toCharArray();
        
    }
    
}
