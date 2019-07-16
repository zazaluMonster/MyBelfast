<style scoped>
.article-inner {
  border-color: #d1d1d1;
}

.article-header {
  border-left: 5px solid #4d4d4d;
  padding: 30px 0 15px 25px;
  padding-left: 7.6923%;
}

.article-inner h1:first-child {
  margin-bottom: 10px;
  display: inline;
}
.archive-article-date {
  color: #999;
  margin-right: 7.6923%;
  float: right;
}
.archive-article-date .icon {
  margin: 5px 5px 5px 0;
}
.project {
  width: 100%;
  min-height: 150px;
  margin: 20px 0px;
  display: block;
  clear: both;
}
.project img {
  width: 132px;
  height: 132px;
  float: left;
  background-color: white;
  padding: 6px;
  border-radius: 8px;
  border: 1px solid #dedede;
  margin: -5px 10px 5px 0px;
}
.project .intro {
  margin: 5px 10px 5px 0px;
  width: 100%;
}
.project .intro ul {
  list-style: none;
  margin-left: 0;
}
.project .intro ul li {
  line-height: 20px;
}
.project .intro ul li:first-child {
  font-size: 20px;
  padding-bottom: 5px;
  margin-bottom: 10px;
  border-bottom: 1px #eee solid;
}
.article-entry {
  line-height: 1.8em;
  padding-right: 7.6923%;
  padding-left: 7.6923%;
}
.demo-drawer-footer {
  width: 100%;
  position: absolute;
  bottom: 0;
  left: 0;
  border-top: 1px solid #e8e8e8;
  padding: 10px 16px;
  text-align: right;
  background: #fff;
}
</style>
<template>
  <div>
    <Card class="card">
      <!-- header -->
      <div class="article-inner">
        <header class="article-header">
          <h1 class="article-title" itemprop="name">用户管理</h1>
          <a href="/project/index.html" class="archive-article-date">
            <time datetime="2016-02-23T17:03:48.000Z" itemprop="datePublished">
              <Icon class="icon-calendar icon" type="md-calendar" />仅对管理员开放
            </time>
          </a>
        </header>
      </div>
      <br />
      <!-- crew列表 -->
      <Table border :columns="columns1" :data="data1"></Table>
      <!-- 修改框 -->
      <Drawer
        title="用户修改"
        v-model="show"
        width="720"
        :mask-closable="false"
        :styles="styles"
        placement="right"
      >
        <Form ref="updateForm" :model="formData" :rules="rules">
          <Row :gutter="32">
            <i-col span="12">
              <FormItem label="昵称" label-position="top" prop="crewName">
                <i-input v-model="formData.crewName" placeholder="首先让MyBelfast知道你是谁" />
              </FormItem>
            </i-col>
            <i-col span="12">
              <FormItem label="邮箱" label-position="top" prop="mail">
                <i-input v-model="formData.mail" placeholder="邮箱是重要的联系方式">
                  <span slot="append">.com</span>
                </i-input>
              </FormItem>
            </i-col>
          </Row>
          <Row :gutter="32">
            <i-col span="12">
              <FormItem label="密码" label-position="top" prop="password">
                <i-input disabled type="password" placeholder="密码无法修改" />
              </FormItem>
            </i-col>
            <i-col span="12">
              <FormItem label="手机号" label-position="top" prop="phoneNum">
                <i-input v-model="formData.phoneNum" placeholder="目前只支持国人注册哦">
                  <span slot="prepend">86</span>
                </i-input>
              </FormItem>
            </i-col>
          </Row>
          <FormItem label="短信验证码" label-position="top" prop="verifyCode">
            <i-input v-model="formData.verifyCode" placeholder="防止恶意注册" style="width: 120px" />
            <Button style="margin-left: 10px" @click="getVerificationCode">获取验证码</Button>
          </FormItem>
        </Form>
        <div class="demo-drawer-footer">
          <Button style="margin-right: 8px" @click="show = false">取消</Button>
          <Button type="primary" @click="submitUpdate">提交</Button>
        </div>
      </Drawer>
    </Card>
  </div>
</template>
<script>
import { post } from "@/util/httpUtil.js";
import jsonManager from "json5";

