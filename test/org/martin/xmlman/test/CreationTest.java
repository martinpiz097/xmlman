/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.martin.xmlman.test;

import java.io.IOException;
import org.martin.xmlman.file.Tag;
import org.martin.xmlman.file.XMLDocument;

/**
 *
 * @author martin
 */
public class CreationTest {
    public static void main(String[] args) throws IOException {
        XMLDocument xml = new XMLDocument("test.xml");
        xml.create();
        Tag root = new Tag("root");
        Tag child = new Tag("hijo", root);
        child.addAttribute("name", "nom1");
        child.addAttribute("surname", "ape1");
        child.addChild("nieto");
        root.addChild("child");
        root.addChild("child");
        root.addChild("child");
        root.addChild(child);
        xml.setRootTag(root);
        xml.update();
    }

}
