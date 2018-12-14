package webPageMailRu.setting;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomParameters {
    private static final String PARAMETERS_XML = "src/main/resources/Parameters.xml";
    private Parameters parameters;

    private Parameters getParameters(Document document) {
        NodeList nodeList = document.getElementsByTagName("Parameters");
        parameters = getParameter(nodeList.item(0));
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

    public Parameters parse() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(PARAMETERS_XML);
        parameters = getParameters(document);
        return parameters;
    }
}
