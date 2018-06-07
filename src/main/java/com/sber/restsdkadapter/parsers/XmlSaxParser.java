package com.sber.restsdkadapter.parsers;

import com.sber.restsdkadapter.models.Statement;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Arrays;

@Service
@Log4j2
public class XmlSaxParser {

    public Statement readXmlAndGetNewStatement() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        Statement statement = new Statement();
        final String URI = "c:\\file.xml";

        DefaultHandler handler = new DefaultHandler() {

            boolean isValuePresent = false;

            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                log.info("Start Element:" + qName);
                if (qName.equalsIgnoreCase("value")) {
                    isValuePresent = true;
                }
            }

            public void endElement(String uri, String localName, String qName) throws SAXException {
                log.info("End Element:" + qName);
            }

            public void characters(char ch[], int start, int length) throws SAXException {
                if (isValuePresent) {
                    statement.setValue(new String(ch));
                    log.info("Value: " + new String(ch, start, length));
                    isValuePresent = false;
                }
            }
        };

        try {
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(URI, handler);
        } catch (ParserConfigurationException e) {
            log.error("Factory cannot produce new SAXParser because of configuration " + Arrays.toString(e.getStackTrace()));
        } catch (SAXException e) {
            log.error("SaxParser cannot parse or handle " + Arrays.toString(e.getStackTrace()));
        } catch (IOException e) {
            log.error("Can't read file for parsing " + URI + Arrays.toString(e.getStackTrace()));
        }

        return statement;
    }
}
