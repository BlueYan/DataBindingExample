package com.databinding.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.databinding.activity.BR;

/**
 * Author Yan.
 * Date 16/6/4.
 */
public class Star extends BaseObservable {


    /**
     * ctime : 2016-06-03 06:59
     * title : 刘恺威送机态度转变 轻扶杨幂背脊全程帮拎包
     * description : 腾讯明星
     * picUrl : http://img1.gtimg.com/16/1633/163301/16330171_small.jpg
     * url : http://ent.qq.com/a/20160603/007842.htm
     */

    private String ctime;
    private String title;
    private String description;
    private String picUrl;
    private String url;

    public Star(String ctime, String title, String description, String picUrl, String url) {
        this.ctime = ctime;
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
        this.url = url;
    }

    @Bindable
    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
        notifyPropertyChanged(BR.ctime);
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    @Bindable
    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.description);
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
