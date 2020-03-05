package trans;

import java.lang.instrument.ClassDefinition;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

public class Premain {
	public static void premain(String agentArgs, Instrumentation inst)
			throws ClassNotFoundException, UnmodifiableClassException {
//		inst.addTransformer(new Transformer());
		
		byte[] bts = Transformer.getBytesFromFile(Transformer.classNumberReturns2);
		System.out.println("bts : " + bts);
		ClassDefinition def = new ClassDefinition(TransClass.class, bts);
	       inst.redefineClasses(def); 
	       System.out.println("success");
	}
}
