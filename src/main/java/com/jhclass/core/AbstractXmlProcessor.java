package com.jhclass.core;

import com.jhclass.annotation.XmlTag;
import com.jhclass.model.PostData;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class AbstractXmlProcessor {

    protected void process(String xmlPath,String className){
        XMLInputFactory inputFactory = XMLInputFactory.newFactory();
        inputFactory.setProperty("http://www.oracle.com/xml/jaxp/properties/getEntityCountInfo", "yes");
        inputFactory.setProperty("http://www.oracle.com/xml/jaxp/properties/totalEntitySizeLimit", Integer.MAX_VALUE);
        File sourceFile = new File(xmlPath);
        try (InputStream inputStream = new FileInputStream(sourceFile)) {
            int countRow = 0;
            Class<?> loadClass = this.getClass().getClassLoader().loadClass(className);
            XMLStreamReader streamReader = inputFactory.createXMLStreamReader(inputStream);
            while( streamReader.hasNext() ){
                streamReader.next();
                if ( streamReader.getEventType() == XMLStreamReader.START_ELEMENT ){
                    if ( "row".equals(streamReader.getLocalName()) ){
                        Object o = loadClass.newInstance();
                        for( Method method : loadClass.getMethods() ){
                            XmlTag annotation = method.getAnnotation(XmlTag.class);
                            if ( annotation != null ){
                                method.invoke(o,streamReader.getAttributeValue(null,annotation.name()));
                            }
                        }
                        countRow++;
                        if( o instanceof PostData){
                            PostData postData = (PostData)o;
                            System.out.println("Count:"+countRow+" id:"+postData.getId());
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}