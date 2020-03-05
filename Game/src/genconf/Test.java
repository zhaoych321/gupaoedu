package genconf;

import java.io.IOException;

public class Test {
	public static void main(String[] args) {
		org.apache.log4j.xml.DOMConfigurator.configure("log4j.xml");	
		com.thoughtworks.xstream.XStream xstream=new com.thoughtworks.xstream.XStream();
		try {
			HuobanPassiveSkillbookAttr.toXML("src", "src", xstream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
