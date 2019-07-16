import jsonManager from "json5";
import iView from 'iview';

var util = {
    debug: global.$prop.DEBUG,
    // debug: true,
    logger(msg) {
        if (this.debug) {
            console.log(msg);
        }
    },
    compare(obj1, obj2) {
        if (obj1 == obj2) {
            return true;
        } else {
            return false;
        }
    },
    equals(obj1, obj2) {
        if (obj1 === obj2) {
            return true;
        } else {
            return false;
        }
    },
    responseResolve(response, data, successFunction,successStatus,errorFunction) {
        let responseData = this.parseJson(response.data)
        global.$util.logger(responseData);
        if(successStatus == undefined){
            successStatus = global.$prop.HTTP_STATUS.OK;
        }
      
        if (responseData.status === successStatus) {
            successFunction(data.crewName, responseData);
        }else{
            if(errorFunction == undefined){
                this.errorNotice(responseData.msg);
            }else{
                errorFunction(responseData);
            }
        }
    },
    successNotice(title,desc) {
        if(desc == undefined){
            desc = "";
        }
        iView.Notice.success({
          title: title,
          desc: desc
        });
    },
    errorNotice(title,desc){
        if(desc == undefined){
            desc = "";
        }
        iView.Notice.error({
          title: title,
          desc: desc
        });
    },
    parseJson(jsonData){
        let responseData = jsonManager.parse(jsonData);
        return responseData
    }
}

export {
    util
}