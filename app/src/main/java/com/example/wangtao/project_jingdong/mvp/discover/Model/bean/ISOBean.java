package com.example.wangtao.project_jingdong.mvp.discover.Model.bean;

import java.util.List;

/**
 * Created by wangtao on 2018/7/19.
 * 创建日期: on 2018/5/8.
 * 描述:
 * 作者:wangtao
 */
public class ISOBean {

    /**
     * code : 200
     * msg : success
     * newslist : [{"id":34519,"title":"取消婚姻","content":"卡特夫人家的小猫在外面乱窜，一会屋顶，一会地窖。受扰的邻居敲开卡特夫人 的门：\u201c你家的猫怎么这么疯跑？\u201d <br/>\u201c是这样，\u201d卡特夫人解释：\u201c我让兽医刚给他做了手术，最近正忙着到处取 消原先订好的婚姻。\u201d <br/>"},{"id":34519,"title":"杏花宝典","content":"一男子得到一本杏花宝典，他非常的高兴，打开书的第一页，只见上面有一行字\u201c若想练功，必先自宫！\u201d为了练功，他忍痛割爱了，就在他疼的难以忍受的时候，他翻开了第二页，只见上面又有一行字\u201c若不自宫，也可练功\u201d，气得他差点晕倒，可是已经来不及了，他又翻开第三页，只见上面赫然写着\u201c若已自宫，未必成功\u201d...... "},{"id":34519,"title":"你长的很有创意","content":"你长的很有创意，丑并不是你的本意，只是上帝和你发了个脾气，如果没有了你怎能衬托世界的美丽。 "},{"id":34519,"title":"年龄","content":"一名拥有上亿资产的寡妇，已近50岁了，但风韵犹存，看起来比实际年龄年轻许多。后来她和一位英俊潇洒的男人结婚了，那男人只有30岁。<br/>\u201c你们年纪相差那么多，他怎么肯娶你呢？\u201d寡妇的闺中密友问。<br/>\u201c我瞒了年龄。\u201d寡妇答道。<br/>\u201c你说你只有30岁？\u201d朋友问。<br/>\u201c错了，\u201d寡妇说，\u201c我骗他说我已经70岁了！\u201d<br/>"},{"id":34519,"title":"狗山官","content":"山官吃了几次倪片的亏，很是恼火。一天，他把倪片叫来，说：\u201c你聪明，能算出我是 属什么的吗？\u201d<br/>倪片扳了几下指头，说：\u201c枕头官，你是属狗的。\u201d\u201c凭什么说我是属狗的？\u201d山官确 实属狗，被倪片算着，心里暗暗吃惊。<br/>倪片说：\u201c因为见到你的一举一动，就叫人想到狗。\u201d <br/>"},{"id":34519,"title":"舔一舔","content":"一个小孩立在铁店前，看铁匠打铁，久立不去。铁匠讨厌他，拿烧红的铁块，钳到他鼻下，想逼他走开。小孩说：\u201c你如给我一块钱，我就舔它。\u201d<br/>铁匠便拿出一块钱，交给小孩。小孩把钱接了，舔了纸币，放人袋内，就此走了。<br/>"},{"id":34519,"title":"特长报告","content":"某领导刚作完一次报告，批评秘书说：\u201c你怎么写这么长的稿子给我，底下的人差不多都睡着了！\u201d秘书诚惶诚恐：\u201c我错了，本来报告不长，只是我不小心把三份复印件全给您了！\u201d <br/>"},{"id":34519,"title":"朋友和仇敌","content":"两个贪吃懒做的人在聊天。 <br/>甲：\u201c钱是我的朋友，有了钱我就不愁吃，不愁喝了。\u201d <br/>乙：\u201c钱可是我的仇敌。我一有钱就赶紧把它花光，也就是把仇敌消灭得干干净净。\u201d"},{"id":34519,"title":"莫管它漏水","content":"有一次，一条渡船过河时，船身突然撞上了礁石。河水不断地涌进舱里，旅客们惊慌失措。唯有一位先生没事似地坐着不动，并且讥笑众人大惊小怪。\u201c用不着急嘛！关咱们什么事，\u201d那人说，\u201c莫管它漏水！船又不是咱们的。\u201d "},{"id":34519,"title":"幸好没有","content":"房客：楼上那些人真是莫名其妙，昨晚半夜两点钟时，乒乒乓乓地冲下楼梯，疯狂似地敲我的房门。 <br/>房东：真的吗？他们把你吵醒了吗？<br/>房客：幸好没有。当时我正在练习吹喇叭。 <br/>"}]
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
         * id : 34519
         * title : 取消婚姻
         * content : 卡特夫人家的小猫在外面乱窜，一会屋顶，一会地窖。受扰的邻居敲开卡特夫人 的门：“你家的猫怎么这么疯跑？” <br/>“是这样，”卡特夫人解释：“我让兽医刚给他做了手术，最近正忙着到处取 消原先订好的婚姻。” <br/>
         */

        private int id;
        private String title;
        private String content;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
