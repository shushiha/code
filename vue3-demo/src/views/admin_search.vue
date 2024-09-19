<script setup>
import { ref ,computed} from 'vue'
import {useRouter} from 'vue-router'
const router = useRouter()
const adminSearch = ref({
    id:''
})
const resetForm=()=>{
    router.push('/option')
}
</script>

<template>
    <el-container>
        <el-header>
            <h2>情報検索</h2>
            <hr>
        </el-header>
        <el-main>
            <el-form>
                <el-form-item label="ログインID:" class="id">
                    <el-input v-model="adminSearch.id"></el-input>
                </el-form-item>
                <el-form-item class="button">
                    <el-button type="primary" @click="submitForm('ruleForm')">検索</el-button>
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
.id {
    margin-left: 400px;
    margin-right: 400px;
}
.button{
    margin-left: 550px;
}

</style>