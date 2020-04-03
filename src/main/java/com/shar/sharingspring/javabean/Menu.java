package com.shar.sharingspring.javabean;

import java.util.List;

public class Menu {
    private int menuid;
    private String menuname;
    private String menuurl;
    private int menufid;
    private Menurela menurela;

    private List fNodeId;
    private List cNodeId;

    private int roleid;
    private List<Menurela> relist;

    public Menu() {
    }

    public Menu(int menuid, String menuname, String menuurl, int menufid) {
        this.menuid = menuid;
        this.menuname = menuname;
        this.menuurl = menuurl;
        this.menufid = menufid;
    }

    public List getfNodeId() {
        return fNodeId;
    }

    public void setfNodeId(List fNodeId) {
        this.fNodeId = fNodeId;
    }

    public List getcNodeId() {
        return cNodeId;
    }

    public void setcNodeId(List cNodeId) {
        this.cNodeId = cNodeId;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public List<Menurela> getRelist() {
        return relist;
    }

    public void setRelist(List<Menurela> relist) {
        this.relist = relist;
    }

    public Menurela getMenurela() {
        return menurela;
    }

    public void setMenurela(Menurela menurela) {
        this.menurela = menurela;
    }

    public int getMenuid() {
        return menuid;
    }

    public void setMenuid(int menuid) {
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


    @Override
    public String toString() {
        return "Menu{" +
                "menuid=" + menuid +
                ", menuname='" + menuname + '\'' +
                ", menuurl='" + menuurl + '\'' +
                ", menufid=" + menufid +
                ", menurela=" + menurela +
                ", fNodeId=" + fNodeId +
                ", cNodeId=" + cNodeId +
                ", roleid=" + roleid +
                ", relist=" + relist +
                '}';
    }
}
