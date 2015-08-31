package org.zzc.user.entity;

import org.zzc.base.model.util.JsonTool;

/**
 * tu ling api result
 * Created by Administrator on 2015/8/31 0031.
 */
public class TuLingResult {
    /** result code */
    private Long code;
    /* result container */
    private String text;
    private String url;
    private String list;

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return JsonTool.getJsonString(this);
    }
}
