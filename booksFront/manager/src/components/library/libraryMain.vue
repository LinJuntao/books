<template>
<div
   v-loading="loading"
>
<el-breadcrumb separator-class="el-icon-arrow-right">
  <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
  <el-breadcrumb-item>书库</el-breadcrumb-item>

</el-breadcrumb>  

<div style="width:100%;height:60px">
<el-row style="float:right;z-index:3">
  <div style="float:left;padding-top:20px;padding-right:20px">
  <el-button type="success" plain icon="el-icon-plus" @click="addFrom">添加</el-button>
  </div>
 <div style="float:right" >
<el-input placeholder="请输入内容"  style="margin-top:20px" v-model="findInput" class="input-with-select"  v-on:keyup.enter.native="enterFindSub(findInput)" clearable>
    <template slot="prepend">搜索:</template>
    <el-button slot="append" icon="el-icon-search" @click="enterFindSub(findInput)"></el-button>
  </el-input>
 </div>

</el-row>
</div>
<el-row :gutter="22">
  <el-col :xl="12" :lg="12" :md="24" :sm="24" :xs="24">
    <div class="grid-content bg-purple">
     <h3>文学 : </h3>
   <el-table
    :data="booksLiteratures"
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
      <el-table-column
      fixed="right"
      label="操作"
      width="160">
      <template slot-scope="scope">
          <!-- (scope) -->
          <el-row>
                <el-tooltip class="item" effect="dark" content="查看" placement="bottom-start">
               <el-button type="success" icon="el-icon-search" v-on:click="handleLook(scope.row)" size="small"  circle></el-button>
    </el-tooltip>
                <el-tooltip class="item" effect="dark" content="修改" placement="bottom-start">
               <el-button type="primary" icon="el-icon-edit" v-on:click = "handleUp(scope.row)"  size="small"  circle></el-button>
    </el-tooltip>
    <el-tooltip class="item" effect="dark" content="删除" placement="bottom-start">
               <el-button type="danger" icon="el-icon-delete" v-on:click = "handleDelect(scope.row)"  size="small"  circle></el-button>
    </el-tooltip>
          </el-row>
       
      </template>
    </el-table-column>
  </el-table>
  <div style="float:right;padding-top:20px">
   
   <el-pagination
   background
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange1"
      :current-page.sync="pageData.page1.pageNum1"
      :page-size="pageSize"
      layout="total, prev, pager, next"
      :total="pageData.page1.total">
    </el-pagination>
 </div>  
      </div></el-col>
  <el-col :xl="12" :lg="12" :md="24" :sm="24" :xs="24" ><div class="grid-content bg-purple">
     <h3>传记 : </h3>
   <el-table
    :data="booksBiographys"
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
      <el-table-column
      fixed="right"
      label="操作"
      width="160">
      <template slot-scope="scope">
          <!-- (scope) -->
          <el-row>
                <el-tooltip class="item" effect="dark" content="查看" placement="bottom-start">
               <el-button type="success" icon="el-icon-search" v-on:click="handleLook(scope.row)" size="small"  circle></el-button>
    </el-tooltip>
                <el-tooltip class="item" effect="dark" content="修改" placement="bottom-start">
               <el-button type="primary" icon="el-icon-edit" v-on:click = "handleUp(scope.row)"  size="small"  circle></el-button>
    </el-tooltip>
    <el-tooltip class="item" effect="dark" content="删除" placement="bottom-start">
               <el-button type="danger" icon="el-icon-delete" v-on:click = "handleDelect(scope.row)"  size="small"  circle></el-button>
    </el-tooltip>
          </el-row>
       
      </template>
    </el-table-column>
  </el-table>
  <div style="float:right;padding-top:20px">
   
   <el-pagination
   background
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange2"
      :current-page.sync="pageData.page2.pageNum2"
      :page-size="pageSize"
      layout="total, prev, pager, next"
      :total="pageData.page2.total">
    </el-pagination>
 </div>  
    </div></el-col>
    <el-col :xl="12" :lg="12" :md="24" :sm="24" :xs="24" ><div class="grid-content bg-purple">
     <h3>青春动漫 : </h3>
   <el-table
    :data="booksCartoons"
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
      <el-table-column
      fixed="right"
      label="操作"
      width="160">
      <template slot-scope="scope">
          <!-- (scope) -->
          <el-row>
                <el-tooltip class="item" effect="dark" content="查看" placement="bottom-start">
               <el-button type="success" icon="el-icon-search" v-on:click="handleLook(scope.row)" size="small"  circle></el-button>
    </el-tooltip>
                <el-tooltip class="item" effect="dark" content="修改" placement="bottom-start">
               <el-button type="primary" icon="el-icon-edit" v-on:click = "handleUp(scope.row)"  size="small"  circle></el-button>
    </el-tooltip>
    <el-tooltip class="item" effect="dark" content="删除" placement="bottom-start">
               <el-button type="danger" icon="el-icon-delete" v-on:click = "handleDelect(scope.row)"  size="small"  circle></el-button>
    </el-tooltip>
          </el-row>
       
      </template>
    </el-table-column>
  </el-table>
  <div style="float:right;padding-top:20px">
   
   <el-pagination
   background
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange3"
      :current-page.sync="pageData.page3.pageNum3"
      :page-size="pageSize"
      layout="total, prev, pager, next"
      :total="pageData.page3.total">
    </el-pagination>
 </div>  
    </div></el-col>
    <el-col :xl="12" :lg="12" :md="24" :sm="24" :xs="24" ><div class="grid-content bg-purple">
     <h3>艺术与摄影 : </h3>
   <el-table
    :data="booksArts"
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
      <el-table-column
      fixed="right"
      label="操作"
      width="160">
      <template slot-scope="scope">
          <!-- (scope) -->
          <el-row>
                <el-tooltip class="item" effect="dark" content="查看" placement="bottom-start">
               <el-button type="success" icon="el-icon-search" v-on:click="handleLook(scope.row)" size="small"  circle></el-button>
    </el-tooltip>
                <el-tooltip class="item" effect="dark" content="修改" placement="bottom-start">
               <el-button type="primary" icon="el-icon-edit" v-on:click = "handleUp(scope.row)"  size="small"  circle></el-button>
    </el-tooltip>
    <el-tooltip class="item" effect="dark" content="删除" placement="bottom-start">
               <el-button type="danger" icon="el-icon-delete" v-on:click = "handleDelect(scope.row)"  size="small"  circle></el-button>
    </el-tooltip>
          </el-row>
       
      </template>
    </el-table-column>
  </el-table>
  <div style="float:right;padding-top:20px">
   
   <el-pagination
   background
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange4"
      :current-page.sync="pageData.page4.pageNum4"
      :page-size="pageSize"
      layout="total, prev, pager, next"
      :total="pageData.page4.total">
    </el-pagination>
 </div>  
    </div></el-col>
    <el-col :xl="12" :lg="12" :md="24" :sm="24" :xs="24" ><div class="grid-content bg-purple">
     <h3>少儿 : </h3>
   <el-table
    :data="booksChildrens"
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
      <el-table-column
      fixed="right"
      label="操作"
      width="160">
      <template slot-scope="scope">
          <!-- (scope) -->
          <el-row>
                <el-tooltip class="item" effect="dark" content="查看" placement="bottom-start">
               <el-button type="success" icon="el-icon-search" v-on:click="handleLook(scope.row)" size="small"  circle></el-button>
    </el-tooltip>
                <el-tooltip class="item" effect="dark" content="修改" placement="bottom-start">
               <el-button type="primary" icon="el-icon-edit" v-on:click = "handleUp(scope.row)"  size="small"  circle></el-button>
    </el-tooltip>
    <el-tooltip class="item" effect="dark" content="删除" placement="bottom-start">
               <el-button type="danger" icon="el-icon-delete" v-on:click = "handleDelect(scope.row)"  size="small"  circle></el-button>
    </el-tooltip>
          </el-row>
       
      </template>
    </el-table-column>
  </el-table>
  <div style="float:right;padding-top:20px">
   
   <el-pagination
   background
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange5"
      :current-page.sync="pageData.page5.pageNum5"
      :page-size="pageSize"
      layout="total, prev, pager, next"
      :total="pageData.page5.total">
    </el-pagination>
 </div>  
    </div></el-col>
    <el-col :xl="12" :lg="12" :md="24" :sm="24" :xs="24" ><div class="grid-content bg-purple">
     <h3>社会科学 : </h3>
   <el-table
    :data="booksSocials"
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
      <el-table-column
      fixed="right"
      label="操作"
      width="160">
      <template slot-scope="scope">
          <!-- (scope) -->
          <el-row>
                <el-tooltip class="item" effect="dark" content="查看" placement="bottom-start">
               <el-button type="success" icon="el-icon-search" v-on:click="handleLook(scope.row)" size="small"  circle></el-button>
    </el-tooltip>
                <el-tooltip class="item" effect="dark" content="修改" placement="bottom-start">
               <el-button type="primary" icon="el-icon-edit" v-on:click = "handleUp(scope.row)"  size="small"  circle></el-button>
    </el-tooltip>
    <el-tooltip class="item" effect="dark" content="删除" placement="bottom-start">
               <el-button type="danger" icon="el-icon-delete" v-on:click = "handleDelect(scope.row)"  size="small"  circle></el-button>
    </el-tooltip>
          </el-row>
       
      </template>
    </el-table-column>
  </el-table>
  <div style="float:right;padding-top:20px">
   
   <el-pagination
   background
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange6"
      :current-page.sync="pageData.page6.pageNum6"
      :page-size="pageSize"
      layout="total, prev, pager, next"
      :total="pageData.page6.total">
    </el-pagination>
 </div>  
    </div></el-col>
    <el-col :xl="12" :lg="12" :md="24" :sm="24" :xs="24" ><div class="grid-content bg-purple">
     <h3>历史 : </h3>
   <el-table
    :data="booksHistorys"
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
      <el-table-column
      fixed="right"
      label="操作"
      width="160">
      <template slot-scope="scope">
          <!-- (scope) -->
          <el-row>
                <el-tooltip class="item" effect="dark" content="查看" placement="bottom-start">
               <el-button type="success" icon="el-icon-search" v-on:click="handleLook(scope.row)" size="small"  circle></el-button>
    </el-tooltip>
                <el-tooltip class="item" effect="dark" content="修改" placement="bottom-start">
               <el-button type="primary" icon="el-icon-edit" v-on:click = "handleUp(scope.row)"  size="small"  circle></el-button>
    </el-tooltip>
    <el-tooltip class="item" effect="dark" content="删除" placement="bottom-start">
               <el-button type="danger" icon="el-icon-delete" v-on:click = "handleDelect(scope.row)"  size="small"  circle></el-button>
    </el-tooltip>
          </el-row>
       
      </template>
    </el-table-column>
  </el-table>
  <div style="float:right;padding-top:20px">
   
   <el-pagination
   background
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange6"
      :current-page.sync="pageData.page6.pageNum6"
      :page-size="pageSize"
      layout="total, prev, pager, next"
      :total="pageData.page6.total">
    </el-pagination>
 </div>  
    </div></el-col>
    <el-col :xl="12" :lg="12" :md="24" :sm="24" :xs="24" ><div class="grid-content bg-purple">
     <h3>励志与成功 : </h3>
   <el-table
    :data="booksSuccers"
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
      <el-table-column
      fixed="right"
      label="操作"
      width="160">
      <template slot-scope="scope">
          <!-- (scope) -->
          <el-row>
                <el-tooltip class="item" effect="dark" content="查看" placement="bottom-start">
               <el-button type="success" icon="el-icon-search" v-on:click="handleLook(scope.row)" size="small"  circle></el-button>
    </el-tooltip>
                <el-tooltip class="item" effect="dark" content="修改" placement="bottom-start">
               <el-button type="primary" icon="el-icon-edit" v-on:click = "handleUp(scope.row)"  size="small"  circle></el-button>
    </el-tooltip>
    <el-tooltip class="item" effect="dark" content="删除" placement="bottom-start">
               <el-button type="danger" icon="el-icon-delete" v-on:click = "handleDelect(scope.row)"  size="small"  circle></el-button>
    </el-tooltip>
          </el-row>
       
      </template>
    </el-table-column>
  </el-table>
  <div style="float:right;padding-top:20px">
   
   <el-pagination
   background
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange8"
      :current-page.sync="pageData.page8.pageNum8"
      :page-size="pageSize"
      layout="total, prev, pager, next"
      :total="pageData.page8.total">
    </el-pagination>
 </div>  
    </div></el-col>
    <el-col :xl="12" :lg="12" :md="24" :sm="24" :xs="24" ><div class="grid-content bg-purple">
     <h3>娱乐与体育 : </h3>
   <el-table
    :data="booksFuns"
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
      <el-table-column
      fixed="right"
      label="操作"
      width="160">
      <template slot-scope="scope">
          <!-- (scope) -->
          <el-row>
                <el-tooltip class="item" effect="dark" content="查看" placement="bottom-start">
               <el-button type="success" icon="el-icon-search" v-on:click="handleLook(scope.row)" size="small"  circle></el-button>
    </el-tooltip>
                <el-tooltip class="item" effect="dark" content="修改" placement="bottom-start">
               <el-button type="primary" icon="el-icon-edit" v-on:click = "handleUp(scope.row)"  size="small"  circle></el-button>
    </el-tooltip>
    <el-tooltip class="item" effect="dark" content="删除" placement="bottom-start">
               <el-button type="danger" icon="el-icon-delete" v-on:click = "handleDelect(scope.row)"  size="small"  circle></el-button>
    </el-tooltip>
          </el-row>
       
      </template>
    </el-table-column>
  </el-table>
  <div style="float:right;padding-top:20px">
   
   <el-pagination
   background
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange9"
      :current-page.sync="pageData.page9.pageNum9"
      :page-size="pageSize"
      layout="total, prev, pager, next"
      :total="pageData.page9.total">
    </el-pagination>
 </div>  
    </div></el-col>
    <el-col :xl="12" :lg="12" :md="24" :sm="24" :xs="24" ><div class="grid-content bg-purple">
     <h3>旅游 : </h3>
   <el-table
    :data="booksTravals"
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
      <el-table-column
      fixed="right"
      label="操作"
      width="160">
      <template slot-scope="scope">
          <!-- (scope) -->
          <el-row>
                <el-tooltip class="item" effect="dark" content="查看" placement="bottom-start">
               <el-button type="success" icon="el-icon-search" v-on:click="handleLook(scope.row)" size="small"  circle></el-button>
    </el-tooltip>
                <el-tooltip class="item" effect="dark" content="修改" placement="bottom-start">
               <el-button type="primary" icon="el-icon-edit" v-on:click = "handleUp(scope.row)"  size="small"  circle></el-button>
    </el-tooltip>
    <el-tooltip class="item" effect="dark" content="删除" placement="bottom-start">
               <el-button type="danger" icon="el-icon-delete" v-on:click = "handleDelect(scope.row)"  size="small"  circle></el-button>
    </el-tooltip>
          </el-row>
       
      </template>
    </el-table-column>
  </el-table>
  <div style="float:right;padding-top:20px">
   
   <el-pagination
   background
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange10"
      :current-page.sync="pageData.page10.pageNum10"
      :page-size="pageSize"
      layout="total, prev, pager, next"
      :total="pageData.page10.total">
    </el-pagination>
 </div>  
    </div></el-col>
    <el-col :xl="12" :lg="12" :md="24" :sm="24" :xs="24" ><div class="grid-content bg-purple">
     <h3>科技与生活 : </h3>
   <el-table
    :data="booksLifes"
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
      <el-table-column
      fixed="right"
      label="操作"
      width="160">
      <template slot-scope="scope">
          <!-- (scope) -->
          <el-row>
                <el-tooltip class="item" effect="dark" content="查看" placement="bottom-start">
               <el-button type="success" icon="el-icon-search" v-on:click="handleLook(scope.row)" size="small"  circle></el-button>
    </el-tooltip>
                <el-tooltip class="item" effect="dark" content="修改" placement="bottom-start">
               <el-button type="primary" icon="el-icon-edit" v-on:click = "handleUp(scope.row)"  size="small"  circle></el-button>
    </el-tooltip>
    <el-tooltip class="item" effect="dark" content="删除" placement="bottom-start">
               <el-button type="danger" icon="el-icon-delete" v-on:click = "handleDelect(scope.row)"  size="small"  circle></el-button>
    </el-tooltip>
          </el-row>
       
      </template>
    </el-table-column>
  </el-table>
  <div style="float:right;padding-top:20px">
   
   <el-pagination
   background
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange11"
      :current-page.sync="pageData.page11.pageNum11"
      :page-size="pageSize"
      layout="total, prev, pager, next"
      :total="pageData.page11.total">
    </el-pagination>
 </div>  
    </div></el-col>
    <el-col :xl="12" :lg="12" :md="24" :sm="24" :xs="24" ><div class="grid-content bg-purple">
     <h3>外语学习 : </h3>
   <el-table
    :data="booksLanguages"
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
      <el-table-column
      fixed="right"
      label="操作"
      width="160">
      <template slot-scope="scope">
          <!-- (scope) -->
          <el-row>
                <el-tooltip class="item" effect="dark" content="查看" placement="bottom-start">
               <el-button type="success" icon="el-icon-search" v-on:click="handleLook(scope.row)" size="small"  circle></el-button>
    </el-tooltip>
                <el-tooltip class="item" effect="dark" content="修改" placement="bottom-start">
               <el-button type="primary" icon="el-icon-edit" v-on:click = "handleUp(scope.row)"  size="small"  circle></el-button>
    </el-tooltip>
    <el-tooltip class="item" effect="dark" content="删除" placement="bottom-start">
               <el-button type="danger" icon="el-icon-delete" v-on:click = "handleDelect(scope.row)"  size="small"  circle></el-button>
    </el-tooltip>
          </el-row>
       
      </template>
    </el-table-column>
  </el-table>
  <div style="float:right;padding-top:20px">
   
   <el-pagination
   background
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange12"
      :current-page.sync="pageData.page12.pageNum12"
      :page-size="pageSize"
      layout="total, prev, pager, next"
      :total="pageData.page12.total">
    </el-pagination>
 </div>  
    </div></el-col>
    <el-col :xl="12" :lg="12" :md="24" :sm="24" :xs="24" ><div class="grid-content bg-purple">
     <h3>小说 : </h3>
   <el-table
    :data="booksNovels"
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
      <el-table-column
      fixed="right"
      label="操作"
      width="160">
      <template slot-scope="scope">
          <!-- (scope) -->
          <el-row>
                <el-tooltip class="item" effect="dark" content="查看" placement="bottom-start">
               <el-button type="success" icon="el-icon-search" v-on:click="handleLook(scope.row)" size="small"  circle></el-button>
    </el-tooltip>
                <el-tooltip class="item" effect="dark" content="修改" placement="bottom-start">
               <el-button type="primary" icon="el-icon-edit" v-on:click = "handleUp(scope.row)"  size="small"  circle></el-button>
    </el-tooltip>
    <el-tooltip class="item" effect="dark" content="删除" placement="bottom-start">
               <el-button type="danger" icon="el-icon-delete" v-on:click = "handleDelect(scope.row)"  size="small"  circle></el-button>
    </el-tooltip>
          </el-row>
       
      </template>
    </el-table-column>
  </el-table>
  <div style="float:right;padding-top:20px">
   
   <el-pagination
   background
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange13"
      :current-page.sync="pageData.page13.pageNum13"
      :page-size="pageSize"
      layout="total, prev, pager, next"
      :total="pageData.page13.total">
    </el-pagination>
 </div>  
    </div></el-col>
 
 
