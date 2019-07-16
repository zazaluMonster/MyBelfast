(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-4ed5e1a9"],{4152:function(e,t,a){"use strict";(function(e){var r=a("5928"),i=a("5e48"),s=a.n(i),o="",l=function(e,t,a){t!=o?a(new Error("验证码错误")):a()};t["a"]={props:{crewNameRules:{type:Array,default:function(){return[{required:!0,message:"账号不能为空",trigger:"blur"}]}},passwordRules:{type:Array,default:function(){return[{required:!0,message:"密码不能为空",trigger:"blur"}]}},mailRules:{type:Array,default:function(){return[{required:!0,message:"邮箱不能为空",trigger:"blur"}]}},phoneRules:{type:Array,default:function(){return[{required:!0,message:"手机不能为空",trigger:"blur"},{type:"string",pattern:/^[0-9]+$/,message:"请输入数字!",trigger:"blur"},{max:11,message:"目前中国手机号不超过11位"}]}},crewMessageRules:{type:Array,default:function(){return[{max:200,message:"你的雄心壮志太多了",trigger:"change"}]}},verifyCodeRules:{type:Array,default:function(){return[{required:!0,message:"验证码不能为空",trigger:"blur"},{type:"string",pattern:/^[0-9]+$/,message:"验证码格式错误",trigger:"blur"},{max:6,message:"验证码长度错误"},{validator:l,trigger:"blur"}]}}},data:function(){var e=this;return{show:!1,styles:{height:"calc(100% - 55px)",overflow:"auto",paddingBottom:"53px",position:"static"},formData:{id:0,crewName:"",mail:"",phoneNum:"",verifyCode:""},columns1:[{title:"名称",key:"crewName"},{title:"电话",key:"phoneNum"},{title:"邮箱",key:"mail"},{title:"注册时间",key:"createTime"},{title:"最后上线时间",key:"lastOfflineTime"},{title:"操作",key:"action",width:150,align:"center",render:function(t,a){return t("div",[t("Button",{props:{type:"primary",size:"small"},style:{marginRight:"5px"},on:{click:function(){e.modifyCrew(a)}}},"修改"),t("Button",{props:{type:"error",size:"small"},on:{click:function(){e.removeCrew(a)}}},"删除")])}}],data1:[{crewName:"暂无数据",phoneNum:"暂无数据",mail:"暂无数据",createTime:"暂无数据",lastOfflineTime:"暂无数据"}]}},computed:{rules:function(){return{crewName:this.crewNameRules,mail:this.mailRules,phoneNum:this.phoneRules,verifyCode:this.verifyCodeRules}}},methods:{getCrewsItems:function(){var t={};Object(r["b"])(e.$prop.URL.getAllCrews,t,this.crewItemsResponse)},freshTable:function(){this.getCrewsItems()},crewItemsResponse:function(t){var a=e.$util.parseJson(t.data);e.$util.logger(a),this.data1=a.crewList},modifyCrew:function(e){this.show=!0,this.formData.id=e.row.id,this.formData.crewName=e.row.crewName,this.formData.mail=e.row.mail,this.formData.phoneNum=e.row.phoneNum,this.formData.crewMessage=e.row.crewMessage},getVerificationCode:function(){Object(r["b"])(e.$prop.URL.getVerificationCode,{},this.verificationResponse)},verificationResponse:function(t){var a=s.a.parse(t.data);o=a.verifyCode,e.$util.logger("短信验证码："+o)},submitUpdate:function(){var t=this;this.$refs.updateForm.validate(function(a){if(a){var i={id:t.formData.id,crewName:t.formData.crewName,mail:t.formData.mail,phoneNum:t.formData.phoneNum};Object(r["b"])(e.$prop.URL.update,i,t.updateResponse)}})},updateResponse:function(t){var a=e.$util.parseJson(t.data);e.$util.logger(a),a.status===e.$prop.HTTP_STATUS.OK?(e.$util.successNotice("修改成功"),this.show=!1,this.freshTable()):this.errorNotice("修改用户异常")},removeCrew:function(t){var a={id:t.row.id};Object(r["b"])(e.$prop.URL.delete,a,this.deleteResponse)},deleteResponse:function(t){var a=e.$util.parseJson(t.data);e.$util.logger(a),a.status===e.$prop.HTTP_STATUS.OK?(e.$util.successNotice("删除成功"),this.freshTable()):this.errorNotice("删除用户异常")}},created:function(){this.getCrewsItems()}}}).call(this,a("c8ba"))},"7dac":function(e,t,a){"use strict";var r=a("a0d1"),i=a.n(r);i.a},a0d1:function(e,t,a){},e98d:function(e,t,a){"use strict";a.r(t);var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("Card",{staticClass:"card"},[a("div",{staticClass:"article-inner"},[a("header",{staticClass:"article-header"},[a("h1",{staticClass:"article-title",attrs:{itemprop:"name"}},[e._v("用户管理")]),a("a",{staticClass:"archive-article-date",attrs:{href:"/project/index.html"}},[a("time",{attrs:{datetime:"2016-02-23T17:03:48.000Z",itemprop:"datePublished"}},[a("Icon",{staticClass:"icon-calendar icon",attrs:{type:"md-calendar"}}),e._v("仅对管理员开放\n          ")],1)])])]),a("br"),a("Table",{attrs:{border:"",columns:e.columns1,data:e.data1}}),a("Drawer",{attrs:{title:"用户修改",width:"720","mask-closable":!1,styles:e.styles,placement:"right"},model:{value:e.show,callback:function(t){e.show=t},expression:"show"}},[a("Form",{ref:"updateForm",attrs:{model:e.formData,rules:e.rules}},[a("Row",{attrs:{gutter:32}},[a("i-col",{attrs:{span:"12"}},[a("FormItem",{attrs:{label:"昵称","label-position":"top",prop:"crewName"}},[a("i-input",{attrs:{placeholder:"首先让MyBelfast知道你是谁"},model:{value:e.formData.crewName,callback:function(t){e.$set(e.formData,"crewName",t)},expression:"formData.crewName"}})],1)],1),a("i-col",{attrs:{span:"12"}},[a("FormItem",{attrs:{label:"邮箱","label-position":"top",prop:"mail"}},[a("i-input",{attrs:{placeholder:"邮箱是重要的联系方式"},model:{value:e.formData.mail,callback:function(t){e.$set(e.formData,"mail",t)},expression:"formData.mail"}},[a("span",{attrs:{slot:"append"},slot:"append"},[e._v(".com")])])],1)],1)],1),a("Row",{attrs:{gutter:32}},[a("i-col",{attrs:{span:"12"}},[a("FormItem",{attrs:{label:"密码","label-position":"top",prop:"password"}},[a("i-input",{attrs:{disabled:"",type:"password",placeholder:"密码无法修改"}})],1)],1),a("i-col",{attrs:{span:"12"}},[a("FormItem",{attrs:{label:"手机号","label-position":"top",prop:"phoneNum"}},[a("i-input",{attrs:{placeholder:"目前只支持国人注册哦"},model:{value:e.formData.phoneNum,callback:function(t){e.$set(e.formData,"phoneNum",t)},expression:"formData.phoneNum"}},[a("span",{attrs:{slot:"prepend"},slot:"prepend"},[e._v("86")])])],1)],1)],1),a("FormItem",{attrs:{label:"短信验证码","label-position":"top",prop:"verifyCode"}},[a("i-input",{staticStyle:{width:"120px"},attrs:{placeholder:"防止恶意注册"},model:{value:e.formData.verifyCode,callback:function(t){e.$set(e.formData,"verifyCode",t)},expression:"formData.verifyCode"}}),a("Button",{staticStyle:{"margin-left":"10px"},on:{click:e.getVerificationCode}},[e._v("获取验证码")])],1)],1),a("div",{staticClass:"demo-drawer-footer"},[a("Button",{staticStyle:{"margin-right":"8px"},on:{click:function(t){e.show=!1}}},[e._v("取消")]),a("Button",{attrs:{type:"primary"},on:{click:e.submitUpdate}},[e._v("提交")])],1)],1)],1)],1)},i=[],s=a("4152"),o=s["a"],l=(a("7dac"),a("2877")),n=Object(l["a"])(o,r,i,!1,null,"00ff026a",null);t["default"]=n.exports}}]);
//# sourceMappingURL=chunk-4ed5e1a9.9931e5b9.js.map