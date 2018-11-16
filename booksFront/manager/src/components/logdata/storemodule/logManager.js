import Vue from 'vue'
import Vuex from 'vuex'

//引入axios
import axios from 'axios'

Vue.use(Vuex)
const url = "http://120.78.75.213:8080/books/"
var state = {
  count: 13,
  logManager: []
}

let mutations = {
  upData(state) {
    axios
      .get(url + "showManagerLog")
      .then(function (e) {
        state.logManager = e.data;
      })
      .catch(error => {
        console.log(error);
        alert("网络错误，不能访问");
      });
  }
}
let actions = {
  upData(_content) {
    _content.commit('upData')
  }

}

export default new Vuex.Store({
  state,
  mutations,
  actions
})