</el-row>
<transition name="el-fade-in-linear">
  <div class="formBg" v-if="this.$store.state.ifForm">
   <div>
     <h4>书_详情:</h4>
    <p>ID ：{{this.$store.state.booksForm.id}}</p>
    <p>书名 ：{{this.$store.state.booksForm.bookname}}</p>
    <p>作者 ： {{this.$store.state.booksForm.manage}}</p>
    <p>更新时间 ：{{this.$store.state.booksForm.altertime}}</p>
    <p>作品简介 ：{{this.$store.state.booksForm.bookintro}}</p>
    <p>封面地址 ：{{this.$store.state.booksForm.bookimg}}</p>
    <p>下载地址 ：{{this.$store.state.booksForm.downloadIVN}}</p>
    <p>下载量 ：{{this.$store.state.booksForm.downlaodNUM}}</p>
    <p>分类 ：{{this.$store.state.booksForm.kindname}}</p>
    <p>分类ID ：{{this.$store.state.booksForm.kindid}}</p>
    <p>状态 ：{{this.$store.state.booksForm.remove}}</p>
    <el-row style="padding-right:30px">
    <el-button style="float:right;" type="primary" v-on:click="isOk"  plain>确定</el-button>
    </el-row>
  </div>
  </div>
  </transition>
    </div>
