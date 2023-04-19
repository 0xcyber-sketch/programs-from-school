
import chef from "../app.js";
//const Chef = require('../app.js')
//const assert = require('chai').assert;
import { assert } from 'chai';


describe('Chef test', function() {

    let c = chef

    it ('Check the dish has a vaild name', function() {
        assert.isString(c.cheackMenu(), 'string')
    })


    it ('Check for a dish in menu', function() {
        let dish = c.cheackMenu()
        assert.oneOf(dish, c.dishes)
    })
})