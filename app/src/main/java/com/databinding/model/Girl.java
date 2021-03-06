package com.databinding.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.databinding.activity.BR;

/**
 * Author Yan.
 * Date 16/5/31.
 * 如果要能被View绑定，需要在get方法上添加@Bindable标注，同时在set方法中要调用notifyPropertyChanged(BR.title)方法通知View更新。
 * 模型类需要继承BaseObservable
 */
public class Girl extends BaseObservable{


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

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
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
