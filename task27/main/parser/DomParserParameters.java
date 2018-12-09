package task27.parser;

import task27.dataClasses.Parameters;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class DomParserParameters {

    public List<Parameters> parse(Document document) {
        NodeList nodeList = document.getElementsByTagName("Parameters");
        List<Parameters> parameters = new ArrayList<Parameters>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            parameters.add(getParameter(nodeList.item(i)));
        }
        return parameters;
    }

    private static Parameters getParameter(Node node) {
        Parameters parameters = new Parameters();
        Element element = (Element) node;
        parameters.setTextForSearch(getTagValue("textForSearch", element));
        parameters.setRecipients(getTagValue("recipients", element));
        parameters.setTopicLetter(getTagValue("topicLetter", element));
        parameters.setTextLetter(getTagValue("textLetter", element));
        parameters.setMoveToSpamValidText(getTagValue("moveToSpamValidText", element));
        parameters.setExtractFromSpamValidText(getTagValue("extractFromSpamValidText", element));
        parameters.setSendLetterValidText(getTagValue("sendLetterValidText", element));

        return parameters;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}