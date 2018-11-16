import Vue from "vue";
import Vuex from "vuex";

//引入axios
import axios from "axios";

Vue.use(Vuex);

const urltcp = "http://120.78.75.213:8080/books/";
// const test = "http://localhost:9090/";
var state = {
  booksArt: [],
  booksBiography: [],
  booksCartoon: [],
  booksFun: [],
  booksChildren: [],
  booksHistory: [],
  booksLanguage: [],
  booksLife: [],
  booksLiterature: [],
  booksNovel: [],
  booksSocial: [],
  booksSuccer: [],
  booksTraval: [],
  ifForm: false,
  booksForm: {
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
    remove: null


  }
}
let mutations = {
  booksLiterature: function (state) {
    axios.post(urltcp + "showData/" + 1).then(function (e) {
      state.booksLiterature = e.data;
    }).catch(error => {
      console.log(error);
      alert("网络错误，不能访问");
    })
  },
  booksBiography: function (state) {
    axios.post(urltcp + "showData/" + 2).then(function (e) {
      state.booksBiography = e.data;

    }).catch(error => {
      console.log(error);
      alert("网络错误，不能访问");
    })
  },
  booksCartoon: function (state) {
    axios.post(urltcp + "showData/" + 3).then(function (e) {
      state.booksCartoon = e.data;

    }).catch(error => {
      console.log(error);
      alert("网络错误，不能访问");
    })
  },
  booksArt: function (state) {
    axios.post(urltcp + "showData/" + 4).then(function (e) {
      state.booksArt = e.data;

    }).catch(error => {
      console.log(error);
      alert("网络错误，不能访问");
    })
  },
  booksChildren: function (state) {
    axios.post(urltcp + "showData/" + 5).then(function (e) {
      state.booksChildren = e.data;

    }).catch(error => {
      console.log(error);
      alert("网络错误，不能访问");
    })
  },
  booksSocial: function (state) {
    axios.post(urltcp + "showData/" + 6).then(function (e) {
      state.booksSocial = e.data;

    }).catch(error => {
      console.log(error);
      alert("网络错误，不能访问");
    })
  },
  booksHistory: function (state) {
    axios.post(urltcp + "showData/" + 7).then(function (e) {
      state.booksHistory = e.data;

    }).catch(error => {
      console.log(error);
      alert("网络错误，不能访问");
    })
  },
  booksSuccer: function (state) {
    axios.post(urltcp + "showData/" + 8).then(function (e) {
      state.booksSuccer = e.data;

    }).catch(error => {
      console.log(error);
      alert("网络错误，不能访问");
    })
  },
  booksFun: function (state) {
    axios.post(urltcp + "showData/" + 9).then(function (e) {
      state.booksFun = e.data;

    }).catch(error => {
      console.log(error);
      alert("网络错误，不能访问");
    })
  },
  booksTraval: function (state) {
    axios.post(urltcp + "showData/" + 10).then(function (e) {
      state.booksTraval = e.data;

    }).catch(error => {
      console.log(error);
      alert("网络错误，不能访问");
    })
  },
  booksLife: function (state) {
    axios.post(urltcp + "showData/" + 11).then(function (e) {
      state.booksLife = e.data;

    }).catch(error => {
      console.log(error);
      alert("网络错误，不能访问");
    })
  },
  booksLanguage: function (state) {
    axios.post(urltcp + "showData/" + 12).then(function (e) {
      state.booksLanguage = e.data;

    }).catch(error => {
      console.log(error);
      alert("网络错误，不能访问");
    })
  },
  booksNovel: function (state) {
    axios.post(urltcp + "showData/" + 13).then(function (e) {
      state.booksNovel = e.data;

    }).catch(error => {
      console.log(error);
      alert("网络错误，不能访问");
    })
  },
  handleLook(state, data) {
    state.ifForm = !state.ifForm;
    // document.documentElement.style.overflowY = 'hidden';
    state.booksForm.bookimg = data.bookimg;
    state.booksForm.altertime = data.altertime;
    state.booksForm.bookintro = data.bookintro;
    state.booksForm.bookname = data.bookname;
    state.booksForm.downlaodNUM = data.downlaodNUM;
    state.booksForm.downloadIVN = data.downloadIVN;
    state.booksForm.id = data.id;
    state.booksForm.kindid = data.kindid;
    state.booksForm.kindname = data.kindname;
    state.booksForm.manage = data.manage;
    state.booksForm.remove = data.remove;
    // console.log(data);
  },
  isOk(state) {
    state.ifForm = !state.ifForm;
  },
  handleDelect(state, data) {
    axios({
      method: "POST",
      url: urltcp + "delectData",
      params: {
        kindId: data.kindid,
        id: data.id
      }
    }).then(function () {
      alert("删除成功");
      location.reload();
    }).catch(function (err) {
      console.log(err);
      alert("删除失败！");
    });
  },
  enterFindSub(state, inputFind) {
    axios({
      method: "POST",
      url: urltcp + "findData",
      params: {
        inputFind: inputFind
      }
    }).then(function (e) {
      state.booksLiterature = e.data[1];
      state.booksBiography = e.data[2];
      state.booksCartoon = e.data[3];
      state.booksArt = e.data[4];
      state.booksChildren = e.data[5];
      state.booksSocial = e.data[6];
      state.booksHistory = e.data[7];
      state.booksSuccer = e.data[8];
      state.booksFun = e.data[9];
      state.booksTraval = e.data[10];
      state.booksLife = e.data[11];
      state.booksLanguage = e.data[12];
      state.booksNovel = e.data[13];

    }).catch(function (err) {
      console.log(err);
      alert("搜索失败！");
    });

  }
}
let actions = {
  booksLiterature(_content) {
    _content.commit("booksLiterature")
  },
  booksBiography(_content) {
    _content.commit("booksBiography")
  },
  booksCartoon(_content) {
    _content.commit("booksCartoon")
  },
  booksArt(_content) {
    _content.commit("booksArt")
  },
  booksChildren(_content) {
    _content.commit("booksChildren")
  },
  booksSocial(_content) {
    _content.commit("booksSocial")
  },
  booksHistory(_content) {
    _content.commit("booksHistory")
  },
  booksSuccer(_content) {
    _content.commit("booksSuccer")
  },
  booksFun(_content) {
    _content.commit("booksFun")
  },
  booksTraval(_content) {
    _content.commit("booksTraval")
  },
  booksLife(_content) {
    _content.commit("booksLife")
  },
  booksLanguage(_content) {
    _content.commit("booksLanguage")
  },
  booksNovel(_content) {
    _content.commit("booksNovel")
  }
}
export default new Vuex.Store({
  state,
  mutations,
  actions
});
