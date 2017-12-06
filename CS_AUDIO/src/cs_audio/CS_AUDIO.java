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
  protected double[][] delaybuffer = new double[][];

//public void fixeddelayLine(int t, double m){
//double m = 0.5;
//int t = 44100;
//for the array: i=t; i < my_wav.length, i++ 
//my_wav[0][1000]+ = my_wav[0][0];
//my_wav[0][i] = my_wav[0][i] * m + my_wav[0][i-t] * (1-m)
//}

public void mutateFile(int t, double m)
{
  for (int i = t; i < my_wav.length(); i++)
  {
    my_wav[0][i] = my_wav[0][i] * m += my_wav[0][i-t] * (1-m);
  }
}


// idea for polymorhpism: have fixedDelay method be called mutateFile() so each child can override this method
// with their corresponding thing they do such as flanger or chorus or echo, etc,
// then in main method when call a reference of the base delay class and call mutateFile() on that object, the
// effect that gets generated will depend on the kind of child object that the bass class reference is pointing to
// from matt
