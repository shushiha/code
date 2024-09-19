import request from '@/utils/request.js'
export const userRegisterService =(registerData)=>{
    const params = new URLSearchParams()
    for (let key in registerData) {
        params.append(key,registerData[key]);
        
    }
    return request.post('/admin/register',params)
}
//ログインインタフェースを呼び出す関数を提供する
export const userLoginService =(loginData)=>{
    const params = new URLSearchParams()
    for (let key in loginData) {
        params.append(key,loginData[key]);
        
    }
    return request.post('/admin/login',params)
}
// export const userNewUserService =(newUserData)=>{
//     const params = new URLSearchParams()
//     for (let key in newUserData) {
//         params.append(key,newUserData[key]);
        
//     }
//     return request.post('/user/register',params)
// }