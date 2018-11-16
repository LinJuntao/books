 var kindli = new Vue({
     el: "#kindli",
     data: {
         lis: [{
                 CNname: "文学",
                 USname: "literature",
                 data: [{
                     bookimg: "../img/Koala.jpg ",
                     bookintro: "popopopopopopo",
                     bookname: "kolooiio"
                 }]
             }, {
                 CNname: "传记",
                 USname: "biography",
                 data: [{
                     bookimg: "../img/Koala.jpg ",
                     bookintro: "popopopopopopo",
                     bookname: "kolooiio"
                 }]
             },
             {
                 CNname: "青春动漫",
                 USname: "cartoon",
                 data: [{
                     bookimg: "../img/Koala.jpg ",
                     bookintro: "popopopopopopo",
                     bookname: "kolooiio"
                 }]
             }, {
                 CNname: "艺术与摄影",
                 USname: "art",
                 data: [{
                     bookimg: "../img/Koala.jpg ",
                     bookintro: "popopopopopopo",
                     bookname: "kolooiio"
                 }]
             }, {
                 CNname: "少儿",
                 USname: "children",
                 data: [{
                     bookimg: "../img/Koala.jpg ",
                     bookintro: "popopopopopopo",
                     bookname: "kolooiio"
                 }]
             }, {
                 CNname: "社会科学",
                 USname: "social",
                 data: [{
                     bookimg: "../img/Koala.jpg ",
                     bookintro: "popopopopopopo",
                     bookname: "kolooiio"
                 }]
             }, {
                 CNname: "历史",
                 USname: "history",
                 data: [{
                     bookimg: "../img/Koala.jpg ",
                     bookintro: "popopopopopopo",
                     bookname: "kolooiio"
                 }]
             }, {
                 CNname: "励志与成功",
                 USname: "succer",
                 data: [{
                     bookimg: "../img/Koala.jpg ",
                     bookintro: "popopopopopopo",
                     bookname: "kolooiio"
                 }]
             }, {
                 CNname: "娱乐与体育",
                 USname: "fun",
                 data: [{
                     bookimg: "../img/Koala.jpg ",
                     bookintro: "popopopopopopo",
                     bookname: "kolooiio"
                 }, ]
             }, {
                 CNname: "旅游",
                 USname: "traval",
                 data: [{
                     bookimg: "../img/Koala.jpg ",
                     bookintro: "popopopopopopo",
                     bookname: "kolooiio"
                 }]
             }, {
                 CNname: "科技与生活",
                 USname: "life",
                 data: [{
                     bookimg: "../img/Koala.jpg ",
                     bookintro: "popopopopopopo",
                     bookname: "kolooiio"
                 }]
             }, {
                 CNname: "外语学习",
                 USname: "language",
                 data: [{
                     bookimg: "../img/Koala.jpg ",
                     bookintro: "popopopopopopo",
                     bookname: "kolooiio"
                 }]
             }, {
                 CNname: "小说",
                 USname: "novel",
                 data: [{
                     bookimg: "../img/Koala.jpg ",
                     bookintro: "popopopopopopo",
                     bookname: "kolooiio"
                 }]
             }
         ]
     },
     methods: {
         jumpBook: function (id, kindid) {
             sessionStorage.setItem("id_book", id);
             sessionStorage.setItem("kindid_book", kindid);
             window.open("infornal/html/onebook.html");
         },
         jumpmorebooks: function (kindid) {
             sessionStorage.setItem("more_kindid", kindid);
             window.location.href = "infornal/html/morebooks.html";
         }
     },
     mounted: function () {
         const that = this;
         var lists = [];
         for (let i = 0; i < that.lis.length; i++) {
             $.ajax({
                 url: "http://localhost:9090/allBooksLink/" + (i + 1),
                 method: "POST",
                 async: false,
                 success: function (e) {
                     lists[i] = e;

                 }
             })
             that.lis[i].data = lists[i];
         }
     }
 })
 var newslistId = new Vue({
     el: "#newlistId",
     data() {
         return {
             newlists: [],
             morelists: [],
             morestatu: true
         }
     },
     computed: {
         newList: function () {
             return this.newlists;
         }
     },
     methods: {
         morelistNew: function () {
             let that = this;
             $.ajax({
                 url: "http://localhost:9090/newBooksLink/1",
                 method: "POST",
                 success: function (e) {
                     that.morestatu = !that.morestatu;
                     that.morelists = e;
                 }
             })
         },
         putmore: function () {
             this.morestatu = !this.morestatu
         },
         jumpNewBook: function (bookid) {
             sessionStorage.setItem("id_newbook", bookid);
             window.open("infornal/html/onenewbook.html");

         }
     },
     created() {
         let _vm = this;
         $.ajax({
             url: "http://localhost:9090/newBooksLink/0",
             method: "POST",
             success: function (e) {
                 _vm.newlists = e;
                 //  console.log(e)
             }
         })
     }
 })

 var quitelist = new Vue({
     el: "#quitelist",
     data() {
         return {
             quitelists: [],
             quiteMorelists: [],
             quitestatu: true
         }
     },
     computed: {
         quiteList: function () {
             return this.quitelists;
         },

     },
     methods: {
         morelistQuite: function () {
             let that = this;
             $.ajax({
                 url: "http://localhost:9090/newsLink/2",
                 method: "POST",
                 success: function (e) {
                     that.quitestatu = !that.quitestatu;
                     that.quiteMorelists = e;
                 }
             })
         },
         putmore: function () {
             this.quitestatu = !this.quitestatu
         },
         jumpNews: function (newsid) {
             sessionStorage.setItem("newid_book", newsid);
             window.open("infornal/html/onenews.html");
         }
     },
     created() {
         let _vm = this;
         $.ajax({
             url: "http://localhost:9090/newsLink/1",
             method: "POST",
             success: function (e) {
                 _vm.quitelists = e;
                 //  console.log(e)
             }
         })
     }
 })