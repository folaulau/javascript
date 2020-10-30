

let Utils = {

    copyObject(obj){
        let jsonString = JSON.stringify(obj);
        return JSON.parse(jsonString);
    }
}

export {Utils};