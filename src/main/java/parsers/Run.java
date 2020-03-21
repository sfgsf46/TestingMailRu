package parsers;

import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Run {
    private static final String COUNTRIES_XML = "project.xml";

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        System.out.println("SAX parser:");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        SaxParser modelHandler = new SaxParser();
        saxParser.parse(new File(COUNTRIES_XML), modelHandler);
        List<Model> models = modelHandler.getData();
        models.forEach(model -> System.out.println(model));

    }
}
