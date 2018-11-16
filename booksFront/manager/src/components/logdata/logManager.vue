<template>
    <div>
       <el-breadcrumb separator-class="el-icon-arrow-right">
  <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
  <el-breadcrumb-item>管理员操作日志</el-breadcrumb-item>

</el-breadcrumb>
      <h2>管理员操作日志：</h2>
        <hr>
  <el-table
    :data="logManagerDataAll"
    style="width: 100%">
    <el-table-column type="expand">
      <template slot-scope="props">
        <el-form label-position="left" inline class="demo-table-expand">
          <el-form-item label="LOG日志日期">
            <span>{{  props.row.logtime }}</span>
          </el-form-item>
          <el-form-item label="LOG日志操作人">
            <span>{{  props.row.loguser }}</span>
          </el-form-item>
          <el-form-item label="LOG日志操作记录">
            <span>{{  props.row.logcontent }}</span>
          </el-form-item>
        </el-form>
      </template>
    </el-table-column>
     <el-table-column
      type="index"
      width="60">
    </el-table-column>
    <el-table-column
      label="日期" 
      sortable
      width="100"
      prop="logtime">
    </el-table-column>
    <el-table-column
      label="姓名"
       width="100"
      prop="loguser">
    </el-table-column>
    <el-table-column
      label="操作记录"
      prop="logcontent">
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
</template>
<script>
import store from "./storemodule/logManager";
import { mapState, mapMutations, mapGetters, mapActions } from "vuex";

export default {
  data() {
    return {
      logManagerData: "",
      pageNum: 1,
      pageSize: 10,
      total: 20,
      count: ""
    };
  },
  mounted() {
    this.$store.dispatch("upData");
    // this.count = this.$store.state;
    this.logManagerData = this.$store.state;
  },
  computed: {
    ...mapState({
      logUser: function(state) {
        return state.logUser;
      }
    }),
    totalData: function() {
      this.total = this.$store.state.logManager.length;
      return this.total;
    },
    logManagerDataAll: function() {
      this.logManagerData = this.$store.state.logManager;
      this.logManagerData = this.logManagerData.slice(
        (this.pageNum - 1) * this.pageSize,
        this.pageNum * this.pageSize
      );
      return this.logManagerData;
    }
  },
  methods: {
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
<style>
.p_total {
  padding-top: 20px;
  float: right;
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
  width: 50%;
}
</style>
