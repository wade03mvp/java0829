package com.web.tag;

import java.io.IOException;
import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class HelloTag implements Tag {

    private PageContext pageContext;
    private Tag parentTag;

    @Override
    public void setPageContext(PageContext pc) {
        pageContext = pc;
    }

    @Override
    public void setParent(Tag tag) {
        parentTag = tag;
    }

    @Override
    public Tag getParent() {
        return parentTag;
    }

    @Override
    public int doStartTag() throws JspException {
        // code
        JspWriter out = pageContext.getOut();
        try {
            out.print("Hello");
            out.print(new Date());
        } catch (IOException ex) {
                
        }
        return Tag.SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        // code
        return Tag.EVAL_PAGE; // 正常結束,繼續執行 JSP 未完成的任務
        // return Tag.SKIP_PAGE; // 此標籤後 JSP 程式不執行
    }

    @Override
    public void release() {

    }

}
