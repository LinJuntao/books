<template>
    <div>
      <el-breadcrumb separator-class="el-icon-arrow-right">
  <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
  <el-breadcrumb-item>用户列表</el-breadcrumb-item>

</el-breadcrumb>
        <div>
            <div class="title">
            <h2>管理员的列表名单：</h2>
            </div>
      <el-table
    :data="PeopleManager"
    style="width: 100%">
    <el-table-column
      type="index"
      width="80">
    </el-table-column>
    <el-table-column
      prop="date"
      label="日期"
      width="150">
    </el-table-column>
    <el-table-column
      prop="username"
      label="用户名"
      width="150">
    </el-table-column>
    <el-table-column
      prop="remark"
      label="备注"
      >
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
          </el-row>
       
      </template>
    </el-table-column>
  </el-table>
        </div>
        <div class="userList">
          <div class="findPeople" >
            <h2>普通用户的列表名单：</h2>
            <span> <span>搜索:</span> <el-input
    placeholder="请输入内容" v-model="findInput" v-on:keyup.enter.native="enterSubmit(findInput)" clearable>
    <i slot="prefix" class="el-input__icon el-icon-search"></i>
  </el-input>
  </span>
          </div>
      <el-table
    :data="PeoperUser"
    style="width: 100%">
    <el-table-column
      type="index"
      width="80">
    </el-table-column>
    <el-table-column
      prop="date"
      label="日期"
      width="150">
    </el-table-column>
    <el-table-column
      prop="username"
      label="用户名"
      width="150">
    </el-table-column>
     <el-table-column
      prop="downloadNul"
      label="下载量"
      >
      </el-table-column>
       <el-table-column
      prop="shareNul"
      label="分享量"
      >
      </el-table-column>
       <el-table-column
      prop="ifMember"
      width="100"
      label="是否为会员"
      >
      </el-table-column>
    <el-table-column
      prop="remark"
      label="备注"
      >
    </el-table-column>
    
    <el-table-column
      fixed="right"
      label="操作"
      width="160">
      <template slot-scope="scope">
          <!-- (scope) -->
          <el-row>
                <el-tooltip class="item" effect="dark" content="查看" placement="bottom-start">
               <el-button type="success" icon="el-icon-search" v-on:click="handleLookUser(scope.row)" size="small"  circle></el-button>
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
  <div class="p_nul">
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
        <div class="upForm" v-if="this.$store.state.ifUp">
<el-form ref="peopleData" :model="peopleData"  label-width="80px" class="labelForm" >
    <h3>管理员/用户信息修改:</h3>
    <hr>
  <el-form-item label="用户名:">
    <el-input type="text" v-model="People.username" clearable  ></el-input>
  </el-form-item>
   <el-form-item label="用户密码:">
    <el-input type="password" v-model="People.password" clearable ></el-input>
  </el-form-item>
    <el-form-item label="备注:" prop="desc">
    <el-input type="textarea" v-model="People.remark"></el-input>
  </el-form-item>
  <el-form-item size="large">
    <el-button type="primary" @click="onSubmit">确认</el-button>
    <el-button @click="requr">取消</el-button>
  </el-form-item>
</el-form>
        </div>
        </transition>
    </div>
