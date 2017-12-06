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
public class CS_AUDIO extends WaveTools
{
    
    public CS_AUDIO()
    {
        super();
    }
    
    public void mutateFile(int t, double m)
    {
        for (int j = 0; j < my_wav.length; j++)
        {
            for (int i = t; i < my_wav[j].length; i++)
            {
                my_wav[j][i] = my_wav[j][i] * m + my_wav[j][i-t] * (1.0-m);
            }
        }
    }
}


// idea for polymorhpism: have fixedDelay method be called mutateFile() so each child can override this method
// with their corresponding thing they do such as flanger or chorus or echo, etc,
// then in main method when call a reference of the base delay class and call mutateFile() on that object, the
// effect that gets generated will depend on the kind of child object that the bass class reference is pointing to
// from matt