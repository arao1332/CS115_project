/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package waveedit;

import java.io.*;
import javax.swing.*;
import java.util.Random;

/**
 *
 * @author tbecker
 */
public class WaveTools {
    
    //main reading function stores file in my_wav
    //and populates all the internal variables
    public WaveTools(){        
        try
        {
            File inWav = select_wave();
            // Open the wav file specified as the first argument
            System.out.println("Attempting to read file: " + inWav);
            WavFile wavFile = WavFile.openWavFile(inWav);

            // Display information about the wav file
            wavFile.display();

            // Get the number of audio channels in the wav file
            sample_rate = (int)wavFile.getSampleRate();
            bit_depth = wavFile.getValidBits();
            wav_name = inWav.getAbsolutePath();
            
            // Create a buffer of 100 frames
            my_wav = new double[wavFile.getNumChannels()][(int)wavFile.getNumFrames()];
            
            //store a a double[][] 2D real-valued array
            int framesRead = wavFile.readFrames(my_wav, my_wav[0].length);
            wavFile.close();

        }
        catch (Exception e)
        {
            System.err.println(e);
        }
    }
    
    //graphical dialog box that allows user to pick the wav file
    public File select_wave(){
        File selected = new File("");
        
        try{
            JFileChooser chooser = new JFileChooser();
            int status = chooser.showOpenDialog(null);
            selected = chooser.getSelectedFile();
        
        }
        catch (Exception e){
            System.err.println(e);
        }
        
        return selected;
    }
    
    //finds the largest absolute value in the my_wav array
    //and then scales (multiplies every element in the array) 
    //by the inverse
    public void normalize()
    {           
        //find the maximum absolute value
        double max_amp = 0.0;
        
        for (int i = 0; i < my_wav.length; i++)
        {
            for (int j = 0; j < my_wav[i].length; j++)
            {
                double value = Math.abs(my_wav[i][j]);
                if (value > max_amp)
                {
                    max_amp = my_wav[i][j]; // assign value to max_amp
                }      
            }
        }
                
        //scale the result to get the normalized version
        double diff;
        for (int i = 0; i < my_wav.length; i++)
        {
            for (int j = 0; j < my_wav[i].length; j++)
            {
                diff = my_wav[i][j] * (1 / max_amp);
                my_wav[i][j] = diff;    // store result back into array
            }
        }
    }
    
    //reverse the contents of the my_wav array
    public void reverse()
    {
        for (int i = 0; i < my_wav.length; i++)
        {
            for (int j = 0; j < my_wav[i].length / 2; j++)
            {
                double temp = my_wav[i][j]; // assign first value to variable
                
                // reverse elements
                my_wav[i][j] = my_wav[i][my_wav[i].length - j - 1];
                my_wav[i][my_wav[i].length - j - 1] = temp;
            }
        }
    }
    
    //finalizes processes by writing an output wav audio file
    public void write_wave(){
         try{
                // Create a wav file with the name specified as the first argument
                int end_pos = wav_name.indexOf(".wav");
                String new_wav_name = wav_name.substring(0,end_pos) + "-out.wav";
		WavFile wavFile = WavFile.newWavFile(new File(new_wav_name), my_wav.length, 
                                                     my_wav[0].length, bit_depth, sample_rate);
		// Write the buffer
		wavFile.writeFrames(my_wav, my_wav[0].length);

		// Close the wavFile
		wavFile.close();
	}   
	catch (Exception e){
            System.err.println(e);
	}
        
    }
    
    //sample rate is the time resolution of the wave file
    //a higher sample rate sounds more realistic
    protected int    sample_rate;
    //bit depth is the size of the nubers used to store the
    //amplitude, thus affecting amplitude resolution and
    //in turn dynamics. More bits sounds better
    protected int    bit_depth;
    //String used to find, load, and read into the
    //my_wav array, also this name is appended with -out
    //when the wave_write function is called
    protected String wav_name;
    //internal 2D array used to store the wav file selected from
    //the graphical chooser when the WaveTools constructor is called
    protected double[][] my_wav;
}