</template>
<script>
import store from "./storemodule/people";
import { mapState, mapMutations, mapGetters, mapActions } from "vuex";
export default {
  data() {
    return {
      peoUser: "",
      peoMan: "",
      People: {
        date: "",
        id: "",
        username: "",
        password: "",
        remark: "",
        nul: "",
        downloadNul: "",
        shareNul: "",
        ifMember: ""
      },
      pageNum: 1,
      pageSize: 10,
      total: 0,
      findInput: ""
    };
  },
  mounted() {
    this.$store.dispatch("upPeoUser");
    this.$store.dispatch("upPeoManager");
    this.peoUser = this.$store.state;
    this.peoMan = this.$store.state;
  },
  computed: {
    PeoperUser: function() {
      this.peoUser = this.$store.state.peopleUser;
      this.peoUser = this.peoUser.slice(
        (this.pageNum - 1) * this.pageSize,
        this.pageNum * this.pageSize
      );
      for (var i = 0; i < this.peoUser.length; i++) {
        if (this.peoUser[i].ifMember == 0) {
          this.peoUser[i].ifMember = "普通用户";
        }
        if (this.peoUser[i].ifMember == 1) {
          this.peoUser[i].ifMember = "会员";
        }
      }
      return this.peoUser;
    },
    PeopleManager: function() {
      this.peoMan = this.$store.state.peopleManager;
      return this.peoMan;
    },
    peopleData: function() {
      this.People.username = this.$store.state.peopleData.username;
      this.People.password = this.$store.state.peopleData.password;
      this.People.date = this.$store.state.peopleData.date;
      this.People.id = this.$store.state.peopleData.id;
      this.People.remark = this.$store.state.peopleData.remark;
      this.People.nul = this.$store.state.peopleData.nul;
      //   console.log(this.People);
      return this.People;
    },
    totalData: function() {
      this.total = this.$store.state.peopleUser.length;
      return this.total;
    }
  },
  methods: {
    ...mapMutations(["handleUp", "handleDelect", "enterSubmit"]),
    handleClick(row) {
      console.log(row);
    },
    requr() {
      this.$store.state.ifUp = !this.$store.state.ifUp;
    },
    onSubmit() {
      if (this.People.nul == 0) {
        let urlHttp = "http://120.78.75.213:8080/books/upDataManagers";
        console.log(this.People);
        let that = this;
        this.$axios({
          method: "POST",
          url: urlHttp,
          params: this.People
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
        // console.log(this.People);
      } else if (this.People.nul == 1) {
        let urlHttp = "http://120.78.75.213:8080/books/upDataUsers";
        console.log(this.People);
        let that = this;
        this.$axios({
          method: "POST",
          url: urlHttp,
          params: this.People
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
        // console.log(this.People);
      }
    },
    handleLook(rows) {
      const h = this.$createElement;
      this.People.date = rows.date;
      this.People.id = rows.id;
      this.People.username = rows.username;
      this.People.password = rows.password;
      this.People.remark = rows.remark;

      this.$alert(
        "<div >" +
          "<p>管理员创建时间 :" +
          this.People.date +
          "</p>" +
          "<p>管理员ID :" +
          this.People.id +
          "</p>" +
          "<p>管理员名 :" +
          this.People.username +
          "</p>" +
          "<p>管理员密码 :" +
          this.People.password +
          "</p>" +
          "<p>备注 :" +
          this.People.remark +
          "</p>" +
          "</div>",
        "用户信息：",
        {
          dangerouslyUseHTMLString: true
        }
      );
    },
    handleLookUser(rows) {
      const h = this.$createElement;
      this.People.date = rows.date;
      this.People.id = rows.id;
      this.People.username = rows.username;
      this.People.password = rows.password;
      this.People.remark = rows.remark;
      this.People.downloadNul = rows.downloadNul;
      this.People.shareNul = rows.shareNul;

      this.People.ifMember = rows.ifMember;

      this.$alert(
        "<div >" +
          "<p>用户创建时间 :" +
          this.People.date +
          "</p>" +
          "<p>用户ID :" +
          this.People.id +
          "</p>" +
          "<p>用户名 :" +
          this.People.username +
          "</p>" +
          "<p>用户密码 :" +
          this.People.password +
          "</p>" +
          "<p>下载量 :" +
          this.People.downloadNul +
          "</p>" +
          "<p>分享量 :" +
          this.People.shareNul +
          "</p>" +
          "<p>是否为会员 :" +
          this.People.ifMember +
          "</p>" +
          "<p>备注 :" +
          this.People.remark +
          "</p>" +
          "</div>",
        "用户信息：",
        {
          dangerouslyUseHTMLString: true
        }
      );
    },
    handleSizeChange(val) {
      this.pageSize = val;
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      this.pageNum = val;
      console.log(`当前页: ${val}`);
    }
  },
  store
};
</script>

<style >
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
  margin: 15% auto;
  background-color: white;
  border-radius: 10px;
  padding: 10px 30px;
}
.userList {
  padding-top: 20px;
}
.findPeople > h2 {
  float: left;
}
.findPeople > span {
  float: right;
  width: 220px;
}
.findPeople > span > span {
  width: 40px;
  font-size: 15px;
  float: left;
  line-height: 35px;
  padding-right: 5px;
}
.findPeople > span > div {
  float: left;
  width: 180px;
}
.p_nul {
  padding-top: 15px;
  float: right;
}
</style>
