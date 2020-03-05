package xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {
	
	public static final String ROLE_CACHE_NAME = "ROLE_CACHE_CAPACITY";
	public static final String FACTION_CACHE_NAME = "FACTION_CACHE_CAPACITY";
	
	public static void main(String[] args) {
		try {
			DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
			df.setXIncludeAware(true);
			df.setNamespaceAware(true);
			Document doc = df.newDocumentBuilder().parse("gsx.xdb.xml.m4");
			parse(doc.getDocumentElement());
			
			write(doc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void parse(Element self) throws Exception {
		NodeList childnodes = self.getChildNodes();
		for (int i = 0; i < childnodes.getLength(); ++i) {
			Node node = childnodes.item(i);
			parseNode(node);
		}
	}
	
	private static void parseNode(Node node) throws Exception {
		if (Node.ELEMENT_NODE != node.getNodeType())
			return;

		Element e = (Element) node;
		String nodename = e.getNodeName();
		if (nodename.equals("table")) {
			String attr_lock = e.getAttribute("lock");
			String attr_persistence = e.getAttribute("persistence");
			
			if (attr_lock != null && "rolelock".equals(attr_lock) && (attr_persistence == null || !"MEMORY".equals(attr_persistence))) {
				e.setAttribute("cacheCapacity", ROLE_CACHE_NAME);
			}
		}
	}
	
	private static void write(Document doc) throws FileNotFoundException, TransformerException {
//		try {
//			File file = new File("rssnews.xml");
//			
//			OutputFormat format = OutputFormat.createPrettyPrint();
//			format.setEncoding("UTF-8");
//			
//			XMLWriter writer = new XMLWriter(new FileOutputStream(file),format);
//			writer.setEscapeText(false);
//			writer.write(doc);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		//生成XML文件
		DOMSource source = new DOMSource(doc);
		TransformerFactory tf = TransformerFactory.newInstance();
		//设置缩进量
		tf.setAttribute("indent-number", new Integer(3));
		Transformer transformer = tf.newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		//设置文档的换行与缩进
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		//合成文件路径
		File file = new File("test.xml");
		
		//写入文件
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		PrintWriter pw = new PrintWriter(fileOutputStream);
		StreamResult result = new StreamResult(pw);
		transformer.transform(source, result);
		System.out.println("生成XML文件成功!");
		
	}
}
