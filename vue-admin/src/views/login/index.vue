<template>
  <div class="login-wrapper">
    <div class="login-container">
      <div class="welcome">
        <div class="title">
          <p>欢迎光临</p>
          <p>欢迎光临XX后台管理系统，在这里和志同道合的朋友一起分享有趣的故事，一起组织有趣的活动...</p>
        </div>
      </div>
      <div class="form">
        <div class="form-wrapper">
          <div class="form-title">
            <p>欢迎回来</p>
          </div>
          <el-form class="el_form" :model="loginForm">
            <el-form-item>
              <el-input type="text" v-model="loginForm.userName"></el-input>
              <label>账号</label>
              <div class="bar"></div>
            </el-form-item>
            <el-form-item>
              <el-input type="passWord" v-model="loginForm.passWord"></el-input>
              <label>密码</label>
              <div class="bar"></div>
            </el-form-item>
            <el-button type="primary" class="login-btn" @click="login">登录</el-button>
          </el-form>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import {reactive} from "vue";

const loginForm = reactive({
  userName: '',
  passWord: ''
})

function login() {
  console.log('登录', loginForm.passWord)
}


</script>

<style scoped lang="scss">
.login-wrapper {
  background: url("~@/assets/bg.jpg") no-repeat 50% fixed;
  background-size: cover;
  height: 100%;

  .login-container {
    background: rgba(4, 40, 68, 0.8);
    padding: 20px;
    display: flex;
    justify-content: center;
    flex-direction: row;
    align-items: center;
    height: 100%;

    .welcome {
      background-image: linear-gradient(rgba(0, 133, 165, 0.75), rgba(53, 112, 209, 0.75));
      border-radius: 8px 0 0 8px;
      height: 400px;
      width: 90%;
      max-width: 420px;

      .title {
        position: relative;
        transform: translate(0, -50%);
        top: 50%;
        padding: 30px;

        p:nth-child(1) {
          font-size: 2.5rem;
          font-weight: bold;
          margin-bottom: 10px;
        }

        p:nth-child(2) {
          font-size: 0.8rem;
        }
      }
    }

    .form {
      background: #fffc;
      border-radius: 0 8px 8px 0;
      height: 400px;
      width: 90%;
      max-width: 420px;
      padding: 20px 55px;
      text-align: center;

      .form-wrapper {
        position: relative;
        top: 50%;
        transform: translateY(-50%);


        .form-title {
          margin-bottom: 35px;

          p {
            color: #0f2c3f;
            font-weight: bold;
            font-size: 2.3rem;
          }
        }


        :deep(.el_form) {

          .el-form-item {
            margin-bottom: 25px;

            p {
              font-size: 1rem;
              position: relative;
              top: 4px;
              color: #0f2c3f;
            }
          }

          .el-input__wrapper {
            background: none;
            padding: 0;
            box-shadow: none;
            border-radius: 0;
            border-bottom: 1px solid #979696;

            .el-input__inner {
              border-color: transparent;
              font-size: 1.2rem;
              margin-top: 15px;

              &:focus {

              }
            }


          }


          .el-form-item__content:focus-within {
            label {
              transform: translate(-12%, -50%) scale(0.75);
            }

            .bar {
              transform: none;
            }
          }

          label {
            position: absolute;
            top: 0;
            left: 0;
            font-size: 1.2rem;
            font-weight: 400;
            color: #0f2c3f;
            transition: 0.3s ease;
          }

          .bar {
            width: 100%;
            height: 2px;
            background: #2464a5;
            transition: 0.3s ease;
            transform: scale(0, 1);
            //transform: translate(-12%, -50%) scale(1);
          }
        }

        .login-btn {
          margin-top: 35px;
          width: 100%;
          height: 40px;
          font-size: 1.11rem;
        }
      }
    }
  }
}
</style>