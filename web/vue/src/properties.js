const PROP = {
    COOKIE_USERNAME : "MyBelfasetCrewName",
    COOKIE_SUFFIX : "_token",
    HTTP_STATUS : {
        OK: "OK",
        NETWORK_AUTHENTICATION_REQUIRED: "NETWORK_AUTHENTICATION_REQUIRED",
        REGISTER_SUCCESS: "REGISTER_SUCCESS"
    },
    URL: {
        login: "/crew/login",
        register: "/crew/register",
        getVerificationCode: "/general/verificationCode",
        getMenu: "/general/getMenu",
        getYouthNews: "/news/youthNews",
        getAllCrews: "/crew/list",
        update: "/crew/update",
        delete: "/crew/delete"
    },
    // 无需进行身份验证的请求
    NO_LOGIN_URL: {
        login: "/crew/login",
        register: "/crew/register",
        getVerificationCode: "/general/verificationCode"
    },
    TOKEN_LIVE_TIME : 20,
    DEBUG: false,
    AXIOS_TIME_OUT: 60000
}


export {
    PROP
}