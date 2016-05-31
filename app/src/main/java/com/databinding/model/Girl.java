package com.databinding.model;

/**
 * Author Yan.
 * Date 16/5/31.
 */
public class Girl {


    /**
     * ctime : 2016-03-06 14:11
     * title : Beautyleg &#8211; Arvi 私房美腿写真
     * description : 美女图片
     * picUrl : http://m.xxxiao.com/wp-content/uploads/sites/3/2015/05/m.xxxiao.com_e7e731faf790487ccaf90d11774fae6b-760x500.jpg
     * url : http://m.xxxiao.com/1353
     */

    private String ctime;
    private String title;
    private String description;
    private String picUrl;
    private String url;

    public Girl(String ctime, String url, String picUrl, String description, String title) {
        this.ctime = ctime;
        this.url = url;
        this.picUrl = picUrl;
        this.description = description;
        this.title = title;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
