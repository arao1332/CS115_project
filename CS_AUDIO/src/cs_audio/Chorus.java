/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs_audio;
import java.util.ArrayList;
/**
 *
 * @author petermorganjr
 */
public class Chorus extends delayCircularBuffer{
    
    public Chorus(int t){
        super(t);
    }
    

    protected ArrayList<double[][]> chorus = new ArrayList<double[][]>();
    protected int[] primes = {5003,5009,5011,5021,5023,5039,5051,5059,5077,5081,5087,5099,5101,5107,5113,5119,5147,5153,5167,5171,5179,5189,5197,5209,5227,5231,5233,5237};
    public void build_chorus(){
        for(int i = 0; i < primes.length; i++){
            chorus.add(new double[my_wav.length][primes[i]]);
        }
    }
    @Override 
    public void mutateFile(int t, double m, double f){
        for(int i = 0; i < my_wav.length; i++){
           for(int j = 0; j < my_wav[i].length; j++){
               for(int x = 0; x < chorus.size(); x++){
                    double[][] d = chorus.get(x);
                    int k = j%d[i].length;
                    my_wav[i][j] = my_wav[i][j]*m + d[i][k]*(1.0-m);
                    d[i][k] = my_wav[i][j]+d[i][k]*f;
               }
        } 
    
}
    }
}


