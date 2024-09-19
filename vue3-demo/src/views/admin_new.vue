<script setup>
import { ref ,computed} from 'vue'
import { ElMessage } from 'element-plus'
const addData = ref({
    personalNumber:'',
    lastNameKanji:'',
    firstNameKanji:'',
    lastNameKana:'',
    firstNameKana:'',
    postalCode:'',
    address1:'',
    address2:'',
    address3:'',
    birthDate:'',
    email:'',
    reEmail:'',
    password:'',
    rePassword:''
})
const postalCodeData = ref({
    postalCode1:'',
    postalCode2:''
})
const combinedData = computed(() => ({
  ...addData.value,
  ...postalCodeData.value
}))
const CombinedpostalCode = () => {
  addData.value.postalCode = `${postalCodeData.value.postalCode1}-${postalCodeData.value.postalCode2}`;
}
const resetForm=()=>{
    router.push('/option')
}
const checkReEmail=(rule,value,callback)=>{
    if(value===''){
        callback(new Error('もう一度emailを入力してください'))
    }else if(value!==addData.value.email){
        callback(new Error('もう一度emailを確認してください'))
    }else{
        callback()
    }
}
const checkRePassword=(rule,value,callback)=>{
    if(value===''){
        callback(new Error('もう一度パスワードを入力してください'))
    }else if(value!==addData.value.password){
        callback(new Error('もう一度パスワードを確認してください'))
    }else{
        callback()
    }
}
const rules= {
          personalNumber: [
            { required: true, message: '個人番号を入力してください', trigger: 'blur' },
            { min: 1, max: 5, message: '長さは5位までスペースなし', trigger: 'blur' }
          ],
          lastNameKanji: [
            { required: true, message: '氏を入力してください', trigger: 'blur' },
            { min: 1, max: 5, message: '長さは5位までスペースなし', trigger: 'blur' }
          ],
          firstNameKanji: [
            { required: true, message: '名を入力してください', trigger: 'blur' },
            { min: 1, max: 5, message: '長さは5位までスペースなし', trigger: 'blur' }
          ],
          lastNameKana: [
            { required: true, message: '氏を入力してください', trigger: 'blur' },
            { min: 1, max: 5, message: '長さは5位までスペースなし', trigger: 'blur' }
          ],
          firstNameKana: [
            { required: true, message: '名を入力してください', trigger: 'blur' },
            { min: 1, max: 5, message: '長さは5位までスペースなし', trigger: 'blur' }
          ],
          postalCode1: [
            { required: true, message: '郵便番号を入力してください', trigger: 'blur' },
            { min: 1, max: 3, message: '長さは3位までスペースなし', trigger: 'blur' }
          ],
          postalCode2: [
            { required: true, message: '郵便番号を入力してください', trigger: 'blur' },
            { min: 1, max: 4, message: '長さは4位までスペースなし', trigger: 'blur' }
          ],
          birthDate:[
          {type: 'date', required: true, message: '生年月日を選択してください', trigger: 'change'} 
          ],
          email:[
            {type:'email', required: true, message: '正しいメールアドレスを入力してください', trigger: 'change' }
          ],
          reEmail:[
            {validator:checkReEmail, trigger:'change'}
          ],
          password:[
            {required: true, message:'パスワードを入力してください', trigger:'blur'},
            {min:5, max:16, message:'長さは5~16位スペースなし', trigger:'blur'}
          ],
          rePassword:[
            {validator:checkRePassword, trigger:'blur'}
          ]
        }

</script>

