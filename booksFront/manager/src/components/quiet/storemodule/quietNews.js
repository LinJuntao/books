import Vue from "vue";
import Vuex from "vuex";

//引入axios
import axios from "axios";

Vue.use(Vuex);

const urltcp = "http://120.78.75.213:8080/books/";
// const test = "http://localhost:9090/";
var state = {
  newsData: [],
  ifUp: false,
  ifAdd: false,
  oneNewsForm: {
    newsid: "",
    title: "",
    context: "",
    issuer: "books",
    titleimg: "",
    newstime: ""

  }

}

let mutations = {
  upNewsData(state) {
    axios.post(urltcp + "allNews").then(function (e) {
      state.newsData = e.data;
    }).catch(error => {
      console.log(error);
      alert("网络错误，不能访问");
    })
  },
  handleUp(state, rows) {
    state.ifUp = !state.ifUp;
    state.oneNewsForm.newsid = rows.newsid;
    state.oneNewsForm.title = rows.title;
    state.oneNewsForm.context = rows.context;
    state.oneNewsForm.issuer = rows.issuer;
    state.oneNewsForm.titleimg = rows.titleimg;
    state.oneNewsForm.newstime = rows.newstime

  },
  handleAdd(state) {
    state.ifAdd = !state.ifAdd;
    state.oneNewsForm.title = null;
    state.oneNewsForm.context = null;
    state.oneNewsForm.issuer = "books";
    state.oneNewsForm.titleimg = null;
    state.oneNewsForm.newstime = null
  },
  handleDelect(state, rows) {

    axios({
        method: "POST",
        url: urltcp + "delNews",
        params: {
          newsid: rows.newsid
        }
      }).then(function () {
        alert("删除成功");
        location.reload();

      })
      .catch(function (err) {
        console.log(err);
        alert("删除失败！");
      });
  },
  enterFindSub(state, inputFindNews) {
    axios({
      method: "POST",
      url: urltcp + "findAllNewsData",
      params: {
        findInputNews: inputFindNews
      }
    }).then(function (e) {
      state.newsData = e.data;
    }).catch(function (err) {
      console.log(err);
      alert("搜索失败！");
    });

  }

}
let actions = {
  upNewsData(_content) {
    _content.commit("upNewsData")
  },

}
export default new Vuex.Store({
  state,
  mutations,
  actions
});
