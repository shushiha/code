import { ElMessage } from 'element-plus'
//axios  npm install axios
import axios from 'axios';
const baseURL = '/api';
const instance = axios.create({baseURL})


instance.interceptors.response.use(
    result => {
            //codeは0の場合、操作は成功
        if (result.data.code == 0) {
            return result.data;
        }
        ElMessage.error(result.data.message || 'エラー');
        return Promise.reject(result.data);
    },
    err => {
        alert('エラー')
        return Promise.reject(err);
    }
)

export default instance;