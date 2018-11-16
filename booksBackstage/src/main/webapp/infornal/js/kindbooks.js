var kinds = new Vue({
    el: "#kindList",
    data() {
        return {
            kinds_radio: ["文学", "传记", "青春动漫", "艺术与摄影", "少儿", "社会科学", "历史", "励志与生活", "娱乐与成功", "旅游", "科技与生活", "外语学习", "小说"],
            radio: 1,
            activeName: 1,
            books_data: ""

        };
    },
    methods: {
        kindChange() {
            sessionStorage.setItem("more_kindid", this.radio);
            let _bm = this;
            $.ajax({
                url: "http://120.78.75.213:8080/books/showData/" + _bm.radio,
                method: "POST",
                data: {},
                success: function (edata) {
                    _bm.books_data = edata;
                },
                error: function (e) {
                    console.log(e);
                }
            });
        },
        jumpBook: function (kindid, id) {
            sessionStorage.setItem("id_book", id);
            sessionStorage.setItem("kindid_book", kindid);
            window.open("./onebook.html");
        },
        downBook: function (kindid, id) {
            let _om = this;
            $.ajax({
                url: "http://120.78.75.213:8080/books/downloadBookOne",
                method: "POST",
                data: {
                    kindid: kindid,
                    id: id
                },
                success: function (eurl) {
                    if (eurl.downKey) {
                        _om.$message({
                            showClose: true,
                            message: eurl.message,
                            type: 'success'
                        });
                        window.open(eurl.url);
                    } else {
                        _om.$message({
                            showClose: true,
                            message: '已经没有下载的次数了哦，请升级为会员',
                            type: 'warning'
                        });
                    }
                },
                error: function (e) {
                    console.log(e);
                }
            });
        },
        btnCollcetion: function (kindid, id) {
            let _vm = this;
            $.ajax({
                url: "http://120.78.75.213:8080/books/collection_add",
                method: "POST",
                data: {
                    collcetion_book_kindid: kindid,
                    collcetion_book_id: id
                },
                success: function (ecollection) {
                    _vm.$message({
                        showClose: true,
                        message: ecollection.message,
                        type: 'success'
                    });
                },
                error: function (e) {
                    console.log(e);
                }
            });
        },
        btnShopping: function (kindid, id) {
            let _vm = this;
            $.ajax({
                url: "http://120.78.75.213:8080/books/shopping_add",
                method: "POST",
                data: {
                    shopping_book_kindid: kindid,
                    shopping_book_id: id
                },
                success: function (eshopping) {
                    _vm.$message({
                        showClose: true,
                        message: eshopping.message,
                        type: 'success'
                    });
                },
                error: function (e) {
                    console.log(e);
                }
            });
        }

    },
    created() {
        this.radio = parseInt(sessionStorage.getItem("more_kindid"));
        let _vm = this;
        $.ajax({
            url: "http://120.78.75.213:8080/books/showData/" + _vm.radio,
            method: "POST",
            data: {},
            success: function (edata) {
                _vm.books_data = edata;
            },
            error: function (e) {
                console.log(e);
            }
        });
    }
})

document.getElementById("userID").innerText = sessionStorage.getItem(
    "username"
);