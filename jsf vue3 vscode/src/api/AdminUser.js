import request from '@/utils/request.js'
import { useTokenStore } from '@/stores/token.js'

//查询
export const AdminUserListService=()=>{

 return request.get('/adminuser/chakan')
}


//添加
export const AdminUserAddService=(AdminUserData)=>{
    return request.post('/adminuser/tianjia',AdminUserData)
}

//修改
export const AdminUserupdateService=(AdminUserData)=>{
    return request.put('/adminuser/update',AdminUserData)
}

//删除
export const AdminUserDeleteService=(id)=>{
   return request.delete('/adminuser/delete?id='+id)
}