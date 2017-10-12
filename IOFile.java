/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author NGOCTAM
 */
public class IOFile {
    public void outFile(List list, String path ) throws FileNotFoundException, IOException {
        ObjectOutputStream outf = new ObjectOutputStream(new FileOutputStream(path));
        for (Object obj:list) {
            outf.writeObject(obj);
        }
        
    }
    
    public void InFile(List list, String path ) throws FileNotFoundException, IOException, ClassNotFoundException {
        list.clear();
        Object obj = null;
        ObjectInputStream inf = new ObjectInputStream(new FileInputStream(path));
        while((obj = inf.readObject()) != null){
            list.add(obj);
        }
        
    }
   
}
