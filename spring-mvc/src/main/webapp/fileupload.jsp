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
    <title>File Upload</title>

    <link rel="stylesheet" href="/springmvc/lib/css/element-ui.css">
    <script src="/springmvc/lib/js/vue.js"></script>
    <script src="/springmvc/lib/js/myAjax.js"></script>
    <script src="/springmvc/lib/js/element-ui.js"></script>

    <base href="http://localhost/springmvc/">

</head>
<body>
    <div id="fileUpload">
        <el-upload
                class="upload-demo"
                ref="upload"
                action="multipart/fileupload"
                :on-preview="handlePreview"
                :on-remove="handleRemove"
                :file-list="fileList"
                :auto-upload="false">
            <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
            <el-button style="margin-left: 10px;" size="small" type="success" @click="submitUpload">上传</el-button>
            <div slot="tip" class="el-upload__tip">上传文件大小不超过10MB</div>
        </el-upload>
    </div>
    <script>
        new  Vue({
            el: "#fileUpload",
            data() {
                return {
                    fileList: []
                };
            },
            methods: {
                submitUpload() {
                    this.$refs.upload.submit();
                },
                handleRemove(file, fileList) {
                    console.log(file, fileList);
                },
                handlePreview(file) {
                    console.log(file);
                }
            }
        });
    </script>

    <div id="form">
        <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="账号" prop="userID">
                <el-input v-model="ruleForm.userID" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="确认密码" prop="password">
                <el-input type="password" v-model="ruleForm.password" autocomplete="off"></el-input>
            </el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
        </el-form>
    </div>
    <script>
        new Vue({
            el: "#form",
            data() {
                var validateUserID = (rule, value, callback) => {
                    if (value === '') {
                        callback(new Error('请输入账号'));
                    } else {
                        callback();
                    }
                };
                var validatePassword = (rule, value, callback) => {
                    if (value === '') {
                        callback(new Error('请输入输入密码'));
                    } else {
                        callback();
                    }
                };
                return {
                    ruleForm: {
                        userID: '',
                        password: ''
                    },
                    rules: {
                        userID: [
                            { validator: validateUserID, trigger: 'blur' }
                        ],
                        password: [
                            { validator: validatePassword, trigger: 'blur' }
                        ]
                    }
                };
            },
            methods: {
                submitForm(formName) {
                    this.$refs[formName].validate((valid) => {
                        if (valid) {
                            alert('submit!');
                        } else {
                            console.log('error submit!!');
                            return false;
                        }
                    });
                },
                resetForm(formName) {
                    this.$refs[formName].resetFields();
                }
            }
        });
    </script>
    </body>
</html>