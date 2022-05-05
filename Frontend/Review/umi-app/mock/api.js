export default {
  "GET /users": {name: "evan", age: 100},

  "POST /users/login": (req, res) => {
    console.log(req.body)
    if (req.body.username === "kerwin" && req.body.password === "123") {
      res.send({
        ok: 1
      })
    } else {
      res.send({
        ok: 0
      })
    }
  }
}
