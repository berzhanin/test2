package task27.parser;

import task27.dataClasses.Parameters;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class ParametersHandler extends DefaultHandler {

    private List<Parameters> parameters;
    private Parameters parameter;
    private boolean bTextForSearch = false;
    private boolean bRecipients = false;
    private boolean bTopicLetter = false;
    private boolean bTextLetter = false;
    private boolean bMoveToSpamValidText = false;
    private boolean bExtractFromSpamValidText = false;
    private boolean bSendLetterValidText = false;

    public List<Parameters> getParameters() {
        return parameters;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("Parameters")) {
            parameter = new Parameters();
            if (parameters == null) {
                parameters = new ArrayList<>();
            }

        } else if (qName.equalsIgnoreCase("textForSearch")) {
            bTextForSearch = true;
        } else if (qName.equalsIgnoreCase("recipients")) {
            bRecipients = true;
        } else if (qName.equalsIgnoreCase("topicLetter")) {
            bTopicLetter = true;
        } else if (qName.equalsIgnoreCase("textLetter")) {
            bTextLetter = true;
        } else if (qName.equalsIgnoreCase("moveToSpamValidText")) {
            bMoveToSpamValidText = true;
        } else if (qName.equalsIgnoreCase("extractFromSpamValidText")) {
            bExtractFromSpamValidText = true;
        } else if (qName.equalsIgnoreCase("sendLetterValidText")) {
            bSendLetterValidText = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("Parameters")) {
            parameters.add(parameter);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if (bTextForSearch) {
            parameter.setTextForSearch(new String(ch, start, length));
            bTextForSearch = false;
        } else if (bRecipients) {
            parameter.setRecipients(new String(ch, start, length));
            bRecipients = false;
        } else if (bTopicLetter) {
            parameter.setTopicLetter(new String(ch, start, length));
            bTopicLetter = false;
        } else if (bTextLetter) {
            parameter.setTextLetter(new String(ch, start, length));
            bTextLetter = false;
        } else if (bMoveToSpamValidText) {
            parameter.setMoveToSpamValidText(new String(ch, start, length));
            bMoveToSpamValidText = false;
        } else if (bExtractFromSpamValidText) {
            parameter.setExtractFromSpamValidText(new String(ch, start, length));
            bExtractFromSpamValidText = false;
        } else if (bSendLetterValidText) {
            parameter.setSendLetterValidText(new String(ch, start, length));
            bSendLetterValidText = false;
        }
    }
}