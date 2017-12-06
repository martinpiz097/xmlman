/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.martin.xmlman.io;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author martin
 */
public class StringInputStream extends InputStream {
    private final InputStream in;

    public StringInputStream(InputStream in) {
        this.in = in;
    }
    
    public String readAll() throws IOException{
        byte[] buffFile = new byte[in.available()];
        in.read(buffFile);
        // Posible causa de errores al no leerse como UNICODE
        return new String(buffFile);
    }

    @Override
    public boolean markSupported() {
        return in.markSupported();
    }

    @Override
    public synchronized void reset() throws IOException {
        in.reset();;
    }

    @Override
    public synchronized void mark(int readlimit) {
        in.mark(readlimit);
    }

    @Override
    public void close() throws IOException {
        in.close();
    }

    @Override
    public int available() throws IOException {
        return in.available();
    }

    @Override
    public long skip(long n) throws IOException {
        return in.skip(n);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        if (off <= len)
            throw new IndexOutOfBoundsException();
        
        int readLen =   
    }

    @Override
    public int read(byte[] b) throws IOException {
        return super.read(b); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
