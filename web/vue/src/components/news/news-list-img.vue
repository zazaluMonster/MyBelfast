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
              <Icon class="icon-calendar icon" type="md-calendar" />Feb 24 2016
            </time>
          </a>
        </header>

        <div class="article-entry" itemprop="articleBody">
          <article class="project">
            <aside>
              <aside>
                <img src="@/assets/avatar/avatar.jpg" />
              </aside>
              <section class="intro">
                <ul>
                  <li>
                    <a
                      href="keroinxidian_master.html"
                    >adsadsadsasjdadsjladsjkalsdjlaksdjasdadsasdasdasdasdasd</a>
                  </li>
                  <li>adsadsadsasjdadsjladsjkalsdjlaksdjasdadsasdasdasdasdasd</li>
                  <li>
                    <time>2016年1月</time>
                  </li>
                  <li>鼠绘</li>
                </ul>
              </section>
            </aside>
          </article>
          <article class="project">
            <aside>
              <aside>
                <img src="@/assets/avatar/avatar.jpg" />
              </aside>
              <section class="intro">
                <ul>
                  <li>
                    <a
                      href="keroinxidian.html"
                    >adsadsadsasjdadsjladsjkalsdjlaksdjasdadsasdasdasdasdasd</a>
                  </li>
                  <li>一部记录我大学生活的手绘作品。</li>
                  <li>
                    <time>2013年6月</time>
                  </li>
                  <li>鼠绘</li>
                </ul>
              </section>
            </aside>
          </article>
           <article class="project">
            <aside>
              <aside>
                <img src="@/assets/avatar/avatar.jpg" />
              </aside>
              <section class="intro">
                <ul>
                  <li>
                    <a
                      href="keroinxidian.html"
                    >adsadsadsasjdadsjladsjkalsdjlaksdjasdadsasdasdasdasdasd</a>
                  </li>
                  <li>一部记录我大学生活的手绘作品。</li>
                  <li>
                    <time>2013年6月</time>
                  </li>
                  <li>鼠绘</li>
                </ul>
              </section>
            </aside>
          </article>
           <article class="project">
            <aside>
              <aside>
                <img src="@/assets/avatar/avatar.jpg" />
              </aside>
              <section class="intro">
                <ul>
                  <li>
                    <a
                      href="keroinxidian.html"
                    >adsadsadsasjdadsjladsjkalsdjlaksdjasdadsasdasdasdasdasd</a>
                  </li>
                  <li>一部记录我大学生活的手绘作品。</li>
                  <li>
                    <time>2013年6月</time>
                  </li>
                  <li>鼠绘</li>
                </ul>
              </section>
            </aside>
          </article>
        </div>
      </div>
    </Card>
  </div>
</template>
<script>
export default {
  data() {
    return {
      isCollapsed: false
    };
  },
  computed: {
  },
  components: {
  }
};
</script>