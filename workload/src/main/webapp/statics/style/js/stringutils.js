function isIntNum(val){
    var regPos = / ^\d+$/; // 非负整数
    var regNeg = /^\-[1-9][0-9]*$/; // 负整数
    if(regPos.test(val) || regNeg.test(val)){
        return true;
    }else{
        return false;
    }
}
//判断是否是一个正整数
function isPositiveIntNum(val){
    var regPos = / ^\d+$/; // 非负整数
    var result = false;
    if(regPos.test(val)){
        result = true;
    }
    return result;
}