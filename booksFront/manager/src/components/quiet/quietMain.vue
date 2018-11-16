<template>
    <div>
<el-breadcrumb separator-class="el-icon-arrow-right">
  <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
  <el-breadcrumb-item>新闻列表</el-breadcrumb-item>

</el-breadcrumb>   

<div>
<div >
            <el-row :gutter="24"  >
              <el-col :md="18" :sm="12" :xs="24">
             <h2 style="float:left" >快讯的列表名单：</h2>
    <el-button type="primary" style="margin-top:20px" v-on:click="handleAdd" round>发布新闻</el-button>
              </el-col>
            
              <el-col :md="6" :sm="12" :xs="24" >
                <el-input placeholder="请输入内容"  style="margin-top:20px" v-model="findInputNews" class="input-with-select"  v-on:keyup.enter.native="enterFindSub(findInputNews)" clearable>
    <template slot="prepend">搜索:</template>
    <el-button slot="append" icon="el-icon-search" @click="enterFindSub(findInputNews)"></el-button>
  </el-input>
                </el-col>  
</el-row>
            </div>
            <hr>
            <el-table
    :data="allNewsData"
    style="width: 100%">
    <el-table-column type="expand">
      <template slot-scope="props">
        <el-form label-position="left" inline class="demo-table-expand">
          <el-form-item label="新闻ID:">
            <span>{{  props.row.newsid }}</span>
          </el-form-item>
          <el-form-item label="新闻标题:">
            <span>{{  props.row.title }}</span>
          </el-form-item>
          <el-form-item label="新闻时间:">
            <span>{{  props.row.newstime }}</span>
          </el-form-item>
          <el-form-item label="发布人:">
            <span>{{  props.row.issuer }}</span>
          </el-form-item>
          <el-form-item label="新闻内容:">
            <span>{{  props.row.context }}</span>
          </el-form-item>
          <el-form-item label="新闻图片路径:">
            <span>{{  props.row.titleimg }}</span>
          </el-form-item>
        </el-form>
      </template>
    </el-table-column>
     <el-table-column
      type="index"
      width="60">
    </el-table-column>
    <el-table-column
      label="发布日期" 
      sortable
      width="100"
      prop="newstime">
    </el-table-column>
    <el-table-column
      label="发布人"
       width="100"
      prop="issuer">
    </el-table-column>
  <el-table-column
      label="新闻标题"
       width="300"
      prop="title">
         </el-table-column>
      <el-table-column
      label="新闻内容"
      prop="context">
    </el-table-column>
    <el-table-column
      label="新闻图片地址"
       width="200"
       :show-overflow-tooltip="true"
      prop="titleimg">
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
    <el-tooltip class="item" effect="dark" content="修改" placement="bottom-start">
               <el-button type="danger" icon="el-icon-delete" v-on:click = "handleDelect(scope.row)"  size="small"  circle></el-button>
    </el-tooltip>
          </el-row>
       
      </template>
    </el-table-column>
  </el-table>
  <div class="p_total">
  <el-pagination
   background
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page.sync="pageNum"
      :page-sizes="[10, 20, 30, 40]"
      :page-size="pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="totalData">
      
    </el-pagination>
    
 </div>  

</div>
<!-- 自己写了弹框的from表单 -->
      <transition name="el-fade-in">
        <div class="upForm" v-if="this.$store.state.ifUp" >
         <el-form ref="newsForm" :model="newsForm"  label-width="80px" class="labelForm" >
    <h3>信息修改:</h3>
    <hr>
     <el-form-item label="新闻ID:">
    <p >NO.{{News.newsid}}</p>
  </el-form-item>
  <el-form-item label="发布人:">
    <p >{{News.issuer}}</p>
  </el-form-item>
  <el-form-item label="新闻标题:">
    <el-input type="text" v-model="News.title" clearable  ></el-input>
  </el-form-item>
   <el-form-item label="新闻内容:">
    <el-input type="textarea" v-model="News.context" clearable ></el-input>
  </el-form-item>
  <el-form-item label="上传图片:">
   <form style="height:40px">  
    <input type="file" @change="getFile($event)" name="file" accept="image/gif, image/jpeg,image/pnd" >
   <el-row style=" position: relative;top: -40px;right: -80%;" >
     <el-button type="success" @click="submitForm($event)" icon="el-icon-upload2" size="small"   circle></el-button>
   </el-row>
  </form>
  </el-form-item>
 <el-form-item label="新闻图片地址:" >
   <p >{{News.titleimg}}</p>
  </el-form-item>
  <el-form-item size="large">
    <el-button type="primary" @click="onSubmit(1)">确认</el-button>
    <el-button @click="requr">取消</el-button>
  </el-form-item>
