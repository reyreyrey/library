package module.com.test.models;

import java.io.Serializable;

/**
 * author: Rea.X
 * date: 2017/12/20.
 */

public class InterfaceCheckModel implements Serializable{
    /**
     * appid : 94836902
     * appname : 948810408
     * isshowwap : 2
     * wapurl :
     * status : 1
     * desc : 成功返回数据
     */

    private String appid;
    private String appname;
    private String isshowwap;
    private String wapurl;
    private int status;
    private String desc;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getIsshowwap() {
        return isshowwap;
    }

    public void setIsshowwap(String isshowwap) {
        this.isshowwap = isshowwap;
    }

    public String getWapurl() {
        return wapurl;
    }

    public void setWapurl(String wapurl) {
        this.wapurl = wapurl;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
