<script setup>
import {useRouter} from 'vue-router'
const router = useRouter()
const newUser =()=>{
  router.push('/new')
}
const searchUser =()=>{
  router.push('/search')
}
const logOff =()=>{
  router.push('/login')
}
</script>
<template>
<el-container>
    <el-header>
        <div class="header-container">
          <h1>新規/検索選択:</h1>
          <hr>
        </div>
    </el-header>
    <el-main class="main-container">
        
    <div class="button-container">

      <el-row>
        <el-button round class="custom-button" @click="newUser">新規登録</el-button>
      </el-row>
      <el-row>
        <el-button round class="custom-button" @click="searchUser">検索</el-button>
      </el-row>
      <el-row>
        <el-button round class="custom-button" @click="logOff">ログオフ</el-button>
      </el-row>
    </div>
    </el-main>
    <el-footer>
      <hr>
    <h4 style="text-align: right;">©株式会社BSS</h4>
    </el-footer>
  </el-container>
</template>

<style scoped>
.custom-button {
  width: 100px;
  height: 25px;
  font-size: 16px; 
  margin-bottom: 30px; /* 设置按钮之间的间距 */
}
.button-container {
  background-color:rgb(158, 196, 220);    
  padding: 20px;           
  border-radius: 10px;     
  max-width: 200px;           /* 最大宽度 */
  margin: 0 auto;             /* 水平居中 */
  display: flex;              /* 使用 flex 布局 */
  flex-direction: column;     /* 让子元素垂直排列 */
  justify-content: center;    /* 垂直居中 */
  align-items: center;        /* 水平居中 */
  height: 200px;              /* 给容器一个固定的高度来控制居中 */
}
.main-container {
  position: relative;       /* 相对定位 */
  height: 100vh;            /* 占满整个视口高度 */
  padding: 100px 20px;           
}
.header-container{
height: 100px;
}
</style>