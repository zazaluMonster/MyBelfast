<template>
  <div id="app">
    <router-view/>
  </div>
</template>


<style lang="less">
// less是css的一个扩充，可以让我们css写起来更简单
.size{
  width: 100%;
  height: 100%;
}
html,body{
  .size;
  overflow: hidden;
  margin: 0;
  padding: 0;
}
#app {
  .size;
  overflow-x: hidden;
  overflow-y: auto;
}
.card{
     margin-bottom: 20px
}
</style>
