package com.jhclass;

public class MainApp {

    public static void main(String[] args) {
        String postsPath="";
        PostsXmlProcessor postsXmlProcessor = new PostsXmlProcessor("C:\\Users\\John_Yang\\EPAM_Work\\TestData\\Posts.xml");
        postsXmlProcessor.process();
    }
}