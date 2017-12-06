/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs_audio;

/**
 *
 * @author macuser
 */
public class delayCircularBuffer extends CS_AUDIO {
    
    protected double[][] delaybuffer = new double[2][100];
    
    
     
public delayCircularBuffer(){
    super();
}  
     
     public void mutateFile(int t, double m, double f)
{   
  for (int j = 0; j < my_wav.length; j++)
  {
      for (int i = t; i < my_wav[j].length; i++)
      {
          for (int k = 0; k < my_wav[j].length; k++)
          {
        delaybuffer[j][k] = my_wav[j][i] + delaybuffer[j][k] * f;
        
        my_wav[j][i] = my_wav[j][i] + m + delaybuffer[j][k] * (1.0 - m);
        my_wav[j][i] = (k+ 1)% t;
      }
  }
}
}
}

