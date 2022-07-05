<template>
    <div class="login-container" style="background-color: #7e8c8d">
        <el-form :model="loginForm" class="login-form">
            <div class="title-container">
                <h3 class="title">{{loginTitle}}</h3>
            </div>
            <el-card class="box-card">
                <el-form-item>
                    <el-input v-model="loginForm.userName" name="userName" type="text" placeholder="账户" auto-complete="on" :prefix-icon="Avatar" />
                </el-form-item>
                <el-form-item>
                    <el-input v-model="loginForm.passWord" type="passWord" placeholder="密码" show-password :prefix-icon="Lock" />
                </el-form-item>
                <el-button type="primary" style="width: 100%; margin-bottom: 30px">登录</el-button>
            </el-card>
        </el-form>

            </div>
</template>
<script setup>
    import { reactive } from 'vue'
    import { Avatar, Lock } from '@element-plus/icons-vue'



    const loginTitle = '测试管理后台'
    const loginForm = reactive({
        userName: '',
        passWord: '',
    })
</script>

<style lang="scss" scoped>
    .login-container {
        min-height: 100%;
        width: 100%;
        overflow: hidden;

        .title-container {
            position: relative;

            .title {
                font-size: 46px;
                color: #eee;
                margin: 0px auto 40px auto;
                text-align: center;
                font-weight: bold;
            }
        }


        .login-form {
            position: relative;
            width: 520px;
            max-width: 100%;
            padding: 160px 35px 0;
            margin: 0 auto;
            overflow: hidden;

        }
    }
</style>