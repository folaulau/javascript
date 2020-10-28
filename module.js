


class User{
    //private fields are declared with #
    #name;
    constructor(name) {
        this.name = name;
    }

    getName(){
        return this.name;
    }

}

function sayHi(name) {
    return `Hello, ${name}!`;
}

let folau = {

    name: "Folau",

    getName(){
        return this.name;
    }
}

/**
 * export class User {...} -> import {User} from ..
 * export default class User {...} -> import User from ...
 */
// export has to be in the same order as import
// Named exports are explicit. They exactly name what they import, so we have that information from them; that’s a good thing.
export {User, sayHi, folau};