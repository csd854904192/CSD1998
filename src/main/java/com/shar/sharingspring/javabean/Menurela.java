package com.shar.sharingspring.javabean;

public class Menurela {
    private int relaid;
    private int roleid;
    private int menuid;
    private String menuname;
    private String menuurl;
    private int menufid;

    public Menurela() {
    }

    public Menurela(int relaid, int roleid, int menuid) {
        this.relaid = relaid;
        this.roleid = roleid;
        this.menuid = menuid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getMenuurl() {
        return menuurl;
    }

    public void setMenuurl(String menuurl) {
        this.menuurl = menuurl;
    }

    public int getMenufid() {
        return menufid;
    }

    public void setMenufid(int menufid) {
        this.menufid = menufid;
    }

    public int getRelaid() {
        return relaid;
    }

    public void setRelaid(int relaid) {
        this.relaid = relaid;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public int getMenuid() {
        return menuid;
    }

    public void setMenuid(int menuid) {
        this.menuid = menuid;
    }

    @Override
    public String toString() {
        return "menurela{" +
                "relaid=" + relaid +
                ", roleid=" + roleid +
                ", menuid=" + menuid +
                ", menuname='" + menuname + '\'' +
                ", menuurl='" + menuurl + '\'' +
                ", menufid=" + menufid +
                '}';
    }
}
