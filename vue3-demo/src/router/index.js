import {createRouter,createWebHistory} from 'vue-router'

//导入组件
import adminLoginVue from '@/views/admin_login.vue'
import adminOption from '@/views/admin_option.vue'
import adminNew from '@/views/admin_new.vue'
import adminSearch from '@/views/admin_search.vue'
//定义路由关系
const routes = [
    {path: '/', redirect: '/login' },
    {path:'/login',component:adminLoginVue},
    {path:'/option',component:adminOption},
    {path:'/new',component:adminNew},
    {path:'/search',component:adminSearch}
   
]
//创建路由器
const router = createRouter({
    history:createWebHistory(),
    routes:routes
})


//导出路由
export default router