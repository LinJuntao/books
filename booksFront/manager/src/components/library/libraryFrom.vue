<template>
   <div>
     <div style="padding-bottom:10px">
<el-breadcrumb separator-class="el-icon-arrow-right" >
  <el-breadcrumb-item :to="{ path: '/libraryMain' }">
  <i class="el-icon-error"></i> 后退
  </el-breadcrumb-item>
  <el-breadcrumb-item>书库</el-breadcrumb-item>
  <el-breadcrumb-item>添加或修改</el-breadcrumb-item>

</el-breadcrumb>  
</div>



     <el-radio-group v-model="labelPosition" size="small">
  <el-radio-button label="left">左对齐</el-radio-button>
  <el-radio-button label="right">右对齐</el-radio-button>
  <el-radio-button label="top">顶部对齐</el-radio-button>
</el-radio-group>
<div style="margin: 10px;"></div>

<el-row>
<el-col :xs="24" :sm="24" :md="16" :lg="12" :xl="12">
<el-form :label-position="labelPosition" label-width="100px" :model="bookForm" :rules="rules"   ref="bookForm" class="demo-ruleForm"> 
  <el-form-item label="书名:" prop="bookname">
    <el-input v-model="bookForm.bookname" clearable></el-input>
  </el-form-item>
   <el-form-item label="作者:" prop="manage" v-if="ifUser.booknameIf">
    <el-input v-model="bookForm.manage" disabled clearable></el-input>
  </el-form-item>
   <el-form-item label="作者:" prop="bookname" v-if="!ifUser.booknameIf" >
    <el-input v-model="bookForm.manage"  clearable></el-input>
  </el-form-item>
  <el-form-item label="书籍种类:"  prop="kindname">
    <el-select v-model="bookForm.kindname" placeholder="请选择书籍种类">
      <el-option label="文学" value="文学"></el-option>
      <el-option label="传记" value="传记"></el-option>
      <el-option label="青春动漫" value="青春动漫"></el-option>
      <el-option label="艺术与摄影" value="艺术与摄影"></el-option>
      <el-option label="少儿" value="少儿"></el-option>
      <el-option label="社会科学" value="社会科学"></el-option>
      <el-option label="历史" value="历史"></el-option>
      <el-option label="励志与体育" value="励志与体育"></el-option>
      <el-option label="旅游" value="旅游"></el-option>
      <el-option label="科技与生活" value="科技与生活"></el-option>
      <el-option label="外语学习" value="外语学习"></el-option>
      <el-option label="小说" value="小说"></el-option>
      
    </el-select>
  </el-form-item>
  <el-form-item label="上传图片：">
    <form style="height:40px" >
<input type="file" @change="getFile($event)" name="file" accept="image/gif, image/jpeg,image/pnd" >
   <el-row style=" position: relative;top: -40px;right: -80%;" >
     <el-button type="primary" @click="submitWord($event,0)" icon="el-icon-picture" size="small"  circle></el-button>
      </el-row>
    </form>
  </el-form-item>
  <el-form-item label="封面地址:" prop="bookimg" >
    <el-input  type="textarea" autosize v-model="bookForm.bookimg" disabled clearable></el-input>
  </el-form-item>
  <el-form-item label="上传文件：">
    <form style="height:40px" >
<input type="file" @change="getFile($event)" name="file" accept="application/msword,application/zip,text/plain,text/javascript，application/javascript" >
   <el-row style=" position: relative;top: -40px;right: -80%;" >
     <el-button type="primary" @click="submitWord($event,1)" icon="el-icon-upload" size="small"  circle></el-button>
      </el-row>
    </form>
  </el-form-item>
   <el-form-item label="书籍下载地址:" prop="downloadIVN" >
    <el-input  type="textarea" autosize v-model="bookForm.downloadIVN" disabled clearable></el-input>
  </el-form-item>
  <el-form-item label="书本简介" prop="bookintro">
    <el-input type="textarea" autosize v-model="bookForm.bookintro" clearable ></el-input>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="submitForm('bookForm')" v-if="!ifUser.subIf">确定</el-button>
    <el-button type="primary" @click="submitAdd('bookForm')" v-if="ifUser.subIf">确认</el-button>
    <el-button @click="resetForm('bookForm')">重置</el-button>
  </el-form-item>
