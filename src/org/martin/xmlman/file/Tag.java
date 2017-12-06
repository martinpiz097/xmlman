/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.martin.xmlman.file;

import java.util.LinkedList;
import static org.martin.xmlman.file.Symbols.MAJOR;
import static org.martin.xmlman.file.Symbols.MINOR;
import static org.martin.xmlman.file.Symbols.NEW_LINE;
import static org.martin.xmlman.file.Symbols.SLASH;
import static org.martin.xmlman.file.Symbols.SPACE;
import sun.invoke.util.ValueConversions;

/**
 *
 * @author martin
 */
public class Tag {
    private String name;
    private Tag parent;
    private LinkedList<Attribute> listAttributes;
    private LinkedList<Tag> listChilds;

    public Tag(String name) {
        this(name, new LinkedList<>(), new LinkedList<>());
    }

    public Tag(String name, LinkedList<Attribute> listAttributes, LinkedList<Tag> listChilds) {
        this.name = name;
        this.listAttributes = listAttributes;
        this.listChilds = listChilds;
    }

    public Tag(String name, Tag parent) {
        this.name = name;
        this.parent = parent;
    }

    public Tag(String name, Tag parent, LinkedList<Attribute> listAttributes, LinkedList<Tag> listChilds) {
        this.name = name;
        this.parent = parent;
        this.listAttributes = listAttributes;
        this.listChilds = listChilds;
    }
    
    private String startTag(){
        StringBuilder sbTag = new StringBuilder();
        sbTag.append(MINOR).append(name);
        
        if (!listAttributes.isEmpty()){
            sbTag.append(SPACE);
            for (Attribute attr : listAttributes)
                sbTag.append(attr.toString()).append(SPACE);
            sbTag.deleteCharAt(sbTag.length()-1);
        }
        sbTag.append(MAJOR);
        return sbTag.toString();
        
    }
    
    private String endTag(){
        StringBuilder sb = new StringBuilder();
        if (hasChilds())
            sb.append('\n');
        sb.append(MINOR).append(SLASH)
                .append(name).append(MAJOR);
        if (hasChilds()) sb.append(NEW_LINE);
        return sb.toString();
    }
    
    public boolean isRoot(){
        return parent == null;
    }
    
    public boolean hasChilds(){
        return !listChilds.isEmpty();
    }
    
    public boolean hasAttributes(){
        return !listAttributes.isEmpty();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Attribute> getListAttributes() {
        return listAttributes;
    }
    
    public Attribute getAttribute(String name){
        return listAttributes.stream().filter(a->a.getKey().equals(name))
                .findFirst().orElse(null);
    }
    
    public void setListAttributes(LinkedList<Attribute> listAttributes) {
        this.listAttributes = listAttributes;
    }

    /*public void addChild(String name, String content){
        Tag newChild = new Tag(name);
    }*/

    public Tag getParent() {
        return parent;
    }

    public void setParent(Tag parent) {
        this.parent = parent;
    }
    
    public void addChild(String name){
        addChild(new Tag(name));
    }
    
    public void addChild(Tag child){
        listChilds.add(child);
    }
    
    
    public LinkedList<Tag> getListChilds() {
        return listChilds;
    }

    public LinkedList<Tag> getChilds(String name){
        LinkedList<Tag> listFindedChilds = new LinkedList<>();
        listChilds.stream().filter(ch -> ch.getName().equals(name))
                .forEach(listFindedChilds::add);
        return listFindedChilds;
    }
    
    public Tag getFirstOcurrence(String name){
        return listChilds.stream().filter(ch->ch.getName().equals(name))
                .findFirst().orElse(null);
    }
    
    public void setListChilds(LinkedList<Tag> listChilds) {
        this.listChilds = listChilds;
    }

    @Override
    public String toString() {
        StringBuilder sbTag = new StringBuilder();
        sbTag.append(startTag());
        
        if (hasChilds()) {
            sbTag.append(NEW_LINE);
            for (Tag child : listChilds)
                sbTag.append(child.toString()).append(NEW_LINE);
            sbTag.deleteCharAt(sbTag.length()-1);
        }
        sbTag.append(endTag());
        return sbTag.toString();
    }

    public static void main(String[] args) {
        Tag root = new Tag("root");
        root.addChild("child");
        root.addChild("child");
        root.addChild("child");
        root.getFirstOcurrence("child").listAttributes.add(new Attribute("name", "nom1"));
    }
    
}
