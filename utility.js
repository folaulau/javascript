

let Utils = {

    // You should avoid using functions in JSON, 
    // the functions will lose their scope, 
    // and you would have to use eval() to convert them back into functions.
    copyObject(obj){
        let jsonString = JSON.stringify(obj);
        return JSON.parse(jsonString);
    },

    utcToLocalDateTime(utcDate){
        if(utcDate==undefined || utcDate==null){
            return new Date().toLocaleDateString()+" "+new Date().toLocaleTimeString()
        }
        return new Date(utcDate).toLocaleDateString()+" "+new Date(utcDate).toLocaleTimeString();
    },

    utcToLocalDate(utcDate){
        if(utcDate==undefined || utcDate==null){
            return new Date().toLocaleDateString();
        }
        return new Date(utcDate).toLocaleDateString();
    },

    utcToLocalTime(utcDate){
        if(utcDate==undefined || utcDate==null){
            return new Date().toLocaleTimeString()
        }
        return new Date(utcDate).toLocaleTimeString();
    }
}

export {Utils};