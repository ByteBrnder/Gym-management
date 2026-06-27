import request from '@/utils/request.js'
import { useTokenStore } from '@/stores/token.js'

//文章分类列表查询
export const QicaiListService=()=>{

 return request.get('/qicai/chakan')
}


//器材添加
export const QicaiAddService=(qicaiData)=>{
    return request.post('/qicai/tianjia',qicaiData)
}

//器材修改
export const QicaiupdateService=(qicaiData)=>{
    return request.put('/qicai/update',qicaiData)
}

//器材删除
export const QiCaiDeleteService=(id)=>{
   return request.delete('/qicai/delete?id='+id)
}