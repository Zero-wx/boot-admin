<template>
    <div class="login-container" style="background-color: #7e8c8d">
        <el-form :model="loginForm" class="login-form">
            <div class="title-container">
                <h3 class="title">{{ loginTitle }}</h3>
            </div>
            <el-card class="box-card">
                <el-form-item>
                    <el-input v-model="loginForm.userName" name="userName" type="text" placeholder="账户"
                              auto-complete="on" prefix-icon="user"/>
                </el-form-item>
                <el-form-item>
                    <el-input v-model="loginForm.passWord" type="passWord" placeholder="密码" show-password
                              prefix-icon="Lock"/>
                </el-form-item>
                <el-button type="primary" style="width: 100%; margin-bottom: 30px" @click="submitLogin">登录</el-button>
            </el-card>
        </el-form>
        <A></A>
    </div>
</template>

<script setup>
import A from '@/components/A.vue'
import {login} from "@/api/user";
import {reactive} from 'vue'


let loginTitle = '测试管理后台'


const loginForm = reactive({
    userName: '',
    passWord: '',
})
/**
 * 登录
 */
function submitLogin() {
    console.log('?', this)
    loginTitle = 'asd'
    login({userName: loginForm.userName, passWord: loginForm.passWord}).then(res => {
        console.log(res, '登录')
    })

}


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
            margin: 0 auto 40px auto;
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
