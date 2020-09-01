let myFunction={
    callBack(src){
        var s = src + "_callBack" + new Date().getTime();
    return s;
    },
    setAutoBackUp(any){
        console.log(any);
    }
}

export default {
    install:function(){
        window.JC = myFunction;
    }
};