</template>
<script>
import store from "./library";
import { mapState, mapMutations, mapGetters, mapActions } from "vuex";
export default {
  data() {
    return {
      libraryData: {},
      booksLiterature: "",
      booksBiography: "",
      booksCartoon: "",
      booksArt: "",
      booksChildren: "",
      booksSocial: "",
      booksHistory: "",
      booksSuccer: "",
      booksFun: "",
      booksTraval: "",
      booksLife: "",
      booksLanguage: "",
      booksNovel: "",
      pages: {
        page1: { pageNum1: 1, total: "" },
        page2: { pageNum2: 1, total: "" },
        page3: { pageNum3: 1, total: "" },
        page4: { pageNum4: 1, total: "" },
        page5: { pageNum5: 1, total: "" },
        page6: { pageNum6: 1, total: "" },
        page7: { pageNum7: 1, total: "" },
        page8: { pageNum8: 1, total: "" },
        page9: { pageNum9: 1, total: "" },
        page10: { pageNum10: 1, total: "" },
        page11: { pageNum11: 1, total: "" },
        page12: { pageNum12: 1, total: "" },
        page13: { pageNum13: 1, total: "" }
      },
      pageSize: 10,
      findInput: "",
      loading: true
    };
  },
  mounted() {
    this.$store.dispatch("booksLiterature");
    this.$store.dispatch("booksBiography");
    this.$store.dispatch("booksCartoon");
    this.$store.dispatch("booksArt");
    this.$store.dispatch("booksChildren");
    this.$store.dispatch("booksSocial");
    this.$store.dispatch("booksHistory");
    this.$store.dispatch("booksSuccer");
    this.$store.dispatch("booksFun");
    this.$store.dispatch("booksTraval");
    this.$store.dispatch("booksLife");
    this.$store.dispatch("booksLanguage");
    this.$store.dispatch("booksNovel");
    this.libraryData = this.$store.state;
    this.loading = false;
  },
  computed: {
    booksLiteratures: function() {
      this.booksLiterature = this.$store.state.booksLiterature;
      this.booksLiterature = this.booksLiterature.slice(
        (this.pages.page1.pageNum1 - 1) * this.pageSize,
        this.pages.page1.pageNum1 * this.pageSize
      );
      return this.booksLiterature;
    },
    booksBiographys: function() {
      this.booksBiography = this.$store.state.booksBiography;
      this.booksBiography = this.booksBiography.slice(
        (this.pages.page2.pageNum2 - 1) * this.pageSize,
        this.pages.page2.pageNum2 * this.pageSize
      );
      return this.booksBiography;
    },
    booksCartoons: function() {
      this.booksCartoon = this.$store.state.booksCartoon;
      this.booksCartoon = this.booksCartoon.slice(
        (this.pages.page3.pageNum3 - 1) * this.pageSize,
        this.pages.page3.pageNum3 * this.pageSize
      );
      return this.booksCartoon;
    },
    booksArts: function() {
      this.booksArt = this.$store.state.booksArt;
      this.booksArt = this.booksArt.slice(
        (this.pages.page4.pageNum4 - 1) * this.pageSize,
        this.pages.page4.pageNum4 * this.pageSize
      );
      return this.booksArt;
    },
    booksChildrens: function() {
      this.booksChildren = this.$store.state.booksChildren;
      this.booksChildren = this.booksChildren.slice(
        (this.pages.page5.pageNum5 - 1) * this.pageSize,
        this.pages.page5.pageNum5 * this.pageSize
      );
      return this.booksChildren;
    },
    booksSocials: function() {
      this.booksSocial = this.$store.state.booksSocial;
      this.booksSocial = this.booksSocial.slice(
        (this.pages.page6.pageNum6 - 1) * this.pageSize,
        this.pages.page6.pageNum6 * this.pageSize
      );
      return this.booksSocial;
    },
    booksHistorys: function() {
      this.booksHistory = this.$store.state.booksHistory;
      this.booksHistory = this.booksHistory.slice(
        (this.pages.page7.pageNum7 - 1) * this.pageSize,
        this.pages.page7.pageNum7 * this.pageSize
      );
      return this.booksHistory;
    },
    booksSuccers: function() {
      this.booksSuccer = this.$store.state.booksSuccer;
      this.booksSuccer = this.booksSuccer.slice(
        (this.pages.page8.pageNum8 - 1) * this.pageSize,
        this.pages.page8.pageNum8 * this.pageSize
      );
      return this.booksSuccer;
    },
    booksFuns: function() {
      this.booksFun = this.$store.state.booksFun;
      this.booksFun = this.booksFun.slice(
        (this.pages.page9.pageNum9 - 1) * this.pageSize,
        this.pages.page9.pageNum9 * this.pageSize
      );
      return this.booksFun;
    },
    booksTravals: function() {
      this.booksTraval = this.$store.state.booksTraval;
      this.booksTraval = this.booksTraval.slice(
        (this.pages.page10.pageNum10 - 1) * this.pageSize,
        this.pages.page10.pageNum10 * this.pageSize
      );
      return this.booksTraval;
    },
    booksLifes: function() {
      this.booksLife = this.$store.state.booksLife;
      this.booksLife = this.booksLife.slice(
        (this.pages.page11.pageNum11 - 1) * this.pageSize,
        this.pages.page11.pageNum11 * this.pageSize
      );
      return this.booksLife;
    },
    booksLanguages: function() {
      this.booksLanguage = this.$store.state.booksLanguage;
      this.booksLanguage = this.booksLanguage.slice(
        (this.pages.page12.pageNum12 - 1) * this.pageSize,
        this.pages.page12.pageNum12 * this.pageSize
      );
      return this.booksLanguage;
    },
    booksNovels: function() {
      this.booksNovel = this.$store.state.booksNovel;
      this.booksNovel = this.booksNovel.slice(
        (this.pages.page13.pageNum13 - 1) * this.pageSize,
        this.pages.page13.pageNum13 * this.pageSize
      );
      return this.booksNovel;
    },
    pageData: function() {
      this.pages.page1.total = this.$store.state.booksLiterature.length;
      this.pages.page2.total = this.$store.state.booksBiography.length;
      this.pages.page3.total = this.$store.state.booksCartoon.length;
      this.pages.page4.total = this.$store.state.booksArt.length;
      this.pages.page5.total = this.$store.state.booksChildren.length;
      this.pages.page6.total = this.$store.state.booksSocial.length;
      this.pages.page7.total = this.$store.state.booksHistory.length;
      this.pages.page8.total = this.$store.state.booksSuccer.length;
      this.pages.page9.total = this.$store.state.booksFun.length;
      this.pages.page10.total = this.$store.state.booksTraval.length;
      this.pages.page11.total = this.$store.state.booksLife.length;
      this.pages.page12.total = this.$store.state.booksLanguage.length;
      this.pages.page13.total = this.$store.state.booksNovel.length;
      return this.pages;
    }
  },
  methods: {
    ...mapMutations(["handleLook", "isOk", "handleDelect", "enterFindSub"]),
    handleUp(data) {
      this.$store.state.booksForm.bookimg = data.bookimg;
      this.$store.state.booksForm.altertime = data.altertime;
      this.$store.state.booksForm.bookintro = data.bookintro;
      this.$store.state.booksForm.bookname = data.bookname;
      this.$store.state.booksForm.downlaodNUM = data.downlaodNUM;
      this.$store.state.booksForm.downloadIVN = data.downloadIVN;
      this.$store.state.booksForm.id = data.id;
      this.$store.state.booksForm.kindid = data.kindid;
      this.$store.state.booksForm.kindname = data.kindname;
      this.$store.state.booksForm.manage = data.manage;
      this.$store.state.booksForm.remove = data.remove;
      // console.log(state.booksForm);
      this.$router.push({
        path: "/libraryMain/libraryFrom"
      });
      sessionStorage.setItem(
        "booksFrom",
        JSON.stringify(this.$store.state.booksForm)
      );
      sessionStorage.setItem("routerID", 1);
      // console.log(this.$store.state.booksForm);
    },
    addFrom() {
      this.$router.push({
        path: "/libraryMain/libraryFrom"
      });
      sessionStorage.setItem("routerID", 0);
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange1(val) {
      this.pages.page1.pageNum1 = val;
      console.log(`当前页: ${val}`);
    },
    handleCurrentChange2(val) {
      this.pages.page2.pageNum2 = val;
      console.log(`当前页: ${val}`);
    },
    handleCurrentChange3(val) {
      this.pages.page3.pageNum3 = val;
      console.log(`当前页: ${val}`);
    },
    handleCurrentChange4(val) {
      this.pages.page4.pageNum4 = val;
      console.log(`当前页: ${val}`);
    },
    handleCurrentChange5(val) {
      this.pages.page5.pageNum5 = val;
      console.log(`当前页: ${val}`);
    },
    handleCurrentChange6(val) {
      this.pages.page6.pageNum6 = val;
      console.log(`当前页: ${val}`);
    },
    handleCurrentChange7(val) {
      this.pages.page7.pageNum7 = val;
      console.log(`当前页: ${val}`);
    },
    handleCurrentChange8(val) {
      this.pages.page8.pageNum8 = val;
      console.log(`当前页: ${val}`);
    },
    handleCurrentChange9(val) {
      this.pages.page9.pageNum9 = val;
      console.log(`当前页: ${val}`);
    },
    handleCurrentChange10(val) {
      this.pages.page10.pageNum10 = val;
      console.log(`当前页: ${val}`);
    },
    handleCurrentChange11(val) {
      this.pages.page11.pageNum11 = val;
      console.log(`当前页: ${val}`);
    },
    handleCurrentChange12(val) {
      this.pages.page12.pageNum12 = val;
      console.log(`当前页: ${val}`);
    },
    handleCurrentChange13(val) {
      this.pages.page13.pageNum13 = val;
      console.log(`当前页: ${val}`);
    }
  },
  store
};
</script>
<style scoped>
.el-col {
  border-radius: 4px;
  margin-bottom: 20px;
}

/* .bg-purple {
  background: #ebeef1bb;
} */

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}

.demo-table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  width: 45%;
}
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
  width: 350px;
  background-color: white;
  border-radius: 5px;
  margin: 15% auto;
  padding-bottom: 10px;
}
.formBg > div > h4 {
  padding: 0px 30px;
  padding-top: 20px;
}
.formBg > div > p {
  padding: 3px 10px;
  text-align: center;
  word-break: break-all;
}
</style>
