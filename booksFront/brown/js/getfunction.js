function getCookie(cooker) {
    var strcookie = document.cookie; //获取cookie字符串
    var arrcookie = strcookie.split("; "); //分割
    //遍历匹配
    for (var i = 0; i < arrcookie.length; i++) {
        var arr = arrcookie[i].split("=");

        if (arr[0] == cooker) {
            // console.log(arr[1])
            sessionStorage.setItem(cooker, arr[1]);
        }
    }
}

function keyupEnter(e) {
    var evt = window.event || e;
    if (evt.keyCode == 13) {
        searchAllBooks(1)
    }
}

function keyupEnterIndex(e) {
    var evt = window.event || e;
    if (evt.keyCode == 13) {
        searchAllBooks(0)
    }
}

/**搜索 */

function searchAllBooks(ifIndex) {
    let searchString = $('#searchString').val();
    if (ifIndex == 0) {
        if (searchString == "") {
            alert("请输入搜索内容!")
        } else {
            let str = searchString.replace(/(^\s+)|(\s+$)/g, "");
            sessionStorage.setItem("searchData", str);
            window.location.href = "infornal/html/serachBook.html";

        }

    }

    if (ifIndex == 1) {
        if (searchString == "") {
            alert("请输入搜索内容!")
        } else {
            let str = searchString.replace(/(^\s+)|(\s+$)/g, "");
            sessionStorage.setItem("searchData", str);
            window.location.href = "./serachBook.html";

        }
    }

}