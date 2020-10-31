package com.web.tag;

import java.io.IOException;
import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class BmiTag implements Tag {
    private PageContext pageContext;
    private Tag parentTag;
    private double h ,w;

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

    public Tag getParentTag() {
        return parentTag;
    }

    public void setParentTag(Tag parentTag) {
        this.parentTag = parentTag;
    }

    public Double getH() {
        return h;
    }

    public void setH(Double h) {
        this.h = h;
    }

    public Double getW() {
        return w;
    }

    public void setW(Double w) {
        this.w = w;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            double bmi = w / Math.pow(h/100, 2);
            String result = (bmi>23)?"過重":(bmi<=18)?"過輕":"正常";
            String data = String.format("h: %.1f w: %.1f bmi: %.2f (%s)", h, w, bmi, result);
            out.print(data); 
        } catch (IOException ex) {
            
        }
        
        return Tag.SKIP_BODY;
    }
    

    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {

    }
    
}
