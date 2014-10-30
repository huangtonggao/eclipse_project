package parseXML;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;



import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
import org.w3c.dom.*;

public class parseXML {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
//		System.out.println(System.getProperty("user.dir"));
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document d = builder.parse(new File("src/parseXML/test.xml"));

		Element root = d.getDocumentElement();
		
		NodeList list = root.getChildNodes();
		
		System.out.println(list.getLength());
		
		for (int i = 0; i < list.getLength(); i++)
		{
			Node node = list.item(i);
			if (node instanceof Element)
			{
				System.out.println(node.getNodeName()); //获取到了Student元素
				
				System.out.println("node.getFirstChild() is " + node.getFirstChild().getNextSibling().getNodeName());
				
				NodeList list1 = node.getChildNodes();
				System.out.println("list1.getLength() is " + list1.getLength());
				for (int j = 0; j < list1.getLength(); j++)
				{
					Node node1 = list1.item(j);
					if (node1 instanceof Element)
					{
						//System.out.println(node1.getNodeName());
//						System.out.println(node1.getNodeValue());
						//System.out.println(node1.getChildNodes().getLength());
						
						
						Node node11 = node1.getFirstChild();
						if (node11 instanceof Text)
						{
//							System.out.println(((Text)node11).getData());
							System.out.println(node11.getNodeName());
							System.out.println(node11.getNodeValue());
						}
						else if (node11 instanceof Element)
						{
							System.out.println("node11 instanceof Element branch: " + node11.getNodeName());
						}
					
						
					}
				}
				
			}
			
		}
		
		
		
		
//		System.out.println(root.getNodeName());
//		System.out.println(root.getNodeValue());
//		System.out.println(root.getAttributes().getLength());
		
//		NamedNodeMap map = root.getAttributes();
//		System.out.println("root element has " +map.getLength() + " elements");
//		for (int i = 0; i < map.getLength(); i++)
//		{
//			Node node = map.item(i);
//			
//			if (node instanceof Attr)
//			{
//				Attr attr = (Attr)node;
//				System.out.println(attr.getTextContent());
//			}
//			
////			System.out.println(node.getNodeName());
////			System.out.println(node.getNodeValue());			
//		}
		
		
		
	}

}
