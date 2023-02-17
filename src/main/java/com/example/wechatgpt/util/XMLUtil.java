package com.example.wechatgpt.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringWriter;

/**
 * @Author: nansongling
 * @Date: 2023/2/17 12:36 PM
 **/
public class XMLUtil {
  public static <T> String parseToXml(T t) throws JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(t.getClass());
    Marshaller marshaller = jaxbContext.createMarshaller();
    StringWriter stringWriter = new StringWriter();
    marshaller.marshal(t, stringWriter);
    return stringWriter.toString();
  }
}
