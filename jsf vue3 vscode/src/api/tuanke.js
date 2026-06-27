import request from '@/utils/request.js'
//团课查看
export const TuanKeListService=()=>{

    return request.get('/tuanke/chakan')
   }

   //团课添加
export const TuankeAddService=(tuankeData)=>{
    return request.post('/tuanke/tianjia',tuankeData)
}

//团课修改
export const TuankeupdateService=(tuankeData)=>{
    return request.put('/tuanke/update',tuankeData)
}

//团课删除
export const TuankeDeleteService=(id)=>{
   return request.delete('/tuanke/delete?id='+id)
}

//课程预约
export const TuankeYuyueService=(id)=>{
    
    return request.post('/tuanke/yuyue?id='+id)
}