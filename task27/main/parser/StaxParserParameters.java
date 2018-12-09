package task27.parser;

import task27.dataClasses.Parameters;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StaxParserParameters {
    private static final String TEXT_FOR_SEARCH = "textForSearch";
    private static final String RECIPIENTS = "recipients";
    private static final String TOPIC_LETTER = "topicLetter";
    private static final String TEXT_LETTER = "textLetter";
    private static final String MOVE_TO_SPAM_VALIDTEXT = "moveToSpamValidText";
    private static final String EXTRACT_FROM_SAPM_VALIDTEXT = "extractFromSpamValidText";
    private static final String SEND_LETTER_VALIDTEXT = "sendLetterValidText";
    private static final String PARAMETERS = "Parameters";

    private Parameters parameter;
    List<Parameters> parameters = new ArrayList<>();

    public List<Parameters> parse(XMLEventReader xmlEventReader) throws FileNotFoundException, XMLStreamException {
        while (xmlEventReader.hasNext()) {
            XMLEvent xmlEvent = xmlEventReader.nextEvent();
            proceedStartElement(xmlEvent, xmlEventReader);
            proceedEndElement(xmlEvent);
        }
        return parameters;
    }

    private void proceedStartElement(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws XMLStreamException {
        if (xmlEvent.isStartElement()) {
            StartElement startElement = xmlEvent.asStartElement();
            if (isTagNameEqual(startElement, PARAMETERS)) {
                parameter = new Parameters();
            } else if (isTagNameEqual(startElement, TEXT_FOR_SEARCH)) {
                parameter.setTextForSearch(xmlEventReader.nextEvent().asCharacters().getData());
            } else if (isTagNameEqual(startElement, RECIPIENTS)) {
                parameter.setRecipients(xmlEventReader.nextEvent().asCharacters().getData());
            } else if (isTagNameEqual(startElement, TOPIC_LETTER)) {
                parameter.setTopicLetter(xmlEventReader.nextEvent().asCharacters().getData());
            } else if (isTagNameEqual(startElement, TEXT_LETTER)) {
                parameter.setTextLetter(xmlEventReader.nextEvent().asCharacters().getData());
            } else if (isTagNameEqual(startElement, MOVE_TO_SPAM_VALIDTEXT)) {
                parameter.setMoveToSpamValidText(xmlEventReader.nextEvent().asCharacters().getData());
            } else if (isTagNameEqual(startElement, EXTRACT_FROM_SAPM_VALIDTEXT)) {
                parameter.setExtractFromSpamValidText(xmlEventReader.nextEvent().asCharacters().getData());
            } else if (isTagNameEqual(startElement, SEND_LETTER_VALIDTEXT)) {
                parameter.setSendLetterValidText(xmlEventReader.nextEvent().asCharacters().getData());
            }
        }
    }

    private void proceedEndElement(XMLEvent xmlEvent) {
        if (xmlEvent.isEndElement()) {
            EndElement endElement = xmlEvent.asEndElement();
            if (endElement.getName().getLocalPart().equals(PARAMETERS)) {
                parameters.add(parameter);
            }
        }
    }

    private boolean isTagNameEqual(StartElement startElement, String tagName) {
        return startElement.getName().getLocalPart().equals(tagName);
    }
}