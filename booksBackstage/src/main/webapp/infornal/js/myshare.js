$("#koko").click(function () {
  $("#ajaxForm").ajaxSubmit(function (e) {
    console.log(e[0]);
    alert("提交成功1");
  });
  return false;
});
var app = new Vue({
  el: "#app",
  data: function () {
    return {
      fileList2: [],
      active: 1,
      ac1String0: "现阶段可以通过共享自己的书籍，让自己升级成为会员，后续会开发补充通过充值的方法进行升级。",
      ac1String1: "当分享的书籍超过5本时，便可以成为会员，享受会员的权利。",
      ac1String2: "这个世界只要分享才会更美好！分享自己喜欢的书籍，说不定也能找到与自己同爱好的书友呢。一千个读者会有一千个哈姆雷特，我们也可以通过分享的书籍与他人交流心得.",
      ac1String3: "在本站设定当中，普通用户只能下载20本书籍，并且在首页以及其他部分会显示广告。",
      ac1String4: "但如果成为会员，可以享受免广告，以及无下载数量限制，并且在用户名旁会有特殊的标志",
      labelPosition: "left",
      file: "",
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
        bookname: [{
          required: true,
          message: "请输入书名",
          trigger: "blur"
        }],
        bookimg: [{
          required: true,
          message: "请上传图片",
          trigger: "blur"
        }],
        manage: [{
          required: true,
          message: "请输入作者名字",
          trigger: "blur"
        }],
        bookintro: [{
          required: true,
          message: "请填写书籍简介",
          trigger: "blur"
        }],
        kindname: [{
          required: true,
          message: "请填写书籍种类",
          trigger: "blur"
        }],
        downloadIVN: [{
          required: true,
          message: "请上传文件",
          trigger: "blur"
        }]
      },
      shareUser: "",
      shareUserList: ""
    };
  },
  created() {
    let username = sessionStorage.getItem("username");
    let _vm = this;
    this.bookForm.manage = username;

    $.ajax({
      url: "http://120.78.75.213:8080/books/showShareUserData",
      method: "POST",
      data: {
        username: username
      },
      success: function (sharedata) {
        _vm.shareUserList = sharedata;
      },
      error: function (e) {
        console.log(e);
      }
    });
    $.ajax({
      url: "http://120.78.75.213:8080/books/showShareUser",
      method: "POST",
      data: {
        username: username
      },
      success: function (userdata) {
        _vm.shareUser = userdata[0];
      },
      error: function (e) {
        console.log(e);
      }
    });
  },
  methods: {
    next() {
      // this.active++;
      if (this.active++ > 3) this.active = 1;
    },
    lplp() {
      let _vn = this;
      $("#ajaxForm").ajaxSubmit(function (e) {
        _vn.bookForm.downloadIVN = e[0];
        // console.log(e[0])
        alert("上传成功");
      });
    },
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
          var formdata = new FormData();
          formdata.append("file", this.file);
          formdata.append("kind", 0);
          const URLIMG = "http://120.78.75.213:8080/books/upload";
          // const URLIMG = "http://120.78.75.213:8080/books/upload";
          $.ajax({
              url: URLIMG,
              type: "POST",
              cache: false,
              data: formdata,
              processData: false,
              contentType: false,
              async: false
            })
            .done(function (res) {
              // let imgUrl = res.data[0];
              that.bookForm.bookimg = res[0];
              // console.log(res)
            })
            .fail(function (res) {
              console.log(res);
            });
        }
      } else {
        alert("程序出错");
      }
    },
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          let urlHttp = "http://120.78.75.213:8080/books/addShareUserData";
          //  let urlHttp = "http://120.78.75.213:8080/books/upData";
          let that = this;
          $.ajax({
            url: urlHttp,
            method: "POST",
            data: that.bookForm,
            success: function (e) {
              that.$message({
                message: e.message,
                type: "success"
              });
              setTimeout(function () {
                that.$message({
                  message: "你已分享" + e.shareNul + "本书籍",
                  type: "success"
                });
              }, 1000);
              that.bookForm = {
                altertime: null,
                bookimg: null,
                bookintro: null,
                bookname: null,
                downlaodNUM: null,
                downloadIVN: null,
                id: null,
                kindid: null,
                kindname: null,
                manage: sessionStorage.getItem("username"),
                remove: 0
              };
              if (e.status) {
                that.active = that.active + 1;
              }
            },
            error: function (e) {
              console.log(e);
            }
          });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    editShare(sharedata) {
      console.log(sharedata);
    },
    downshare(shareid) {
      let _bm = this;
      $.ajax({
        url: "http://120.78.75.213:8080/books/shareUserdownoreup",
        method: "POST",
        data: {
          id: shareid,
          downup: 101
        },
        success: function (edata) {
          _bm.$message({
            message: edata.message,
            type: "success"
          });
          setTimeout(function () {
            window.location.reload();
          }, 500);
        },
        error: function (e) {
          console.log(e);
        }
      });
    },
    upshare(shareid) {
      let _bm = this;
      $.ajax({
        url: "http://120.78.75.213:8080/books/shareUserdownoreup",
        method: "POST",
        data: {
          id: shareid,
          downup: 100
        },
        success: function (edata) {
          _bm.$message({
            message: edata.message,
            type: "success"
          });
          setTimeout(function () {
            window.location.reload();
          }, 500);
        },
        error: function (e) {
          console.log(e);
        }
      });
    }
  }
});

document.getElementById("userID").innerText = sessionStorage.getItem(
  "username"
);