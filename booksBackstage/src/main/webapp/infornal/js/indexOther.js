var banana = new Vue({
    el: " #banana ",
    data: {
        imgs: [{
                id: "img1",
                class: "item active ",
                url: "",
                title: "",
                context: "",
                newsid: ""
            },
            {
                id: "img2",
                class: "item ",
                url: "",
                title: "",
                context: "",
                newsid: ""
            },
            {
                id: "img3",
                class: "item ",
                url: "",
                title: "",
                context: "",
                newsid: ""
            },
            {
                id: "img4",
                class: "item ",
                url: "",
                title: "",
                context: "",
                newsid: ""
            },
            {
                id: "img5",
                class: "item ",
                url: "",
                title: "",
                context: "",
                newsid: ""
            }
        ]
    },
    mounted: function () {
        var that = this;
        $.ajax({
            url: "http://120.78.75.213:8080/books/newsLink/0",
            method: "POST",
            data: {},
            success: function (e) {
                for (var i = 0; i < e.length; i++) {
                    that.imgs[i].url = e[i].titleimg;
                    that.imgs[i].title = e[i].title;
                    that.imgs[i].context = e[i].context;
                    that.imgs[i].newsid = e[i].newsid;
                }
            },
            error: function (e) {
                console.log(e);
            }
        });
    },
    methods: {
        jumpNews: function (data) {
            sessionStorage.setItem("newid_book", data);
            window.open("infornal/html/onenews.html");
        }
    }
});

var lowBananr = new Vue({
    el: "#lowBananr",
    data: {
        loadBananr: false,
        downClass: "glyphicon glyphicon-chevron-down",
        upClass: "glyphicon glyphicon-chevron-up",
        page: {
            begin: "上一页",
            end: "下一页"
        },
        kindID: 1,
        pageNub: 0,
        pageCur: null,
        kinds: [{
                kindname: "文学",
                kindClass: "active",
                panesClass: "tab-pane fade in active"
            },
            {
                kindname: "传记",
                kindClass: null,
                panesClass: "tab-pane fade"
            },
            {
                kindname: "青春动漫",
                kindClass: null,
                panesClass: "tab-pane fade"
            },
            {
                kindname: "艺术与摄影",
                kindClass: null,
                panesClass: "tab-pane fade"
            },
            {
                kindname: "少儿",
                kindClass: null,
                panesClass: "tab-pane fade"
            },
            {
                kindname: "社会科学",
                kindClass: null,
                panesClass: "tab-pane fade"
            },
            {
                kindname: "历史",
                kindClass: null,
                panesClass: "tab-pane fade"
            },
            {
                kindname: "励志与生活",
                kindClass: null,
                panesClass: "tab-pane fade"
            },
            {
                kindname: "娱乐与成功",
                kindClass: null,
                panesClass: "tab-pane fade"
            },
            {
                kindname: "旅游",
                kindClass: null,
                panesClass: "tab-pane fade"
            },
            {
                kindname: "科技与生活",
                kindClass: null,
                panesClass: "tab-pane fade"
            },
            {
                kindname: "外语学习",
                kindClass: null,
                panesClass: "tab-pane fade"
            },
            {
                kindname: "小说",
                kindClass: null,
                panesClass: "tab-pane fade"
            }
        ],
        kindidLi: []
    },
    computed: {
        kindLis: function () {
            this.axData(this.kindID, this.pageNub);
            return this.kindLi;
        }
    },
    methods: {
        testButton: function (value) {
            console.log(value);
            switch (value) {
                case "文学":
                    this.kindID = 1;
                    break;
                case "传记":
                    this.kindID = 2;
                    break;
                case "青春动漫":
                    this.kindID = 3;
                    break;
                case "艺术与摄影":
                    this.kindID = 4;
                    break;
                case "少儿":
                    this.kindID = 5;
                    break;
                case "社会科学":
                    this.kindID = 6;
                    break;
                case "历史":
                    this.kindID = 7;
                    break;
                case "励志与生活":
                    this.kindID = 8;
                    break;
                case "娱乐与成功":
                    this.kindID = 9;
                    break;
                case "旅游":
                    this.kindID = 10;
                    break;
                case "科技与生活":
                    this.kindID = 11;
                    break;
                case "外语学习":
                    this.kindID = 12;
                    break;
                case "小说":
                    this.kindID = 13;
                    break;
                default:
                    this.kindID = 0;
            }
        },
        pageNul: function (value) {

            if (value == "上一页") {
                if (this.pageNub == 0) {
                    this.pageNub = 0;
                    alert("已经到了上线了哦");
                }
                if (this.pageNub > 0) {
                    this.pageNub = this.pageNub - 1;
                    // console.log(this.pageNub);
                    // this.axData(this.kindID, this.pageNub);
                }
            }
            if (value == "下一页") {
                // console.log(this.pageNub);
                if (this.pageNub == this.pageCur - 1) {
                    alert("我也是有底线的");
                    this.pageNub = this.pageNub;
                }
                if (this.pageNub < this.pageCur - 1) {
                    this.pageNub = this.pageNub + 1;
                    // console.log(this.pageNub);
                    // this.axData(this.kindID, this.pageNub);
                }

            }
        },
        axData: function (kindid, page) {
            let _vm = this;
            $.ajax({
                url: "http://120.78.75.213:8080/books/booksLinkPaging/" + kindid + "-" + page,
                method: "POST",
                async: false,
                success: function (e) {
                    _vm.kindLi = e.sql;
                    _vm.pageCur = e.pageCur;
                },
                error: function (err) {
                    alert(err + "错误");
                }
            });

        },
        jumpBook: function (id, kindid) {
            sessionStorage.setItem("id_book", id);
            sessionStorage.setItem("kindid_book", kindid);
            window.open("infornal/html/onebook.html");

        }
    },
});
getCookie('username');
getCookie('userID');
document.getElementById('userID').innerText = sessionStorage.getItem('username');

var delBtnGg = document.getElementById("delGg");
delBtnGg.onclick = function () {
    document.getElementById('imgGg').style.display = "none"
}