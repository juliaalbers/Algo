package staxapi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;


/*
 * Julia
 */



public class FilterStax {
	public static void main(String [] args) throws FileNotFoundException, XMLStreamException {
		//get XML input factory
		XMLInputFactory factory = XMLInputFactory.newInstance();
		//create XML Stream reader
		XMLStreamReader strmReader = factory.createXMLStreamReader(new FileInputStream("C:\\1Studium Informatik\\Prog\\‹bungen\\Assignment2Web\\src\\staxapi\\newsticker.rdf"));
		
		String elementText;
		String [] test = {"Berlin", "Mensch", "Android", "Java", "Welt"};
		
		
		while(strmReader.hasNext()) {
			strmReader.next();

			try {
				//Filtert alles auﬂer "description" - Start_Elemente 
				strmReader.require(XMLEvent.START_ELEMENT,null, "description");
				
				elementText = strmReader.getElementText();
				for(int i = 0; i < test.length; i++) {
					if(elementText.contains(test[i])) {
						String elementName = strmReader.getLocalName();
						System.out.print("<" + elementName + ">");
//						System.out.print("CHECK!  ------------------------  ");
						System.out.println(" "+ elementText);
					}
				}
			}catch (XMLStreamException e) {	}
		}
	}
}