</el-form>
        </div>
        </transition>

        <!--添加用到的 -->
      <transition name="el-fade-in">
        <div class="upForm" v-if="this.$store.state.ifAdd" >
         <el-form ref="newsForm" :model="newsForm"  label-width="80px" class="labelForm" >
    <h3>添加新闻:</h3>
    <hr>
     
  <el-form-item label="新闻标题:">
    <el-input type="text" v-model="News.title" clearable  ></el-input>
  </el-form-item>
   <el-form-item label="新闻内容:">
    <el-input type="textarea" v-model="News.context" clearable ></el-input>
  </el-form-item>
  <el-form-item label="上传图片:">
   <form style="height:40px">  
    <input type="file" @change="getFile($event)" name="file" accept="image/gif, image/jpeg,image/pnd" >
   <el-row style=" position: relative;top: -40px;right: -80%;" >
     <el-button type="success" @click="submitForm($event)" icon="el-icon-upload2" size="small"   circle></el-button>
   </el-row>
  </form>
  </el-form-item>
 <el-form-item label="新闻图片地址:" >
   <p >{{News.titleimg}}</p>
  </el-form-item>
  <el-form-item size="large">
    <el-button type="primary" @click="onSubmit(0)">确认</el-button>
    <el-button @click="requr">取消</el-button>
  </el-form-item>
</el-form>
        </div>
        </transition>

