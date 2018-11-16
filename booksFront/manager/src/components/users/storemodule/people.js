import Vue from "vue";
import Vuex from "vuex";

//引入axios
import axios from "axios";

Vue.use(Vuex);

const url = "http://120.78.75.213:8080/books/";

var state = {
  peopleUser: [],
  peopleManager: [],
  ifUp: false,
  peopleData: {
    date: "",
    id: "",
    username: "",
    password: "",
    remark: "",
    nul: ""
  }
};
let mutations = {
  upPeoUser(state) {
    axios
      .get(url + "userPeople")
      .then(function (e) {
        state.peopleUser = e.data;
      })
      .catch(error => {
        console.log(error);
        alert("网络错误，不能访问");
      });
  },
  upPeoManager(state) {
    axios
      .get(url + "managerPeople")
      .then(function (e) {
        state.peopleManager = e.data;
        // console.log(e);
      })
      .catch(error => {
        console.log(error);
        alert("网络错误，不能访问");
      });
  },
  handleUp(state, rows) {
    state.ifUp = !state.ifUp;
    // this.Managers.date = rows.data;
    state.peopleData.id = rows.id;
    state.peopleData.date = rows.date;
    state.peopleData.username = rows.username;
    state.peopleData.password = rows.password;
    state.peopleData.remark = rows.remark;
    state.peopleData.nul = rows.nul;
    // console.log(rows)
  },
  handleDelect(state, rows) {
    let urlHttp = "http://120.78.75.213:8080/books/delUserPeople";
    // let urlHttp = "http://localhost:9090/delUserPeople";
    axios({
        method: "POST",
        url: urlHttp,
        params: {
          id: rows.id
        }
      })
      .then(function () {
        alert("删除成功");
        location.reload();
      })
      .catch(function (err) {
        console.log(err);
        alert("删除失败！");
      });
    console.log(rows);
  },
  enterSubmit(state, innul) {
    let urlHttp = "http://120.78.75.213:8080/books/findPeopleUser";
    // let urlHttp = "http://localhost:9090/findPeopleUser";

    axios({
        method: "POST",
        url: urlHttp,
        params: {
          fInputuser: innul
        }
      })
      .then(function (e) {
        state.peopleUser = e.data;
      })
      .catch(function (err) {
        console.log(err);
        alert("搜索失败！");
      });
  }
};

let actions = {
  upPeoUser(_content) {
    _content.commit("upPeoUser");
  },
  upPeoManager(_content) {
    _content.commit("upPeoManager");
  }
};

export default new Vuex.Store({
  state,
  mutations,
  actions
});
