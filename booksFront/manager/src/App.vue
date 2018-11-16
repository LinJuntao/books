<template>
  <div id="app">
<nav class="navbar navbar-inverse navbar-fixed-top" >
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header" >
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
       <router-link  class="navbar-brand"  to="/"> &nbsp &nbsp &nbsp  &nbsp  &nbsp BOOKS_Jt</router-link>
      <el-switch class="swiths" v-model="isCollapse"></el-switch>  
    </div>
  
    <div class="collapse navbar-collapse " id="bs-example-navbar-collapse-1" >
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span>嗨！</span> {{username}} <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">
              <i class="el-icon-view"> 个人信息</i>
              </a></li>
               <li role="separator" class="divider"></li>
            <li><a href="#">
              <i class="el-icon-setting"> 设置</i>
              </a></li>
             <li role="separator" class="divider"></li>
            <li><a href="http://120.78.75.213:8080/books/exit"><i class="el-icon-warning"> 退出</i> </a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>

<div class="content">
  <div class="leftMenu">
<el-menu default-active="1-4-1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" :collapse="isCollapse">
<el-submenu index="1">
 <template slot="title">  
   <i class="el-icon-menu"></i>
<span slot="title">Library 书库</span>
    </template>
 <el-menu-item index="1-1"  style="padding:0"> <router-link  class="aliy" to="/libraryMain"> Library 书库</router-link></el-menu-item>
  </el-submenu>
  <el-submenu index="2">
 <template slot="title">  
    <i class="el-icon-mobile-phone"></i>
<span slot="title">Users 用户列表</span>
    </template>
 <el-menu-item index="2-1"   style="padding:0"> <router-link  class="aliy"  to="/usersMain">Users 用户列表</router-link></el-menu-item>
  </el-submenu>
  <el-submenu index="3">
 <template slot="title">  
   <i class="el-icon-news"></i>
<span slot="title">Quiet 快讯</span>
    </template>
 <el-menu-item index="3-1"   style="padding:0" > <router-link class="aliy"  to="/quietMain">Quiet 快讯</router-link></el-menu-item>
  </el-submenu>
  <el-submenu index="4">
    <template slot="title">
<i class="el-icon-document"></i>
<span slot="title">New 新书榜</span>
    </template>
 <el-menu-item index="4-1"   style="padding:0" ><router-link class="aliy"  to="/newMain">New 新书榜</router-link></el-menu-item>
  </el-submenu>

   <el-submenu index="5">
    <template slot="title">
      <i class="el-icon-date"></i>
      <span slot="title" >Log 日志</span>
    </template>
    <el-menu-item index="5-1"   style="padding:0">
      <router-link   class="aliy" to="/logManager">管理员操作日志</router-link></el-menu-item>
      <el-menu-item index="5-2"  style="padding:0">
        <router-link  class="aliy"  to="/logUser">用户操作日志</router-link></el-menu-item>
  </el-submenu>
</el-menu>
</div>
<div class="rightMenu">
  <transition name="fade" mode="out-in">
    <router-view/>
    </transition> 
</div>
</div>
   
  </div>
</template>

<script>
export default {
  name: "App",
  data() {
    return {
      username: "",
      isCollapse: true
    };
  },
  mounted() {
    function getCookie(cookie_name) {
      var allcookies = document.cookie;
      var cookie_pos = allcookies.indexOf(cookie_name);
      if (cookie_pos != -1) {
        cookie_pos += cookie_name.length + 1;
        var cookie_end = allcookies.indexOf(";", cookie_pos);
        if (cookie_end == -1) {
          cookie_end = allcookies.length;
        }
        var value = unescape(allcookies.substring(cookie_pos, cookie_end));
      }
      return value;
    }
    this.username = getCookie("username");
    sessionStorage.setItem("username", this.username);
  },
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    }
  }
};
</script>

<style scoped >
body {
  margin: 0;
  padding: 0;
  font-family: "Microsoft YaHei", "Hiragino Sans GB", Helvetica, Arial,
    "Lucida Grande", sans-serif;
}
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  /* text-align: center; */
}
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 300px;
}
.swiths {
  margin: 15px;
}
.content {
  margin-top: 50px;
}
.leftMenu {
  position: fixed;
  text-align: center;
  z-index: 99;
}
.rightMenu {
  padding-top: 30px;
  padding-left: 85px;
  padding-right: 20px;
  width: 100%;
}

.aliy {
  display: block;
  width: 100%;
  height: 100%;
  text-align: center;
}
a:hover {
  text-decoration: none;
}
.fade-enter {
  opacity: 0;
}
.fade-enter-active {
  transition: opacity 0.5s;
}
.fade-leave {
  opacity: 1;
}
.fade-leave-active {
  opacity: 0;
  transition: opacity 0.5s;
}
</style>
