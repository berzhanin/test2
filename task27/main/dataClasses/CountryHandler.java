package task27.dataClasses;

import task27.dataClasses.Country;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class CountryHandler extends DefaultHandler {

    private List<Country> countries;
    private Country country;
    private boolean bId = false;
    private boolean bCode = false;
    private boolean bName = false;
    private boolean bDescription = false;

    public List<Country> getCountries() {
        return countries;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("Country")) {
            country = new Country();
            if (countries == null) {
                countries = new ArrayList<>();
            }

        } else if (qName.equalsIgnoreCase("Id")) {
            bId = true;
        } else if (qName.equalsIgnoreCase("Code")) {
            bCode = true;
        } else if (qName.equalsIgnoreCase("Name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("Description")) {
            bDescription = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("Country")) {
            countries.add(country);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if (bId) {
            country.setId(Integer.parseInt(new String(ch, start, length)));
            bId = false;
        } else if (bCode) {
            country.setCode(new String(ch, start, length));
            bCode = false;
        } else if (bName) {
            country.setName(new String(ch, start, length));
            bName = false;
        } else if (bDescription) {
            country.setDescription(new String(ch, start, length));
            bDescription = false;
        }
    }
}