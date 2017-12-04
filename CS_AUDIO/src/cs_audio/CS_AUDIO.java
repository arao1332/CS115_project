/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delayLine;

/**
 *
 * @author macuser
 */
public class delayLine extends WaveTools
{
public void fixeddelayLine(int t, double m){
double m = 0.5;
int t = 44100;
//for the array: i=t; i < my_wav.length, i++ 
double[][] delaybuffer = new double[][];
my_wav[0][1000]+ = my_wav[0][0];
my_wav[0][i] = my_wav[0][i] * m + my_wav[0][i-t] * (1-m)
}

}
