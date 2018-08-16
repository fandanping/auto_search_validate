package com.neusoft.autosearch.datavalidate.domain;


/**
 * 比对分析结果：数据库映射实体类
 */
public class Validate {

     String id;
    //厂商
     String cname;
    //领域
     String type;
    //案卷号
     String anum;
    //公开号
     String pnum;
    //结果文献申请号
     String app_ori;
    //结果文献申请号
     String app_sid;
    //结果文献公开号
     String pub_ori;
    //结果文献公开号
     String pub_sid;
    //排序字段
     Integer seq;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAnum() {
        return anum;
    }

    public void setAnum(String anum) {
        this.anum = anum;
    }

    public String getPnum() {
        return pnum;
    }

    public void setPnum(String pnum) {
        this.pnum = pnum;
    }

    public String getApp_ori() {
        return app_ori;
    }

    public void setApp_ori(String app_ori) {
        this.app_ori = app_ori;
    }

    public String getApp_sid() {
        return app_sid;
    }

    public void setApp_sid(String app_sid) {
        this.app_sid = app_sid;
    }

    public String getPub_ori() {
        return pub_ori;
    }

    public void setPub_ori(String pub_ori) {
        this.pub_ori = pub_ori;
    }

    public String getPub_sid() {
        return pub_sid;
    }

    public void setPub_sid(String pub_sid) {
        this.pub_sid = pub_sid;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}
