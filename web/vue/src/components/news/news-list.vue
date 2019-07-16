<style scoped>
.article-inner {
  border-color: #d1d1d1;
}

.article-header {
  border-left: 5px solid #4d4d4d;
  padding: 30px 0 15px 25px;
  padding-left: 7.6923%;
}

.article-inner h1:first-child {
  margin-bottom: 10px;
  display: inline;
}
.archive-article-date {
  color: #999;
  margin-right: 7.6923%;
  float: right;
}
.archive-article-date .icon {
  margin: 5px 5px 5px 0;
}
.project {
  width: 100%;
  min-height: 150px;
  margin: 20px 0px;
  display: block;
  clear: both;
}
.project img {
  width: 132px;
  height: 132px;
  float: left;
  background-color: white;
  padding: 6px;
  border-radius: 8px;
  border: 1px solid #dedede;
  margin: -5px 10px 5px 0px;
}
.project .intro {
  margin: 5px 10px 5px 0px;
  width: 100%;
}
.project .intro ul {
  list-style: none;
  margin-left: 0;
}
.project .intro ul li {
  line-height: 20px;
}
.project .intro ul li:first-child {
  font-size: 20px;
  padding-bottom: 5px;
  margin-bottom: 10px;
  border-bottom: 1px #eee solid;
}
.article-entry {
  line-height: 1.8em;
  padding-right: 7.6923%;
  padding-left: 7.6923%;
}
</style>
<template>
  <div>
    <Card class="card">
      <div class="article-inner">
        <header class="article-header">
          <h1 class="article-title" itemprop="name">文章</h1>

          <a href="/project/index.html" class="archive-article-date">
            <time datetime="2016-02-23T17:03:48.000Z" itemprop="datePublished">
              <Icon class="icon-calendar icon" type="md-calendar" />看看新闻天天好心情
            </time>
          </a>
        </header>

        <div class="article-entry" itemprop="articleBody">
          <article class="project">
            <div v-for="item in items" :key="item.id">
              <aside>
                <section class="intro">
                  <ul>
                    <li>
                      <a :href="item.url">{{item.title}}</a>
                    </li>
                    <li>{{item.hits}}次点击</li>
                    <li>
                      <time>{{item.outTime}}</time>
                    </li>
                    <li>{{item.tag}}</li>
                  </ul>
                </section>
              </aside>
              <br />
            </div>
          </article>
          <Page :current="page" :total="100" size="small" style="text-align: center" @on-change="getNewsItemsByPage" />
        </div>
      </div>
    </Card>
  </div>
</template>
<script>
import { post } from "@/util/httpUtil.js";
export default {
  data() {
    return {
      page: 1,
      items: [
        {
          id: 0,
          title: "暂无数据",
          hits: 0,
          outTime: "暂无数据",
          tag: "暂无数据",
          url: "/blank"
        }
      ]
    };
  },
  computed: {},
  methods: {
    getNewsItems: function() {
      let curPage = this.page;
      let data = {
        page: String(curPage)
      };
      post(global.$prop.URL.getYouthNews, data, this.youthNewsResponse);
    },
    youthNewsResponse: function(response) {
      let resData = global.$util.parseJson(response.data);
      global.$util.logger(resData);
      this.items = resData.news;
    },
    getNewsItemsByPage: function(curPage){
      this.page = curPage;
      this.getNewsItems();
    }
  },
  created: function() {
    this.getNewsItems();
  }
};
</script>