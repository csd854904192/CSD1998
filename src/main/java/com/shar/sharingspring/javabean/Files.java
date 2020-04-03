package com.shar.sharingspring.javabean;

public class Files {
    private int docid;
    private String docname;
    private String docdes;
    private String doctype;
    private int docscore;
    private String updoctime;
    private String docstatu;
    private int dowcount;
    private int userid;
    private String docurl;

    public Files() {
    }

    public int getDocid() {
        return docid;
    }

    public void setDocid(int docid) {
        this.docid = docid;
    }

    public String getDocname() {
        return docname;
    }

    public void setDocname(String docname) {
        this.docname = docname;
    }

    public String getDocdes() {
        return docdes;
    }

    public void setDocdes(String docdes) {
        this.docdes = docdes;
    }

    public String getDoctype() {
        return doctype;
    }

    public void setDoctype(String doctype) {
        this.doctype = doctype;
    }

    public int getDocscore() {
        return docscore;
    }

    public void setDocscore(int docscore) {
        this.docscore = docscore;
    }

    public String getUpdoctime() {
        return updoctime;
    }

    public void setUpdoctime(String updoctime) {
        this.updoctime = updoctime;
    }

    public String getDocstatu() {
        return docstatu;
    }

    public void setDocstatu(String docstatu) {
        this.docstatu = docstatu;
    }

    public int getDowcount() {
        return dowcount;
    }

    public void setDowcount(int dowcount) {
        this.dowcount = dowcount;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getDocurl() {
        return docurl;
    }

    public void setDocurl(String docurl) {
        this.docurl = docurl;
    }

    @Override
    public String toString() {
        return "Files{" +
                "docid=" + docid +
                ", docname='" + docname + '\'' +
                ", docdes='" + docdes + '\'' +
                ", doctype='" + doctype + '\'' +
                ", docscore=" + docscore +
                ", updoctime='" + updoctime + '\'' +
                ", docstatu='" + docstatu + '\'' +
                ", dowcount=" + dowcount +
                ", userid=" + userid +
                ", docurl='" + docurl + '\'' +
                '}';
    }
}