var verifyCode = "";
const verifyCodePass = (rule, value, callback) => {
  if (value != verifyCode) {
    callback(new Error("验证码错误"));
  } else {
    callback();
  }
};
export default {
  props: {
    crewNameRules: {
      type: Array,
      default: () => {
        return [{ required: true, message: "账号不能为空", trigger: "blur" }];
      }
    },
    passwordRules: {
      type: Array,
      default: () => {
        return [{ required: true, message: "密码不能为空", trigger: "blur" }];
      }
    },
    mailRules: {
      type: Array,
      default: () => {
        return [{ required: true, message: "邮箱不能为空", trigger: "blur" }];
      }
    },
    phoneRules: {
      type: Array,
      default: () => {
        return [
          { required: true, message: "手机不能为空", trigger: "blur" },
          {
            type: "string",
            pattern: /^[0-9]+$/,
            message: "请输入数字!",
            trigger: "blur"
          },
          { max: 11, message: "目前中国手机号不超过11位" }
        ];
      }
    },
    crewMessageRules: {
      type: Array,
      default: () => {
        return [{ max: 200, message: "你的雄心壮志太多了", trigger: "change" }];
      }
    },
    verifyCodeRules: {
      type: Array,
      default: () => {
        return [
          { required: true, message: "验证码不能为空", trigger: "blur" },
          {
            type: "string",
            pattern: /^[0-9]+$/,
            message: "验证码格式错误",
            trigger: "blur"
          },
          { max: 6, message: "验证码长度错误" },
          { validator: verifyCodePass, trigger: "blur" }
        ];
      }
    }
  },
  data() {
    return {
      show: false,
      styles: {
        height: "calc(100% - 55px)",
        overflow: "auto",
        paddingBottom: "53px",
        position: "static"
      },
      formData: {
        id: 0,
        crewName: "",
        mail: "",
        phoneNum: "",
        verifyCode: ""
      },
      columns1: [
        {
          title: "名称",
          key: "crewName"
        },
        {
          title: "电话",
          key: "phoneNum"
        },
        {
          title: "邮箱",
          key: "mail"
        },
        {
          title: "注册时间",
          key: "createTime"
        },
        {
          title: "最后上线时间",
          key: "lastOfflineTime"
        },
        {
          title: "操作",
          key: "action",
          width: 150,
          align: "center",
          render: (h, params) => {
            return h("div", [
              h(
                "Button",
                {
                  props: {
                    type: "primary",
                    size: "small"
                  },
                  style: {
                    marginRight: "5px"
                  },
                  on: {
                    click: () => {
                      this.modifyCrew(params);
                    }
                  }
                },
                "修改"
              ),
              h(
                "Button",
                {
                  props: {
                    type: "error",
                    size: "small"
                  },
                  on: {
                    click: () => {
                      this.removeCrew(params);
                    }
                  }
                },
                "删除"
              )
            ]);
          }
        }
      ],
      data1: [
        {
          crewName: "暂无数据",
          phoneNum: "暂无数据",
          mail: "暂无数据",
          createTime: "暂无数据",
          lastOfflineTime: "暂无数据"
        }
      ]
    };
  },
  computed: {
    rules() {
      return {
        crewName: this.crewNameRules,
        mail: this.mailRules,
        phoneNum: this.phoneRules,
        verifyCode: this.verifyCodeRules
      };
    }
  },
  methods: {
    getCrewsItems: function() {
      let data = {};
      post(global.$prop.URL.getAllCrews, data, this.crewItemsResponse);
    },
    freshTable: function() {
      this.getCrewsItems();
    },
    crewItemsResponse: function(response) {
      let resData = global.$util.parseJson(response.data);
      global.$util.logger(resData);
      this.data1 = resData.crewList;
    },
    modifyCrew: function(item) {
      this.show = true;
      this.formData.id = item.row.id;
      this.formData.crewName = item.row.crewName;
      this.formData.mail = item.row.mail;
      this.formData.phoneNum = item.row.phoneNum;
      this.formData.crewMessage = item.row.crewMessage;
    },
    getVerificationCode: function() {
      post(global.$prop.URL.getVerificationCode, {}, this.verificationResponse);
    },
    verificationResponse: function(response) {
      let responseData = jsonManager.parse(response.data);
      verifyCode = responseData.verifyCode;
      global.$util.logger("短信验证码：" + verifyCode);
    },
    submitUpdate: function() {
      this.$refs.updateForm.validate(valid => {
        if (valid) {
          let data = {
            id: this.formData.id,
            crewName: this.formData.crewName,
            mail: this.formData.mail,
            phoneNum: this.formData.phoneNum
          };
          post(global.$prop.URL.update, data, this.updateResponse);
        }
      });
    },
    updateResponse: function(response) {
      let resData = global.$util.parseJson(response.data);
      global.$util.logger(resData);

      if (resData.status === global.$prop.HTTP_STATUS.OK) {
        global.$util.successNotice("修改成功");
        this.show = false;
        this.freshTable();
      } else {
        this.errorNotice("修改用户异常");
      }
    },
    removeCrew: function(item) {
        let data = {
            id: item.row.id
        }
      post(global.$prop.URL.delete, data, this.deleteResponse);
    },  
    deleteResponse: function(response) {
      let resData = global.$util.parseJson(response.data);
      global.$util.logger(resData);

      if (resData.status === global.$prop.HTTP_STATUS.OK) {
        global.$util.successNotice("删除成功");
        this.freshTable();
      } else {
        this.errorNotice("删除用户异常");
      }
    }
  },
  created: function() {
    this.getCrewsItems();
  }
};
</script>