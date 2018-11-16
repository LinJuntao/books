<template>

<div style="padding-bottom:20px">
    <el-breadcrumb separator-class="el-icon-arrow-right">
  <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
  <el-breadcrumb-item>新书榜</el-breadcrumb-item>
</el-breadcrumb>
<h2>最新创建书的目录:</h2>
<el-table
    :data="newBookAll"
    @row-click="Rclick"
    style="width: 100%">
      <el-table-column type="expand">
      <template slot-scope="props">
        <el-form label-position="left" inline class="demo-table-expand">
          <el-form-item label="BookID:">
            <span>{{  props.row.id }}</span>
          </el-form-item>
          <el-form-item label="书名:">
            <span>{{  props.row.bookname }}</span>
          </el-form-item>
          <el-form-item label="更新时间:">
            <span>{{  props.row.altertime }}</span>
          </el-form-item>
          <el-form-item label="简介:">
            <span>{{  props.row.bookintro }}</span>
          </el-form-item>
          <el-form-item label="下载地址:">
            <span>{{  props.row.downloadIVN }}</span>
          </el-form-item>
          <el-form-item label="下载量:">
            <span>{{  props.row.downlaodNUM }}</span>
          </el-form-item>
          <el-form-item label="书封面:">
            <span>{{  props.row.bookimg }}</span>
          </el-form-item>
          <el-form-item label="作者:">
            <span>{{  props.row.manage }}</span>
          </el-form-item>
          <el-form-item label="分类:">
            <span>{{  props.row.kindname }}</span>
          </el-form-item>
          <el-form-item label="状态:">
            <span>{{  props.row.remove }}</span>
          </el-form-item>
        </el-form>
      </template>
    </el-table-column>
   
     <el-table-column
      type="index"
      width="60">
    </el-table-column>
    <el-table-column
      label="书名" 
     :show-overflow-tooltip="true"
      width="120"
      prop="bookname">
    </el-table-column>
    <el-table-column
      label="作者"
       width="100"
      prop="manage">
    </el-table-column>
  
  <el-table-column
      label="更新时间"
       width="120"
       sortable
      prop="altertime">
         </el-table-column>

      <el-table-column
      label="下载地址"
      :show-overflow-tooltip="true"
      prop="downloadIVN">
    </el-table-column>
          <el-table-column
      label="简介"
       :show-overflow-tooltip="true"
      prop="bookintro">
         </el-table-column>
     
  </el-table>

      <transition name="el-fade-in-linear">
<div class="formBg" v-if="OnUp">
   <div>
     <h4>书_详情:</h4>
    <p>ID ：{{this.oneNewBook.id}}</p>
    <p>书名 ：{{this.oneNewBook.bookname}}</p>
    <p>作者 ： {{this.oneNewBook.manage}}</p>
    <p>更新时间 ：{{this.oneNewBook.altertime}}</p>
    <p>作品简介 ：{{this.oneNewBook.bookintro}}</p>
    <p>封面地址 ：{{this.oneNewBook.bookimg}}</p>
    <p>下载地址 ：{{this.oneNewBook.downloadIVN}}</p>
    <p>下载量 ：{{this.oneNewBook.downlaodNUM}}</p>
    <p>分类 ：{{this.oneNewBook.kindname}}</p>
    <p>分类ID ：{{this.oneNewBook.kindid}}</p>
    
    <el-row style="padding-right:30px">
    <el-button style="float:right;" type="primary" v-on:click="isOk"  plain>确定</el-button>
    </el-row>
  </div>
  </div>
   </transition>

    </div>    
</template>
<script>
import store from "./storemodule/new.js";
import { mapState, mapMutations, mapActions } from "vuex";
export default {
  data() {
    return {
      NewBooks: "",
      oneNewBook: "",
      OnUp: false
    };
  },
  mounted() {
    this.$store.dispatch("upData");
    this.NewBooks = this.$store.state;
  },
  computed: {
    newBookAll: function() {
      this.NewBooks = this.$store.state.newBooks;
      return this.NewBooks;
    }
  },
  methods: {
    isOk() {
      this.OnUp = !this.OnUp;
    },
    Rclick(row, event, column) {
      console.log(row);
      this.oneNewBook = row;
      this.OnUp = !this.OnUp;
    }
  },
  store
};
</script>
<style scoped>
.formBg {
  width: 100%;
  height: 100%;
  position: fixed;
  top: 0;
  left: 0;
  z-index: 99;

  background-color: rgba(0, 0, 0, 0.5);
}
.formBg > div {
  width: 380px;
  background-color: white;
  border-radius: 5px;
  margin: 15% auto;
  transition: 1s;
  padding-bottom: 10px;
}
.formBg > div > h4 {
  padding: 0px 30px;
  padding-top: 20px;
}
.formBg > div > p {
  padding: 3px 20px;
  text-align: center;
  word-break: break-all;
}
</style>
