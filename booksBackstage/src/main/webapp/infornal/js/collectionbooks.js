var collectionBooks = new Vue({
    el: "#collectionBooks",
    data() {
        return {
            activeName: 1,
            collection_books_data: ""
        }
    },
    methods: {
        delCollocetion: function (coId) {
            let _vm = this;
            $.ajax({
                url: "http://120.78.75.213:8080/books/collection_del",
                method: "POST",
                data: {
                    collcetionId: coId
                },
                success: function (edata) {
                    _vm.$message({
                        showClose: true,
                        message: edata.message,
                        type: 'success'
                    });
                    window.location.reload()
                },
                error: function (e) {
                    console.log(e);
                }
            });
        },
        jumpbook: function (kindid, id) {
            sessionStorage.setItem("id_book", id);
            sessionStorage.setItem("kindid_book", kindid);
            window.open("./onebook.html");
        }
    },
    created: function () {
        let _vm = this;
        $.ajax({
            url: "http://120.78.75.213:8080/books/collectionData",
            method: "POST",
            data: {},
            success: function (edata) {
                _vm.collection_books_data = edata;
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