</div>
</template>
<script>
import store from "./storemodule/quietNews";
import { mapState, mapMutations, mapGetters, mapActions } from "vuex";
export default {
  data() {
    return {
      httpImg: "",
      file: "",
      qkAllNewsData: "",
      pageNum: 1,
      pageSize: 10,
      total: 20,
      News: {
        newsid: "",
        issuer: "",
        title: "",
        newstime: "",
        context: "",
        titleimg: ""
      },
      findInputNews: ""
    };
  },
  mounted() {
    this.$store.dispatch("upNewsData");
    this.qkAllNewsData = this.$store.state;
  },
  computed: {
    allNewsData: function() {
      this.qkAllNewsData = this.$store.state.newsData;
      this.qkAllNewsData = this.qkAllNewsData.slice(
        (this.pageNum - 1) * this.pageSize,
        this.pageNum * this.pageSize
      );
      return this.qkAllNewsData;
    },
    totalData: function() {
      this.total = this.$store.state.newsData.length;
      return this.total;
    },
    newsForm: function() {
      this.News.newsid = this.$store.state.oneNewsForm.newsid;
      this.News.newstime = this.$store.state.oneNewsForm.newstime;
      this.News.title = this.$store.state.oneNewsForm.title;
      this.News.issuer = this.$store.state.oneNewsForm.issuer;
      this.News.context = this.$store.state.oneNewsForm.context;
      this.News.titleimg = this.$store.state.oneNewsForm.titleimg;
      return this.News;
    }
  },
  methods: {
    ...mapMutations(["handleUp", "handleDelect", "handleAdd", "enterFindSub"]),
    ...mapActions(["imgForm"]),
    requr() {
      let that = this;
      console.log(that.$store.state.ifUp);
      that.$store.state.ifUp = false;
      console.log(that.$store.state.ifUp);
    },
    onSubmit(dataNul) {
      if (dataNul == 1) {
        console.log(dataNul);
        if (
          this.News.titleimg == "" ||
          this.News.titleimg == null ||
          this.News.title == null ||
          this.News.title == "" ||
          this.News.context == null ||
          this.News.context == ""
        ) {
          this.$message.error("标题/内容不能为空，或者图片还没有上传哦");
        } else {
          let urlHttp = "http://120.78.75.213:8080/books/updateNews";
          console.log(urlHttp);
          let that = this;
          this.$axios({
            method: "POST",
            url: urlHttp,
            params: this.News
          })
            .then(function() {
              that.$store.state.ifUp = !that.$store.state.ifUp;
              that.$message({
                message: "已成功修改！",
                type: "success"
              });
              setInterval(function() {
                location.reload();
              }, 500);
            })
            .catch(function(err) {
              console.log(err);
              alert("发送失败！");
            });
        }
      }
      if (dataNul == 0) {
        console.log(dataNul);
        if (
          this.News.titleimg == "" ||
          this.News.titleimg == null ||
          this.News.title == null ||
          this.News.title == "" ||
          this.News.context == null ||
          this.News.context == ""
        ) {
          this.$message.error("标题/内容不能为空，或者图片还没有上传哦");
        } else {
          let urlHttp = "http://120.78.75.213:8080/books/addNews";
          console.log(urlHttp);
          let that = this;
          this.$axios({
            method: "POST",
            url: urlHttp,
            params: this.News
          })
            .then(function() {
              that.$store.state.ifAdd = !that.$store.state.ifAdd;
              that.$message({
                message: "添加成功",
                type: "success"
              });
              setInterval(function() {
                location.reload();
              }, 500);
            })
            .catch(function(err) {
              console.log(err);
              alert("发送失败！");
            });
        }
      }
    },
    getFile(event) {
      this.file = event.target.files[0];
      console.log(this.file);
    },
    submitForm(event) {
      event.preventDefault();
      if (this.file == "") {
        this.$message({
          message: "上传文件为空",
          type: "warning"
        });
      } else {
        const that = this;
        let formData = new FormData();
        formData.append("file", this.file);
        formData.append("kind", 0);
        let config = {
          headers: {
            "Content-Type": "multipart/form-data"
          }
        };
        const URLIMG = "http://120.78.75.213:8080/books/upload";
        // const URLIMG = "http://localhost:9696/upload";
        this.$axios.post(URLIMG, formData, config).then(function(res) {
          that.httpImg = res.data[0];
          that.News.titleimg = that.httpImg;
        });
      }
    },
    handleSizeChange(val) {
      this.pageSize = val;
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      this.pageNum = val;
      console.log(`当前页: ${val}`);
    },
    handleLook(rows) {
      //console.log(rows);
      this.News.newsid = rows.newsid;
      this.News.issuer = rows.issuer;
      this.News.title = rows.title;
      this.News.newstime = rows.newstime;
      this.News.context = rows.context;
      this.News.titleimg = rows.titleimg;

      this.$alert(
        "<div >" +
          "<p>新闻ID :" +
          this.News.newsid +
          "</p>" +
          "<p>新闻发布时间 :" +
          this.News.newstime +
          "</p>" +
          "<p>发布人 :" +
          this.News.issuer +
          "</p>" +
          "<p>新闻标题 :" +
          this.News.title +
          "</p>" +
          "<p>新闻内容 :" +
          this.News.context +
          "</p>" +
          "<p>新闻图片地址 :" +
          this.News.titleimg +
          "</p>" +
          "</div>",
        "快讯信息：",
        {
          dangerouslyUseHTMLString: true
        }
      );
    }
  },
  store
};
</script>
<style>
.p_total {
  padding-top: 20px;
  float: right;
  padding-bottom: 40px;
}
.demo-table-expand {
  font-size: 0;
}
.demo-table-expand label {
  width: 200px;
  color: #99a9bf;
}
.demo-table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  width: 40%;
}
.upForm {
  width: 100%;
  height: 100%;
  position: fixed;
  top: 0;
  left: 0;
  background-color: rgba(0, 0, 0, 0.37);
  z-index: 99;
}
.labelForm {
  width: 500px;
  margin: 10% auto;
  background-color: white;
  border-radius: 10px;
  padding: 10px 30px;
}
</style>
