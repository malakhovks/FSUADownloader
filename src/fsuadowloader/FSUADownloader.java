/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsuadowloader;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MalahovKS
 */
public class FSUADownloader {

    /**
     * @param args the command line arguments
     */
    public static void main(String [] args) {
        // TODO code application logic here
        File f_in = new File(args[0]);
        String s;
        
        
         BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(f_in));
        } catch (FileNotFoundException ex) {
            
        }
        try {
            while ((s = br.readLine()) != null) {
            
                
                
            GetURL GU = new GetURL();
            GU.Get(s);
            
            
            }
        } catch (IOException ex) {
            Logger.getLogger(FSUADownloader.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