<template>
  <el-container>
  <el-header>
    <h1>新規登録:</h1>
    <hr>
  </el-header>
  <el-main>
    <el-form ref="form" :model="combinedData" :rules="rules" label-width="300px" class="demo-ruleForm">
  <el-form-item label="個人番号：" prop="personalNumber">
    <el-input v-model="addData.personalNumber"></el-input>
  </el-form-item>
  
  <el-form-item label="氏名(漢字)：" prop="personalNumber">
      <el-row>
        <el-col :span="11">
          <el-form-item :label-width="0" prop="lastNameKanji">
            <div class="input-container">
              <span class="input-label">氏：</span>
              <el-input v-model="addData.lastNameKanji"></el-input>
            </div>
          </el-form-item>
        </el-col>
        <el-col :span="2" ></el-col>
        <el-col :span="11">
          <el-form-item :label-width="0" prop="firstNameKanji">
            <div class="input-container">
              <span class="input-label">名：</span>
              <el-input v-model="addData.firstNameKanji"></el-input>
            </div>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form-item>
    <el-form-item label="氏名(カタカナ)：" prop="personalNumber">
      <el-row>
        <el-col :span="11">
          <el-form-item :label-width="0" prop="lastNameKana">
            <div class="input-container">
              <span class="input-label">氏：</span>
              <el-input v-model="addData.lastNameKana"></el-input>
            </div>
          </el-form-item>
        </el-col>
        <el-col :span="2" ></el-col>
        <el-col :span="11">
          <el-form-item :label-width="0" prop="firstNameKana">
            <div class="input-container">
              <span class="input-label">名：</span>
              <el-input v-model="addData.firstNameKana"></el-input>
            </div>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form-item>
  
  <el-form-item label="郵便番号：" required>
    <el-col :span="8">
      <el-form-item prop="postalCode1">
        <el-input v-model="postalCodeData.postalCode1"></el-input>
      </el-form-item>
    </el-col>
    <el-col class="line" :span="1">―</el-col>
    <el-col :span="8">
      <el-form-item prop="postalCode2">
        <el-input v-model="postalCodeData.postalCode2"></el-input>
      </el-form-item>
    </el-col>
  </el-form-item><br>
  <el-form-item label="住所（都道府県）：" prop="address1">
    <el-select v-model="addData.address1" placeholder="地域を選択してください">
      <el-option label="東京都" value="東京都"></el-option>
      <el-option label="千葉県" value="千葉県"></el-option>
    </el-select>
  </el-form-item>
  <el-form-item label="住所（区市町村、町名番地）：" prop="address2">
    <el-input v-model="addData.address2"></el-input>
  </el-form-item>
  <el-form-item label="住所（ビル、号室など）：" prop="address3">
    <el-input v-model="addData.address3"></el-input>
  </el-form-item>
  <el-form-item label="生年月日：" prop="address3" required>
    <el-col :span="11">
      <el-form-item>
        <el-date-picker type="date" v-model="addData.birthDate" style="width: 100%;"></el-date-picker>
      </el-form-item>
    </el-col>
  </el-form-item>
  <el-form-item label="E-mail：" prop="email">
    <el-input v-model="addData.email"></el-input>
  </el-form-item>
  <el-form-item label="E-mail（確認）：" prop="reEmail">
    <el-input v-model="addData.reEmail"></el-input>
  </el-form-item>
  <el-form-item label="パスワード：" prop="password">
    <el-input v-model="addData.password"></el-input>
  </el-form-item>
  <el-form-item label="パスワード（確認）：" prop="rePassword">
    <el-input v-model="addData.rePassword"></el-input>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="submitForm('ruleForm')">登録確認</el-button>
    <el-button @click="resetForm">戻る</el-button>
  </el-form-item>
</el-form>
  </el-main>
  <el-footer>
    <hr>
    <h4 style="text-align: right;">©株式会社BSS</h4>
  </el-footer>
</el-container>
  

</template>

<style scoped>
.demo-ruleForm {
  margin-left: 250px;
  margin-right: 400px;
}
.input-container {
  display: flex;
  align-items: center;
}

.input-label {
  margin-right: 8px; /* 控制文字和输入框之间的间距 */
}

/* Optional: Adjust the spacing between the label and the form item */
.el-form-item__label {
  margin-bottom: 0; /* Adjust as needed */
}

.separator {
  text-align: center;
  line-height: 32px; /* Adjust as needed */
}
</style>