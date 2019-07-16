<style scoped>
.avatar {
  width: 100%;
  height: auto;
}
.profilepic {
  display: block;
  border: 5px solid #fff;
  width: 100%;
  height: auto;
  margin: 0 auto;
  position: relative;
  overflow: hidden;
  background: #88acdb;
  -webkit-transition: all 0.2s ease-in;
  display: -webkit-box;
  -webkit-box-orient: horizontal;
  -webkit-box-pack: center;
  -webkit-box-align: center;
  text-align: center;
}
.header-author {
  text-align: center;
  margin: 0.67em 0;
  font-family: Roboto, serif;
  font-size: 30px;
  transition: 0.3s;
}

.crewNameA {
  color: #fdfdfd;
}

.header-menu {
  font-weight: 300;
  line-height: 31px;
  text-transform: uppercase;
  float: none;
  min-height: 150px;
  margin-left: -12px;
  text-align: center;
  display: -webkit-box;
  -webkit-box-orient: horizontal;
  -webkit-box-pack: center;
  -webkit-box-align: center;
}

.header-nav {
  width: 100%;
  position: absolute;
  transition: -webkit-transform 0.3s ease-in;
  transition: transform 0.3s ease-in;
  transition: transform 0.3s ease-in, -webkit-transform 0.3s ease-in;
}
.header-nav .social {
  margin-top: 10px;
  text-align: center;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -ms-flex-wrap: wrap;
  flex-wrap: wrap;
  -webkit-box-pack: center;
  -ms-flex-pack: center;
  justify-content: center;
}
.header-nav .social a {
  border-radius: 50%;
  display: -moz-inline-stack;
  display: inline-block;
  vertical-align: middle;
  *vertical-align: auto;
  zoom: 1;
  *display: inline;
  margin: 0 8px 15px;
  transition: 0.3s;
  text-align: center;
  color: #fff;
  opacity: 0.7;
  width: 28px;
  height: 28px;
  line-height: 26px;
}
.header-nav .social a.github {
  background: #afb6ca;
  border: 1px solid #afb6ca;
}

.header-nav .social a.weibo {
  background: #aaf;
  border: 1px solid #aaf;
}
.header-nav .social a.rss {
  background: #ef7522;
  border: 1px solid #ef7522;
}
</style>

<template>
  <div>
    <div class="crewContent">
      <a>
        <img class="avatar profilepic" src="@/assets/avatar/avatar.jpg" />
      </a>
    </div>
    <hgroup>
      <h1 class="header-author">
        <a class="crewNameA">{{crewName}}</a>
      </h1>
    </hgroup>
    <nav class="header-menu">
      <ul>
        <li v-for="item in items" :key="item.title">
          <a class="crewNameA" @click="selected(item.url)">{{item.title}}</a>
        </li>
      </ul>
    </nav>
    <!-- <nav class="header-nav">
      <div class="social">
        <a class="github" target="_blank" href="https://github.com/Yikun" title="github">
          <Icon type="logo-github" />
        </a>

        <a class="weibo" target="_blank" href="http://weibo.com/keroenigma" title="weibo">
          <Icon type="logo-github" />
        </a>

        <a class="rss" target="_blank" href="/atom.xml" title="rss">
          <Icon type="logo-github" />
        </a>
      </div>
    </nav> -->

  </div>
</template>

<script>
import { getLoginUserName } from "@/controller/login.js";
import { post } from "@/util/httpUtil.js";
export default {
  data() {
    return {
      crewName: getLoginUserName(),
      items: this.getMenuItems()
    };
  },
  components: {},
  methods: {
    getMenuItems: function(){
      let data = {
        crewName: getLoginUserName()
      }
      post(global.$prop.URL.getMenu, data, this.menuResponse);
    },
    menuResponse: function(response){
      let resData = global.$util.parseJson(response.data);
      global.$util.logger(resData);
      this.items = resData.menus;
    },
    selected: function(url){
      this.$emit("on-select", url);
    }
  }
};
</script>

