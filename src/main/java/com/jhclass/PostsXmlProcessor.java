package com.jhclass;

import com.jhclass.core.AbstractXmlProcessor;
import com.jhclass.core.XmlProcessor;
import com.jhclass.model.PostData;


public class PostsXmlProcessor extends AbstractXmlProcessor implements XmlProcessor {

    private String xmlPath;
    private String className;
    private PostData postData;
    private Class<?> loadClass = null;

    public PostsXmlProcessor(String xmlPath) {
        this.xmlPath = xmlPath;
        this.className = PostData.class.getName();
    }

    public void process(){
        this.process(this.xmlPath,this.className);

    }
}