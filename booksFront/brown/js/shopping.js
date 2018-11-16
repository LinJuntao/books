 document.getElementById("userID").innerText = sessionStorage.getItem(
     "username"
 );

 var shoppingBooks = new Vue({
     el: "#shoppingBooks",
     data() {
         return {
             shoppingBooksdata: "",
             checkboxGroup: [],
             someDownloadData: [],
             loadingIf: false
         }
     },
     created() {
         let _vm = this;
         $.ajax({
             url: "http://localhost:9090/shoppingData",
             method: "POST",
             data: {},
             success: function (shoppingdata) {
                 _vm.shoppingBooksdata = shoppingdata;

             },
             error: function (e) {
                 console.log(e);
             }
         });
     },
     methods: {
         someDownload: function () {
             if (this.checkboxGroup.length == 0) {
                 this.$message({
                     showClose: true,
                     message: '请正确选择!',
                     type: 'error'
                 });
             } else {
                 var data, spCB;
                 for (let i = 0; i < this.checkboxGroup.length; i++) {
                     spCB = this.checkboxGroup[i].split(",");
                     data = {
                         kindid: spCB[0],
                         id: spCB[1],
                         shoppingId: spCB[2]
                     };
                     this.someDownloadData.push(data);
                 }
                 let _vm = this;
                 _vm.loadingIf = true;
                 const h = this.$createElement;

                 $.ajax({
                     url: "http://localhost:9090/downloadBooks",
                     method: "POST",
                     dataType: "json",
                     data: {
                         datasql: JSON.stringify(_vm.someDownloadData)
                     },
                     success: function (spdata) {
                         if (spdata.massage == "成功压缩") {
                             _vm.loadingIf = false;
                             window.open(spdata.HttpURL);
                             _vm.$notify({
                                 title: '成功',
                                 message: h('i',
                                     spdata.key
                                 ),
                                 type: 'success'
                             });
                             setTimeout(function () {
                                 _vm.$notify({
                                     title: '提示',
                                     message: h('i',
                                         spdata.downloadNul
                                     ),
                                     type: 'success'
                                 });
                             }, 200)

                             setTimeout(function () {
                                 _vm.$notify({
                                     title: '提示',
                                     message: h('i',
                                         spdata.shengXia
                                     ),
                                     type: 'warning'
                                 });
                             }, 500)

                             setTimeout(function () {
                                 location.reload();
                             }, 1000)

                             for (let b = 0; b < _vm.someDownloadData.length; b++) {
                                 $.ajax({
                                     url: "http://localhost:9090/shopping_del",
                                     method: "POST",
                                     data: {
                                         shoppingId: parseInt(_vm.someDownloadData[
                                             b].shoppingId)
                                     },
                                     success: function (qdata) {
                                         console.log(qdata)
                                     },
                                     error: function (e) {
                                         console.log(e);
                                     }
                                 });
                             }
                         } else {
                             _vm.loadingIf = false;
                             alert("压缩失败");
                         }
                         // _vm.shoppingBooksdata = shoppingdata;
                         console.log(spdata)

                     },
                     error: function (e) {
                         console.log(e);
                     }
                 });

             }
         },
         delectMore: function () {
             if (this.checkboxGroup.length == 0) {
                 this.$message({
                     showClose: true,
                     message: '请正确选择!',
                     type: 'error'
                 });
             } else {
                 let _nm = this;
                 for (let i = 0; i < this.checkboxGroup.length; i++) {
                     spCB = this.checkboxGroup[i].split(",");
                     $.ajax({
                         url: "http://localhost:9090/shopping_del",
                         method: "POST",
                         data: {
                             shoppingId: parseInt(spCB[2])
                         },
                         success: function (qdata) {
                             _nm.$message({
                                 showClose: true,
                                 message: '删除成功!',
                                 type: 'success'
                             });
                             setTimeout(function () {
                                 location.reload();
                             }, 500)
                         },
                         error: function (e) {
                             console.log(e);
                         }
                     });
                 }
             }

         }
     }
 })

 $('#usernameInput').val(sessionStorage.getItem('username'));