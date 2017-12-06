/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.martin.xmlman.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author martin
 */
public class XMLDocument {
    //private String encoding;
    //private String version;

    private Tag rootTag;
    private File xmlFile;

    public XMLDocument(String path) {
        if (!path.endsWith(".xml"))
            path+=".xml";
        xmlFile = new File(path);
    }

    public XMLDocument(File xmlFile) {
        this.xmlFile = xmlFile;
    }
    
    public void load() throws IOException{
        if (xmlFile.exists()) {
            if (xmlFile.length() > 0) {
                // Verificar si tiene estructura xml
                rootTag = TagManager.createTagFrom(xmlFile);
            }
        }
    }
    
    public void loadOrCreate() throws IOException{
        if (xmlFile.exists()) {
            if (xmlFile.length() > 0) {
                // Verificar si tiene estructura xml
                rootTag = TagManager.createTagFrom(xmlFile);
            }
        }
        else
            create();
    }
    
    public void create() throws IOException{
        if (xmlFile.getParentFile() != null)
            if (!xmlFile.getParentFile().exists())
                    xmlFile.getParentFile().mkdirs();
        xmlFile.createNewFile();
    }
    
    public void update() throws IOException{
        xmlFile.createNewFile();
        if (rootTag != null) {
            Files.write(xmlFile.toPath(), rootTag.toString().getBytes(), 
                    StandardOpenOption.WRITE);
        }
    }

    public Tag getRootTag() {
        return rootTag;
    }

    public void setRootTag(Tag rootTag) {
        this.rootTag = rootTag;
    }

    public File getFile() {
        return xmlFile;
    }

    public void setFile(File xmlFile) {
        this.xmlFile = xmlFile;
    }
    
}
