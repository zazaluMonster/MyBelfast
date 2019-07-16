<style scoped>
.layout-con {
  height: 100%;
  width: 100%;
}
.menu-item span {
  display: inline-block;
  overflow: hidden;
  width: 69px;
  text-overflow: ellipsis;
  white-space: nowrap;
  vertical-align: bottom;
  transition: width 0.2s ease 0.2s;
}
.menu-item i {
  transform: translateX(0px);
  transition: font-size 0.2s ease, transform 0.2s ease;
  vertical-align: middle;
  font-size: 16px;
}
.collapsed-menu span {
  width: 0px;
  transition: width 0.2s ease;
}
.collapsed-menu i {
  transform: translateX(5px);
  transition: font-size 0.2s ease 0.2s, transform 0.2s ease 0.2s;
  vertical-align: middle;
  font-size: 22px;
}
.layout {
  border: 1px solid #d7dde4;
  background: #f5f7f9;
  position: relative;
  border-radius: 4px;
  overflow: hidden;
}
.layout-header-bar {
  background: #fff;
  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1);
}
</style>
<template>
  <div class="layout">
    <Layout :style="{minHeight: '100vh'}">
      <Sider
        :style="{position: 'fixed', height: '100vh', left: 0, overflow: 'auto'}"
        :collapsed-width="78"
        v-model="isCollapsed"
      >
        <sider-message @on-select="turnToPage"></sider-message>
      </Sider>
      <Layout :style="{marginLeft: '200px'}">
        <Content :style="{padding: '0 16px 16px',margin: '16px 0'}">
          <router-view/>
        </Content>
      </Layout>
    </Layout>
  </div>
</template>
<script>
import SiderMessage from "@/components/sider/siderMessage.vue";
import NewsList from "@/components/news/news-list.vue";
import router from '@/router.js'
export default {
  data() {
    return {
      isCollapsed: false
    };
  },
  computed: {
    menuitemClasses: function() {
      return ["menu-item", this.isCollapsed ? "collapsed-menu" : ""];
    }
  },
  components: {
    SiderMessage,
    NewsList
  },
  methods: {
    turnToPage: function(routerName){
       router.push({ name: routerName })
    }
  }
};
</script>