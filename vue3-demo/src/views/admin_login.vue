<script setup>
import { User, Lock } from '@element-plus/icons-vue'
import { ref } from 'vue'
import { ElMessage } from 'element-plus'

const isRegister = ref(false)

const registerData = ref({
    register:'',
    password:'',
    rePassword:'',
    privilege:''
})
const loginData = ref({
    loginId:'',
    password:'',
    
})


const checkRePassword=(rule,value,callback)=>{
    if(value===''){
        callback(new Error('もう一度パスワードを入力してください'))
    }else if(value!==registerData.value.password){
        callback(new Error('もう一度パスワードを確認してください'))
    }else{
        callback()
    }
}

const rules={
    register:[
        {required: true, message:'登録者名を入力してください', trigger:'blur'},
        {min:5, max:16, message:'長さは5~16位スペースなし', trigger:'blur'}
    ],
    password:[
        {required: true, message:'パスワードを入力してください', trigger:'blur'},
        {min:5, max:16, message:'長さは5~16位スペースなし', trigger:'blur'}
    ],  
    loginId:[
        {required: true, message:'管理者IDを入力してください', trigger:'blur'},
        {min:1, max:5, message:'長さは5位までスペースなし', trigger:'blur'}
    ],
    rePassword:[
        {validator:checkRePassword, trigger:'blur'}
    ]
}
import {userRegisterService,userLoginService} from '@/api/user.js'
const register = async()=>{
    let result = await userRegisterService(registerData.value);
    ElMessage.success(result.msg? result.msg:'登録成功');
}

//ログイン関数
import {useRouter} from 'vue-router'
import {jwtDecode} from 'jwt-decode'; // 直接导入默认导出
const router = useRouter();
const login = async() => {
    let result = await userLoginService(loginData.value);
    ElMessage.success(result.msg ? result.msg : 'ログイン成功');
    // 获取 token
    const token = result.data;
    // 解析 token
    const decoded = jwtDecode(token); // 使用默认导出 jwtDecode
    const adminAuth = decoded.claims.auth
    if (adminAuth == 1) {
        router.push('/new');
    } 
    if (adminAuth == 2){
        router.push('/option');
    }
};

</script>

<template>
    <el-row class="login-page">
        <el-col :span="12" class="bg"></el-col>
        <el-col :span="6" :offset="3" class="form">
            <!-- 登録 -->
            <el-form ref="form" size="large" autocomplete="off" v-if="isRegister" :model="registerData" :rules="rules">
                <el-form-item>
                    <h1>登録</h1>
                </el-form-item>
                <el-form-item prop="register">
                    <el-input :prefix-icon="User" placeholder="登録者名" v-model="registerData.register"></el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input :prefix-icon="Lock" type="password" placeholder="パスワード" v-model="registerData.password"></el-input>
                </el-form-item>
                <el-form-item prop="rePassword">
                    <el-input :prefix-icon="Lock" type="password" placeholder="パスワード(確認)" v-model="registerData.rePassword"></el-input>
                </el-form-item>
                <el-form-item prop="privilege">
                   <el-select v-model="registerData.privilege" placeholder="権限を選択してください">
                   <el-option label="最高管理者権限" value="1"></el-option>
                   <el-option label="一般管理者権限" value="2"></el-option>
                  </el-select>
                </el-form-item>
                <!-- 登録ボタン -->
                <el-form-item>
                    <el-button class="button" type="primary" auto-insert-space @click="register">
                        登録
                    </el-button>
                </el-form-item>
                <el-form-item class="flex">
                    <el-link type="info" :underline="false" @click="isRegister = false;clearRegisterData()">
                        ← 戻る
                    </el-link>
                </el-form-item>
            </el-form>
            <!-- ログイン -->
            <el-form ref="form" size="large" autocomplete="off" v-else :model="loginData" :rules="rules">
                <el-form-item>
                    <h1>管理機能用ログイン画面</h1>
                </el-form-item>
                <el-form-item prop="loginId">
                    <el-input :prefix-icon="User" placeholder="管理IDを入力してください" v-model="loginData.loginId"></el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input name="password" :prefix-icon="Lock" type="password" placeholder="パスワードを入力してください" v-model="loginData.password"></el-input>
                </el-form-item>
                <el-form-item class="flex">
                    <div class="flex">
                        <el-link type="primary" :underline="false">パスワードを忘れた</el-link>
                    </div>
                </el-form-item>
                <!-- ログインボタン -->
                <el-form-item>
                    <el-button class="button" type="primary" auto-insert-space @click="login">ログイン</el-button>
                </el-form-item>
                <el-form-item class="flex">
                    <el-link type="info" :underline="false" @click="isRegister = true;clearRegisterData()">
                        登録 →
                    </el-link>
                </el-form-item>
            </el-form>
        </el-col>
    </el-row>
</template>

<style lang="scss" scoped>
.login-page {
    height: 100vh;
    background-color: #fff;

    .bg {
        background:
            url('@/assets/956.jpg') no-repeat center / cover;
        border-radius: 0 20px 20px 0;
    }

    .form {
        display: flex;
        flex-direction: column;
        justify-content: center;
        user-select: none;

        .title {
            margin: 0 auto;
        }

        .button {
            width: 100%;
        }

        .flex {
            width: 100%;
            display: flex;
            justify-content: space-between;
        }
    }
}
</style>
