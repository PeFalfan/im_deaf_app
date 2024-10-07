//package cl.duoc.im_deaf_app.mock
//
//import cl.duoc.im_deaf_app.model.UserModel
// val users = listOf<UserModel>(
//        UserModel("pete@gmail.com", "111111"),
//        UserModel("Maria", "123123")
//    )
//
//    fun loginUser(email:String, pasword: String) : Boolean {
//
//        val users = users.filter { user -> user.email == email }
//        return if (users.size == 1){
//            if (users[0].password == pasword) {
//                return true
//            } else {
//                return false
//            }
//        } else {
//            return false
//        }
//    }
//}