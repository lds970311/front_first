//CREATE AT: 2021-12-11
// import Ajv from "ajv"
const Ajv = require("ajv")
// import addFormats from "ajv-formats"
const addFormats = require("ajv-formats")
const ajv = new Ajv({
    allErrors: true
}) // options can be passed, e.g. {allErrors: true}
require("ajv-errors")(ajv)
addFormats(ajv)
const schema = {
    type: "object",
    properties: {
        foo: {
            type: "integer",
        },
        bar: {
            type: "string",
            format: 'email',
            errorMessage: {
                type: "should be an object", // will not replace internal "type" error for the property "foo"
                required: "should have property foo",
                additionalProperties: "should not have properties other than foo",
            },
        },
        test: {
            type: 'string',
            errorMessage: {
                type: "should be an object", // will not replace internal "type" error for the property "foo"
                required: "should have property foo",
                additionalProperties: "should not have properties other than foo",
            },
        }
    },
    required: ["foo"],
    additionalProperties: false,

}


const data = {
    foo: 1,
    bar: "abc@126.com",
    test: '123'
}

/*
ajv.addFormat('test', {
    type: "string",
    validate(data) {
        console.log(data)
        return true
    }
})
*/


const validate = ajv.compile(schema)
const valid = validate(data)

if (!valid) {
    console.log(validate.errors)
} else {
    console.log("success")
}
