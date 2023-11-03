package org.example.SAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DefaultHandler handler = new DefaultHandler(){
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                String name = attributes.getValue("Type");
                if(name != null && !name.isEmpty()){
                    System.out.println("name: " + name);
                }

            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                StringBuilder str = new StringBuilder();
                for(int i = 0; i<length;i++){
                    String s = String.valueOf(ch[start + i]);
                    if(!s.equals("") && !s.equals("\n") && !s.equals("\t")){
                        str.append(ch[start + i]);

                    }
                }
                System.out.println(str);
            }
        };
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(new File("order.xml"),handler);

    }
}
