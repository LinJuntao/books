/**Vue */
var oneBook = new Vue({
    el: "#oneBook",
    data() {
        return {
            id_onebook: null,
            kindid_onebook: null,
            oneBookData: "",
            ifadvertising: true,
            advertisingImg: "http://120.78.75.213:8080/kindid/guanggao.jpg"
        }
    },
    methods: {
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
        btnDownload: function (kindid, id) {
            let _vm = this;
            $.ajax({
                url: "http://120.78.75.213:8080/books/downloadBookOne",
                method: "POST",
                data: {
                    kindid: kindid,
                    id: id
                },
                success: function (eurl) {
                    if (eurl.downKey) {
                        _vm.$message({
                            showClose: true,
                            message: eurl.message,
                            type: 'success'
                        });
                        window.open(eurl.url);
                    } else {
                        _vm.$message({
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
    computed: {
        oneBookImgStyle: function () {
            if (this.oneBookData != '') {
                let styleD;
                styleD = " background-image: url(" + this.oneBookData.bookimg + "); background-repeat: no-repeat;";
                return styleD;

            }
        }
    },
    created: function () {
        let _vm = this;
        _vm.id_onebook = sessionStorage.getItem("id_book");
        _vm.kindid_onebook = sessionStorage.getItem("kindid_book");
        $.ajax({
            url: "http://120.78.75.213:8080/books/showOneBooksData/" + _vm.kindid_onebook + "-" + _vm.id_onebook,
            method: "POST",
            data: {},
            success: function (eone) {
                _vm.oneBookData = eone[0];
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

$(document).ready(function () {
    var native_width = 0;
    var native_height = 0;
    $('.small').load(function () {
        var img_obj = new Image();
        img_obj.src = $(this).attr('src');
        native_width = img_obj.width;
        native_height = img_obj.height;
        $('.magnify').mousemove(function (e) {
            var magnify_offset = $(this).offset();
            var mouse_x = e.pageX - magnify_offset.left;
            var mouse_y = e.pageY - magnify_offset.top;
            if (mouse_x > 0 && mouse_y > 0 && mouse_x < $(this).width() && mouse_y < $(this).height()) {
                $('.large').fadeIn(100);
            } else {
                $('.large').fadeOut(100);
            }
            if ($('.large').is(':visible')) {
                var rx = Math.round(mouse_x / $('.small').width() * native_width - $('.large').width() / 2) * -1;
                var ry = Math.round(mouse_y / $('.small').height() * native_height - $('.large').height() / 2) * -1;
                var bgp = rx + 'px ' + ry + 'px';
                var gx = mouse_x - $('.large').width() / 2;
                var gy = mouse_y - $('.large').height() / 2;
                $('.large').css({
                    'left': gx,
                    'top': gy,
                    'backgroundPosition': bgp
                })
            }
        })
    })
})

$('#jumpMoreBooks').on("click", function () {
    sessionStorage.setItem("more_kindid", "1");
    window.open("./morebooks.html");
})