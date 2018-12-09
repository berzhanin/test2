package task27.parser;

import task27.dataClasses.Country;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;

import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StaxParserCountries {
    private static final String DESCRIPTION = "Description";
    private static final String NAME = "Name";
    private static final String CODE = "Code";
    private static final String ID = "Id";
    private static final String COUNTRY = "Country";
    private Country country;
    List<Country> countries = new ArrayList<>();

    public List<Country> parse(XMLEventReader xmlEventReader) throws FileNotFoundException, XMLStreamException {
        while (xmlEventReader.hasNext()) {
            XMLEvent xmlEvent = xmlEventReader.nextEvent();
            proceedStartElement(xmlEvent, xmlEventReader);
            proceedEndElement(xmlEvent);
        }
        return countries;
    }

    private void proceedStartElement(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws XMLStreamException {
        if (xmlEvent.isStartElement()) {
            StartElement startElement = xmlEvent.asStartElement();
            if (isTagNameEqual(startElement, COUNTRY)) {
                country = new Country();
            } else if (isTagNameEqual(startElement, ID)) {
                country.setId(Integer.parseInt(xmlEventReader.nextEvent().asCharacters().getData()));
            } else if (isTagNameEqual(startElement, NAME)) {
                country.setName(xmlEventReader.nextEvent().asCharacters().getData());
            } else if (isTagNameEqual(startElement, CODE)) {
                country.setCode(xmlEventReader.nextEvent().asCharacters().getData());
            } else if (isTagNameEqual(startElement, DESCRIPTION)) {
                country.setDescription(xmlEventReader.nextEvent().asCharacters().getData());
            }
        }
    }

    private void proceedEndElement(XMLEvent xmlEvent) {
        if (xmlEvent.isEndElement()) {
            EndElement endElement = xmlEvent.asEndElement();
            if (endElement.getName().getLocalPart().equals(COUNTRY)) {
                countries.add(country);
            }
        }
    }

    private boolean isTagNameEqual(StartElement startElement, String tagName) {
        return startElement.getName().getLocalPart().equals(tagName);
    }
}