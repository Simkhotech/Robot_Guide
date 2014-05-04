package by.bstu.robotics.util;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import by.bstu.robotics.excursions.Excursion;
import by.bstu.robotics.excursions.Exhibit;


public class ParseXML {

	public ParseXML() {}
	public ArrayList<Excursion> Parse(){

        File f = new File("c:\\Documents and Settings\\Administrator\\workspace\\Client\\WebContent\\excursion.xml");
        Document document = parseFile(f);

        ArrayList<Exhibit> exhibits = new ArrayList<>();
        int length = document.getDocumentElement().getElementsByTagName("description").getLength();
        
        for (int i = 0; i < length; i++) {
        			String visual = document.getDocumentElement()
	        			.getElementsByTagName("visual")
	        			.item(i).getAttributes()
	        			.item(0).getTextContent();
        			
        			String audio = document.getDocumentElement()
		        		.getElementsByTagName("audio")
		        		.item(i).getAttributes()
	        			.item(0).getTextContent();
        			
        			String description = document.getDocumentElement()
		        		.getElementsByTagName("description")
		        		.item(i).getTextContent();
        			
        			int x = Integer.parseInt(document.getDocumentElement()
		        		.getElementsByTagName("x")
		        		.item(i).getTextContent());
        			
        			int y = Integer.parseInt(document.getDocumentElement()
		    	        .getElementsByTagName("y")
		    	        .item(i).getTextContent());
        			
        			int phi = Integer.parseInt(document.getDocumentElement()
		    	    	.getElementsByTagName("phi")
		    	    	.item(i).getTextContent());
		        	
        			exhibits.add(i, new Exhibit(i, visual, true, audio, description, x, y, phi));
        			System.out.println(exhibits.get(i).toString());
        }
        
                Excursion excursion = new Excursion(1, "Name"//document.getDocumentElement()
                /*		.getElementsByTagName("ExcursionTitle")
                		.item(0).getAttributes()
	        			.item(0).getTextContent()*/, exhibits);
                ArrayList<Excursion> excursions = new ArrayList<>();
                excursions.add(excursion);
                return excursions;
	}

	private static Document parseFile(File f) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
			return builder.parse(f);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
		return null;
	}

}
