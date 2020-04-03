package com.shar.sharingspring.javabean;

public class DocType {
    private int typeid;
    private String typename;
    private int bounty;

    public DocType() {
    }

    public DocType(int typeid, String typename, int bounty) {
        this.typeid = typeid;
        this.typename = typename;
        this.bounty = bounty;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public int getBounty() {
        return bounty;
    }

    public void setBounty(int bounty) {
        this.bounty = bounty;
    }

    @Override
    public String
    toString() {
        return "DocType{" +
                "typeid=" + typeid +
                ", typename='" + typename + '\'' +
                ", bounty=" + bounty +
                '}';
    }
}
