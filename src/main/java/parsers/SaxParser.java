package parsers;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SaxParser extends DefaultHandler {
    private List<Model> data;
    private Model model;
    boolean isSite = false;
    boolean isLink = false;
    boolean isDescription = false;

    public List<Model> getData() {
        return data;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        if (qName.equalsIgnoreCase("Info")) {
            String id = attributes.getValue("id");

            model = new Model();
            model.setId(Integer.parseInt(id));
            if (data == null) {
                data = new ArrayList<>();
            }
        } else if (qName.equalsIgnoreCase("site")) {
            isSite = true;
        } else if (qName.equalsIgnoreCase("link")) {
            isLink = true;
        } else if (qName.equalsIgnoreCase("description")) {
            isDescription = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("Info")) {
            data.add(model);
        }
    }

    @Override
    public void characters(char characters[], int start, int length) {

        if (isSite) {
            model.setSite(new String(characters, start, length));
            isSite = false;
        } else if (isLink) {
            model.setLink(new String(characters, start, length));
            isLink = false;
        } else if (isDescription) {
            model.setDescription(new String(characters, start, length));
            isDescription = false;
        }
    }
}
