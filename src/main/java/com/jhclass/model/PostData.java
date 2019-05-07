package com.jhclass.model;

import com.alibaba.fastjson.JSONObject;
import com.jhclass.annotation.XmlTag;

public class PostData {
    /**
     *  id of stack overflow post
     */
    private String id;
    /**
     * the number of view the post
     */
    private String viewCount;
    /**
     * created date
     */
    private String createDate;
    /**
     * title
     */
    private String title;
    /**
     * the tag for the post
     */
    private String tags;
    /**
     * the number of answer
     */
    private String answerCount;
    /**
     * the number of comment
     */
    private String commentCount;
    /**
     * the main body information of post
     */
    private String body;

    public String getId() {
        return id;
    }

    @XmlTag(name ="Id")
    public void setId(String id) {
        this.id = id;
    }


    public String getViewCount() {
        return viewCount;
    }
    @XmlTag(name = "ViewCount")
    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    public String getCreateDate() {
        return createDate;
    }
    @XmlTag(name="CreationDate")
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getTitle() {
        return title;
    }
    @XmlTag(name="Title")
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }
    @XmlTag(name="Tags")
    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getAnswerCount() {
        return answerCount;
    }
    @XmlTag(name="AnswerCount")
    public void setAnswerCount(String answerCount) {
        this.answerCount = answerCount;
    }

    public String getCommentCount() {
        return commentCount;
    }
    @XmlTag(name="CommentCount")
    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    public String getBody() {
        return body;
    }
    @XmlTag(name="Body")
    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}