</el-form>
</el-col>
</el-row>
   </div>
</template>
<script>
import store from "./libraryFrom";
import { mapState, mapMutations, mapGetters, mapActions } from "vuex";
export default {
  data() {
    return {
      labelPosition: "left",
      file: "",
      ifUser: {
        booknameIf: true,
        subIf: false
      },
      bookForm: {
        altertime: null,
        bookimg: null,
        bookintro: null,
        bookname: null,
        downlaodNUM: null,
        downloadIVN: null,
        id: null,
        kindid: null,
        kindname: null,
        manage: null,
        remove: 0
      },
      rules: {
        bookname: [{ required: true, message: "请输入书名", trigger: "blur" }],
        bookimg: [{ required: true, message: "请上传图片", trigger: "blur" }],
        manage: [
          { required: true, message: "请输入作者名字", trigger: "blur" }
        ],
        bookintro: [
          { required: true, message: "请填写书籍简介", trigger: "blur" }
        ],
        kindname: [
          { required: true, message: "请填写书籍种类", trigger: "blur" }
        ],
        downloadIVN: [
          { required: true, message: "请上传文件", trigger: "blur" }
        ]
      }
    };
  },
  mounted() {
    let routerID = sessionStorage.getItem("routerID");
    if (routerID == 1) {
      this.ifUser.booknameIf = true;
      this.ifUser.subIf = false;
      var josn = sessionStorage.getItem("booksFrom");
      var oneBook = JSON.parse(josn);
      this.bookForm = oneBook;
    } else if (routerID == 0) {
      this.ifUser.booknameIf = false;
      this.ifUser.subIf = true;
      this.bookForm.manage = sessionStorage.getItem("username");
    } else {
      alert("程序出错");
    }
  },
  methods: {
    getFile(event) {
      this.file = event.target.files[0];
      console.log(this.file);
    },
    submitWord(event, kind) {
      if (kind == 0) {
        if (this.file == "") {
          this.$message({
            message: "请上传图片",
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
            let imgUrl = res.data[0];
            that.bookForm.bookimg = imgUrl;
          });
        }
      } else if (kind == 1) {
        if (this.file == "") {
          this.$message({
            message: "请上传文件",
            type: "warning"
          });
        } else {
          const that = this;
          let formData = new FormData();
          formData.append("file", this.file);
          formData.append("kind", 1);
          let config = {
            headers: {
              "Content-Type": "multipart/form-data"
            }
          };
          const URLIMG = "http://120.78.75.213:8080/books/upload";
          // const URLIMG = "http://localhost:9999/upload";
          this.$axios.post(URLIMG, formData, config).then(function(res) {
            let imgWen = res.data[0];
            that.bookForm.downloadIVN = imgWen;
          });
        }
      } else {
        alert("程序出错");
      }
    },
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          // let urlHttp = "http://localhost:9090/upData";
          let urlHttp = "http://120.78.75.213:8080/books/upData";
          let that = this;
          this.$axios({
            method: "POST",
            url: urlHttp,
            params: this.bookForm
          })
            .then(function(e) {
              that.$message({
                message: "已成功修改！",
                type: "success"
              });
              that.$router.push({
                path: "/libraryMain"
              });
              console.log(e.data.message);
            })
            .catch(function(err) {
              console.log(err);
              alert("发送失败！");
            });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    submitAdd(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          // let urlHttp = "http://localhost:9090/addData";
          let urlHttp = "http://120.78.75.213:8080/books/addData";
          let that = this;
          this.$axios({
            method: "POST",
            url: urlHttp,
            params: this.bookForm
          })
            .then(function(e) {
              that.$message({
                message: "已成功修改！",
                type: "success"
              });
              that.$router.push({
                path: "/libraryMain"
              });
              console.log(e);
            })
            .catch(function(err) {
              console.log(err);
              alert("发送失败！");
            });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  },
  store
};
</script>
<style scoped>
</style>
