<%--
  @Author PENGL
  2020-03-09
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" session="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Header</title>

    <script src="/springmvc/lib/js/vue.js"></script>
    <script src="/springmvc/lib/js/myAjax.js"></script>
    <script src="/springmvc/lib/js/element-ui.js"></script>

    <base href="http://localhost/springmvc/">

    <style>
        .el-table .warning-row {
            background: oldlace;
        }

        .el-table .success-row {
            background: #f0f9eb;
        }
    </style>
</head>
<body>
<div id="table">
    <button v-on:click="getData">获取Response响应头数据</button>
    <el-table
            :data="tableData"
            style="width: 100%"
            :row-class-name="tableRowClassName">
        <el-table-column
                prop="key"
                label="key"
                width="180">
        </el-table-column>
        <el-table-column
                prop="value"
                label="value">
        </el-table-column>
    </el-table>

</div>
<script>
    var tableVue = new Vue({
        el: "#table",
        data() {
            return {
                tableData: []
            }
        },
        methods: {
            getData: function () {
                ajaxSend(
                    {
                        state200: function (ajax) {
                            var rest = ajax.responseText;
                            //alert(rest);
                            var header = JSON.parse(rest);
                            console.log(header);
                            tableVue.tableData = [];
                            for (var i = 0; i < header.length; i++) {
                                tableVue.tableData.push({
                                    key: header[i].key,
                                    value: header[i].value
                                });
                            }
                        }
                    },
                    "POST",
                    "ajax/header",
                    '{"name": "刘婵","age": 20,"parent":{"name": "刘备","gender":"男"}}',
                    {
                        key: "content-type",
                        value:"application/json; charset=UTF-8"
                    }
                );
            },
            tableRowClassName({row, rowIndex}) {
                if (rowIndex % 2 === 0) {
                    return '';
                } else if (rowIndex % 2 === 1) {
                    return 'success-row';
                }
                return '';
            }
        }
    });
</script>
</body>
</html>