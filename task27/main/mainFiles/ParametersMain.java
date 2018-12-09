package task27.mainFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;

import task27.parser.DomParserParameters;
import task27.dataClasses.Parameters;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import task27.parser.ParametersHandler;
import task27.parser.StaxParserParameters;

public class ParametersMain {
    private static final String PARAMETERS_XML = "src/main/resources/Parameters.xml";

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException,
            XMLStreamException {
        List<Parameters> parameters;

        System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~ SAX parser ~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        ParametersHandler parametersHandler = new ParametersHandler();
        saxParser.parse(new File(PARAMETERS_XML), parametersHandler);
        parameters = parametersHandler.getParameters();
        parameters.forEach(System.out::println);

        System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~ STAX parser ~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(PARAMETERS_XML));
        parameters = new StaxParserParameters().parse(xmlEventReader);
        parameters.forEach(System.out::println);

        System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~ DOM parser ~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(PARAMETERS_XML);
        parameters = new DomParserParameters().parse(document);
        parameters.forEach(System.out::println);
    }
}