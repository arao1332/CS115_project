/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs_audio;

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
       // WaveTools w_t = new WaveTools();
        //make the example file louder
        CS_AUDIO delay = new CS_AUDIO();
        // reverse the example file
        delay.mutateFile(44100, 0.5);
        
        //save the result to a new file, so you can hear it
        delay.write_wave();
    }
}