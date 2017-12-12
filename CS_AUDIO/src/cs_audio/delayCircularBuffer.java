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
public class delayCircularBuffer extends CS_AUDIO 
{
    protected double[][] delaybuffer; 
  
    public delayCircularBuffer(int t)
    {
        super();
        delaybuffer = new double[my_wav.length][t];
    }  
     
    public void mutateFile(int t, double m, double f)
    {   
       for (int j = 0; j < my_wav.length; j++)
        {
           for (int i = t; i < my_wav[j].length; i++)
            {
                int k = i%delaybuffer[j].length;// pointer
                delaybuffer[j][k] = my_wav[j][i] + delaybuffer[j][k]*f;
                my_wav[j][i] = my_wav[j][i]*m + delaybuffer[j][k]*(1.0-m);
                
                }
            }
        }
    }

