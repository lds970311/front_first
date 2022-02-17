function resetForm(formObj: FormObj) {
    for (const formObjKey in formObj) {
        if (typeof formObj[formObjKey] === 'string') {
            formObj[formObjKey] = ''
        }
        if (typeof formObj[formObjKey] === 'number') {
            formObj[formObjKey] = 0;
        }
    }
}

export default resetForm
