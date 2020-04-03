package com.shar.sharingspring.javabean;

import java.util.List;

public class TreeResult {
    private String title;
    private Integer id;
    private List<TreeResult>children;


    public TreeResult() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<TreeResult> getChildren() {
        return children;
    }

    public void setChildren(List<TreeResult> children) {
        this.children = children;
    }


    @Override
    public String toString() {
        return "TreeResult{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", children=" + children +
                '}';
    }
}
