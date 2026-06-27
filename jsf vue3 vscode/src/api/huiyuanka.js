import request from '@/utils/request.js'
//会员卡查看
export const HuiyuankaListService=()=>{

    return request.get('/huiyuanka/chakan')
   }

    //会员卡添加
export const HuiyuankaAddService=(huiyuankaData)=>{
    return request.post('/huiyuanka/tianjia',huiyuankaData)
}

//会员卡修改
export const HuiyuankaupdateService=(huiyuankaData)=>{
    return request.put('/huiyuanka/update',huiyuankaData)
}

//会员卡删除
export const HuiyuankaDeleteService=(id)=>{
   return request.delete('/huiyuanka/delete?id='+id)
} 


//购买
export const HykGoumaiService=(id)=>{
    
    request.post('/huiyuanka/goumai?id='+id)
}