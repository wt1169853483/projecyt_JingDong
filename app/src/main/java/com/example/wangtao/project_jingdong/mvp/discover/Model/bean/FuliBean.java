package com.example.wangtao.project_jingdong.mvp.discover.Model.bean;

import java.util.List;

/**
 * Created by wangtao on 2018/7/19.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class FuliBean {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2017-02-25 21:00","title":"【美D共享】&#9824; Michi-Ho","description":"华声美女","picUrl":"http://image.hnol.net/c/2017-02/25/09/201702250936183581-2089977.jpg","url":"http://bbs.voc.com.cn/mm/meinv-7668919-0-1.html"},{"ctime":"2017-02-26 08:00","title":"张逸斐(张飞飞) 清纯灵动美少女养眼写真","description":"美女写真","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2017/02/m.xxxiao.com_3d72ecdf590b37455db25c66d31915c0-683x1024.jpg","url":"http://m.xxxiao.com/123002"},{"ctime":"2017-02-26 08:00","title":"吴雯琦(吴雨轩) Cgirls Studio 美女主播清新纯美私房写真","description":"美女写真","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2017/02/m.xxxiao.com_365cc2ae1164295e6ef3c74b2d9e1f5b-683x1024.jpg","url":"http://m.xxxiao.com/122921"},{"ctime":"2017-02-26 08:00","title":"治愈系泰国正妹 May Sitapha Uttaburanont 泰国版结衣清纯唯美清新有气质写真","description":"美女写真","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2017/02/m.xxxiao.com_f2ec7e6d075b1fba06648f892d28ef23-820x1024.jpg","url":"http://m.xxxiao.com/122920"},{"ctime":"2017-02-26 09:00","title":"赫连露娜 [尤果圈爱尤物] VOL642 典雅随意丸子头俏皮又可爱半敞花衬衫显露小性感大尺度浴室制服诱惑","description":"美女写真","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2017/02/m.xxxiao.com_ecf6e32e9cdcb8b3b45c090a3cddb5e0-614x1024.jpg","url":"http://m.xxxiao.com/123037"},{"ctime":"2017-02-26 09:00","title":"西出阳关","description":"华声美女","picUrl":"http://image.hnol.net/c/2017-02/26/07/201702260758479421-239867.gif","url":"http://bbs.voc.com.cn/mm/meinv-7669796-0-1.html"},{"ctime":"2017-02-26 10:00","title":"波涛胸涌女仆 欣妍 [尤果圈爱尤物] VOL643 黑与白 妖娆性感的黑色和纯洁无暇的白色叫人深陷灰色地带","description":"美女写真","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2017/02/m.xxxiao.com_857334d3f44877d90846bd75fb01e60c-614x1024.jpg","url":"http://m.xxxiao.com/123038"},{"ctime":"2017-02-26 10:00","title":"【美D共享】&#9824; Michi-Ho-2","description":"华声美女","picUrl":"http://image.hnol.net/c/2017-02/26/09/201702260947457281-2089977.jpg","url":"http://bbs.voc.com.cn/mm/meinv-7669850-0-1.html"},{"ctime":"2017-02-26 10:00","title":"【美D共享】&#9824; Ada","description":"华声美女","picUrl":"http://image.hnol.net/c/2017-02/26/09/20170226094131751-2089977.jpg","url":"http://bbs.voc.com.cn/mm/meinv-7669841-0-1.html"},{"ctime":"2017-02-26 11:00","title":"木尧 [尤果圈爱尤物] VOL644 和风唯美日画 头发散落肩头衬托白皙的肌肤几分恬静与柔美","description":"美女写真","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2017/02/m.xxxiao.com_fa7c71f89438757639e48189c21559d4-614x1024.jpg","url":"http://m.xxxiao.com/123042"}]
     */

    private int code;
    private String msg;
    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        /**
         * ctime : 2017-02-25 21:00
         * title : 【美D共享】&#9824; Michi-Ho
         * description : 华声美女
         * picUrl : http://image.hnol.net/c/2017-02/25/09/201702250936183581-2089977.jpg
         * url : http://bbs.voc.com.cn/mm/meinv-7668919-0-1.html
         */

        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

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
}
