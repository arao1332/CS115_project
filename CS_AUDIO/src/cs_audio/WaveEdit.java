/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package waveedit;

/**
 *
 * @author tbecker
 */
public class WaveEdit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //instatiate a new WaveTools Object
        //instantiation also reads the wav into the internal
        //my_wav variable
        WaveTools w_t = new WaveTools();
        //make the example file louder
        w_t.normalize();
        
        // reverse the example file
        w_t.reverse();
        
        //save the result to a new file, so you can hear it
        w_t.write_wave();
    }
}
