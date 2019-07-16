<style lang="less">
@import "./login.less";

.register {
  text-align: right !important;
  color: #20bd0d !important;
  font-size: 12px !important;
}
.registerIcon {
  font-size: 17px !important;
}
.registerCursor {
  cursor: pointer;
}
</style>

<template>
  <div class="login">
    <div class="login-con">
      <Card icon="log-in" title="MyBelfast" :bordered="false">
        <div class="form-con">
          <login-form @on-success-valid="handleLogin"></login-form>
          <p class="login-tip register">
            <span class="registerCursor" @click="startRegister">
              <Icon type="ios-contact" class="registerIcon registerCursor" />注册
            </span>
          </p>
        </div>
      </Card>
      <login-circle ref="myCircle"></login-circle>
      <login-register ref="myRegister" @on-success-valid="handleRegister"></login-register>
    </div>
  </div>
</template>

<script>
import LoginForm from "../../components/login-form/login-form";
import LoginCircle from "../../components/login-form/login-circle";
import LoginRegister from "../../components/login-form/login-register";
import { post } from "@/util/httpUtil.js";
import { manageLoginCookie } from "@/controller/login.js";
import { backLoginAuth } from "@/controller/login.js";
import router from "@/router.js";
import sleep from "sleepjs";
export default {
  components: {
    LoginForm,
    LoginCircle,
    LoginRegister
  },
  methods: {
    // 登录
    async handleLogin(data) {
      //为了演示加载转圈特效,延迟请求发送
      this.$refs.myCircle.loading();
      await sleep(2000);
      post(global.$prop.URL.login, data, this.loginResponse);
    },
    loginResponse(response, data) {
      global.$util.responseResolve(
        response,
        data,
        this.loginSuccess,
        global.$prop.HTTP_STATUS.OK,
        this.loginError
      );
    },
    loginSuccess(crewName, responseData) {
      manageLoginCookie(crewName, responseData.token);
      router.push({ name: "main" });
    },
    loginError(responseData) {
      this.$refs.myCircle.wait();
      global.$util.errorNotice(responseData.msg);
    },
    // 注册
    startRegister() {
      this.openRegisterPanel();
    },
    handleRegister(data) {
      global.$util.logger("准备提交注册");
      post(global.$prop.URL.register, data, this.registerResponse);
    },
    registerResponse(response, data) {
      global.$util.responseResolve(
        response,
        data,
        this.registerSuccess,
        global.$prop.HTTP_STATUS.REGISTER_SUCCESS
      );
    },
    registerSuccess() {
      global.$util.successNotice("注册成功");
      this.closeRegisterPanel();
    },
    // 其他操作
    openRegisterPanel() {
      this.$refs.myRegister.show = true;
    },
    closeRegisterPanel() {
      this.$refs.myRegister.show = false;
    }
  }
};
</script>

<style>
</style>
