package org.example;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("order.xml"));
        Element element = document.getDocumentElement();
        printElements(element.getChildNodes());
    }

    private static void printElements(NodeList childNodes) {
        for(int i = 0; i<childNodes.getLength(); i++){
            if(childNodes.item(i) instanceof Element){
                if (((Element) childNodes.item(i)).hasAttribute("Type")) {
                    System.out.println(((Element) childNodes.item(i)).getTagName() + ": " + ((Element) childNodes.item(i)).getAttribute("Type"));
                } else {
                    System.out.println(((Element) childNodes.item(i)).getTagName());
                }
            }
            if (childNodes.item(i).hasChildNodes()){
                printElements(childNodes.item(i).getChildNodes());
            }
        }
    }
}
