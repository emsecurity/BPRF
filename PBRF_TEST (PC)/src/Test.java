
import java.math.BigInteger;

import it.unisa.dia.gas.jpbc.*;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;

public class Test {
	
	public static void main (String args[])
	{
		int iterations = 1000;
		int t1 = 0,t2=0,t3=0;
		Pairing pairing = PairingFactory.getPairing("param/d159.properties");
				
		for (int i = 0; i < iterations; i++) {
            Element g = pairing.getG1().newElement().setToRandom();
            Element h = pairing.getG2().newElement().setToRandom();

            long start = System.currentTimeMillis();
            pairing.pairing(g, h);
            long end = System.currentTimeMillis();
            t1 += Math.abs((end - start));

            /* Test of preprocessing
            start = System.currentTimeMillis();
            PairingPreProcessing ppp = pairing.pairing(g);
            end = System.currentTimeMillis();
            t2 += Math.abs((end - start));

            start = System.currentTimeMillis();
            ppp.pairing(h);
            end = System.currentTimeMillis();
            t3 += Math.abs((end - start));*/
            
        }
		

		System.out.println((double) t1 / iterations);
		System.out.println("finish");
	       
       
		Field G1 = pairing.getG1();
		Element e,z;
		
		for (int i = 0; i < iterations; i++) {
			
			e = G1.newRandomElement();
			z = pairing.getZr().newRandomElement();
			

            long start = System.currentTimeMillis();
            e.powZn(z);
            long end = System.currentTimeMillis();
            t2 += Math.abs((end - start));
           
        }

		System.out.println((double) t2 / iterations);
		
		System.out.println("finish");
		
	}

}
