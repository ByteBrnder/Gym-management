import request from '@/utils/request.js'
//教练查看
export const JiaolianListService=()=>{

    return request.get('/jiaolian/chakan')
   }


  //教练添加
export const JiaolianAddService=(jiaolianData)=>{
    return request.post('/jiaolian/tianjia',jiaolianData)
}

//教练修改
export const JiaolianupdateService=(jiaolianData)=>{
    return request.put('/jiaolian/update',jiaolianData)
}

//教练删除
export const JiaolianDeleteService=(id)=>{
   return request.delete('/jiaolian/delete?id='+id)
} 