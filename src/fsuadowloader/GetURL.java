/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsuadowloader;

/**
 *
 * @author kirilmalahov
 *
 */
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetURL {

    /**
     * @param args the command line arguments
     */
    public void Get(String in_string_url) {
        // TODO code application logic here
        URL url;
        InputStream in = null;
        OutputStream out = null;

        try {
            // Set up the streams
            url = new URL(in_string_url);   // Create the URL


            URLConnection c = url.openConnection();
            c.connect();
            System.out.println("  Content Length: " + c.getContentLength());
            System.out.println("  Content Type: " + c.getContentType());

            in = url.openStream();        // Открываем поток


            in_string_url = in_string_url.substring(in_string_url.lastIndexOf("/") + 1, in_string_url.length());
            out = new FileOutputStream(in_string_url);
            // out = System.out;


            //Коприрование байт из указанного URL в OutputStream
            byte[] buffer = new byte[20096]; //размер скачеваемого пакета
            int bytes_read;
            System.out.println("Start Downloading ...");

            while ((bytes_read = in.read(buffer)) != -1) {

                out.write(buffer, 0, bytes_read);
                System.out.println(Integer.toString(bytes_read));

            }

        } catch (IOException ex) {
            Logger.getLogger(GetURL.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Finish Dowloading");
        try {

            in.close();
        } catch (IOException ex) {
            Logger.getLogger(GetURL.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(GetURL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
